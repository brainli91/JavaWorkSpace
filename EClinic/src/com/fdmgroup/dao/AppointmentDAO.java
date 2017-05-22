package com.fdmgroup.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.entity.Appointment;
import com.fdmgroup.entity.AppointmentStatus;
import com.fdmgroup.entity.User;

public class AppointmentDAO implements IStorage<Appointment>{

	@Autowired
	DBConnection dbConnection;
	
	
	public AppointmentDAO() {
		super();
	}

	
	public DBConnection getDbConnection() {
		return dbConnection;
	}


	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}


	@Override
	public Appointment read(long id) {
		EntityManager em = dbConnection.getEntityManager();
		
		return em.find(Appointment.class, id);
	}

	@Override
	public Appointment create(Appointment ap) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(ap);
		em.getTransaction().commit();
		return ap;
	}

	@Override
	public Appointment update(Appointment ap) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.persist(ap);
		em.getTransaction().commit();
		return ap;
	}

	@Override
	public boolean delete(Appointment ap) {
		EntityManager em  = dbConnection.getEntityManager();
		em.getTransaction().begin();
		ap.setStatus(AppointmentStatus.CANCELLED);
		em.merge(ap);
		em.getTransaction().commit();
		return false;
	}
	
	public List<Appointment> findAll(){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("appointment.findAll");
		List<Appointment> appointments = query.getResultList();
		return appointments;
	}
	
	public List<Appointment> findAppointmentsByStatus(AppointmentStatus status){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("appointment.findAppointmentByStatus");
		query.setParameter("status", status);
		List<Appointment> appointments = query.getResultList();
		return appointments;
	}
	
	public List<Appointment> findAppointmentsByDate (Date date){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("appointment.findAppointmentByDate");
		query.setParameter("date", date);
		List<Appointment> appointments = query.getResultList();
		return appointments;
	}

	public List<Appointment> findCurrentAppointments(){
		EntityManager em = dbConnection.getEntityManager();
		Query query = em.createNamedQuery("appointment.findCurrentAppointments");
		List<Appointment> appointments = query.getResultList();
		return appointments;
	}

}
