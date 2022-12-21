package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.AuthDAO;
import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import io.javalin.http.Handler;

import javax.servlet.http.HttpSession;

public class AuthController {
    AuthDAO aDAO = new AuthDAO();

    //empty HttpSession object that will be filed upon successful login
    public static HttpSession ses;
    /*To prevent functionalities from running until login, have them check
    if the session is null...
    What?
     */

    //login will be a POST request, since the user is expected to send some data in the HTTP Request
    public Handler loginHandler=(ctx)->{

        //ctx.body() to grab HTTP Request data
        String body = ctx.body();

        //GSON for the JSON -> Java conversion
        Gson gson = new Gson();

        //take the incoming data, instantiate a LoginDTO class
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class); //.class = "turn this into a LoginDTO object"

        //if login is successful, this Employee object will be populated. Otherwise, null
        User loggedInUser = aDAO.login(lDTO.getUsername(), lDTO.getPassword());

        if (loggedInUser != null) {

            ses = ctx.req.getSession();
            //time 11:57

            //setAttribute() to set certain values to certain keys
            // this is how you save data in a session
//            ses.setAttribute("role_id", loggedInUser.getRole().getRole_id());
//            ses.setAttribute("employee_id", loggedInUser.getEmployee_id());

            //role id would be used to determine manager/employee, giving access to only certain methods

            //turn the employee back into JSON, so we can send it in the HTTP Response
            String userJSON = gson.toJson(loggedInUser);
            ctx.result(userJSON);
            ctx.status(202); //202 "accepted"

        } else {
            ctx.status(401); //401 "unauthorized"
        }

    };
}
