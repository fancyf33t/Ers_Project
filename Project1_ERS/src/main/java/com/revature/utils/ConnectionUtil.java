package com.revature.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    //This method will eventually return an object of type Connection, which we'll use to connect to our database
    public static Connection getConnection() throws SQLException {
        //For compatibility with other technologies/frameworks, we'll need to register our PostgresSQL driver
        //This process makes the application aware of what Driver class we're using
        try {
            Class.forName("org.postgresql.Driver"); //searching for the postgres driver, which we have as a dependency
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //This tells in the console us what went wrong
            System.out.println("problem occurred locating driver");
        }
        //Use our database credentials to establish a database connection
        //Hardcoded for now - It's possible hide them in the Environment Variables, feel free to look into it

        //I'm going to put the credentials in Strings, and use those strings in a method that gets connections
        String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=project1_demo_schema";
        String username = "postgres";
        String password = "post_password";
        /*
         * url - the location of your database/schema
         * username - postgres username (usually postgres)
         * password - postgres password (post_password)
         * */

        //This return statement is what returns out actual database Connection object
        //Note how this getConnection() method has a return type of Connection
        return DriverManager.getConnection(url, username, password);

    }

}
