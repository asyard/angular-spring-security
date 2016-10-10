package com.asy.test.angular.controller.rest;

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
    public ResponseEntity<List<User>> listAllUsersSecuredAdmin() {
        List<User> users = new ArrayList<>();
        User user1 = new User("a1", "b1");
        users.add(user1);
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String handleAppException(Exception ex) {
        return "unauthorized";
    }

}
