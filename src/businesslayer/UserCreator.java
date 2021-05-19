package businesslayer;

import businesslayer.model.User;

public interface UserCreator {

    public User createUser(String userName, String password);

}
