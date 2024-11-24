package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Girl g1 = new Girl();
		g1.setId(1);
		g1.setName("sohini");
		g1.setInstaId("s@123");
				
		Girl g2 = new Girl();
		g2.setId(2);
		g2.setName("mohini");
		g2.setInstaId("m@123");
		
		Boy b1 = new Boy();
		b1.setId(101);
		b1.setName("mithun");
		b1.setEmail("m@g.com");
		b1.setPassword("1234");
		
		Boy b2 = new Boy();
		b2.setId(102);
		b2.setName("rakesh");
		b2.setEmail("r@g.com");
		b2.setPassword("5678");
		
		//mapping
		b1.setGirl(g1);
		g1.setBoy(b1);
		
		b2.setGirl(g2);
		g2.setBoy(b2);
		
		
		//save/persist
		et.begin();
		em.persist(g1);
		em.persist(g2);
		em.persist(b1);
		em.persist(b2);
		et.commit();
		
		System.out.println("data saved successfully in the db");
		
		
		
		
	}

}
