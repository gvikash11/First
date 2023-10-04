package e1_manytomany_hibernate1.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import e1_manytomany_hibernate1.dto.Course;
import e1_manytomany_hibernate1.dto.Students;

public class StudentCrud {
	
	public EntityManager getmanager() {
		return Persistence.createEntityManagerFactory("vikash").createEntityManager();
	}
	
//	public void saveStudent(Student student,int id) {
//		EntityManager entityManager=getmanager();
//		Course course=entityManager.find(Course.class, id);
//		if(course!=null) {
//			EntityTransaction entityTransaction=entityManager.getTransaction();
//			List<Student> list=new ArrayList<Student>();
//			list.add(student);
//			course.setStudents(list);
//			entityTransaction.begin();
//			entityManager.persist(student );
//			entityManager.merge(course);
//			entityTransaction.commit();
//		}
//		else
//			System.out.println("Provide proper course id");
//	}
	
	public void saveStudent(Students student,List<Integer> list) {
		EntityManager entityManager=getmanager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(student);
		for(Integer integer: list) {
			Course course = entityManager.find(Course.class, integer);
			if(course != null) {
				List<Students> studentList=new ArrayList<Students>();
				studentList.add(student);
				studentList.addAll(course.getStudents());
				course.setStudents(studentList);
				entityManager.merge(course);
			}
		}
	   entityTransaction.commit();
	}	
}
