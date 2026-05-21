package com.example.k234112eapp.models;

import java.util.ArrayList;

public class ListUserAccount {
    public static ArrayList<UserAccount> getUserAccounts() {
        ArrayList<UserAccount> database = new ArrayList<>();

        database.add(new UserAccount("admin", "123", "admin","Thi Ho", true));
        database.add(new UserAccount("user1", "123","employee", "Nguyen Van A", true));
        database.add(new UserAccount("user2", "123", "employee", "Nguyen Van B", true));

        return database;
    }
    public static UserAccount login(String username, String password)
    {
        // step 1: query data
        ArrayList<UserAccount> database = getUserAccounts();
        // step 2: compare to login
        for(UserAccount user : database)
        {
            if(user.getUsername().equals(username) && user.getPassword().equals(password))
            {//login success
                return user;
            }
        }
        return null; //failed
    }
}
