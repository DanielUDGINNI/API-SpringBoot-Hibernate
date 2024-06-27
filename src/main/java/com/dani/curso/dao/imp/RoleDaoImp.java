package com.dani.curso.dao.imp;

import com.dani.curso.dao.RoleDao;
import com.dani.curso.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {
    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll(){
        String hql = "FROM Role as u";
        //List<User> resultList = entityManager.createQuery(hql).getResultList();
        //return resultList;
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }
    @Transactional
    @Override
    public Role get(long id){
        return entityManager.find(Role.class, id);
    }
    @Transactional
    @Override
    public Role register(Role role){
        entityManager.merge(role);
        return role;
    }
    @Transactional
    @Override
    public Role update(Role role){
        entityManager.merge(role);
        return role;
    }
    @Transactional
    @Override
    public void delete(long id){
        Role role = get(id);
        entityManager.remove(role);
    }
}
