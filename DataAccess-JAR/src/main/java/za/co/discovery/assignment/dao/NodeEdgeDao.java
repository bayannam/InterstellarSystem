/**********************************************************************************************************************
 **    Copyright 2015 DISCOVERY.  All rights reserved.
 **
 **    No Part of this file should be copied or distributed without the permission of DISCOVERY.
 **    Application        :    InterstellarSystem
 **    Module             :    DataAccess-WAR
 **    Version            :    1.0
 **    File               :    NodeEdgeDao.java
 **    Description        :    The NodeEdgeDao program provides abstract methods to
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
/**
 * <h1>NodeEdgeDao</h1> The NodeEdgeDao program provides abstract methods to
 * implement to and from communication between application and  to database 
 * <p>
 * 
 * 
 *
 * @author Bayanna Madanapalli
 * @version 1.0
 * @since 2015-12-15
 */

import za.co.discovery.assignment.entity.Planet;
import co.discovery.assignment.entity.helper.RoutePojo;

public interface NodeEdgeDao {
	List<Planet> findAllNodes();

	List<RoutePojo> findAllEdges();

}
