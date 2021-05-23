package businesslayer.creator;

import businesslayer.model.User;

public interface UserCreator {

    User createUser(String userName, String password);

}
