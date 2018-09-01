/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    Route.java
 **    Description        :    The Route which helps to wrap data controller to view
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//@Entity
//@Table(name = "ROUTE")
public class Route implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// @Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// @NotEmpty
	// @Column(name = "PLANET_ORIGIN", nullable = false)
	private Planet planeOrigin;
	// @NotEmpty
	// @Column(name = "PLANET_DESTINATION", nullable = false)
	private Planet planetDestination;
	// @NotEmpty
	// @Column(name = "DISTANCE", nullable = false)
	private Double distance;

	public Route() {

	}

	public Route(Integer id, Planet planeOrigin, Planet planetDestination,
			Double distance) {
		super();
		this.id = id;
		this.planeOrigin = planeOrigin;
		this.planetDestination = planetDestination;
		this.distance = distance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Planet getPlaneOrigin() {
		return planeOrigin;
	}

	public void setPlaneOrigin(Planet planeOrigin) {
		this.planeOrigin = planeOrigin;
	}

	public Planet getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(Planet planetDestination) {
		this.planetDestination = planetDestination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
