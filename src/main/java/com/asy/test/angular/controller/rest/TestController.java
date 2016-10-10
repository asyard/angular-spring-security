package com.asy.test.angular.controller.rest;

import com.asy.test.angular.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
        User user1 = new User("a", "b");
        User user2 = new User("c", "d");
        User user3 = new User("e", "f");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users2", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsersSecured() {
        List<User> users = new ArrayList<>();
        User user1 = new User("a1", "b1");
        User user2 = new User("c1", "d1");
        User user3 = new User("e1", "f1");
        users.add(user1);
        users.add(user2);
        users.add(user3);

        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

}
