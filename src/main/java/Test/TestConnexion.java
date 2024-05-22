package Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestConnexion {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetJpa");
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
		System.out.println(em);

//		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
