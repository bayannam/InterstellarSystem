/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathProducerService
 **    Version            :    1.0
 **    File               :    NodeEdgeSeviceImpl.java
 **    Description        :    The base sarviceImpl which provides to provide
 * 							   implementations to perform business logic SOAP Document literal webservice
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package co.discovery.assignment.planetservice;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import za.co.discovery.assignment.dao.NodeEdgeDao;
import za.co.discovery.assignment.entity.Planet;
import co.discovery.assignment.entity.helper.RoutePojo;

/**
 * <h1>NodeEdgeSeviceImpl</h1> The NodeEdgeSeviceImpl which helps to provide
 * implementations to perform business logic SOAP Document literal webservice
 * <p>
 * this class is act as Interface which takes data from DAO and handles business
 * logic execution forward data to Controller.
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
public class NodeEdgeSeviceImpl implements NodeEdgeService {

	private NodeEdgeDao nodeEdgeDao;

	public NodeEdgeDao getNodeEdgeDao() {
		return nodeEdgeDao;
	}

	public void setNodeEdgeDao(NodeEdgeDao nodeEdgeDao) {
		this.nodeEdgeDao = nodeEdgeDao;
	}

	public List<Planet> findAllNodes() {
		return nodeEdgeDao.findAllNodes();
	}

	public List<RoutePojo> findAllEdges() {
		return nodeEdgeDao.findAllEdges();
	}

}
