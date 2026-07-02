# Spring Security Authentication Notes

A concise set of notes explaining the core authentication flow in Spring Security with examples and diagrams.

---

## Topics Covered

- Spring Security Filter Chain (Overview)
- UserDetails
- UserDetailsService
- InMemoryUserDetailsManager
- AuthenticationProvider
- PasswordEncoder
- Authentication Flow
- SecurityContextHolder
- Interview Questions
- Quick Revision

---

## Spring Security Authentication Flow

```text
Client
   │
   ▼
POST /login
   │
   ▼
UsernamePasswordAuthenticationFilter
   │
   ▼
UsernamePasswordAuthenticationToken
   │
   ▼
AuthenticationManager
   │
   ▼
AuthenticationProvider
   │
   ▼
UserDetailsService
   │
   ▼
UserRepository
   │
   ▼
Database
   │
   ▼
User Entity
   │
   ▼
UserDetails (UserPrincipal)
   │
   ▼
PasswordEncoder.matches()
   │
   ▼
Authentication Success
   │
   ▼
SecurityContextHolder
   │
   ▼
Controller
```

---

## UserDetails

`UserDetails` is an interface used by Spring Security to represent an authenticated user.

It provides:

- Username
- Password
- Roles (Authorities)
- Account Status
- Lock Status
- Expiry Status

Spring Security does **not** use your `User` entity directly.

Instead, your entity is wrapped inside a class implementing `UserDetails`.

---

## UserDetailsService

`UserDetailsService` tells Spring Security **how to load a user**.

Example flow:

```text
Login Request
      │
      ▼
loadUserByUsername(username)
      │
      ▼
Repository
      │
      ▼
Database
      │
      ▼
User Entity
      │
      ▼
UserDetails
```

Example method:

```java
@Override
public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException
```

---

## InMemoryUserDetailsManager

Stores users inside application memory.

Example:

```java
@Bean
public UserDetailsService users() {

    UserDetails user = User.builder()
            .username("harshal")
            .password(passwordEncoder().encode("1234"))
            .roles("USER")
            .build();

    return new InMemoryUserDetailsManager(user);
}
```

### Used For

- Learning
- Testing
- Demo Projects

> Not recommended for production.

---

## AuthenticationProvider

Responsible for authenticating users.

Usually Spring uses:

```text
DaoAuthenticationProvider
```

Responsibilities:

- Calls UserDetailsService
- Loads user
- Reads encoded password
- Uses PasswordEncoder
- Returns Authentication object

Configuration:

```java
@Bean
public AuthenticationProvider authenticationProvider(){

    DaoAuthenticationProvider provider =
            new DaoAuthenticationProvider();

    provider.setUserDetailsService(userDetailsService);

    provider.setPasswordEncoder(passwordEncoder());

    return provider;
}
```

---

## Password Verification

Database stores:

```text
$2a$10$......
```

User enters:

```text
1234
```

Spring compares them using:

```java
passwordEncoder.matches(rawPassword, encodedPassword);
```

---

## SecurityContextHolder

After successful login,

Spring stores the authenticated user inside:

```java
SecurityContextHolder
```

Retrieve current user:

```java
Authentication authentication =
SecurityContextHolder.getContext().getAuthentication();
```

---

## Complete Login Process

```text
User submits username & password
                │
                ▼
UsernamePasswordAuthenticationFilter
                │
                ▼
AuthenticationManager
                │
                ▼
AuthenticationProvider
                │
                ▼
UserDetailsService
                │
                ▼
Database
                │
                ▼
UserDetails
                │
                ▼
PasswordEncoder.matches()
                │
                ▼
Authentication Success
                │
                ▼
SecurityContextHolder
```

---

## Difference Between Components

| Component | Responsibility |
|-----------|----------------|
| UserDetails | Represents authenticated user |
| UserDetailsService | Loads user from database |
| InMemoryUserDetailsManager | Stores users in memory |
| AuthenticationProvider | Authenticates user |
| PasswordEncoder | Encodes and verifies passwords |
| SecurityContextHolder | Stores authenticated user for current request |

---

## Interview Questions

**Why do we implement UserDetails?**
To provide Spring Security with a standard representation of the authenticated user.

**Why is UserDetailsService required?**
To fetch user information from the database.

**What is AuthenticationProvider?**
It authenticates users by loading user details and verifying passwords.

**Why do we use PasswordEncoder?**
Passwords should never be stored in plain text. It securely hashes passwords and verifies them during login.

**Where is the logged-in user stored?**
Inside the `SecurityContextHolder`.

---

## Quick Revision

```text
Login Request
      │
      ▼
UsernamePasswordAuthenticationFilter
      │
      ▼
AuthenticationManager
      │
      ▼
AuthenticationProvider
      │
      ▼
UserDetailsService
      │
      ▼
Database
      │
      ▼
UserDetails
      │
      ▼
PasswordEncoder
      │
      ▼
SecurityContextHolder
```

---

## Author

**Harshal Sakhare**

Spring Security Study Notes for Interview Preparation and Revision.
