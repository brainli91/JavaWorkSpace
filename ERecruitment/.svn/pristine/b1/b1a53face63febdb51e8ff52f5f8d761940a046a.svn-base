package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.Interview;
import com.fdmgroup.model.InterviewResult;
import com.fdmgroup.model.InterviewType;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.User;


public class InterviewDAO implements IStorage<Interview>{
	
	@Autowired
	private DBConnection dbConnection;

//find all interviews by user

	public DBConnection getDbConnection() {
		return dbConnection;
	}


	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}

	public InterviewDAO() {
		super();
	}

	@Override
	public Interview read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		Interview interview = em.find(Interview.class, id);

		return interview;
	}

	@Override
	public Interview create(Interview interview) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(interview);
		em.getTransaction().commit();
		return interview;
	}

	@Override
	public Interview update(Interview interview) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(interview);
		em.getTransaction().commit();
		return interview;
	}

	@Override
	public boolean delete(Interview interview) {
		EntityManager em = dbConnection.getEntityManager();
		if(em.contains(interview)){
			em.getTransaction().begin();
			em.merge(interview);
			em.getTransaction().commit();
			return true;
		}
	return false;
	}

	public List<Interview> findAll() {
		    EntityManager em = dbConnection.getEntityManager();
		    Query query = em.createNamedQuery("interview.findAll");
		    List<Interview> interviews = query.getResultList();
		    return interviews;
		  }
	
	public List<Interview> findCurrentInterviews() {
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("interview.findCurrentInterviews");
		List<Interview> interviews = query.getResultList();
		return interviews;
	}
	
	public List<Interview> findInterviewsByResult(InterviewResult InterviewResult ){
		EntityManager em =  dbConnection.getEntityManager();
		Query query = em.createNamedQuery("interview.findInterviewsByResult");
		query.setParameter("InterviewResult", InterviewResult);
		List<Interview> interviews = query.getResultList();
		return interviews;
	}

	public List<Interview> findInterviewsByType(InterviewType InterviewType ){
		EntityManager em =  dbConnection.getEntityManager();
		Query query = em.createNamedQuery("interview.findInterviewsByType");
		query.setParameter("InterviewType", InterviewType);
		List<Interview> interviews = query.getResultList();
		return interviews;
	}
	
	public List<Interview> findUserInterviews(User user) {
		List<Interview> setOfInterviews = new ArrayList<>();
		  if (user.getRole().getName().equals("admin")){
			  return setOfInterviews;
		  } else if (user.getRole().getName().equals("applicant")){		  		  
			  Set<JobApplication> jobApplications = user.getJobApplications();
			  for ( JobApplication ja : jobApplications){
				  Set<Interview> interviews = ja.getInterviews();
				  if(!(interviews==null)){
					  if (! interviews.isEmpty()) {
						  for (Interview interview : interviews) {
							  User tmp = interview.getJobApplication().getApplicant();
							  if (tmp.equals(user)){						
								  setOfInterviews.add(interview);
							  }
						  }
					  }
				  }
				  else {
					  return setOfInterviews;
				  }
			  }
		  }
		  else if (user.getRole().getName().equals("recruiter")){		  
			  Set<Job> createdJobs = user.getCreatedJobs();
			  if (! createdJobs.isEmpty()) {
				  for (Job job : createdJobs) {
					  Set<JobApplication> jobApplications2 = job.getJobApplications();
					  for ( JobApplication ja : jobApplications2){
						  Set<Interview> interviews = ja.getInterviews();
						  if(!(interviews==null)){
							  if (! interviews.isEmpty()) {
								  for (Interview interview : interviews) {
									  setOfInterviews.add(interview);
								  }
							  }else {
								  return setOfInterviews;
							  }
							  
						  }
					  }
				  }
			  }
		  }
		  else {
			  return setOfInterviews;
		  }
		  return setOfInterviews;
	}

	
}
