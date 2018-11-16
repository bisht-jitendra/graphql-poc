# GraphQL with SpringBoot
This project demonstrate GraphQL integration with spring boot.

## graphql-db-example
Demonstrate fetch data from database and serves the request.

## graphql-api-example
This example fetch data using API and servers the incoming request.

### How to use

```bash
./gradlew :graphql-db-example:bootRun
```

or

```bash
./gradlew :graphql-api-example:bootRun
```

Open postman and make post request on 

`http://localhost:9090/graphiql` with request body

```
{
  userById(id: 1){
    name,
    age,
    address
  }
}
```
