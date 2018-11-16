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

and

```bash
./gradlew :graphql-api-example:bootRun
```

In order to access open your browser and enter the url `http://localhost:9090/graphiql` 

Sample Request body
 
```
{
  userById(id: 1){
    name,
    age,
    address
  }
}
```

You can use `ctrl + space` key to use autocomplete
