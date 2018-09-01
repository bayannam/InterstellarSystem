/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    Graph.java
 **    Description        :    The Graph which helps to wrap data DataBase to service layer
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/
package za.co.discovery.assignment.entity;

import java.io.Serializable;
import java.util.List;

public class Graph implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<Planet> vertexes;
	private final List<Route> edges;

	public Graph(List<Planet> vertexes, List<Route> edges) {
		this.vertexes = vertexes;
		this.edges = edges;
	}

	public List<Planet> getVertexes() {
		return vertexes;
	}

	public List<Route> getEdges() {
		return edges;
	}

}
