/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    RouteDaoImpl.java
 **    Description        :    The RouteDaoImpl program provides implementation methods to
 **                            implement to and from communication between application and to database in
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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import co.discovery.assignment.entity.helper.RoutePojo;

/**
 * <h1>RouteDaoImpl</h1> The RouteDaoImpl program provides implementation
 * methods to implement to and from communication between application and to
 * database in DAO layer for ROUTE Tbale data
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
@Repository("edgeDao")
public class RouteDaoImpl extends AbstractDao<Integer, RoutePojo> implements
		RouteDao {

	public RoutePojo findById(int id) {

		Session ses = getSession();
		Transaction txn = ses.beginTransaction();
		RoutePojo routePojo = (RoutePojo) ses.get(RoutePojo.class, id);
		txn.commit();

		return routePojo;
	}

	public RoutePojo findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveRoute(RoutePojo routePojo) {
		Session ses = getSession();
		Transaction txn = ses.beginTransaction();
		ses.persist(routePojo);
		txn.commit();
	}

	public void updateRoute(RoutePojo routePojo) {
		// TODO Auto-generated method stub

	}

	public void deleteRouteById(int id) {
		/*
		 * Criteria crit = createEntityCriteria();
		 * crit.add(Restrictions.eq("id", id)); RoutePojo routePojo =
		 * (RoutePojo) crit.uniqueResult(); delete(routePojo);
		 */

		Session ses = getSession();
		Transaction txn = ses.beginTransaction();
		RoutePojo route = (RoutePojo) ses.get(RoutePojo.class, id);
		ses.delete(route);
		txn.commit();
	}

	@SuppressWarnings("unchecked")
	public List<RoutePojo> findAllRoutes() {
		Criteria criteria = createEntityCriteria();
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		return (List<RoutePojo>) criteria.list();
	}

}
