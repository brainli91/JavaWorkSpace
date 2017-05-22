package com.fdmgroup.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Role;

public class RoleDAO implements IStorage<Role> {

  @Autowired
  private DBConnection dbConnection;

  public RoleDAO() {
    super();
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }

  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  @Override
  public Role read(long id) {
    EntityManager em = dbConnection.getEntityManager();
    return em.find(Role.class, id);
  }

  @Override
  public Role create(Role role) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.persist(role);
    em.getTransaction().commit();
    return role;
  }

  @Override
  public Role update(Role role) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.merge(role);
    em.getTransaction().commit();
    return role;
  }

  @Override
  public boolean delete(Role role) {
    EntityManager em = dbConnection.getEntityManager();
    if (em.contains(role)) {
      em.getTransaction().begin();
      em.remove(role);
      em.getTransaction().commit();
      return true;
    }
    return false;
  }

  public List<Role> findAll() {
    EntityManager em = dbConnection.getEntityManager();
    Query query = em.createNamedQuery("role.findAll");
    List<Role> roles = query.getResultList();
    return roles;
  }

  public Role findByName(String name) {
    EntityManager em = dbConnection.getEntityManager();
    Query query = em.createNamedQuery("role.findByName");
    query.setParameter("rname", name);
    List<Role> role = query.getResultList();
    if (role.isEmpty() || role.size() > 1)
      return null;
    return role.get(0);
  }

}
