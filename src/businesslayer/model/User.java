package businesslayer.model;

import javax.xml.bind.annotation.*;
import java.util.*;

public class User{

    private static int count = 1;
    private int id;
    private String stringId;
    private String userName;
    private String password;


    public User(String userName, String password) {
        this.id = count;
        count++;
        this.stringId = Integer.toString(id);
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ID: " + stringId +
                " -- " + userName.toUpperCase();
    }
}
