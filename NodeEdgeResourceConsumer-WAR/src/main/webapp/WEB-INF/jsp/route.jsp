<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Routes Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Add a Route</h1>

	<c:url var="addAction" value="/route/add"></c:url>

	<form:form action="${addAction}" commandName="RoutePojo">
		<table>
			<c:if test="${!empty RoutePojo.planet_origin}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="planet_origin">
						<spring:message text="PlanetOrigin" />
					</form:label></td>
				<td><form:input path="planet_origin" /></td>
			</tr>
			<tr>
				<td><form:label path="planet_destination">
						<spring:message text="PlanetDestination" />
					</form:label></td>
				<td><form:input path="planet_destination" /></td>
			</tr>
			<tr>
				<td><form:label path="distance">
						<spring:message text="Distance" />
					</form:label></td>
				<td><form:input path="distance" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty RoutePojo.planet_origin}">
						<input type="submit" value="<spring:message text="Edit Route"/>" />
					</c:if> <c:if test="${empty RoutePojo.planet_destination}">
						<input type="submit" value="<spring:message text="Add Route"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Routes List</h3>
	<c:if test="${!empty listRoutes}">
		<table class="tg">
			<tr>
				<th width="80">Route ID</th>
				<th width="120">Origin Planet</th>
				<th width="120">Destination Planet</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listRoutes}" var="route">
				<tr>
					<td>${route.id}</td>
					<td>${route.planet_origin}</td>
					<td>${route.planet_destination}</td>
					<td>${route.distance}</td>
					<td><a href="<c:url value='route/edit/${route.id}' />">Edit</a></td>
					<td><a href="<c:url value='route/remove/${route.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>