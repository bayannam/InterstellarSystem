/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResourceService-JAR
 **    Version            :    1.0
 **    File               :    PlanetServiceImpl.java
 **    Description        :    The PlanetServiceImpl which helps to provide implementations
 **                             to perform business logic forRest API
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package za.co.discovery.assignment.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.discovery.assignment.dao.RouteDao;
import co.discovery.assignment.entity.helper.RoutePojo;

/**
 * <h1>RouteServiceImpl</h1> The RouteServiceImpl which helps to provide
 * implementations to perform business logic forRest API.
 * <p>
 * this class is act as Implementation which takes data from DAO and handles
 * business logic execution forward data to Controller for Route Data
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */

@Service("routeService")
@Transactional
public class RouteServiceImpl implements RouteService {
	@Autowired
	private RouteDao dao;

	public RoutePojo findById(long id) {
		int newid = (int) id;
		return dao.findById(newid);
	}

	public RoutePojo findByName(String name) {
		return null;
	}

	public void saveEdge(RoutePojo edge) {
		dao.saveRoute(edge);
	}

	public void updateEdge(RoutePojo node) {

		RoutePojo entity = dao.findById(node.getId());
		if (entity != null) {
			entity.setPlanet_origin(entity.getPlanet_origin());
			entity.setPlanet_destination(entity.getPlanet_destination());
			entity.setDistance(entity.getDistance());

		}
		dao.updateRoute(entity);
	}

	public void deleteEdgeById(int id) {
		dao.deleteRouteById(id);

	}

	public List<RoutePojo> findAllEdges() {
		List<RoutePojo> edges = dao.findAllRoutes();
		return edges;
	}

}
