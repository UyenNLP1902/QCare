<%-- 
    Document   : create
    Created on : Jul 18, 2020, 6:05:17 PM
    Author     : SE140355
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <body>
        <h1>Create Account</h1>
        <s:set var="cityDao" value="#application.CITY_DAO"/>
        <s:set var="roleDao" value="#application.ROLE_DAO"/>
        <s:set var="specialistDao" value="#application.SPECIALIST_DAO"/>
        <jsp:useBean id="now" class="java.util.Date" />
        <fmt:formatDate var="year" value="${now}" pattern="yyyy" />

        <form action="create" method="POST">
            Username: <input type="text" name="Username" value="${param.Username}" /><br>

            <br>
            Password: <input type="password" name="Password" value="${param.Password}" /><br>

            <br>
            Name: <input type="text" name="Name" value="${param.Name}" /> (6-50 characters)<br>

            <br>
            City: <select name="City">
                <option value="0" ${param.City == '0' ? 'selected' : ''}>--Select your city--</option>
                <c:forEach var="city" items="${cityDao.getAll()}">
                    <option value="${city.Postcode}" ${param.City == city.Postcode ? 'selected' : ''}>${city.Name}</option>
                </c:forEach>
            </select><br>

            <br>
            Role: <select name="Role">
                <c:forEach var="role" items="${roleDao.getAll()}">
                    <option value="${role.ID}" ${param.Role == role.ID ? 'selected' : ''}>${role.Name}</option>
                </c:forEach>
            </select> <br>

            <br>
            Gender: 
            <input type="radio" name="Gender" value="0" checked="checked" /> Male <br>
            <input type="radio" name="Gender" value="1" /> Female <br>

            <br>
            Birth year: <input type="number" name="Birthyear" value="${param.Birthyear}" 
                               min="1900" max="${year}"/><br>
            
            <br>
            Specialist: <select name="Specialist">
                <option value="0" ${param.Specialist == '0' ? 'selected' : ''}>--Ignore if you're not doctors--</option>
                <c:forEach var="specialist" items="${specialistDao.getAll()}">
                    <option value="${specialist.ID}" ${param.Specialist == specialist.ID ? 'selected' : ''}>${specialist.Name}</option>
                </c:forEach>
            </select><br>
            
            <br>
            <input type="submit" value="Create Account" />
        </form>
    </body>
</html>
