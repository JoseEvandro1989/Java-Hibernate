package br.com.impacta.modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.impacta.jdbc.modelo.Contato;

public class BuscaContatos {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.
		        createEntityManagerFactory("impacta-persistence");
		      EntityManager manager = factory.createEntityManager();
		   
		 //cuidado, use o import javax.persistence.Query
		    Query query = manager
		        .createQuery("select c from Contato as c "+
		          "where c.nome = :paramNome");
		    query.setParameter("paramNome", "Impacta");
		    
		    List<Contato> lista = query.getResultList();

		    for (Contato c : lista) {
		      System.out.println(c.getNome());
		    }

		    manager.close();


	}

}
