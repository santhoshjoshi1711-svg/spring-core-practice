# Spring Core Practice

Hands-on Spring Core practice covering IoC, DI, constructor/setter injection, XML configuration, annotation configuration, autowiring, @Qualifier, @Primary, bean scopes, bean lifecycle, properties, and loose coupling.

## Maven dependencies

Spring Context:

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>6.2.10</version>
</dependency>
```

For `@PostConstruct` and `@PreDestroy`:

```xml
<dependency>
    <groupId>jakarta.annotation</groupId>
    <artifactId>jakarta.annotation-api</artifactId>
    <version>3.0.0</version>
</dependency>
```

Recommended Java version: 17+.
