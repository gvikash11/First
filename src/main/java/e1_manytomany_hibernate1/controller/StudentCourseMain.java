package e1_manytomany_hibernate1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import e1_manytomany_hibernate1.dao.CourseCrud;
import e1_manytomany_hibernate1.dao.StudentCrud;
import e1_manytomany_hibernate1.dto.Course;
import e1_manytomany_hibernate1.dto.Students;

public class StudentCourseMain {
	public static void main(String[] args) {
		
		CourseCrud courseCrud=new CourseCrud();
		StudentCrud studentCrud=new StudentCrud();
		
//		Course course=new Course("Sql", 25, 750);
//		courseCrud.savaCourse(course);
		
		Students student1=new Students("Vikash", "vikash@gmail.com", 9838543210l, "B.Tech");
		Students student2=new Students("Vicky", "vicky@gmail.com", 8853543210l, "BE");
		Students student3=new Students("Anshil", "anshil@gmail.com", 8382543210l, "BSC");
		
		Course course1=new Course("Html", 10, 750);
		Course course2=new Course("java", 60, 2750);
		Course course3=new Course("Sql", 25, 1500);
		
		List<Students> list1=new ArrayList<Students>();
		list1.add(student1);
		list1.add(student3);
		
		course1.setStudents(list1);
		
		List<Students> list2=new ArrayList<Students>();
		list2.add(student1);
		list2.add(student2);
		list2.add(student3);
		
		course2.setStudents(list2);
		
		List<Students> list3=new ArrayList<Students>();
		list3.add(student2);
		list3.add(student3);
		
		course3.setStudents(list3);
		
		List<Course> clist1=new ArrayList<Course>();
		clist1.add(course1);
		clist1.add(course2);
		student1.setCourses(clist1);
		
		List<Course> clist2=new ArrayList<Course>();
		clist2.add(course1);
		clist2.add(course2);
		clist2.add(course3);
		student2.setCourses(clist2);
		
		List<Course> clist3=new ArrayList<Course>();
		clist3.add(course2);
		clist3.add(course3);
		student3.setCourses(clist3);
		
//		courseCrud.saveCourse(course3);
		
		EntityManager entityManager=courseCrud.getmanager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityTransaction.commit();
		
//		Students student4=new Students("Rohit", "rohit@gmail.com", 7888543210l, "BSC");
//		
//		List<Integer> list=new ArrayList<Integer>();
//		list.add(2);
//		list.add(3);
//		studentCrud.saveStudent(student4, list);
	}
}
