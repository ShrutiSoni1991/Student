package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
	    	System.out.println("Crating new object...");
	    	Student tempStudent = new Student ("Shruti","Soni","shruti@gmail.com");
	    	Student tempStudent1 = new Student ("Sweety","Soni","shruti@gmail.com");
	    	Student tempStudent2 = new Student ("Sanket","Soni","shruti@gmail.com");
	    	Student tempStudent3 = new Student ("Sonu","Soni","shruti@gmail.com");

	    	
	    	//start transaction
	    	session.beginTransaction();
	    	
	    	//start the student object
	    	System.out.println("Saving the Student");
	    	session.save(tempStudent);
	    	session.save(tempStudent1);
	    	session.save(tempStudent2);
	    	session.save(tempStudent3);
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    	System.out.println("Done!");
	    }
	    finally {
			factory.close();
		}
	}
}
