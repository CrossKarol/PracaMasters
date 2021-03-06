<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" href="/resources/css/styles.css">
<link rel="stylesheet" href="/resources/css/style.css">

</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>

<div algin="center">
        <h2><s:message code="consultations.wait"/></h2>
</div>


<div class="container">
    <c:forEach var="u" items="${consultationsListStudentZero }">
        <div class="row">
            <div class="row">
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <div class="list-group">
                            <div class="list-group-item">
                                <div class="row-content">
                                    <div class="list-group-item-heading">
                                        <a>
                                            <small><c:out value="${u.to_profesor }"/></small>
                                        </a>
                                    </div>
                                    <small>
                                        <i class="glyphicon glyphicon-time"></i> <c:out value="${u.date }"/> <c:out value="${u.hour }"/>
                                        <br>
                                        <span class="explore"><i class="glyphicon glyphicon-th"></i> <a href="#">Explore 2 places </a></span>
                                    </small>
                                </div>
                                <h4><a href="#"><c:out value="${u.topic }"/></a></h4>
                                <p><c:out value="${u.description }"/></p>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </c:forEach>
</div>


<div algin="center">
        <h2><s:message code="consultations.acceptstudent"/></h2>
</div>

<div class="container">
    <c:forEach var="u" items="${consultationsListStudentOne }">
        <div class="row">
            <div class="row">
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <div class="list-group">
                            <div class="list-group-item">
                                <div class="row-content">
                                    <div class="list-group-item-heading">
                                        <a>
                                            <small><c:out value="${u.to_profesor }"/></small>
                                        </a>
                                    </div>
                                    <small>
                                        <i class="glyphicon glyphicon-time"></i> <c:out value="${u.date }"/> <c:out value="${u.hour }"/>
                                        <br>
                                        <span class="explore"><i class="glyphicon glyphicon-th"></i> <a href="#">Explore 2 places </a></span>
                                    </small>
                                </div>
                                <h4><a href="#"><c:out value="${u.topic }"/></a></h4>
                                <p><c:out value="${u.description }"/></p>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </c:forEach>
</div>

<div algin="center">
        <h2><s:message code="consultations.noacceptstudent"/></h2>
</div>

<div class="container">
    <c:forEach var="u" items="${consultationsListStudentTwo }">
        <div class="row">
            <div class="row">
                    <div class="col-xs-12 col-sm-9 col-md-9">
                        <div class="list-group">
                            <div class="list-group-item">
                                <div class="row-content">
                                    <div class="list-group-item-heading">
                                        <a>
                                            <small><c:out value="${u.to_profesor }"/></small>
                                        </a>
                                    </div>
                                    <small>
                                        <i class="glyphicon glyphicon-time"></i> <c:out value="${u.date }"/> <c:out value="${u.hour }"/>
                                        <br>
                                        <span class="explore"><i class="glyphicon glyphicon-th"></i> <a href="#">Explore 2 places </a></span>
                                    </small>
                                </div>
                                <h4><a href="#"><c:out value="${u.topic }"/></a></h4>
                                <p><c:out value="${u.description }"/></p>
                                <div id="messageFeedba"><c:out value="${u.messageFeedback }"/></div>
                            </div>
                        </div>
                    </div>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>