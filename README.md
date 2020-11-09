## JavaSpring

### A quick walkthrough of the Java Spring web framework

###### This application currently has two versions. both intending to implement a simple RESTful api 
version two adds a persistency layer by writing user data to a postgresql container image.
neither have User interface/views (comming soon), but can be loaded with the spring boot dashboard or within a maven project
once the application is running, visit the following in the browser


#### for version 1:
```
localhost:9898 
```

#### for version 2:
```
localhost:8080
```


##### Both versions can accept the following HTTP methods 

* Version 1
POST (@ /api/v1/person)
{
"name" : "John Smith"
}
GET (@ /api/v1/person/${some UUID})
{
"name" : "John Smith",
"id" : some UUID
}
GET (@ /api/v1/person/${some UUID})
{
  List of all people/names 
  created during this server session
}

* version 2
POST (@ /api/users/register)
{
  "firstName" : "john",
  "lastName" : "smith",
  "email" : "abc@test.com",
  "password" : "abc123"
}
creates an user account and record in db.
returns a Json web token for the current authorization session (expires in 2 hours).
GET (@/api/user/login)
{
  "email" : "abc@test.com",
  "password" : "abc123"
}



