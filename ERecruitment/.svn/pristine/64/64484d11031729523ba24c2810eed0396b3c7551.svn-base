package com.fdmgroup.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;

import com.fdmgroup.model.Job;
import com.fdmgroup.model.User;

public class JobDAOTest {

  @Mock
  User user;

  static DBConnection dbConnection = new DBConnection();
  Date date = new Date(0);
  static JobDAO jobDAO = new JobDAO();

  Job job, job1;
  List<Job> jobList = new ArrayList<Job>();

  @BeforeClass
  public static void setUpBeforeClass() {
    jobDAO.setDbConnection(dbConnection);
  }

  @Before
  public void setUp() {
    job = new Job("QA Automation", "need selenium", date, date, "selenium", 5, user);
    job1 = new Job("QA Automation", "need selenium", date, date, "selenium", 20, user);
    jobList.add(job);
    jobList.add(job1);

  }

  @Test
  @Ignore
  public void createTest() {
    Job createdJob = jobDAO.create(job);
    assertEquals(job, createdJob);

  }

  @Test
  @Ignore
  public void readTest() {
    jobDAO.create(job);
    Job readJob = jobDAO.read(1L);
    System.out.println(readJob);
    assertEquals(job, readJob);
  }

  @Test

  public void updateTest() {

    Job expectedjob = jobDAO.create(job);
    job.setNumOfPositions(20);
    Job updatedJob = jobDAO.update(job);
    System.out.println(updatedJob);
    assertEquals(expectedjob, updatedJob);
  }

  @Test
  @Ignore
  public void deleteTest() {
    jobDAO.create(job);
    Boolean deletedJob = jobDAO.delete(job);
    System.out.println(deletedJob);
    assertEquals(job1, deletedJob);
  }

  @Test
  @Ignore
  public void findAllTest() {
    jobDAO.create(job);
    jobDAO.create(job1);
    List<Job> jobs = jobDAO.findAll();
    assertEquals(jobList, jobs);

  }

}
