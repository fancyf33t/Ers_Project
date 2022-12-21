package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import io.javalin.http.Handler;

import java.util.ArrayList;

/*
The Controller layer is where HTTP Request get sent after Javalin directs them.
It's in this layer that JSON comes in and gets translated to Java and vice versa.
Get data from Service or DAO to get an HTTP Response to the front end...
Receive data from the front end to send to the database(insert, update, delete)
 */
public class UserController {
    // UserDAO object to use its methods
    UserDAO uDAO = new UserDAO();

    //make sure it is java.io http
    public Handler getUsersHandler = (ctx) -> {

//        if(AuthController.ses != null){
//            System.out.println(AuthController.ses.getAttribute("username"));
//            System.out.println(AuthController.ses.getAttribute("password"));
//        }
        //gson
//        Gson gson = new Gson();
//        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
//        User user =
//        String body = ctx.body();
//
//
//        User JsonBody = gson.fromJson(body, User.class);
        //make it match
    };

}
