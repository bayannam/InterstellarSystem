/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    NodeEdgeResourceConsumer-WAR
 **    Version            :    1.0
 **    File               :    RoutePojo.java
 **    Description        :    The RoutePojo which helps to wrap data controller to view
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/
package za.co.discovery.assignment.model;

import java.io.Serializable;

public class RoutePojo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String planet_origin;
	private String planet_destination;
	private Double distance;

	public RoutePojo() {

	}

	public RoutePojo(Integer id, String planet_origin,
			String planet_destination, Double distance) {
		this.id = id;
		this.planet_origin = planet_origin;
		this.planet_destination = planet_destination;
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPlanet_origin() {
		return planet_origin;
	}

	public void setPlanet_origin(String planet_origin) {
		this.planet_origin = planet_origin;
	}

	public String getPlanet_destination() {
		return planet_destination;
	}

	public void setPlanet_destination(String planet_destination) {
		this.planet_destination = planet_destination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return planet_origin + " " + planet_destination;
	}

}
