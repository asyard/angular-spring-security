package com.asy.test.angular.controller.rest;

import com.asy.test.angular.model.Book;
import com.asy.test.angular.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asil on 10.10.2016.
 */
@RestController
public class TestController {

//-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("a", "b"));
        users.add(new User("c", "d"));
        users.add(new User("e", "f"));

        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users2", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsersSecured() {
        List<User> users = new ArrayList<>();
        users.add(new User("a1", "b1"));
        users.add(new User("c1", "d1"));
        users.add(new User("e1", "f1"));

        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users3", method = RequestMethod.GET)
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<User>> listAllUsersSecuredUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("a11", "b11"));
        users.add(new User("a12", "b12"));
        users.add(new User("a13", "b13"));
        users.add(new User("a14", "b14"));
        users.add(new User("a15", "b15"));
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<List<Book>> listAllBooksSecured() {
        List<Book> users = new ArrayList<>();
        users.add(new Book("name1", "author1", 1111));
        users.add(new Book("name2", "author2", 2222));
        users.add(new Book("name3", "author1", 3333));
        users.add(new Book("name4", "author3", 4444));
        if(users.isEmpty()){
            return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(users, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAppException(Exception ex) {
        return "unauthorized";
    }

}
