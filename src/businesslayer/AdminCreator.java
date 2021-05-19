package businesslayer;

import businesslayer.model.Admin;
import businesslayer.model.User;

public class AdminCreator implements UserCreator{


    @Override
    public User createUser(String userName, String password) {
        return new Admin(userName, password);
    }
}
