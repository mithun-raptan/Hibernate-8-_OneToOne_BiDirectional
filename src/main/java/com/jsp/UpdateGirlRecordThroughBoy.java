package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateGirlRecordThroughBoy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Boy b = em.find(Boy.class, 102);
		if(b!=null) {
			Girl g =b.getGirl();
			if(g!=null) {
			g.setName("Mia Khalifa");
			et.begin();
			em.merge(b);
			et.commit();
			System.out.println("girl record updated succesfully");
			}
			else {
				System.out.println("no girl record present");
			}
		}
		else {
			System.out.println("boy record not found ");
		}
		
	}

}
