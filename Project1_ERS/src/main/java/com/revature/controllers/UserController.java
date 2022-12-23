package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.UserDAO;
import com.revature.models.Employee;
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
        /*LOGIN
        With this if-statement, I will be able to restrict access
         */

        if(AuthController.ses != null){
            System.out.println(AuthController.ses.getAttribute("ers_username"));
            System.out.println(AuthController.ses.getAttribute("ers_password"));


//            UserDAO uDAO = new UserDAO();
            ArrayList<User> employees = uDAO.getUsers();

            //instantiate a GSON object so that we can make Java <-> JSON conversions
            Gson gson = new Gson();

            //use the GSON .toJson() method to turn our Java into a JSON String (JSON is always in String format)
            String JSONEmployees = gson.toJson(employees);

            //we use ctx.result() to send back an HTTP Response
            ctx.result(JSONEmployees); //this will send back al employee data


            //we can set status code with ctx.status()
            ctx.status(202); //202 stands for accepted. 200 is default which is also good
            //how to close session...
        } else {
            ctx.result("YOU MUST LOG IN TO DO THIS");
            ctx.status(401); //401 "unauthorized"
        }
    };


    public Handler insertUsersHandler = (ctx) -> {
        String body = ctx.body();

        Gson gson = new Gson();

        User newUser = gson.fromJson(body, User.class);

        if(uDAO.insertUser(newUser)!= null){
            ctx.status(201); //201 "accepted"
            ctx.result(body);
        } else {
            ctx.result("Try another username");
            ctx.status(406); //406 "not acceptable"
        }
    };

        //PROBLEM: can't send plain Java in HTTP Response. Must use JSON



//    } else {
//        ctx.result("YOU MUST LOG IN TO DO THIS");
//        ctx.status(401); //401 "unauthorized"
//    }

 //make sure to add a semicolon to the end of the curly brace on the lambda

}
