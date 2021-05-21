package businesslayer;

import businesslayer.model.HotelAdmin;
import businesslayer.model.User;

public class AdminCreator implements UserCreator{


    @Override
    public User createUser(String userName, String password) {
        return new HotelAdmin(userName, password);
    }
}
