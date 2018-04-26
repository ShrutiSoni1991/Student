package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
	        
	    	int studentId = 1;
	    	
	    	//now get a new and start transaction
	    	session = factory.getCurrentSession();
	    	session.beginTransaction();
	    	
	    	//retrieve the student based on primary key 
	    	System.out.println("\nGetting student with id:"+ studentId );
	    	Student myStudent = session.get(Student.class,studentId);
	    	
	    	//New Code for Delete student id with 1 
	    	//System.out.println("\nGetting student:"+ myStudent );
	    	//session.delete(myStudent);
	    	
	    	//Second approach to delete the student 
	    	System.out.println("\nGetting student with id 2");
	    	session.createQuery("delete from Student where id=2").executeUpdate();
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    		        
	        System.out.println("Done!");
	    }
	    finally {
			factory.close();
		}
	}

}
