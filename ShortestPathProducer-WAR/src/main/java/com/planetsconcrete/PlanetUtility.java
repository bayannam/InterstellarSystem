/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathProducer-WAR
 **    Version            :    1.0
 **    File               :    PlanetUtility.java
 **    Description        :    The PlanetUtility which act as utility to provide
 ** 						   service to who consumes soap service.
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package com.planetsconcrete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import za.co.discovery.assignment.entity.Graph;
import za.co.discovery.assignment.entity.Planet;
import za.co.discovery.assignment.entity.Route;
import co.discovery.assignment.algorithm.ShortestPathAlgorithm;
import co.discovery.assignment.entity.helper.RoutePojo;
import co.discovery.assignment.planetservice.NodeEdgeSeviceImpl;

/**
 * <h1>PlanetUtility</h1> The PlanetUtility which act as utility to provide
 * service to who consumes soap service.
 * <p>
 * this class is act as Implementation which takes data from Service and handles
 * business logic execution forward data to clients
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
public class PlanetUtility {
	Logger log = Logger.getLogger(this.getClass());
	private NodeEdgeSeviceImpl nodeEdgeService;

	public NodeEdgeSeviceImpl getNodeEdgeService() {
		return nodeEdgeService;
	}

	public void setNodeEdgeService(NodeEdgeSeviceImpl nodeEdgeService) {
		this.nodeEdgeService = nodeEdgeService;
	}

	public String findShortestPath(String origonPlanet, String destPlanet) {

		List<Planet> nodes = nodeEdgeService.findAllNodes();
		List<RoutePojo> rawEdges = nodeEdgeService.findAllEdges();

		HashMap<String, Planet> planets = new HashMap<String, Planet>();
		for (Planet planet : nodes) {
			planets.put(planet.getPlanetNode(), planet);
		}

		List<Route> edges = new ArrayList<Route>();
		for (RoutePojo rawEdge : rawEdges) {

			Route finalRoute = new Route(rawEdge.getId(), planets.get(rawEdge
					.getPlanet_origin()), planets.get(rawEdge
					.getPlanet_destination()), rawEdge.getDistance());
			log.info("Origin is......" + rawEdge.getPlanet_origin());
			log.info("Destination is......" + rawEdge.getPlanet_destination());
			edges.add(finalRoute);
		}

		Graph graph = new Graph(nodes, edges);
		ShortestPathAlgorithm algorithm = new ShortestPathAlgorithm(graph);
		algorithm.execute(planets.get(origonPlanet));

		LinkedList<Planet> path = algorithm.getPath(planets.get(destPlanet));

		StringBuffer buffer = new StringBuffer();

		for (Planet vertex : path) {
			log.info(vertex);
			buffer.append(vertex.getPlanetNode());

		}
		log.info(buffer);

		return buffer.toString();
	}

}
