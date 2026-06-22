package org.SpringTutorials;

public class Password {


    private String password;


    public Password(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printPassWord(){
        System.out.println("The password of application is : "+password);
    }
}

