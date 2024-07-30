package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;

	public void saveProduct(Product product) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(product);
		et.commit();
	}

	public Product viewProductById(int id) {
		EntityManager em = emf.createEntityManager();
		Product product = em.find(Product.class, id);
		return product;
	}

	public List<Product> viewAllProducts() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("select p from Product p");
		return query.getResultList();
	}
	
	public void updateProduct(Product product) {
		EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		et.begin();
		em.merge(product) ;
		et.commit(); 
	}
	
    public void deleteProductById(int id) {
    	EntityManager em = emf.createEntityManager() ;
		EntityTransaction et = em.getTransaction() ;
		
		Product product = em.find(Product.class, id) ;
		et.begin();
		em.remove(product);
		et.commit();
    }
    
    
}
