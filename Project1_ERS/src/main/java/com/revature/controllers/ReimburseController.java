package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.daos.ReimburseDAO;
import com.revature.models.Reimburse;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class ReimburseController {
    //ReimburseDAO object to use its methods
    ReimburseDAO rDAO = new ReimburseDAO();

    //make sure to just java.io http
    public Handler getReimburseHandler = (ctx) -> {
        ReimburseDAO rDAO = new ReimburseDAO();
        ArrayList<Reimburse> tickets = rDAO.getReimbursement();

        Gson gson = new Gson();
        String JSONTickets = gson.toJson(tickets);
        ctx.result(JSONTickets); // send back all ticket data

        ctx.status(202);
    };

    public Handler insertReimbursementHandler = (ctx) -> {
        String body = ctx.body();

        Gson gson = new Gson();

        Reimburse newTicket = gson.fromJson(body, Reimburse.class);
        /*Calling insert ticket method
        If successful, send 201
        If failure, send back 406
         */

        //works sort of
        String JSONTickets = gson.toJson(newTicket);
//        ctx.result(JSONTickets); // send back all ticket data
//        ctx.status(202);

        //does not work
        if(rDAO.insertReimbursement(newTicket) != null){
            ctx.status(201);
            ctx.result(body);
        } else {
            ctx.status(406);
        }
    };

    /*update feature
    I want this handler to update a ticket that has the status pending
     */
    public Handler updateReimbursementHandler = (ctx)-> {
        String reimburse_status = ctx.pathParam("pending");

        String update = ctx.body();
    };
}
