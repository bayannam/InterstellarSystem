/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathProducer-WAR
 **    Version            :    1.0
 **    File               :    PlanetEndpoint.java
 **    Description        :    The PlanetEndpoint which act as endpoint to provide
 *                             service to who consumes soap service.
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

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.planetsconcrete.soap.FindShortestPathRequest;
import com.planetsconcrete.soap.FindShortestPathResponse;

/**
 * <h1>PlanetEndpoint</h1> The PlanetEndpoint which act as endpoint to provide
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
@Endpoint
public class PlanetEndpoint {
	private static final String NAMESPACE_URI = "http://planetsconcrete.com/soap";
	private PlanetUtility planetUtility;

	public PlanetUtility getPlanetUtility() {
		return planetUtility;
	}

	public void setPlanetUtility(PlanetUtility planetUtility) {
		this.planetUtility = planetUtility;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "findShortestPathRequest")
	@ResponsePayload
	public FindShortestPathResponse getCountry(
			@RequestPayload FindShortestPathRequest request) {
		FindShortestPathResponse response = new FindShortestPathResponse();
		response.setPath(planetUtility.findShortestPath(
				request.getOriginPlanetName(), request.getDestPlanetName()));
		return response;
	}

}
