# `@GeneratedValue` — Spring Data JPA Notes

> **What is it?**
> `@GeneratedValue` tells JPA to automatically generate the primary key value when a new entity is persisted. It always pairs with `@Id`. Without it, you must set the ID manually before every `save()`.

---

## Syntax

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

The `strategy` parameter controls *how* the ID is generated. There are four options.

---

## The Four Strategies

### 1. `GenerationType.IDENTITY` — Most common

The database column uses `AUTO_INCREMENT` (MySQL) or `SERIAL` (PostgreSQL). JPA inserts the row and asks the DB for the generated ID afterward.

```java
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
}
```

**Generated SQL:**
```sql
INSERT INTO users (name, email) VALUES ('Harshal', 'h@example.com');
-- DB returns: id = 1  (auto-incremented)
```

**Supported by:** MySQL, PostgreSQL, H2, SQL Server  
**Performance:** Good — one DB round-trip per INSERT  
**Use when:** Default choice for most Spring Boot projects

---

### 2. `GenerationType.SEQUENCE` — Best performance

Uses a **database sequence object**. JPA calls `NEXTVAL` before the insert, so it knows the ID in advance. This allows Hibernate to batch inserts efficiently using `allocationSize`.

```java
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "product_seq"
    )
    @SequenceGenerator(
        name = "product_seq",
        sequenceName = "product_sequence",   // actual DB sequence name
        allocationSize = 50                  // pre-fetches 50 IDs at once
    )
    private Long id;

    private String name;
    private double price;
}
```

**Generated SQL:**
```sql
-- JPA calls this first:
SELECT NEXTVAL('product_sequence');   -- returns e.g. 51

-- Then inserts:
INSERT INTO products (id, name, price) VALUES (51, 'Laptop', 49999.0);
```

**Key point — `allocationSize`:** Hibernate pre-fetches 50 IDs in one sequence call and reuses them in memory. For bulk inserts this is dramatically faster than IDENTITY (which needs a round-trip per row).

**Supported by:** PostgreSQL, Oracle  
**Performance:** Best  
**Use when:** High-throughput applications, bulk inserts

---

### 3. `GenerationType.TABLE` — Portable but slow

JPA maintains a separate table (`hibernate_sequences`) that tracks the current ID counter. It locks that row on every insert — a bottleneck under concurrent load.

```java
@Entity
public class Order {

    @Id
    @GeneratedValue(
        strategy = GenerationType.TABLE,
        generator = "order_gen"
    )
    @TableGenerator(
        name = "order_gen",
        table = "id_generator",
        pkColumnValue = "order_id",
        allocationSize = 1
    )
    private Long id;
}
```

**Supported by:** All databases  
**Performance:** Poor — row-level lock on every INSERT  
**Use when:** Only if strict DB portability is required. Avoid in production.

---

### 4. `GenerationType.AUTO` — JPA decides (default)

JPA picks a strategy based on the database dialect. This is the default when you write `@GeneratedValue` with no arguments.

```java
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // or simply:
    // @GeneratedValue
    private Long id;
}
```

**Behavior by DB:**
- PostgreSQL → picks SEQUENCE
- MySQL (older Hibernate) → picks TABLE (not IDENTITY — surprising!)
- MySQL (Hibernate 5.x+) → picks IDENTITY

**Use when:** Quick prototyping only. Always be explicit in production code — AUTO behavior can change across Hibernate versions.

---

## Strategy Comparison

| Strategy | DB Support | Performance | Recommended |
|---|---|---|---|
| `IDENTITY` | MySQL, PG, H2, SQL Server | Good | Yes — default choice |
| `SEQUENCE` | PostgreSQL, Oracle | Best | Yes — for high-throughput |
| `TABLE` | All DBs | Poor | No — avoid |
| `AUTO` | All DBs | Varies | Prototyping only |

---

## Full Working Example — IDENTITY (MySQL / H2)

### Entity

```java
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    // getters and setters
}
```

### Repository

```java
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
```

### Service

```java
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(String firstName, String lastName, String email) {
        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setEmail(email);

        // id is NOT set here — JPA generates it automatically
        return employeeRepository.save(emp);
    }
}
```

### Controller

```java
@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee request) {
        Employee saved = employeeService.save(
            request.getFirstName(),
            request.getLastName(),
            request.getEmail()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
```

**What happens on `save()`:**
1. Hibernate generates: `INSERT INTO employees (first_name, last_name, email) VALUES (?, ?, ?)`
2. DB auto-increments and returns `id = 1`
3. Hibernate sets `emp.id = 1` on the returned object
4. You get back the entity with the populated ID

---

## Full Working Example — SEQUENCE (PostgreSQL)

### Entity

```java
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "order_seq_gen"
    )
    @SequenceGenerator(
        name = "order_seq_gen",
        sequenceName = "orders_id_seq",
        allocationSize = 1        // use 50 for high-throughput
    )
    private Long id;

    private String product;
    private int quantity;

    // getters and setters
}
```

### application.properties (PostgreSQL)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=secret
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

Hibernate creates this in the DB automatically (with `ddl-auto=update`):
```sql
CREATE SEQUENCE orders_id_seq START 1 INCREMENT 1;
```

---

## Common Mistakes

### Using `@GeneratedValue` without `@Id`

```java
// WRONG — @GeneratedValue requires @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

// CORRECT
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

### Manually setting the ID when using `@GeneratedValue`

```java
Employee emp = new Employee();
emp.setId(5L);   // WRONG — JPA ignores this or throws an error
emp.setName("Harshal");
employeeRepository.save(emp);
```

If you set the ID manually, Hibernate treats it as an update (not an insert) and may throw `EntityNotFoundException`. Let JPA handle it.

---

### Using `AUTO` with Hibernate 5 on MySQL

```java
// RISKY — on Hibernate 5 + MySQL, AUTO picks TABLE strategy, not IDENTITY
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

// SAFE — be explicit
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

---

### Wrong `allocationSize` with SEQUENCE

```java
// If your DB sequence increments by 1 but allocationSize = 50,
// Hibernate will skip IDs — huge gaps in your IDs (1, 51, 101...)
@SequenceGenerator(
    name = "my_seq",
    sequenceName = "my_sequence",
    allocationSize = 50    // DB sequence must also increment by 50
)
```

Either set both to the same value, or use `allocationSize = 1` to keep IDs gap-free.

---

## Quick Reference

```
@Id + @GeneratedValue
        │
        ├── IDENTITY   → DB auto-increment, ID returned after INSERT
        │                Best for: MySQL, H2, SQL Server
        │
        ├── SEQUENCE   → DB sequence, ID fetched before INSERT
        │   + @SequenceGenerator(allocationSize)
        │                Best for: PostgreSQL, Oracle, bulk inserts
        │
        ├── TABLE      → Separate counter table, row lock per INSERT
        │   + @TableGenerator  Avoid in production
        │
        └── AUTO       → JPA decides based on dialect
                         Use only for prototyping
```

---

*Notes compiled while learning Spring Boot — covers `@GeneratedValue` strategies with Spring Data JPA.*
