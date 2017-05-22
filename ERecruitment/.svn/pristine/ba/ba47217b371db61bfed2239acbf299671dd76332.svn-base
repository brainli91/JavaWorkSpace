package com.fdmgroup.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.FileEntity;
import com.fdmgroup.model.User;

public class FileDAO{
	

	@Autowired
	private DBConnection dbConnection;



	public FileEntity create(FileEntity file) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		Query query = em.createNamedQuery("fileEntity.count");
		long result = (long) query.getSingleResult();
		file.setId(result + 1);
		String filename = addNumberToTheEndOfFile(file.getFilePath(), result + 1);
		file.setFilePath(filename);
		em.persist(file);
		em.getTransaction().commit();
		return file;
	}

	private String addNumberToTheEndOfFile(String fname, long l) {
		String filename = "";
		String ext = fname.substring(fname.lastIndexOf("."));
		ext = l + ext;
		filename = filename + fname.substring(0, fname.lastIndexOf(".")) + ext;
		
		return filename;
	}

	public FileEntity update(FileEntity file) {
		EntityManager em = dbConnection.getEntityManager();
		em.getTransaction().begin();
		em.merge(file);
		em.getTransaction().commit();
		return file;
	}

	public boolean delete(FileEntity file) {
		EntityManager em = dbConnection.getEntityManager();
	    em.getTransaction().begin();
	    FileEntity fileToDelete = em.find(FileEntity.class, file);
	    em.remove(fileToDelete);
	    em.getTransaction().commit();
		return true;
	}

	public List<FileEntity> findAllByUser(User user){
		EntityManager em = dbConnection.getEntityManager();
	    Query query = em.createNamedQuery("fileEntity.findAll");
	    List<FileEntity> files = query.getResultList();
	    return files;
	}

	public DBConnection getDbConnection() {
		return dbConnection;
	}

	public void setDbConnection(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
}
