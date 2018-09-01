/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    RouteDao.java
 **    Description        :    The RouteDao program provides implementation methods to
 **                            implement to and from communication between application and to database
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/
package za.co.discovery.assignment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * <h1>PlanetDaoImpl</h1> The PlanetDaoImpl program provides implementation methods to
 * implement to and from communication between application and to database in
 * DAO layer for PLANET table data
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
import za.co.discovery.assignment.entity.Planet;

@Repository("planetDao")
public class PlanetDaoImpl extends AbstractDao<Integer, Planet> implements
		PlanetDao {

	public Planet findById(long id) {
		Session ses = getSession();
		int newid = (int) id;
		Transaction txn = ses.beginTransaction();
		Planet node = (Planet) ses.get(Planet.class, newid);
		txn.commit();
		return node;
	}

	public Planet findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void saveNode(Planet node) {
		Session ses = getSession();
		Transaction txn = ses.beginTransaction();
		ses.persist(node);
		txn.commit();
	}

	public void updateNode(Planet node) {
		getSession().saveOrUpdate(node);

	}

	public void deleteNodeById(long id) {

		Session ses = getSession();
		int newid = (int) id;
		Transaction txn = ses.beginTransaction();
		Planet node = (Planet) ses.get(Planet.class, newid);
		ses.delete(node);
		txn.commit();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Planet> findAllNodes() {

		Query query = getSession().createQuery("from Planet");
		List<Planet> nodes = (List<Planet>) query.list();
		return nodes;
	}

}
