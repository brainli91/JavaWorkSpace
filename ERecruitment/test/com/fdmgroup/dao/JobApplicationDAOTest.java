package com.fdmgroup.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.fdmgroup.model.ApplicationStatus;
import com.fdmgroup.model.Job;
import com.fdmgroup.model.JobApplication;
import com.fdmgroup.model.User;

public class JobApplicationDAOTest {

	private static User dummyApplicant;
	private static User dummyApplicant2;
	private static Job dummyJob;
	private static Job dummyJob2;
	private static DBConnection dbConnection;
	private static JobApplicationDAO jobAppDAO;
	
	@BeforeClass
	public static void init() {
		dbConnection = new DBConnection();
		jobAppDAO = new JobApplicationDAO();
		dummyApplicant = new User("dum1@dum.dum", "dum1klgh43kajfdkal;fasf;'a", "Dum", "Dumm", null);
		dummyApplicant2 = new User("dum2@dum.dum", "dum@2222klgh43kajfdkal;fasf;'a", "Dumtwo", "Dumm", null);
		dummyJob = new Job("Dummy Job 1", "This is a dummy job", new Date(Calendar.getInstance().getTimeInMillis()), new Date(Calendar.getInstance().getTimeInMillis()), "Dummy|One", 5, null);
		dummyJob2 = new Job("Dummy Job 2", "This is a dummy job", new Date(Calendar.getInstance().getTimeInMillis()), new Date(Calendar.getInstance().getTimeInMillis()), "Dummy|Two", 5, null);
		JobApplication ja1 = new JobApplication(dummyApplicant, dummyJob);
		JobApplication ja2 = new JobApplication(dummyApplicant2, dummyJob2);
		
		jobAppDAO.setDbConnection(dbConnection);
		
		jobAppDAO.create(ja1);
		jobAppDAO.create(ja2);
	}
	
	@Test
	public void testCreateNewJobApplication_returnNewJobApplication() {
		JobApplication ja3 = new JobApplication(dummyApplicant, dummyJob2);
		
		assertNotNull(jobAppDAO.create(ja3));
	}
	
	@Test
	public void testRead_IdDoesNotExist_ReturnNull() {
		assertNull(jobAppDAO.read(456466));
	}
	
	@Test
	public void testRead_IdExists_ReturnJobApplication() {
		assertNotNull(jobAppDAO.read(1));
	}
	
	@Test
	public void testUpdate_JobAppDoesNotExist_ReturnNull() {
		assertNull(jobAppDAO.update(new JobApplication()));
	}
	
	@Test
	public void testUpdate_JobAppExists_ReturnNewlyUpdatedObject() {
		JobApplication jobApp = jobAppDAO.read(1);
		if(jobApp == null){
			
		}
		else {
			jobApp.setStatus(ApplicationStatus.REJECTED);
			assertNotNull(jobAppDAO.update(jobApp));
		}
	}
	
	@Test
	public void testDelete_JobAppDoesNotExist_ReturnFalse() {
		assertFalse(jobAppDAO.delete(new JobApplication()));
	}
	
	@Test
	public void testDelete_JobAppExists_ReturnTrue() {
		JobApplication jobApp = jobAppDAO.read(1);
		assertTrue(jobAppDAO.delete(jobApp));
	}
	
}
