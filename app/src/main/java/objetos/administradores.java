package objetos;

public class administradores {

    private int id;
    private String user1;
    private String pass1;
    private String user2;
    private String pass2;

    public administradores() {
        {
            user1 = "matias";
            pass1 = "123";
            user2= "benjaflasi957";
            pass2= "456";
        }
    }


    public administradores(int id, String user1, String pass1, String user2, String pass2) {
        this.id = id;
        this.user1 = user1;
        this.pass1 = pass1;
        this.user2 = user2;
        this.pass2 = pass2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser1() {
        return user1;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public String getPass1() {
        return pass1;
    }

    public void setPass1(String pass1) {
        this.pass1 = pass1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
}
