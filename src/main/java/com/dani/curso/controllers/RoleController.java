package com.dani.curso.controllers;

import com.dani.curso.models.Role;
import com.dani.curso.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    RoleService roleService;

    //Trae a todos lo roles
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Role> getAll(){
        return roleService.getAll();
    }

    // Trae a uno solo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Role get(@PathVariable long id){
        return roleService.get(id);
    }

    // Registrar roles
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Role register(@RequestBody Role role){
        // Registrarlo en la base de datos
        return roleService.register(role);
    }

    // Registrar roles
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Role update(@RequestBody Role role){
        // TODO: Actualizarlo en la base de datos
        return roleService.update(role);
    }

    // Elimina roles
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        // TODO: Eliminar en la base de datos
        roleService.delete(id);
    }
}
