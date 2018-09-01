<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Planets Page</title>
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
	<h1>Add a Planet</h1>

	<c:url var="addAction" value="/planet/add"></c:url>

	<form:form action="${addAction}" commandName="planet">
		<table>
			<c:if test="${!empty planet.planetNode}">
				<tr>
					<td><form:label path="id">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="8"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="planetNode">
						<spring:message text="Planet" />
					</form:label></td>
				<td><form:input path="planetNode" /></td>
			</tr>
			<tr>
				<td><form:label path="planetName">
						<spring:message text="PlanetName" />
					</form:label></td>
				<td><form:input path="planetName" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty planet.planetName}">
						<input type="submit" value="<spring:message text="Edit Planet"/>" />
					</c:if> <c:if test="${empty planet.planetName}">
						<input type="submit" value="<spring:message text="Add Planet"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Planets List</h3>
	<c:if test="${not empty listPlanets}">
		<table class="tg">
			<tr>
				<th width="80">Planet ID</th>
				<th width="120">Planet</th>
				<th width="120">Planet Name</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPlanets}" var="Planet">
				<tr>
					<td>${Planet.id}</td>
					<td>${Planet.planetNode}</td>
					<td>${Planet.planetName}</td>
					<td><a href="<c:url value='/edit/${Planet.id}' />">Edit</a></td>
					<td><a href="<c:url value='/remove/${Planet.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</body>
</html>