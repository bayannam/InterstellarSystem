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

import za.co.discovery.assignment.dao.PlanetDao;
import za.co.discovery.assignment.entity.Planet;

/**
 * <h1>PlanetServiceImpl</h1> The PlanetServiceImpl which helps to provide
 * implementations to perform business logic forRest API.
 * <p>
 * this class is act as Implementation which takes data from DAO and handles
 * business logic execution forward data to Controller for Planet Data
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */

@Service("planetService")
@Transactional
public class PlanetServiceImpl implements PlanetService {

	@Autowired
	private PlanetDao dao;

	public List<Planet> findAllNodes() {
		List<Planet> nodes = dao.findAllNodes();
		return nodes;
	}

	public Planet findById(long id) {
		return dao.findById(id);
	}

	public Planet findByName(String name) {
		return dao.findByName(name);
	}

	@Transactional
	public void saveNode(Planet node) {
		dao.saveNode(node);
	}

	public void updateNode(Planet node) {
		Planet entity = dao.findById(node.getId());
		if (entity != null) {
			entity.setPlanetName(node.getPlanetName());
			entity.setPlanetNode(node.getPlanetNode());

		}
		dao.updateNode(entity);
	}

	public void deleteNodeById(long id) {

		dao.deleteNodeById(id);
	}

	/*
	 * public boolean isNodeExist(Node node) { return
	 * findByName(node.getPlanetName()) != null; }
	 */

	/*
	 * private static List<Node> populateDummyUsers() { List<Node> nodes = new
	 * ArrayList<Node>(); nodes.add(new Node((int) counter.incrementAndGet(),
	 * "Sam", "rere")); nodes.add(new Node((int) counter.incrementAndGet(),
	 * "Tom", "ere")); nodes.add(new Node((int) counter.incrementAndGet(),
	 * "Jerome", "erfdsfse")); nodes.add(new Node((int)
	 * counter.incrementAndGet(), "Silvia", "hfiudsfbsdiu")); return nodes; }
	 */
	/*
	 * public void deleteAllNodes() { dao.deleteAllNodes(); }
	 */

}
