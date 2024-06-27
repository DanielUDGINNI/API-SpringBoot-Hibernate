package com.dani.curso.controllers;
import com.dani.curso.utils.JWTUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.dani.curso.models.User;
import com.dani.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    //Trae a todos lo usuarios
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll(){
        return userService.getAll();
    }

    // Trae a uno solo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id){
        return userService.get(id);
    }

    // Registrar usuario
    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user){
        // Registrarlo en la base de datos
        userService.register(user);
    }

    // Registrar usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user){
        // TODO: Actualizarlo en la base de datos
        return userService.update(user);
    }

    // Elimina usuario
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        // TODO: Eliminar en la base de datos
        userService.delete(id);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Map<String, Object> login(@RequestBody User dto){
        User user = userService.login(dto);
        Map<String, Object> result = new HashMap<>();
        if(user != null){
            String token = jwtUtil.create(String.valueOf(user.getId()), user.getEmail());
            result.put("token", token);
            result.put("user", user);
        }
        return result;
    }


}
