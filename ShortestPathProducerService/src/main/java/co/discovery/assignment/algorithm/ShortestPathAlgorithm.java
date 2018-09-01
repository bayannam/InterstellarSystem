/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathProducerService
 **    Version            :    1.0
 **    File               :    ShortestPathAlgorithm.java
 **    Description        :    The ShortestPathAlgorithm is algorithm to find shortest path.
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package co.discovery.assignment.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import za.co.discovery.assignment.entity.Graph;
import za.co.discovery.assignment.entity.Planet;
import za.co.discovery.assignment.entity.Route;

/**
 * <h1>ShortestPathAlgorithm</h1> The ShortestPathAlgorithm is algorithm to find
 * shortest path.
 * <p>
 * this class is Algorithm to take requested edges and nodes , find shortest
 * path.
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */

public class ShortestPathAlgorithm {
	private final List<Planet> nodes;
	private final List<Route> edges;
	private Set<Planet> settledNodes;
	private Set<Planet> unSettledNodes;
	private Map<Planet, Planet> predecessors;
	private Map<Planet, Double> distance;

	public ShortestPathAlgorithm(Graph graph) {
		// create a copy of the array so that we can operate on this array
		this.nodes = new ArrayList<Planet>(graph.getVertexes());
		this.edges = new ArrayList<Route>(graph.getEdges());
	}

	public void execute(Planet source) {
		settledNodes = new HashSet<Planet>();
		unSettledNodes = new HashSet<Planet>();
		distance = new HashMap<Planet, Double>();
		predecessors = new HashMap<Planet, Planet>();
		distance.put(source, 0.0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Planet node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	private void findMinimalDistances(Planet node) {
		List<Planet> adjacentNodes = getNeighbors(node);
		for (Planet target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {
				distance.put(target,
						getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private Double getDistance(Planet node, Planet target) {
		for (Route edge : edges) {
			if (edge.getPlaneOrigin().equals(node)
					&& edge.getPlanetDestination().equals(target)) {
				return edge.getDistance();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Planet> getNeighbors(Planet node) {
		List<Planet> neighbors = new ArrayList<Planet>();
		for (Route edge : edges) {
			if (edge.getPlaneOrigin().equals(node)
					&& !isSettled(edge.getPlanetDestination())) {
				neighbors.add(edge.getPlanetDestination());
			}
		}
		return neighbors;
	}

	private Planet getMinimum(Set<Planet> vertexes) {
		Planet minimum = null;
		for (Planet vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Planet vertex) {
		return settledNodes.contains(vertex);
	}

	private Double getShortestDistance(Planet destination) {
		Double d = distance.get(destination);
		if (d == null) {
			return Double.MAX_VALUE;
		} else {
			return d;
		}
	}

	/*
	 * This method returns the path from the source to the selected target and
	 * NULL if no path exists
	 */
	public LinkedList<Planet> getPath(Planet target) {
		LinkedList<Planet> path = new LinkedList<Planet>();
		Planet step = target;
		// check if a path exists
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		// Put it into the correct order
		Collections.reverse(path);
		return path;
	}

}
