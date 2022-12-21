package com.revature;

import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {

        /*This is a try-with-resources block
        keep tabs open
         */
        /*Typical Javalin object creation syntax*/
        try(Connection conn = ConnectionUtil.getConnection()){
            System.out.println("CONNECTION SUCCESSFUL :) ");
        }
        catch(SQLException e){
            System.out.println("CONNECTION FAILED :(");
        }

        /* Typical Javalin object creation syntax */
        Javalin app = Javalin.create(

                /*this config lambda lets us specify certain configurations for our Javalin object
                ->? "For this config object, do the following things..."
                 */
                config -> {
                    config.enableCorsForAllOrigins(); //Allows us to process HTTP Requests from anywhere
                }
        ).start(3000); //we need .start() to start our Java server on port3000
        /*django likes port 3000 I believe
        It is a parking space for apps...*/

        UserController uc = new UserController();

        //app.get() Javalin method to take GET Requests
        app.get("/ers_users", uc.getUsersHandler);
    }
}
