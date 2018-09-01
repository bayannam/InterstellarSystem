/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathConsumer-WAR
 **    Version            :    1.0
 **    File               :    ShortestPathClient.java
 **    Description        :    The ShortestPathClient which acts as actual client to consume SOAP webservice
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package co.za.discovery.assignment.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import za.co.discovery.asignment.shortPathStubs.FindShortestPathRequest;
import za.co.discovery.asignment.shortPathStubs.FindShortestPathResponse;
import za.co.discovery.asignment.shortPathStubs.ObjectFactory;
import co.za.discovery.assignment.vo.PlanetVO;

public class ShortestPathClient {
	public String getPath(PlanetVO planetVO) {
		FindShortestPathResponse resp = null;
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext(
					new String[] { "springbeans.xml" });
			System.out.println(context.getBeanDefinitionCount());
			WebServiceTemplate template = (WebServiceTemplate) context
					.getBean("shortestPathTemplate");
			ObjectFactory factory = new ObjectFactory();
			FindShortestPathRequest request = factory
					.createFindShortestPathRequest();
			request.setOriginPlanetName(planetVO.getSourceNode());
			request.setDestPlanetName(planetVO.getDestinationNode());
			resp = (FindShortestPathResponse) template
					.marshalSendAndReceive(request);
			System.out.println(resp.getPath());

			/*
			 * ShortestPathClient wsclient = (ShortestPathClient) context
			 * .getBean(ShortestPathClient.class); FindShortestPathResponse resp
			 * = wsclient.getShortestPath("A","Z"); System.out.println(resp);
			 * wsclient.printResp(resp);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resp.getPath();
	}
}
