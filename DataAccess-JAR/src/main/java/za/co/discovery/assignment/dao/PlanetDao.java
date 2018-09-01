/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    PlanetDao.java
 **    Description        :    The PlanetDao program provides abstract methods to
 **                            implement to and from communication between application and to database
 **    Author             :    Bayanna Madanapalli
 **    Created Date       :    17/12/2015
 **********************************************************************************************************************
 **    Change History Header:
 **********************************************************************************************************************
 **    Date          Author                 Version     Description:
 **    -------       --------               --------    ------------
 **    17/12/2015    Bayanna Madanapalli      1.0         Created
 *********************************************************************************************************************/

package za.co.discovery.assignment.dao;

import java.util.List;

import za.co.discovery.assignment.entity.Planet;

/**
 * <h1>PlanetDao</h1> The PlanetDao program provides abstract methods to
 * implement to and from communication between application and to database in
 * DAO layer for PLANET Table Data
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */
public interface PlanetDao {

	Planet findById(long id);

	Planet findByName(String name);

	void saveNode(Planet node);

	void updateNode(Planet node);

	void deleteNodeById(long id);

	List<Planet> findAllNodes();

	// void deleteAllNodes();

}
