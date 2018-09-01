<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Finding shortest Path</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h2>Shortest Path</h2>
	<form:form method="post" action="planetpath">

		<table>
			<tr>
				<td><form:label path="sourceNode">Source Node:</form:label></td>
				<td><form:input path="sourceNode" /></td>
			</tr>
			<tr>
				<td><form:label path="destinationNode">Destination Node:</form:label></td>
				<td><form:input path="destinationNode" /></td>
			</tr>


			<tr>
				<td colspan="2"><input type="submit" value="Send" /></td>
			</tr>
		</table>

	</form:form>
</body>
</html>


<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.loginPageTitle" /></title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<%@include file="header.jsp"%>
<body>
	<form:form method="post" action="planetpath">

		<div align="center">
			<table class="data">
				<tr align="center">
					
				<tr>
				<td><form:label path="sourceNode">Source Node:</form:label></td>
				<td><form:input path="sourceNode" /></td>
			</tr>
			<tr>
				<td><form:label path="destinationNode">Destination Node:</form:label></td>
				<td><form:input path="destinationNode" /></td>
			</tr>
				

				<tr>
					<td />
					<td><input type="submit" value="Submit"></td>
					<td />
				
			</table>
		</div>
	</form:form>
	<%@include file="footer.jsp"%>
</body>
</html>
 --%>