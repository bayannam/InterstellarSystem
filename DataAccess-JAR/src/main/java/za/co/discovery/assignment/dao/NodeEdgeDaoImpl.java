/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    NodeEdgeDaoImpl.java
 **    Description        :    The NodeEdgeDaoImpl program provides implementation methods to
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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import za.co.discovery.assignment.entity.Planet;
import co.discovery.assignment.entity.helper.RoutePojo;

/**
 * <h1>NodeEdgeDaoImpl</h1> The NodeEdgeDao program provides implementations to
 * implement to and from communication between application and to database, to
 * get list of planets and edges from PLANET and ROUTE Tables
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
public class NodeEdgeDaoImpl implements NodeEdgeDao {

	// private HibernateTemplate template;

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * public HibernateTemplate getTemplate() { return template; }
	 * 
	 * public void setTemplate(HibernateTemplate template) { this.template =
	 * template; }
	 */

	@SuppressWarnings("unchecked")
	public List<Planet> findAllNodes() {

		Session session = sessionFactory.openSession();
		return session.createQuery("from Planet").list();

	}

	@SuppressWarnings("unchecked")
	public List<RoutePojo> findAllEdges() {

		Session session = sessionFactory.openSession();
		List<RoutePojo> rawRoutes = session.createQuery("from RoutePojo")
				.list();

		return rawRoutes;
	}

}
