package com.database.demo.service;

import com.database.demo.dao.UserDao;
import com.database.demo.utils.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.charset.StandardCharsets;

@Service
public class LoginService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private Encryption encryption;

    public int signUp(String username,String password,String role){
        String realPassword = userDao.getPassword(username);
        if(null!=realPassword) return -1;
        byte[] bytesOfPassword = password.getBytes(StandardCharsets.UTF_8);
        String newPassword = encryption.MD5Encrypt(bytesOfPassword);
        return userDao.signUp(username, newPassword, role);
    }

    public String signIn(String username,String password) {
        String realPassword = userDao.getPassword(username);
        if(null==realPassword) return "invalid username";
        byte[] bytesOfPassword = password.getBytes(StandardCharsets.UTF_8);
        String nPassword = encryption.MD5Encrypt(bytesOfPassword);
        if(realPassword.equals(nPassword)){
            return userDao.getRole(username);
        }else return "wrong password";
    }

}
