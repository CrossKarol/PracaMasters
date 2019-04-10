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
<title><s:message code="consultations.save"/></title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>


<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="consultations.save"/></h2>

<p align="center">
		<c:out value="${message }" />
</p>

<div class="container">
	<div class="row">

	    <div class="col-md-8 col-md-offset-2">

    		<h1>Create Consultations</h1>

    		<form id="consultationsForm" action="addconsultations" modelAttribute="consultations"
                  		enctype="multipart/form-data" method="POST">

                <div class="form-group">
                    <label for="title">Wybierz prowadzącego <span class="require">*</span></label>
                    <select name="to_profesor">
                        <c:forEach var="u" items="${profList }">
                          <option>${u.name} ${u.lastName}</option>
                        </c:forEach>
                    </select>
                </div>

    		    <div class="form-group">
    		        <label for="title">Temat <span class="require">*</span></label>
    		        <input type="text" class="form-control" name="topic" />
    		    </div>

                <div class="form-group">
                    <label for="title">Data konsultacji <span class="require">*</span></label>
                    <input type="date" class="form-control" name="date" />
                </div>

                <div class="form-group">
                    <label for="title">Godzina konsultacji <span class="require">*</span></label>
                    <input type="time" class="form-control" name="hour" />
                </div>

    		    <div class="form-group">
    		        <label for="description">Opis zagadnienia</label>
    		        <textarea rows="5" class="form-control" name="description" ></textarea>
    		    </div>

    		    <div class="form-group">
    		        <p><span class="require">*</span> - required fields</p>
    		    </div>

    		    <div class="form-group">
    		        <button type="submit" class="btn btn-primary">
    		            Create
    		        </button>
    		        <button class="btn btn-default">
    		            Cancel
    		        </button>
    		    </div>

    		</form>
		</div>
	</div>
</div>

</body>
</html>