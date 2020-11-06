package com.example.demo.service;

import java.util.List;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//can use component too but service is more specific
@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    /*
     * Note for here or elsewhere-
     * 
     * when you GET request the api, body comes back with name = null meaning the
     * write to the database failed (i am assuming)
     * 
     * after some further testing. yes, i am pretty sure you need to configure your
     * app so that it is hooked up to a database. lets use postGRE (used sqlite3 for
     * rails and djano already)...
     */
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

}
