/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResourceConsumer-WAR
 **    Version            :    1.0
 **    File               :    RouteController.java
 **    Description        :    The RouteController which traps request from JSP
 **                            and executes appropriate action and send response back to identified view.
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import za.co.discovery.assignment.model.Planet;
import za.co.discovery.assignment.model.RoutePojo;

/**
 * <h1>RouteController</h1> The RouteController program traps request from JSP
 * and executes appropriate action and send response back to identified view.
 * 
 * <p>
 * this class is act as controller which takes request from browser and handles
 * business logic execution,forwarding response to view for Route requests
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
@Controller
public class RouteController {
	static Logger log = Logger.getLogger(PlanetController.class.getName());

	public static final String REST_SERVICE_URI = "http://localhost:8080/NodeEdgeResources-WAR";

	@RequestMapping(value = "/routes", method = RequestMethod.GET)
	public ModelAndView listRoutes(@ModelAttribute("RoutePojo") RoutePojo route) {

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> listRoutes = restTemplate
				.getForObject(REST_SERVICE_URI + "/routes/", List.class);

		if (listRoutes != null) {

			for (LinkedHashMap<String, Object> map : listRoutes) {
				System.out.println("route : id=" + map.get("id") + ", source="
						+ map.get("planet_origin") + ", dest="
						+ map.get("planet_destination"));

			}
		}

		return new ModelAndView("route", "listRoutes", listRoutes);
		// return "planet";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	// For add and update person both
	@RequestMapping(value = "/route/add", method = RequestMethod.POST)
	public ModelAndView addRoute(@ModelAttribute("RoutePojo") RoutePojo p) {
		RestTemplate restTemplate = new RestTemplate();
		// new person, add it

		restTemplate.postForLocation(REST_SERVICE_URI + "/route/add", p,
				Planet.class);
		String message = "Route Saved Successfully";
		return new ModelAndView("RoutePojo", "message", message);

	}

	// For add and update person both
	@RequestMapping(value = "/route/edit/{id}")
	public ModelAndView updateRoute(@ModelAttribute("RoutePojo") RoutePojo p,
			@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		// new person, add it

		/*
		 * restTemplate.put(REST_SERVICE_URI + "/route/" + p.getId(), p,
		 * Planet.class);
		 */
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> listRoutes = restTemplate
				.getForObject(REST_SERVICE_URI + "/routes/", List.class);

		/*
		 * restTemplate.put(REST_SERVICE_URI + "/planet/edit/" + id, planet,
		 * Planet.class);
		 */
		RoutePojo editroute = restTemplate.getForObject(REST_SERVICE_URI
				+ "/route/" + id, RoutePojo.class);
		ModelAndView model = new ModelAndView();
		model.addObject("RoutePojo", editroute);
		model.addObject("listRoutes", listRoutes);
		model.setViewName("planets");
		return model;

	}

	// For add and update person both
	@RequestMapping(value = "route/remove/{id}")
	public String deleteRoute(@ModelAttribute("route") RoutePojo route,
			@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		// new person, add it
		// log.info(planet.getId());
		restTemplate.put(REST_SERVICE_URI + "/route/delete/" + id, route,
				Planet.class);
		return "redirect:/routes";
	}

}
