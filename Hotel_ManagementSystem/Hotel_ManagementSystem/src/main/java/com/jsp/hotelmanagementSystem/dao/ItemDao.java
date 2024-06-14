package com.jsp.hotelmanagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.hotelmanagementSystem.entities.Hotel;
import com.jsp.hotelmanagementSystem.entities.Item;


@Repository
public class ItemDao {
	
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;

	public void saveItem(Item item) {
		et.begin();
		em.persist(item);
		et.commit();
	}

	public Item findById(int id) {
		return em.find(Item.class, id);
	}

	public void updateFoodOrder(Item item) {
		et.begin();
		em.merge(item);
		et.commit();
	}

	public void deleteByid(int id) {
		et.begin();
		em.remove(em.find(Item.class, id));
		et.commit();
	}
	
}