package ap_project;

public class User {
    
    public Integer id;
    public String email;
    public String name;
    public String password;
    public String dob;

    //constrcutor without user id
    public User(String email, String name, String password, String dob) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
    }

    //constructor with user id
    public User(Integer id, String email, String name, String password, String dob) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.dob = dob;
    }

    //getter 
    
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getDob() {
        return dob;
    }

    //setter 
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    
    
           
}
