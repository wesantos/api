package br.com.r39.erp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory dbEMF = Persistence.createEntityManagerFactory("erp");
	
	public EntityManager getEntityManager() {
		return dbEMF.createEntityManager();
	}
	
}
