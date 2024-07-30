package com.jsp.foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.foodapp.entities.User;

@Repository
public class UserDao {
	@Autowired
	EntityManagerFactory emf;

	public void saveUser(User user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(user);
		et.commit();
	}

	public User viewUserById(int id) {
		EntityManager em = emf.createEntityManager();
		User user = em.find(User.class, id);
		return user;
	}

	public void updateUser(User user) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.merge(user);
		et.commit();
	}

	public void deleteUserById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		User user = em.find(User.class, id);

		et.begin();
		em.remove(user);
		et.commit();
	}

	public List<User> viewAllUsers() {
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select u from User u") ;
        return query.getResultList() ;
	}
	
	public User login (String email, String password) {
		EntityManager em = emf.createEntityManager() ;
		Query query = em.createQuery("select u from User u where u.email=?1 "
				+ "and u.password=?2") ;
        query.setParameter(1, email) ;
        query.setParameter(2, password) ;
        List<User> users = query.getResultList() ;
        if(users.size()>0) return users.get(0) ;
        else return null ;
	}
	
}
