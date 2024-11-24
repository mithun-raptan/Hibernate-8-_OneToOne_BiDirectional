package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class RemoveGirlRecordThroughBoy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Boy b = em.find(Boy.class, 102);
		if(b!=null) {
			Girl g=b.getGirl();
			if(g!=null) {
				b.setGirl(null);
				et.begin();
				em.remove(g);
				et.commit();
				
				System.out.println("girl record deleted");
				
			}
			else {
				System.out.println("girl not present to remove from DB");
			}
		}
		else {
			System.out.println("boy record not present");
		}
	}

}
