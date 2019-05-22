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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>


<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="post.aktualnosc"/></h2>

<p align="center">
		<c:out value="${message }" />
</p>

<div class="container">
	<div class="row">

	    <div class="col-md-8 col-md-offset-2">

    		<h1>Create post</h1>

    		<form id="postsForm" action="addpost" modelAttribute="post"
                  		enctype="multipart/form-data" method="POST">


    		    <div class="form-group">
    		        <label for="title">Title <span class="require">*</span></label>
    		        <input type="text" class="form-control" name="title" />
    		    </div>

    		    <div class="form-group">
    		        <label for="description">Description</label>
    		        <textarea rows="5" class="form-control" name="content" ></textarea>
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


<div class="container">
<c:forEach var="u" items="${postList }">
	<div class="row">
		<div class="row">
                <div class="col-xs-12 col-sm-9 col-md-9">
                    <div class="list-group">
                        <div class="list-group-item">
                            <div class="row-picture">
                                <a href="adminposts/delete/${u.id }">
                                        <img src="/resources/images/delicon.png" width="16" height="16" title="<s:message code="delete.post"/>"/>
                                </a>
                                <a href="#" title="sintret">
                                    <img src="data:image/jpeg;base64,${u.image}" width="100" height="150" alt="" class="img-rounded">
                                </a>
                            </div>
                            <div class="row-content">
                                <div class="list-group-item-heading">
                                    <a>
                                        <small><c:out value="${u.author }"/></small>
                                    </a>
                                </div>
                                <small>
                                    <i class="glyphicon glyphicon-time"></i> <c:out value="${u.createdOn }"/>
                                    <br>
                                    <span class="explore"><i class="glyphicon glyphicon-th"></i> <a href="#">Explore 2 places </a></span>
                                </small>
                            </div>
                            <h4><a href="#"><c:out value="${u.title }"/></a></h4>
                            <p><c:out value="${u.content }"/></p>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</c:forEach>
</div>


</body>
</html>