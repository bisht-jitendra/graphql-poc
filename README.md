# graphql-poc
This project demonstrate the graphql integration with spring boot.

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
