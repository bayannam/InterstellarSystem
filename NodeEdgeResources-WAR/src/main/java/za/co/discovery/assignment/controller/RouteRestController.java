/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResources-WAR
 **    Version            :    1.0
 **    File               :    RouteRestController.java
 **    Description        :    The RouteRestController which takes data from service and handles
 **                            business logic execution,publishing restful URL for Route requests
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package za.co.discovery.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import co.discovery.assignment.entity.helper.RoutePojo;
import za.co.discovery.assignment.springmvc.service.RouteService;

/**
 * <h1>RouteRestController</h1> The RouteRestController which helps to produce
 * restful urls
 * <p>
 * this class is act as controller which takes data from service and handles
 * business logic execution,publishing restful URL for Route requests
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
@RestController
public class RouteRestController {
	@Autowired
	RouteService edgeService; // Service which will do all data
								// retrieval/manipulation work

	// -------------------Retrieve All Nodes

	@RequestMapping(value = "/routes/", method = RequestMethod.GET)
	public ResponseEntity<List<RoutePojo>> listAllUsers() {
		List<RoutePojo> edges = edgeService.findAllEdges();
		if (edges.isEmpty()) {
			return new ResponseEntity<List<RoutePojo>>(HttpStatus.NO_CONTENT);// You
																				// many
																				// decide
																				// to
																				// return
																				// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<RoutePojo>>(edges, HttpStatus.OK);
	}

	// -------------------Retrieve Single Node

	@RequestMapping(value = "/route/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RoutePojo> getRoute(@PathVariable("id") long id) {
		System.out.println("Fetching Node with id " + id);
		RoutePojo edge = edgeService.findById(id);
		if (edge == null) {
			System.out.println("Node with id " + id + " not found");
			return new ResponseEntity<RoutePojo>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<RoutePojo>(edge, HttpStatus.OK);
	}

	// -------------------Create a Node

	@RequestMapping(value = "/route/add", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody RoutePojo edge,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Node " + edge.getPlanet_origin());

		System.out.println(" Node with name " + edge.getPlanet_destination()
				+ " already exist");

		edgeService.saveEdge(edge);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/route/{id}")
				.buildAndExpand(edge.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Node
	// --------------------------------------------------------

	@RequestMapping(value = "/route/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<RoutePojo> updateUser(@PathVariable("id") long id,
			@RequestBody RoutePojo node) {
		System.out.println("Updating Node " + id);

		RoutePojo currentEdge = edgeService.findById(id);

		if (currentEdge == null) {
			System.out.println("Node with id " + id + " not found");
			return new ResponseEntity<RoutePojo>(HttpStatus.NOT_FOUND);
		}

		/*
		 * currentNode.setName(user.getName());
		 * currentNode.setAge(user.getAge());
		 * currentUser.setSalary(user.getSalary());
		 */
		edgeService.updateEdge(currentEdge);
		return new ResponseEntity<RoutePojo>(currentEdge, HttpStatus.OK);
	}

	// ------------------- Delete a Node
	// --------------------------------------------------------

	@RequestMapping(value = "/route/delete/{id}")
	public ResponseEntity<RoutePojo> deleteRoute(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Node with id " + id);

		RoutePojo edge = edgeService.findById(id);
		if (edge == null) {
			System.out.println("Unable to delete. Node with id " + id
					+ " not found");
			return new ResponseEntity<RoutePojo>(HttpStatus.NOT_FOUND);
		}

		edgeService.deleteEdgeById((int) id);
		return new ResponseEntity<RoutePojo>(HttpStatus.NO_CONTENT);
	}

}
