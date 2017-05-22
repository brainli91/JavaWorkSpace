package com.fdmgroup.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnection {

  EntityManagerFactory emf = null;
  EntityManager em = null;

  private void init() {
    if (emf == null) {
      emf = Persistence.createEntityManagerFactory("EClinic");
    }
    em = emf.createEntityManager();
  }

  public EntityManager getEntityManager() {
    if (em == null || !em.isOpen()) {
      init();
    }
    return em;
  }

}
