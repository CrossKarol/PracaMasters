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
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>
<div algin="center">
        <h2><s:message code="post.posts"/></h2>
</div>

<table width="1000" border="0" cellpadding="6" cellspacing="0">


        <c:forEach var="u" items="${postList }">
        <c:set var="licznik" value="${licznik+1}"/>
            <tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">

                <td align="lest"><c:out value="${u.author }"/></td>
                <td align="left"><c:out value="${u.title }"/></td>
                <td align="left"><c:out value="${u.content }"/></td>
                <td align="center"><c:out value="${u.createdOn }"/></td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>