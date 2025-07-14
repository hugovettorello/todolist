package br.com.hugovettorello.todolist.user;

public class UserModel {
    public String username;
    public String name;
    public String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserName(){
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
