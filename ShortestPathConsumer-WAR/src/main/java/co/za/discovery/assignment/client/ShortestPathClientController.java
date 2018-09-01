/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    ShortestPathConsumer-WAR
 **    Version            :    1.0
 **    File               :    ShortestPathClientController.java
 **    Description        :    The ShortestPathClientController which acts as controller to trap requests from browser and consume webservice
 ** 						   service to who consumes soap service.
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

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.za.discovery.assignment.vo.PlanetVO;

@Controller
public class ShortestPathClientController {

	protected static Logger LOGGER = Logger.getLogger("controller");
	@Autowired
	private ShortestPathClient shortestPathClient;

	public ShortestPathClient getShortestPathClient() {
		return shortestPathClient;
	}

	public void setShortestPathClient(ShortestPathClient shortestPathClient) {
		this.shortestPathClient = shortestPathClient;
	}

	/**
	 * Handles and retrieves the shortest path page details
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getIndex() {
		return new ModelAndView("planet", "command", new PlanetVO());
	}

	@RequestMapping(value = "/planetpath", method = RequestMethod.POST)
	public ModelAndView getShortestPath(@ModelAttribute PlanetVO planetVO,
			ModelMap model) {

		// planetVO = new PlanetVO();
		ShortestPathClient shortestPathClient = new ShortestPathClient();
		String path = shortestPathClient.getPath(planetVO);

		model.addAttribute("path", path);
		System.out.println("controlller......");
		if (path == null) {
			path = "No Service Found";
		}

		return new ModelAndView("path", "path", path);
	}

}
