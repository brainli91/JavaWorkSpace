package com.fdmgroup.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.Profile;

public class ProfileDAO implements IStorage<Profile> {

	@Autowired
	DBConnection dbConnection;

	public ProfileDAO() {
		super();
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	@Override
	public Profile read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		return em.find(Profile.class, id);
	}

	@Override
	public Profile create(Profile profile) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(profile);
		em.getTransaction().commit();
		return profile;
	}

	@Override
	public Profile update(Profile profile) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(profile);
		em.getTransaction().commit();
		return profile;
	}

	@Override
	public boolean delete(Profile profile) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.remove(profile);
		em.getTransaction().commit();
		return false;
	}

	public Profile findProfileByUserId(long id) {
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("Profile.findByUserId");
		query.setParameter("uId", id);
		List<Profile> profiles = query.getResultList();
		if (profiles.isEmpty() && profiles.size() != 1) {
			return null;
		}
		return profiles.get(0);
	}

	public Profile findProfileByEmail(String email) {
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("Profile.findByEmail");
		query.setParameter("uEmail", email);
		List<Profile> profiles = query.getResultList();
		if (profiles.isEmpty() && profiles.size() != 1) {
			return null;
		}
		return profiles.get(0);
	}

	public List<String> getDiseaseList(long id) {
		EntityManager em = dbConnection.getEntityManager();
		Profile profile = em.find(Profile.class, id);

		String diseases = profile.getDiseases();
		if (diseases == null) {
			return null;
		}
		return Arrays.asList(diseases.split("\\|"));

	}

}
