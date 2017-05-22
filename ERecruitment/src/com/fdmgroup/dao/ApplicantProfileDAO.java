package com.fdmgroup.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.fdmgroup.model.ApplicantProfile;

public class ApplicantProfileDAO implements IStorage<ApplicantProfile> {

	@Autowired
	@Qualifier("dbConnection")
	private DBConnection dbConnection;
	
	@Autowired
	@Qualifier("workHistoryDAO")
	private WorkHistoryDAO workHistoryDAO;
	
	@Autowired
	@Qualifier("educationDAO")
	private EducationDAO educationDAO;
	
	@Autowired
	@Qualifier("userDAO")
	private UserDAO userDAO;
  
  

	public WorkHistoryDAO getWorkHistoryDAO() {
		return workHistoryDAO;
	}

  	@Autowired
	public void setWorkHistoryDAO(WorkHistoryDAO workHistoryDAO) {
		this.workHistoryDAO = workHistoryDAO;
	}

	public EducationDAO getEducationDAO() {
		return educationDAO;
	}
	
	@Autowired
	public void setEducationDAO(EducationDAO educationDAO) {
		this.educationDAO = educationDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

public ApplicantProfileDAO() {
    super();
  }

  public DBConnection getDbConnection() {
    return dbConnection;
  }
  public void setDbConnection(DBConnection dbConnection) {
    this.dbConnection = dbConnection;
  }

  @Override
  public ApplicantProfile read(long id) {
    EntityManager em = dbConnection.getEntityManager();
    return em.find(ApplicantProfile.class, id);
  }

  @Override
  public ApplicantProfile create(ApplicantProfile ap) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.persist(ap);
    em.getTransaction().commit();
/*    User user = ap.getUser();
    user.setApplicantProfile(ap);*/
   /* userDAO.update(user);*/
    return ap;
  }

  @Override
  public ApplicantProfile update(ApplicantProfile ap) {
    EntityManager em = dbConnection.getEntityManager();
    em.getTransaction().begin();
    em.merge(ap);
    em.getTransaction().commit();
    return ap;
  }

  @Override
  public boolean delete(ApplicantProfile t) {
    return false;
  }
  
  public ApplicantProfile getProfileByUserId(long id){
	  EntityManager em = dbConnection.getEntityManager();
	  Query query = em.createNamedQuery("applicantProfile.findByUserId");
	  query.setParameter("uId", id);
	  
	  List<ApplicantProfile> profile = query.getResultList();
	  
	  if(profile==null || profile.size() > 1)
		  return null;
	  
	  return profile.get(0);  
  }
  
  public ApplicantProfile findProfileByEmail(String email){
	  EntityManager em = dbConnection.getEntityManager();
	  Query query = em.createNamedQuery("applicantProfile.findByEmail");
	  query.setParameter("uEmail", email);
	  List<ApplicantProfile> profile = query.getResultList();
	  if (profile == null || profile.size() > 1) 
		  return null;
	  return profile.get(0);
  }
  
  public List<String> getInterestList(long id){
	  EntityManager em = dbConnection.getEntityManager();
	  ApplicantProfile ap = em.find(ApplicantProfile.class, id);
	  
	  String interests = ap.getInterests();
	  if(interests == null)
		  return null;
	  return Arrays.asList(interests.split("\\|"));
  }
  
  public List<String> getSkillsList(long id){
	  EntityManager em = dbConnection.getEntityManager();
	  ApplicantProfile ap = em.find(ApplicantProfile.class, id);
	  
	  String skills = ap.getSkills();
	  if(skills == null)
		  return null;
	  return Arrays.asList(skills.split("\\|"));
  }
  
  
  

}
