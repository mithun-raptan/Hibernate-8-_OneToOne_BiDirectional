package com.jsp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindThroughGirl {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Girl g = em.find(Girl.class, 2);
		if(g!=null) {
			System.out.println("girl record");
			System.out.println(g.getName()+" "+g.getInstaId());
			System.out.println("boy record ");
			Boy b = g.getBoy();
			if(b!=null) {
				System.out.println(b.getName()+" "+b.getEmail()+" ");
			}
			else {
				System.out.println("boy record not found");
			}
		}
		else {
			System.out.println("girl record not found");
		}
	}

}
