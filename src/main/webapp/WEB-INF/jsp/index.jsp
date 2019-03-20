<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title><s:message code="menu.mainPage"/></title>
</head>


<body>
<%@include file="/WEB-INF/incl/menu.app"%>
<h1>Ta strona internetowa została stworzona dla studentów Politechniki Łódzkiej.</h1>
<h2>Karol jest idiotą ale nic z tym nie zrobisz zanim to ogarnął mineło 3h ale to ogarnął xDD</h2>
<h3>Nie wiem o co chodzi na użytkowniku też jest podpięty index.jsp wow<h3>

<h3 align="center"><c:out value="${message }" /></h3>
</body>
</html>