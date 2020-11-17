#### Java-SpringBoot ExpensetrackerApi README.md
#### Programmer: Ben P Sehnert
#### Date: 11/17/2020
#### Purpose: tracks and categorizes transactions for storage, viewing and future analysis.


###### NOTE: This application currently has two versions both implementing a simple RESTful api 

Sending requests to version_1 api:
use localhost:9898
```
POST (@ /api/v1/person) 
{
  "name" : "John Smith"
}

GET (@ /api/v1/person/${some UUID}) 
{
  "name" : "John Smith",
  "id" : some UUID 
} 

GET (@ /api/v1/person) 
{
  List of all people/names created during this session
}
```
Note the lack of persistency- You cannot permenantly store records with this application.

version two adds a persistency layer by writing user data to a postgresql container image.

Only version 2 has a user interface in development, and can handle each HTTP request verb.
See Postman for full documentation of the Http requests that can be sent.

[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/356018c74700d2e94979)


#### Remove this after deployment:
Note that in order to run these requests succesfully, you will need to link the application to a backend db server or container image.
The repository contains a script for setting up the db. You will simply need to run the following commands:

```
//copy the script to my docker container. I suspect you use curl for live db server instance.
// note that you will need to be in the directory containing expensetracker_db.sql file
$ docker cp expensetracker_db.sql postgresdb:/

//build container and enter bash to execute the script
docker container exec -it postgresdb bash

//run the script from bash
$ psql -U postgres -f expensetracker_db.sql
```

#### Future plans:
Currently, I am working on a React front end client for sending these HTTP Requests.
It will be a simple app that utailizes bootstrap and Sass to create a reactive, responsive and mobile friendly view.
