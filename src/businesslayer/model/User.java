package businesslayer.model;

public abstract class User{

    private static int count = 1;
    private int id;
    private String userName;
    private String password;
    // aunthentication with roles (hoteladmin, owner) cast later


    public User(String userName, String password) {
        this.id = count;
        count++;
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
        return "ID: " + id +
                " -- " + userName.toUpperCase();
    }
}
