package com.fdmgroup.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.WorkHistory;

public class WorkHistoryDAO implements IStorage<WorkHistory> {

  @Autowired
  private DBConnection dbConnection;

  public WorkHistoryDAO() {
    super();
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }

  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  @Override
  public WorkHistory read(long id) {
    EntityManager em = dbConnection.getEntityManager();
    WorkHistory wh = em.find(WorkHistory.class, id);
    return wh;
  }

  @Override
  public WorkHistory create(WorkHistory wh) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.persist(wh);
    em.getTransaction().commit();
    return wh;
  }

  @Override
  public WorkHistory update(WorkHistory wh) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.merge(wh);
    em.getTransaction().commit();
    
    return wh;
  }

  @Override
  public boolean delete(WorkHistory wh) {
    EntityManager em = dbConnection.getEntityManager();
    if (em.contains(wh)) {
      em.getTransaction().begin();
      em.remove(wh);
      em.getTransaction().commit();
      return true;
    }
    return false;
  }

}
