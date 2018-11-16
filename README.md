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

Open postman and make post request on 
`http://localhost:9090/api/users` with request body

```
{
	userByIdIn(ids: [1,2,3]) {
		id,
		name,
		age,
		address,
		createdAt
	}
	
	userById(id: 4) {
		id,
		name,
		address
	}
	
	allUsers{
		id,
		name
	}
	
}
```
