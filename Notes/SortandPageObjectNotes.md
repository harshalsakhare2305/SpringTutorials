# Spring Data JPA - Sorting and Pagination

## Introduction

Spring Data JPA provides built-in support for:

* Sorting records
* Pagination of records
* Sorting + Pagination together

These features are available through:

* `Sort`
* `Pageable`
* `PageRequest`
* `Page`

without writing custom SQL queries.

---

# Project Setup

## Repository

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
```

By extending `JpaRepository`, we automatically get:

```java
findAll()
findAll(Sort sort)
findAll(Pageable pageable)
```

---

# Employee Entity

```java
import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    private Integer id;

    private String name;
    private Double salary;
    private String department;

    public Employee() {
    }

    public Employee(Integer id, String name, Double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
```

---

# Sorting

## What is Sorting?

Sorting is used to arrange records in ascending or descending order.

Example:

```text
10000
50000
20000
```

Ascending:

```text
10000
20000
50000
```

Descending:

```text
50000
20000
10000
```

---

# Sort Class

Package:

```java
import org.springframework.data.domain.Sort;
```

---

## Ascending Sort

```java
Sort sort = Sort.by("salary");

List<Employee> employees =
        employeeRepository.findAll(sort);

employees.forEach(System.out::println);
```

Generated SQL:

```sql
SELECT *
FROM employee
ORDER BY salary ASC;
```

---

## Descending Sort

```java
Sort sort = Sort.by("salary")
                .descending();

List<Employee> employees =
        employeeRepository.findAll(sort);
```

Generated SQL:

```sql
SELECT *
FROM employee
ORDER BY salary DESC;
```

---

## Sort By Multiple Columns

```java
Sort sort = Sort.by("department")
                .ascending()
                .and(
                    Sort.by("salary")
                        .descending()
                );

List<Employee> employees =
        employeeRepository.findAll(sort);
```

Generated SQL:

```sql
SELECT *
FROM employee
ORDER BY department ASC,
         salary DESC;
```

---

## Using Sort.Order

```java
Sort sort = Sort.by(
        Sort.Order.asc("department"),
        Sort.Order.desc("salary")
);

List<Employee> employees =
        employeeRepository.findAll(sort);
```

---

# Pagination

## What is Pagination?

Pagination divides large datasets into smaller chunks.

Suppose table contains:

```text
1 John
2 Alice
3 Bob
4 David
5 Mike
6 Tom
7 Sam
8 Harry
9 Jack
10 Steve
```

Showing all records at once is not practical.

Instead:

```text
Page 0 -> 1 2 3

Page 1 -> 4 5 6

Page 2 -> 7 8 9

Page 3 -> 10
```

---

# Pageable Interface

Package:

```java
import org.springframework.data.domain.Pageable;
```

`Pageable` represents pagination information.

---

# PageRequest Class

Package:

```java
import org.springframework.data.domain.PageRequest;
```

`PageRequest` is the implementation of `Pageable`.

---

## Creating PageRequest

```java
Pageable pageable =
        PageRequest.of(0, 3);
```

Meaning:

```text
Page Number = 0
Page Size   = 3
```

---

# Page Numbering

## First Page

```java
PageRequest.of(0,3)
```

Result:

```text
1
2
3
```

---

## Second Page

```java
PageRequest.of(1,3)
```

Result:

```text
4
5
6
```

---

## Third Page

```java
PageRequest.of(2,3)
```

Result:

```text
7
8
9
```

---

# Fetching Data

```java
Page<Employee> page =
        employeeRepository.findAll(
                PageRequest.of(0,3)
        );
```

---

# Page Object

Package:

```java
import org.springframework.data.domain.Page;
```

A `Page` object contains:

* Actual Records
* Total Records
* Total Pages
* Current Page Number
* Page Size

---

## Getting Records

```java
List<Employee> employees =
        page.getContent();
```

---

## Total Elements

```java
System.out.println(
        page.getTotalElements()
);
```

Output:

```text
10
```

---

## Total Pages

```java
System.out.println(
        page.getTotalPages()
);
```

Output:

```text
4
```

---

## Current Page

```java
System.out.println(
        page.getNumber()
);
```

Output:

```text
0
```

---

## Page Size

```java
System.out.println(
        page.getSize()
);
```

Output:

```text
3
```

---

## Is First Page?

```java
page.isFirst();
```

Output:

```text
true
```

---

## Is Last Page?

```java
page.isLast();
```

Output:

```text
false
```

---

# Pagination Example

```java
Page<Employee> page =
        employeeRepository.findAll(
                PageRequest.of(0, 5)
        );

page.getContent()
    .forEach(System.out::println);
```

---

# Pagination + Sorting

Most commonly used in real-world applications.

```java
Pageable pageable =
        PageRequest.of(
                0,
                5,
                Sort.by("salary")
                    .descending()
        );

Page<Employee> page =
        employeeRepository.findAll(pageable);
```

Generated SQL:

```sql
SELECT *
FROM employee
ORDER BY salary DESC
LIMIT 5 OFFSET 0;
```

---

# Multiple Sorting + Pagination

```java
Pageable pageable =
        PageRequest.of(
                0,
                5,
                Sort.by("department")
                    .ascending()
                    .and(
                        Sort.by("salary")
                            .descending()
                    )
        );

Page<Employee> page =
        employeeRepository.findAll(pageable);
```

Generated SQL:

```sql
SELECT *
FROM employee
ORDER BY department ASC,
         salary DESC
LIMIT 5 OFFSET 0;
```

---

# Complete Example

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void demo() {

        Pageable pageable =
                PageRequest.of(
                        0,
                        3,
                        Sort.by("salary")
                                .descending()
                );

        Page<Employee> page =
                employeeRepository.findAll(pageable);

        System.out.println(
                "Total Records : "
                        + page.getTotalElements()
        );

        System.out.println(
                "Total Pages : "
                        + page.getTotalPages()
        );

        page.getContent()
                .forEach(System.out::println);
    }
}
```

Sample Output:

```text
Total Records : 10

Total Pages : 4

Employee{id=8, salary=90000}
Employee{id=2, salary=85000}
Employee{id=5, salary=80000}
```

---

# Page vs Slice

Spring Data JPA provides two approaches.

## Page

```java
Page<Employee> page =
        employeeRepository.findAll(pageable);
```

Features:

* Total Elements
* Total Pages
* Current Page
* Executes COUNT query

Use when UI needs page numbers.

---

## Slice

```java
Slice<Employee> slice =
        employeeRepository.findAll(pageable);
```

Features:

* Current chunk of data
* Knows whether next page exists
* No COUNT query

Use for:

* Infinite scrolling
* Better performance

---

# Interview Questions

### Q1. Why use Pagination?

To fetch records in chunks instead of loading the entire table.

---

### Q2. Why use Sorting?

To arrange data in ascending or descending order.

---

### Q3. Can Pagination and Sorting be combined?

Yes.

```java
PageRequest.of(
        0,
        10,
        Sort.by("salary")
            .descending()
);
```

---

### Q4. What is the difference between Pageable and PageRequest?

| Pageable                    | PageRequest           |
| --------------------------- | --------------------- |
| Interface                   | Implementation        |
| Defines pagination contract | Implements pagination |

---

### Q5. What is the difference between Page and Slice?

| Page                 | Slice                        |
| -------------------- | ---------------------------- |
| Executes COUNT query | Does not execute COUNT query |
| Knows total pages    | Does not know total pages    |
| Slightly slower      | Faster                       |

---

# Summary

## Sorting

```java
Sort.by("salary")

Sort.by("salary").descending()

Sort.by("department")
    .ascending()
    .and(
        Sort.by("salary")
            .descending()
    )
```

## Pagination

```java
PageRequest.of(pageNumber,pageSize)
```

## Pagination + Sorting

```java
PageRequest.of(
        pageNumber,
        pageSize,
        Sort.by("salary")
            .descending()
)
```

## Fetch Result

```java
Page<Employee> page =
        employeeRepository.findAll(pageable);
```

Useful Methods:

```java
page.getContent()
page.getTotalElements()
page.getTotalPages()
page.getNumber()
page.getSize()
page.isFirst()
page.isLast()
```
