package businesslayer.model;


import javax.xml.bind.annotation.XmlID;

public abstract class User{

    private static Integer count = 1;
    @XmlID
    private String id;
    private String userName;
    private String password;


    public User() {
        this.id = count.toString();
        count++;
        this.userName = "";
        this.password = "";
    }

    public User(String userName, String password) {
        this.id = count.toString();
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
        return "ID = " + id + "      " + " Username = " + userName.toUpperCase();
    }
}
