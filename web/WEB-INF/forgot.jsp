<%-- 
    Document   : forgot
    Created on : 25-Jul-2022, 12:43:58 PM
    Author     : Dakota Chatt
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forgot Password</title>
    </head>
    <body>
        <h1>Forgot Password</h1>
        <p>Please enter the email address associated with your account to retrieve your password</p>
        
        <form action="" method="post">
            <label>Email Address: </label>
            <input type="text" name="email" value="">
            <input type="submit" value="Submit">
        </form>
        
        <c:if test="${message != null}">
            <p>${message}</p>
        </c:if>
    </body>
</html>
