package businesslayer;

import businesslayer.model.Owner;
import businesslayer.model.User;

public class OwnerCreator implements UserCreator{

    @Override
    public User createUser(String userName, String password) {
        return new Owner(userName, password);
    }
}
