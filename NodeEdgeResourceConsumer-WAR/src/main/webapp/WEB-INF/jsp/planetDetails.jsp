<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Planet Details</title>
</head>
<body>
	<form action="addPlanet.htm">
	<div >
			<div >
				<input type="hidden"  name="planetId" value="${planetRef.planetId}">
				Planet Id<input type="text" name="pId" value="${planetRef.pId}"
					class="form-control" placeholder="Planet Id" />
			</div>
			<div >
				Planet Name<input type="text" name="pName"  value="${planetRef.pName}"
					class="form-control" placeholder="Planet Name" />
			</div>
		</div>
 
		</div>
		
		
	 <c:if test="${not empty planetRef.planetId}">
	 	<div  >
			<button type="submit">Update Data</button>
		</div>
	 </c:if>
	  <c:if test="${empty planetRef.planetId}">
	 	<div  >
			<button type="submit">Submit Data</button>
		</div>
	 </c:if>
	
                    <div >
                        <div >
                            <div >
                                <div >
                                    <h3 >All User</h3> 
                                </div><!-- /.box-header -->
                                <div >
                                 <c:if test="${not empty planetList}">
                                    <table id="example1" >
                                        <thead>
                                            <tr><th>No.</th>
											    <th>Planet Id</th>
                                                <th>Planet Name</th>
												<th>Action</th>	
											    <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	<c:forEach items="${planetList}" var="planet" >
	                                            <tr>
													<td><c:out value="${planet.planetId}"/></td>
	                                                <td><c:out value="${planet.pId}"/></td>
	                                                <td><c:out value="${planet.pName}"/></td>
													<td><a href ="editPlanet.htm?planetId=${planet.planetId}">Edit</a></td>
													<td><a href ="deletePlanet.htm?planetId=${planet.planetId}">Delete</a></td>
	                                            </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    </c:if>
                                </div>
                            </div><!-- /.box -->
                        </div>
                    </div>
	</form>
	<h2><a href="goToHome.htm"> Go to Home</a></h2>
</body>
</html>