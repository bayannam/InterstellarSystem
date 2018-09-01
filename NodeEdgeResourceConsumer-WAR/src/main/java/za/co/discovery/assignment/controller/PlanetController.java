/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResourceConsumer-WAR
 **    Version            :    1.0
 **    File               :    PlanetController.java
 **    Description        :    The PlanetController which traps request from JSP
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import za.co.discovery.assignment.model.Planet;

/**
 * <h1>PlanetController</h1> The PlanetController program traps request from JSP
 * and executes appropriate action and send response back to identified view.
 * 
 * <p>
 * this class is act as controller which takes request from browser and handles
 * business logic execution,forwarding response to view for planet requests
 * </p>
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-17
 */
@Controller
public class PlanetController {

	static Logger log = Logger.getLogger(PlanetController.class.getName());

	public static final String REST_SERVICE_URI = "http://localhost:8080/NodeEdgeResources-WAR";

	@RequestMapping(value = "/planets", method = RequestMethod.GET)
	public ModelAndView listPlanets(@ModelAttribute("planet") Planet planet) {

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> listPlanetsMap = restTemplate
				.getForObject(REST_SERVICE_URI + "/planets/", List.class);

		if (listPlanetsMap != null) {

			for (LinkedHashMap<String, Object> map : listPlanetsMap) {
				System.out.println("node : id=" + map.get("id") + ", Node="
						+ map.get("planetNode") + ", Name="
						+ map.get("planetName"));

			}

		} else {
			log.info("No node exist----------");
		}

		return new ModelAndView("planets", "listPlanets", listPlanetsMap);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}

	// For add planet
	@RequestMapping(value = "/planet/add", method = RequestMethod.POST)
	public ModelAndView addPlanet(@ModelAttribute("planet") Planet p,
			UriComponentsBuilder ucBuilder, BindingResult result) {
		RestTemplate restTemplate = new RestTemplate();
		// new person, add it
		System.out.println("Request is running");
		restTemplate.postForLocation(REST_SERVICE_URI + "/planet/add", p,
				Planet.class);
		String message = "Planet Saved Successfully";
		return new ModelAndView("planet", "message", message);
	}

	// For edit planet
	@RequestMapping(value = "/edit/{id}")
	public ModelAndView updatePlanet(@ModelAttribute("planet") Planet planet,
			@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		/*
		 * try { long l = Long.parseLong(id.trim());
		 * System.out.println("long l = " + l); } catch (NumberFormatException
		 * nfe) { System.out.println("NumberFormatException: " +
		 * nfe.getMessage()); }
		 */

		// new person, add it
		// log.info(planet.getId());
		// log.info(planet.getPlanetName());
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> listPlanetsMap = restTemplate
				.getForObject(REST_SERVICE_URI + "/planets/", List.class);

		/*
		 * restTemplate.put(REST_SERVICE_URI + "/planet/edit/" + id, planet,
		 * Planet.class);
		 */
		Planet editplanet = restTemplate.getForObject(REST_SERVICE_URI
				+ "/planet/" + id, Planet.class);
		ModelAndView model = new ModelAndView();
		model.addObject("planet", editplanet);
		model.addObject("listPlanets", listPlanetsMap);
		model.setViewName("planets");
		return model;
	}

	// For add and update person both
	@RequestMapping(value = "/remove/{id}")
	public String deletePlanet(@ModelAttribute("planet") Planet planet,
			@PathVariable("id") long id) {
		RestTemplate restTemplate = new RestTemplate();
		// new person, add it
		// log.info(planet.getId());
		log.info(planet.getPlanetName());
		restTemplate.put(REST_SERVICE_URI + "/planet/delete/" + id, planet,
				Planet.class);
		return "redirect:/planets";
	}

}
