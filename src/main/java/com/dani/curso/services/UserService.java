package com.dani.curso.services;

import com.dani.curso.dao.UserDao;
import com.dani.curso.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    //Trae a todos lo usuarios
    public List<User> getAll(){
        return userDao.getAll();
    }

    // Trae a uno solo
    public User get(long id){
        return userDao.get(id);
    }

    // Registrar usuario
    public void register(User user){
        String hash = generarHash(user.getPassword());
        user.setPassword(hash);
        userDao.register(user);
    }

    // Registrar usuario
    public User update(@RequestBody User user){
        return userDao.update(user);
    }

    // Elimina usuario
    public void delete(@PathVariable long id){
        userDao.delete(id);
    }

    private String generarHash(String password){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024 * 1, 1, password);
    }

    public User login(User user){
        return userDao.login(user);
    }
}
