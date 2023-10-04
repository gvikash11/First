package e1_manytomany_hibernate1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_manytomany_hibernate1.dto.Course;

public class CourseCrud {
	
	public EntityManager getmanager() {
		return Persistence.createEntityManagerFactory("vikash").createEntityManager();		
	}
	
	public void saveCourse(Course course) {
		EntityManager entityManager=getmanager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(course);
		entityTransaction.commit();
	}
}
