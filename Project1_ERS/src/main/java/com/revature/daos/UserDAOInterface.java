package com.revature.daos;

import com.revature.models.User;
import java.util.ArrayList;

public interface UserDAOInterface {

    //lay out functionalities
    ArrayList<User> getUsers();

    User insertUser(User us);

    User deletUser(User us);
}
