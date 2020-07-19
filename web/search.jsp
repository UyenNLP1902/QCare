<%-- 
    Document   : search
    Created on : Jul 19, 2020, 8:22:30 AM
    Author     : SE140355
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head>
    <body>
        <h1>Search Page</h1>
        <s:set var="symptomDao" value="#application.SYMPTOM_DAO"/>
        <s:form action="search_symptom">
            <b>Symptoms:</b><br>

            <s:iterator value="#symptomDao.getAll()" begin="1" end="5">
                <input type="checkbox" name="Symptom" value="id" /> <s:property value="Description"/> <br>
            </s:iterator>
            <s:textfield name="Other" label="Other symptoms"/>
            <s:submit value="Search"/>
        </s:form>
    </body>
</html>
