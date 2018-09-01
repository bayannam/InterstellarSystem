/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    RouteDao.java
 **    Description        :    The RouteDao program provides implementation methods to
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

import co.discovery.assignment.entity.helper.RoutePojo;

public interface RouteDao {

	RoutePojo findById(int id);

	RoutePojo findByName(String name);

	void saveRoute(RoutePojo edge);

	void updateRoute(RoutePojo edge);

	void deleteRouteById(int id);

	List<RoutePojo> findAllRoutes();
}
