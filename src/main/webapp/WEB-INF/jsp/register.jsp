<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Login V8</title>
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
<title><s:message code="menu.register"/></title>
</head>


<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<p align="center">
		<c:out value="${message }" />
</p>

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">

            <form id="usersForm" action="adduser" modelAttribute="user" class="login100-form validate-form p-l-55 p-r-55 p-t-178"
                enctype="multipart/form-data" method="POST">
                <span class="login100-form-title">
                        Register
                </span>

                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter name">
                    <input class="input100" type="text" name="name" id="name" placeholder="Name">
                    <span class="focus-input100"></span>
                </div>
                <div>
                    <td colspan="2" align="center"><font color="red"><sf:errors path="name"/></font></td>
                </div>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter last name">
                    <input class="input100" type="text" name="lastName" id="lastName" placeholder="Last Name">
                    <span class="focus-input100"></span>
                </div>
                <div>
                    <td colspan="2" align="center"><font color="red"><sf:errors path="lastName"/></font></td>
                </div>
               <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter email">
                    <input class="input100" type="text" name="email" id="email" placeholder="Email">
                    <span class="focus-input100"></span>
                </div>
                <div>
                    <td colspan="2" align="center"><font color="red"><sf:errors path="email"/></font></td>
                </div>
                <div class="wrap-input100 validate-input m-b-16" data-validate="Please enter password">
                    <input class="input100" type="password" name="password" id="password" placeholder="Password">
                    <span class="focus-input100"></span>
                </div>
                <div>
                    <td colspan="2" align="center"><font color="red"><sf:errors path="password"/></font></td>
                </div>

                 <div class="wrap-input100 validate-input m-b-16" data-validate="Please select role">
                        <select name="nrRoli" class="wrap-input100 validate-input m-b-16" data-validate="Please select role">
                          <option value="1">Profesor</option>
                          <option value="2">Student</option>
                        </select>
                    <span class="focus-input100"></span>
                </div>

                <div class="text-right p-t-13 p-b-23">
                    <span class="txt1">
                        Have you account?
                    </span>

                    <a href="/login" class="txt2">
                        Sign In
                    </a>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn">
                        Register
                    </button>
                </div>

                <div class="flex-col-c p-t-170 p-b-40">
                    <span class="txt1 p-b-9">
                        Go Back!
                    </span>

                    <a href="/index" class="txt3">
                        CANCEL
                    </a>
                </div>

            </form>
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