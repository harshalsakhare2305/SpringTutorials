# Spring HATEOAS — Complete Notes

## 1. What is HATEOAS?

**HATEOAS** = **H**ypermedia **A**s **T**he **E**ngine **O**f **A**pplication **S**tate.

A REST constraint (Roy Fielding) stating that API responses should not just return raw data, but also include **links** telling the client what actions it can take next — just like hyperlinks on a webpage.

### Without HATEOAS
```json
{
  "id": 1,
  "name": "John",
  "email": "john@example.com"
}
```
Client must already know URL patterns for related actions.

### With HATEOAS
```json
{
  "id": 1,
  "name": "John",
  "email": "john@example.com",
  "_links": {
    "self": { "href": "/users/1" },
    "orders": { "href": "/users/1/orders" },
    "delete": { "href": "/users/1" }
  }
}
```
Response is self-descriptive and navigable.

### Dependency
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
```

---

## 2. Core Building Blocks

| Concept | Purpose |
|---|---|
| `RepresentationModel<T>` | Base class your model extends to hold links |
| `Link` | Represents a single hypermedia link (`rel` + `href`) |
| `WebMvcLinkBuilder` | Builds links from controller methods |
| `EntityModel<T>` | Wraps a single object + adds links |
| `CollectionModel<T>` | Wraps a collection of objects + adds links |
| `PagedModel<T>` | Wraps paginated data + navigation links |

---

## 3. Using `RepresentationModel` Directly in the Model Class

Make the model/DTO class itself extend `RepresentationModel` so it can carry its own `_links`.

```java
import org.springframework.hateoas.RepresentationModel;

public class UserModel extends RepresentationModel<UserModel> {

    private Long id;
    private String name;
    private String email;

    public UserModel(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    // getters/setters
}
```

**Key points:**
- Self-referencing generic `RepresentationModel<UserModel>` gives access to `add(Link...)` and `getLinks()`.
- Serializes automatically to a `_links` JSON node.

### Controller usage
```java
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping("/{id}")
    public UserModel getUser(@PathVariable Long id) {
        UserModel user = new UserModel(id, "John", "john@example.com");

        user.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
        user.add(linkTo(methodOn(OrderController.class).getOrdersByUser(id)).withRel("orders"));

        return user;
    }
}
```

---

## 4. Generating `Link` Objects with `WebMvcLinkBuilder`

```java
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
```

### Method 1 — `linkTo(methodOn(...))` (recommended)
```java
Link selfLink = linkTo(methodOn(UserController.class).getUser(id)).withSelfRel();
Link allUsersLink = linkTo(methodOn(UserController.class).getAllUsers()).withRel("all-users");
```
- `methodOn(...)` creates a proxy call — Spring reads `@GetMapping` to extract the URL.
- `linkTo(...)` converts it into a `Link` builder.
- `.withSelfRel()` → relation name `"self"`.
- `.withRel("name")` → custom relation name.

### Method 2 — Manual class + path
```java
Link link = linkTo(UserController.class).slash(id).withSelfRel();
```

### Method 3 — Direct construction (hardcoded, least preferred)
```java
Link link = Link.of("/users/" + id, "self");
```

### Full Example
```java
@GetMapping("/{id}")
public EntityModel<User> getUser(@PathVariable Long id) {
    User user = userService.findById(id);

    EntityModel<User> resource = EntityModel.of(user);
    resource.add(linkTo(methodOn(UserController.class).getUser(id)).withSelfRel());
    resource.add(linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
    resource.add(linkTo(methodOn(OrderController.class).getOrdersByUser(id)).withRel("orders"));

    return resource;
}
```

**Output:**
```json
{
  "id": 1,
  "name": "John",
  "email": "john@example.com",
  "_links": {
    "self": { "href": "http://localhost:8080/users/1" },
    "users": { "href": "http://localhost:8080/users" },
    "orders": { "href": "http://localhost:8080/orders/user/1" }
  }
}
```

---

## 5. Other Ways to Implement HATEOAS

### a) `EntityModel<T>` wrapper (most common)
Keeps entity clean; wrap only in controller.
```java
EntityModel<User> model = EntityModel.of(user,
    linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel());
```

### b) `CollectionModel<T>` for lists
```java
@GetMapping
public CollectionModel<EntityModel<User>> getAllUsers() {
    List<EntityModel<User>> users = userService.findAll().stream()
        .map(u -> EntityModel.of(u,
             linkTo(methodOn(UserController.class).getUser(u.getId())).withSelfRel()))
        .collect(Collectors.toList());

    return CollectionModel.of(users,
        linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
}
```

### c) `PagedModel` for pagination
```java
@GetMapping
public PagedModel<EntityModel<User>> getUsers(Pageable pageable,
        PagedResourcesAssembler<User> assembler) {
    Page<User> page = userService.findAll(pageable);
    return assembler.toModel(page, user ->
        EntityModel.of(user, linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel()));
}
```
Auto-adds `next`, `prev`, `first`, `last` links.

### d) `RepresentationModelAssembler<T, D>` (clean architecture)
```java
@Component
public class UserModelAssembler implements RepresentationModelAssembler<User, EntityModel<User>> {
    @Override
    public EntityModel<User> toModel(User user) {
        return EntityModel.of(user,
            linkTo(methodOn(UserController.class).getUser(user.getId())).withSelfRel(),
            linkTo(methodOn(UserController.class).getAllUsers()).withRel("users"));
    }
}
```
Controller stays clean:
```java
@GetMapping("/{id}")
public EntityModel<User> getUser(@PathVariable Long id) {
    return assembler.toModel(userService.findById(id));
}
```

### e) Affordances (HAL-FORMS)
Describes which HTTP methods are allowed on a link.
```java
Link link = linkTo(methodOn(UserController.class).getUser(id)).withSelfRel()
    .andAffordance(afford(methodOn(UserController.class).updateUser(id, null)))
    .andAffordance(afford(methodOn(UserController.class).deleteUser(id)));
```

### f) Spring Data REST (auto-HATEOAS)
With `spring-boot-starter-data-rest`, HATEOAS links are generated automatically for every repository-backed endpoint — no manual code needed.

---

## 6. Real-World Examples

1. **E-commerce Order API** — `_links` include `cancel`, `pay`, `items`. UI shows/hides buttons based on which links are present in the response.
2. **Banking API** — `withdraw` link appears only if balance > 0; `close-account` link appears only if no pending transactions. Business rules enforced via link visibility.
3. **GitHub API** — every repo/issue/PR includes hypermedia-style fields (`url`, `comments_url`, `commits_url`) for navigation without hardcoded URLs.
4. **Netflix-style Content API** — a movie resource includes `play`, `add-to-list`, `rate` links depending on subscription tier/region.

---

## 7. Quick Summary Table

| Approach | When to Use |
|---|---|
| `RepresentationModel` in model class | Simple DTO-only models |
| `EntityModel<T>` wrapper | Keep domain entities clean |
| `CollectionModel<T>` | Returning lists |
| `PagedModel` + `PagedResourcesAssembler` | Paginated results |
| `RepresentationModelAssembler` | Clean, reusable, testable link logic |
| Affordances | Allowed HTTP verbs per link (HAL-FORMS) |
| Spring Data REST | Auto-HATEOAS, zero boilerplate |
