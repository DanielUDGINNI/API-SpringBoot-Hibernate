package com.dani.curso.services;

import com.dani.curso.dao.PermisoDao;
import com.dani.curso.models.Permiso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class PermisoService {
    @Autowired
    PermisoDao permisoDao;
    //Trae a todos lo roles
    public List<Permiso> getAll(){
        return permisoDao.getAll();
    }

    // Trae a uno permiso
    public Permiso get(long id){
        return permisoDao.get(id);
    }

    // Registrar permiso
    public Permiso register(Permiso permiso){
        return permisoDao.register(permiso);
    }

    // Registrar permiso
    public Permiso update(@RequestBody Permiso permiso){
        return permisoDao.update(permiso);
    }

    // Elimina permiso
    public void delete(@PathVariable long id){
        permisoDao.delete(id);
    }
}
