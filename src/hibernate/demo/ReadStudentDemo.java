package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		//create Session
	    Session session = factory.getCurrentSession();
	    
	    try{
	    	//use the session object to save java object
	        
	    	//create a student object 
	    	System.out.println("Crating new student object...");
	    	Student tempStudent = new Student ("Lata","Soni","lata@gmail.com");
	    	
	    	//start transaction
	    	session.beginTransaction();
	    	
	    	//start the student object
	    	System.out.println("Saving the Student");
	    	System.out.println(tempStudent);
	    	session.save(tempStudent);
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    	//My new code for read
	    	
	    
	    	//find out the student's id : Primary key 
	    	System.out.println("Saved student: Generated id:"+ tempStudent.getId());
	    	
	    	//now get a new and start transaction
	    	session = factory.getCurrentSession();
	    	session.beginTransaction();
	    	
	    	//retrieve the student based on primary key 
	    	System.out.println("\nGetting student with id:"+ tempStudent.getId());
	    	Student myStudent = session.get(Student.class, tempStudent.getId());
	    	System.out.println("GET COMPLETE"+myStudent);
	    	
	    	//commit the transaction
	    	session.getTransaction().commit();
	    	System.out.println("Done!");
	    }
	    finally {
			factory.close();
		}
	}

}
