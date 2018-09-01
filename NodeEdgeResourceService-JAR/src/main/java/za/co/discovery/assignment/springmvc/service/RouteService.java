/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResourceService-JAR
 **    Version            :    1.0
 **    File               :    RouteService.java
 **    Description        :    The RouteService which helps to provide abstract
 **                            methods to perform business logic forRest API
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

import co.discovery.assignment.entity.helper.RoutePojo;

/**
 * <h1>RouteService</h1> The RouteService which helps to provide abstract
 * methods to perform business logic forRest API.
 * <p>
 * this class is act as Interface which takes data from DAO and handles business
 * logic execution forward data to Controller for Route Data
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
public interface RouteService {
	RoutePojo findById(long id);

	RoutePojo findByName(String name);

	void saveEdge(RoutePojo edge);

	void updateEdge(RoutePojo node);

	void deleteEdgeById(int id);

	List<RoutePojo> findAllEdges();
}
