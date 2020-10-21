package Models;

import Utils.DatabaseController;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id; //id is generated by the DB (do not set it)

    private String passwordHint;

    private String password;

    private String image;

    private String username;

    private String fullname;

    @CreationTimestamp
    private Date creationDate; //creationDate is generated by the DB (do not set it)

    private boolean isAdmin;

    public User() {};
    
    public User(String fullname, String passwordHint, String image, String username, Date creationDate, boolean isAdmin) {
        this.passwordHint = passwordHint;
        this.image = image;
        this.username = username;
        this.creationDate = creationDate;
        this.isAdmin = isAdmin;
        this.fullname = fullname;
    }

    //For test purposes only
    public static User getTestUser() {
        return new User("John Snow", "", null, "shadowhunter2000",new Date(), false);
    }

    public void setUsername(String text) {

        this.username = text;
    }

    public String getUsername() {
        return username;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordHint() {
        return passwordHint;
    }

    public void setPasswordHint(String text) {
        this.passwordHint = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String text) {
        this.image = text;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //DB CRUD
    public void save() {
        DatabaseController.createRecord(this);
    }

    public void update() {
        DatabaseController.createRecord(this);
    }

    public void delete() {
        DatabaseController.deleteRecord(this.id, User.class);
    }

    static public User load(int id) {
        return (User) DatabaseController.getRecord(id,User.class);
    }

    //DB get by username and password
    public static User login(String username, String password) {
        return DatabaseController.getUserByUsernamePassword(username,password);
    }
}