package com.dani.curso.controllers;

import com.dani.curso.models.Permiso;
import com.dani.curso.services.PermisoService;
import com.dani.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("permiso")
public class PermisoController {
    @Autowired
    PermisoService permisoService;

    //Trae a todos lo permisos
    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Permiso> getAll(){
        return permisoService.getAll();
    }

    // Trae a uno solo
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Permiso get(@PathVariable long id){
        return permisoService.get(id);
    }

    // Registrar permisos
    @RequestMapping(value = "/", method = RequestMethod.POST)
    Permiso register(@RequestBody Permiso permiso){
        // Registrarlo en la base de datos
        return permisoService.register(permiso);
    }

    // Registrar permisos
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    Permiso update(@RequestBody Permiso permiso){
        // TODO: Actualizarlo en la base de datos
        return permisoService.update(permiso);
    }

    // Elimina permisos
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id){
        // TODO: Eliminar en la base de datos
        permisoService.delete(id);
    }

}
