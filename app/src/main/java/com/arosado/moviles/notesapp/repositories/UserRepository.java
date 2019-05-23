package com.arosado.moviles.notesapp.repositories;

import com.arosado.moviles.notesapp.models.User;
import com.orm.SugarRecord;

import java.util.List;

public class UserRepository {

    public static List<User> getAllUsers() {
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }

    public static User getUserById(Long id) {
        User user = SugarRecord.findById(User.class, id);
        return user;
    }

    public static void addUser(String nickname, String full_name, String email, String password){
        User user = new User(nickname, full_name, email, password);
        SugarRecord.save(user);
    }

    public static void editUser(Long id, String nickname, String full_name, String email, String password){
        User user = SugarRecord.findById(User.class, id);
        user.setNickname(nickname);
        user.setFull_name(full_name);
        user.setEmail(email);
        user.setPassword(password);
        SugarRecord.save(user);
    }

    public static void deleteUser(Long id){
        User user = SugarRecord.findById(User.class, id);
        SugarRecord.delete(user);
    }

    public static User login(String nickname, String password){

        List<User> users = SugarRecord.find(User.class,
                "nickname=? and password=?", nickname, password);

        if(!users.isEmpty()){
            return users.get(0);
        }
        return null;
    }

    public static boolean verifyIfExits(String nickname, String email) {
        List<User> users  = SugarRecord.find(User.class, "nickname=? and email=?", nickname, email);

        if(!users.isEmpty()){
            return true;
        }
        return false;
    }
}
