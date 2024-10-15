package dk.kea.practice.Model;

public class User {
    private int user_id; // Corresponds to user_id in SQL
    private String user_navn; // Corresponds to user_navn in SQL
    private String user_email; // Corresponds to user_email in SQL
    private String user_password; // Corresponds to user_password in SQL
    private int user_telefonnummer; // Corresponds to user_telefonnummer in SQL
    private String user_rolle; // Corresponds to user_rolle in SQL


    public User() {}


    public User(String user_navn, String user_email, String user_password, int user_telefonnummer, String user_rolle) {
        this.user_navn = user_navn;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_telefonnummer = user_telefonnummer;
        this.user_rolle = user_rolle;
    }


    public User(int user_id, String user_navn, String user_email, String user_password, int user_telefonnummer, String user_rolle) {
        this.user_id = user_id;
        this.user_navn = user_navn;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_telefonnummer = user_telefonnummer;
        this.user_rolle = user_rolle;
    }

    // Getters and Setters
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_navn() {
        return user_navn;
    }

    public void setUser_navn(String user_navn) {
        this.user_navn = user_navn;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getUser_telefonnummer() {
        return user_telefonnummer;
    }

    public void setUser_telefonnummer(int user_telefonnummer) {
        this.user_telefonnummer = user_telefonnummer;
    }

    public String getUser_rolle() {
        return user_rolle;
    }

    public void setUser_rolle(String user_rolle) {
        this.user_rolle = user_rolle;
    }


    @Override
    public String toString() {
        return "User{" +
                "user_email='" + user_email + '\'' +
                ", user_id=" + user_id +
                ", user_navn='" + user_navn + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_telefonnummer=" + user_telefonnummer +
                ", user_rolle='" + user_rolle + '\'' +
                '}';
    }

}