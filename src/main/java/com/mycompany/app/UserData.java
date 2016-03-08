package com.mycompany.app;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dmitriy.martinov on 28.02.2016.
 */
public class UserData {
    String login;
    int user_id;
    int role;
    List<Integer> access_rights;

    public UserData(int user_id, String login, int role, List<Integer> access_rights) {
        this.user_id = user_id;
        this.login = login;
        this.role = role;
        this.access_rights = access_rights;

    }

    public String getLogin() {
        return login;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRole() {
        return role;
    }

    public List<Integer> getAccess_rights() {
        return access_rights;
    }

    public UserData() {
    }
}
