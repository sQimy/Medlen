package sample;

import java.io.Serializable;

class User implements Serializable {

    private static final long serialVersionUID = 1L;

    public String Code;
    public String name;
    public String usernameS;
    public String passwordS;
    public String last_name;
    public String first_name;
    public String telephone;
    public String addres;
    public String rating;


    public User(String code,String name, String usernameS,String passwordS,String last_name,String first_name,String telephone,String addres,String rating)
    {
        this.Code = code;
        this.name=name;
        this.passwordS  = passwordS;
        this.usernameS = usernameS;
        this.last_name = last_name;
        this.first_name = first_name;
        this.telephone = telephone;
        this.addres = addres;
        this.rating = rating;
    }

    public String passwordS(){
        return passwordS;

    }
    public String name() {
        return name;
    }

    public String code() {
        return Code;
    }

    public String UsernameS() {
        return usernameS;
    }

    public String last_name() {
        return last_name;
    }

    public String first_name  () {
        return first_name;
    }

    public String Telephone() {
        return telephone;
    }

    public String addres() {
        return addres;
    }
    public String rating() {
        return rating;
    }
}