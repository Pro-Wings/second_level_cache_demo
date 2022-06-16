package com.prowings;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Test {

	public static void main(String[] args) {
		
		Session session1 = HibernateUtil.getSessionFactory().openSession();

		Student s = session1.get(Student.class, 1L);
		System.out.println(s);
		
		Student s1 = session1.get(Student.class, 1L);
		
		System.out.println(s1);

		session1.close();

		System.out.println(">>>>>>>>>>Opening another session and getting same object<<<<<<<<");
		
		Session session2 = HibernateUtil.getSessionFactory().openSession();

		Student s2 = session2.get(Student.class, 1L);
		System.out.println(s2);

		SessionFactory sf =  HibernateUtil.getSessionFactory();
		
		System.out.println(">>>> removing student object from 1st and 2nd level cache<<<<<");
		session2.evict(s2);
		sf.getCache().evict(Student.class);
		
		Student s3 = session2.get(Student.class, 1L);
		
		HibernateUtil.close();
	}

	
}
