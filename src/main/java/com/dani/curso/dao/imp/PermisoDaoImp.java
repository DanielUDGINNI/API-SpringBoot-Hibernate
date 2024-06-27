package com.dani.curso.dao.imp;

import com.dani.curso.dao.PermisoDao;
import com.dani.curso.models.Permiso;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll(){
        String hql = "FROM Role as u";
        //List<User> resultList = entityManager.createQuery(hql).getResultList();
        //return resultList;
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public Permiso get(long id){
        return entityManager.find(Permiso.class, id);
    }
    @Transactional
    @Override
    public Permiso register(Permiso permiso){
        entityManager.merge(permiso);
        return permiso;
    }
    @Transactional
    @Override
    public Permiso update(Permiso permiso){
        entityManager.merge(permiso);
        return permiso;
    }
    @Transactional
    @Override
    public void delete(long id){
        Permiso permiso = get(id);
        entityManager.remove(permiso);
    }
}
