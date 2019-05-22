<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta charset="UTF-8">
        	<meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/animate/animate.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        	<link rel="stylesheet" type="text/css" href="/resources/css/util.css">
        	<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
        <!--===============================================================================================-->
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css" />
    <title><s:message code="profil.userDane"/></title>
</head>



<body>
<%@include file="/WEB-INF/incl/menu.app"%>

<div align="left">
        <h2><s:message code="profil.userDane"/></h2>
</div>

<div id="divplus">
    <div class="container">
        <div class="row">
            <div class="span2">
              <img src="data:image/jpeg;base64,${image}" width="150" height="225" alt="..." class="img-rounded">
            </div>
            <div class="span4">
              <blockquote>
                <p><c:out value="${user.name}"/> <c:out value="${user.lastName}"/></p>
                <small><cite title="Source Title">Politechnika Łódzka  <i class="icon-map-marker"></i></cite></small>
              </blockquote>
              <p>
                <i class="icon-envelope"></i> <c:out value="${user.email}"/> <br>
                <i class="icon-globe"></i> Aktywny: <c:choose>
                                              <c:when test="${user.active == 1 }">
                                                  <s:message code="word.tak"/>
                                              </c:when>
                                              <c:otherwise>
                                                  <s:message code="word.nie"/>
                                              </c:otherwise>
                                          </c:choose> <br>
                <i class="icon-gift"></i> <c:out value="${user.kierunek}"/> <br>
                <i class="icon-globe"></i> <c:out value="${user.groupLab}"/> <br>
                <i class="icon-gift"></i> <c:out value="${user.specjalizacja}"/> <br>
                <i class="icon-globe"></i> <c:out value="${user.wydzial}"/> <br>
              </p>
            </div>

            <div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" onclick="window.location.href='${pageContext.request.contextPath}/student/editprofilusers'">
                        Edytuj Profil
                    </button>
                </div>
                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" onclick="window.location.href='${pageContext.request.contextPath}/editpassword'">
                        Edytuj Hasło
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<!--===============================================================================================-->
	<script src="/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="/resources/js/main.js"></script>
</body>
</html>