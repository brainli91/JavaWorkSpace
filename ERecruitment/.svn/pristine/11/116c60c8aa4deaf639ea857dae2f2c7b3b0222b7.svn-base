package com.fdmgroup.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Education;

public class EducationDAO implements IStorage<Education> {

  @Autowired
  private DBConnection dbConnection;

  public EducationDAO() {
    super();
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }

  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  @Override
  public Education read(long id) {
    EntityManager em = dbConnection.getEntityManager();
    Education edu = em.find(Education.class, id);
    return edu;
  }

  @Override
  public Education create(Education edu) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.persist(edu);
    em.getTransaction().commit();
    return edu;
  }

  @Override
  public Education update(Education edu) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.merge(edu);
    em.getTransaction().commit();
    return edu;
  }

  @Override
  public boolean delete(Education edu) {
    EntityManager em = dbConnection.getEntityManager();
    if (em.contains(edu)) {
      em.getTransaction().begin();
      em.remove(edu);
      em.getTransaction().commit();
      return true;
    }
    return false;
  }

}
