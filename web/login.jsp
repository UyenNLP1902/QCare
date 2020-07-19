<%-- 
    Document   : login.jsp
    Created on : Jul 18, 2020, 8:39:28 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <s:form action="LoginAction" method="POST">
            <s:textfield name="Username" label="Username"></s:textfield>
            <s:password name="Password" label="Password"/>
            <s:submit name="btnAction" label="Submit"/>
        </s:form>
        
        <s:a action="create_page">Create account</s:a>
    </body>
</html>
