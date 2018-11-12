package com.max.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.max.hibernate.demo.entity.Instructor;
import com.max.hibernate.demo.entity.InstructorDetail;
import com.max.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
//			Instructor tempInstructor = 
//					new Instructor("Bruce","Lee","lee@gmail.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://www.brucelee.com/youtube","whoop asses");
//			
			Instructor tempInstructor = 
					new Instructor("DJ","Solitary","jail@gmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.solitary.com/youtube","Mixing Death Sound");
			
			
			// associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			//save the instructor
			//
			// this ALSO save the details object because of --CascadeType.ALL--
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done.");
		} finally {
			factory.close();
		}
	}

}
