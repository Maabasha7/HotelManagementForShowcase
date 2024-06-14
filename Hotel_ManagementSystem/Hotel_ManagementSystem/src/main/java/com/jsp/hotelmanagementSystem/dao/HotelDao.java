package com.jsp.hotelmanagementSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jsp.hotelmanagementSystem.entities.Hotel;

@Repository
public class HotelDao {
	@Autowired
	EntityManagerFactory emf;

	@Autowired
	EntityManager em;

	@Autowired
	EntityTransaction et;

	
	public void saveHotel(Hotel hotel) {
		et.begin();
		em.persist(hotel);
		et.commit();
		
	
	}

	public Hotel findHotelById(int id) {
		return em.find(Hotel.class, id);
	}

	public void updateHotel(Hotel hotel) {
		et.begin();
		em.merge(hotel);
		et.commit();
	}

	public void deleteById(int id) {
		et.begin();
		em.remove(em.find(Hotel.class, id));
		et.commit();
	}

	public Hotel login(String email, String password) {
		Query query = em.createQuery("select h from Hotel h where h.email=?1 and h.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);

		try {
			Hotel t = (Hotel) query.getSingleResult();
			return t;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Hotel> findUnapprovedhotels() {
		Query query = em.createQuery("select h from Hotel h where h.status='Not approved'");
		return query.getResultList();
	}
}

