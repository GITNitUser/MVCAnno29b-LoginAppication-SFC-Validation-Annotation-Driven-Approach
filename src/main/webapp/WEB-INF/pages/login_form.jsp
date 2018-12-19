<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="login"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color: green; text-align: center">Login Page</h1>

<spring:form method="POST" modelAttribute="loginCmd" > 
	<table border="2" cellpadding="5" cellspacing="5" align="center">
		<tr>
			<td>Username::</td>
			<td><spring:input path="username" /> <spring:errors
					path="username" /></td>
		</tr>
		<tr>
			<td>Password::</td>
			<td><spring:password path="password" /> <spring:errors
					path="password" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit"
				value="Login"></td>
		</tr>
	</table>
</spring:form>

<br>
<br>
<login:if test="${msg ne null}">
	<h1 style="color: green; text-align: center">${msg}</h1>
</login:if>