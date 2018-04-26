package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
	    	
	    	//start transaction
	    	session.beginTransaction();
	    	
	    	//query students , here student is a class name to get data 
	    	List<Student> theStudents = session
	    			.createQuery("from Student")
	    			.list();
	    	
	    	//display students
	    	
	        displayStudent(theStudents);
	        
	        //Query Student whose last name is Soni.
	        theStudents =session.createQuery("from Student s where s.lastName='Soni'").list();
	    	
	        //display the students
	        System.out.println("Students who have last name soni");
	        displayStudent(theStudents);
	        
	        
	        //Query Student: lastName="Soni " OR firstName= "Shruti"
	        theStudents= 
	        		session.createQuery("\n\nfrom Student s where s.lastName='Soni' AND s.firstName='Shruti'").list();
	        System.out.println("Students who have last name soni");
	        displayStudent(theStudents);
	        
	        //Third Query Example
	        
	        theStudents= 
	        		session.createQuery("\n\nfrom Student s where s.email "
	        				+ "LIKE '%gmail.com'").list();
	        
	        System.out.println("Students who have email with gmail account");
	        displayStudent(theStudents);
	        
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    	System.out.println("Done!");
	    }
	    finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

}
