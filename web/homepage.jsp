<%-- 
    Document   : homepage
    Created on : Jul 19, 2020, 7:55:04 AM
    Author     : SE140355
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Hello</h1>
        <s:a action="Login_PageAction">Login</s:a>
        <s:a action="create_page">Create account</s:a><br>
        If you feeling unwell! 
        <s:a action="Search_PageAction">Search symptom</s:a>
    </body>
</html>
