<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
<title><s:message code="menu.register"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="post.aktualnosc"/></h2>

<p align="center">
		<c:out value="${message }" />
</p>

	<sf:form id="postsForm" action="addpost" modelAttribute="post"
		enctype="multipart/form-data" method="POST">

		<table width="500" border="0" cellpadding="4" cellspacing="1"
			align="center">

			<tr>
				<td width="130" align="right" ><s:message code="post.title"/></td>
				<td width="270" align="left"><sf:input path="title"
						size="28" id="title" /></td>
			</tr>

			<tr>
				<td width="130" align="right"><s:message code="post.Content"/></td>
				<td width="270" align="left"><sf:input size="28" path="content"
						 /></td>
			</tr>

			<tr>
				<td colspan="2" align="center" bgcolor="#fff">
					<input type="submit" value="<s:message code="post.button.added"/>" class="formbutton"/>
					<input type="button" value="<s:message code="post.button.cancel"/>" class="formbutton"
						onclick="window.location.href='${pageContext.request.contextPath}/'"/>
				</td>
			</tr>

		</table>
	</sf:form>


</body>
</html>