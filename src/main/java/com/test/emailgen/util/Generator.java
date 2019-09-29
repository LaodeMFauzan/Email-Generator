package com.test.emailgen.util;

public class Generator {
    private String fullName;
    private String email;
    private String userName;

    public Generator(String fullName) {
        this.fullName = fullName;
        generateUserName();
        generateEmail();
    }

    private void generateUserName(){
        if (fullName.split(" ").length > 1){
            String[] splitName = fullName.split(" ");
            userName = (splitName[0]+"."+splitName[splitName.length-1]).toLowerCase();
        } else {
            userName = fullName.toLowerCase();
        }
        //userName = userName.toLowerCase();
    }

    private void generateEmail(){
        email = userName+"@kalimat.ai";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
