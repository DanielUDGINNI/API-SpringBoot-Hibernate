package com.dani.curso.services;

import com.dani.curso.dao.RoleDao;
import com.dani.curso.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleDao roleDao;
    //Trae a todos lo roles
    public List<Role> getAll(){
        return roleDao.getAll();
    }

    // Trae a uno solo
    public Role get(long id){
        return roleDao.get(id);
    }

    // Registrar role
    public Role register(Role role){
        return roleDao.register(role);
    }

    // Registrar role
    public Role update(@RequestBody Role role){
        return roleDao.update(role);
    }

    // Elimina role
    public void delete(@PathVariable long id){
        roleDao.delete(id);
    }
}

