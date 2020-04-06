package com.renata.mentesaudvel.Model;

public class User {

    public String userId;
    public String age;
    public String gender;
    public String userName;
    public String emailAddress;
    public String password;
    public String feelStatus;
    public String dateHistory;
    public String situation;
    public String thought;
    public String action;

    public User() {

    }

    public User(String userId, String age, String gender, String userName, String emailAddress, String password, String feelStatus, String dateHistory, String situation, String thought, String action) {
        this.userId = userId;
        this.age = age;
        this.gender = gender;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.feelStatus = feelStatus;
        this.dateHistory = dateHistory;
        this.situation = situation;
        this.thought = thought;
        this.action = action;
    }

    public String getUserId() {
        return  userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFeelStatus() {
        return feelStatus;
    }

    public void setFeelStatus(String feelStatus) {
        this.feelStatus = feelStatus;
    }


    public String getDateHistory() {
        return dateHistory;
    }

    public void setDateHistory(String dateHistory) {
        this.dateHistory = dateHistory;
    }

    public String getSituation() {
        return  situation;
    }
    public void setSituation(String situation) {
        this.situation = situation;
    }
    public String getThought() {
        return  thought;
    }
    public void setThought(String thought) {
        this.thought = thought;
    }
    public String getAction() {
        return  action;
    }
    public void setAction(String action) {
        this.action = action;
    }

}
