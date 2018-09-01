/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResources-WAR
 **    Version            :    1.0
 **    File               :    PlanetRestController.java
 **    Description        :    The PlanetRestController which takes data from service and handles
 **                            business logic execution,publishing restful URL for Planet requests
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

import za.co.discovery.assignment.entity.Planet;
import za.co.discovery.assignment.springmvc.service.PlanetService;

/**
 * <h1>PlanetRestController</h1> The PlanetRestController which helps to produce
 * restful urls
 * <p>
 * this class is act as controller which takes data from service and handles
 * business logic execution,publishing restful URL for Planet requests
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
@RestController
public class PlanetRestController {
	@Autowired
	PlanetService nodeService; // Service which will do all data
								// retrieval/manipulation work

	// -------------------Retrieve All Nodes

	@RequestMapping(value = "/planets/", method = RequestMethod.GET)
	public ResponseEntity<List<Planet>> listAllUsers() {
		List<Planet> nodes = nodeService.findAllNodes();
		if (nodes.isEmpty()) {
			return new ResponseEntity<List<Planet>>(HttpStatus.NO_CONTENT);// You
																			// many
																			// decide
																			// to
																			// return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Planet>>(nodes, HttpStatus.OK);
	}

	// -------------------Retrieve Single Node

	@RequestMapping(value = "/planet/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Planet> getPlanet(@PathVariable("id") long id) {
		// System.out.println("Fetching Node with id " + id);
		Planet node = nodeService.findById(id);
		if (node == null) {
			// System.out.println("Node with id " + id + " not found");
			return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Planet>(node, HttpStatus.OK);
	}

	// -------------------Create a Node

	@RequestMapping(value = "/planet/add", method = RequestMethod.POST)
	public ResponseEntity<Void> createPlanet(@RequestBody Planet node,
			UriComponentsBuilder ucBuilder) {
		System.out.println("Creating Node " + node.getPlanetNode());

		System.out.println(" Node with name " + node.getPlanetName());

		nodeService.saveNode(node);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/planet/add")
				.buildAndExpand(node.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Node
	// --------------------------------------------------------

	@RequestMapping(value = "/planet/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Planet> updatePlanet(@PathVariable("id") long id,
			@RequestBody Planet node) {
		System.out.println("Updating Node " + id);

		Planet currentNode = nodeService.findById(id);

		if (currentNode == null) {
			System.out.println("Node with id " + id + " not found");
			return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
		}

		nodeService.updateNode(currentNode);
		return new ResponseEntity<Planet>(currentNode, HttpStatus.OK);
	}

	// ------------------- Delete a Node
	// --------------------------------------------------------

	@RequestMapping(value = "/planet/delete/{id}")
	public ResponseEntity<Planet> deletePlanet(@PathVariable("id") long id) {
		System.out.println("Fetching & Deleting Node with id " + id);

		Planet node = nodeService.findById(id);
		if (node == null) {
			// System.out.println("Unable to delete. Node with id " + id
			// + " not found");
			return new ResponseEntity<Planet>(HttpStatus.NOT_FOUND);
		}

		nodeService.deleteNodeById(id);
		return new ResponseEntity<Planet>(HttpStatus.NO_CONTENT);
	}

}
