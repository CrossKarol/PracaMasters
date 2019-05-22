<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Colorlib Templates">
<meta name="author" content="Colorlib">
<meta name="keywords" content="Colorlib Templates">


<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

<!-- Main CSS-->
<link href="/resources/css/maincomment.css" rel="stylesheet" media="all">
</head>

<body>
<form id="postsForm" action="addcommentspotted" modelAttribute="commentSpotted"
enctype="multipart/form-data" method="POST">
<div class="page-wrapper bg-dark p-t-100 p-b-50" >
	<div class="wrapper wrapper--w900">
			<div class="card card-6">
					<div class="card-heading">
						<h2 class="title">Add Comment</h2>
					</div>
						<div class="card-body">
										<div class="form-row">
											<div class="name">Title</div>
											<div class="value">
												<input class="input--style-6" type="text" name="title" id="title" placeholder="Title">
												<input type="hidden" class="form-control" name="id_post" value="${u.id }" />
											</div>
										</div>
										<div class="form-row">
											<div class="name">Message</div>
											<div class="value">
												<div class="input-group">
													<textarea class="textarea--style-6" name="content" placeholder="Description"></textarea>
												</div>
											</div>
										</div>
						</div>
						<div class="card-footer">
							<button class="btn btn--radius-2 btn--blue-2" type="submit">Send Comment</button>
						</div>
			</div>
	</div>
</div>
</form>

<!-- Jquery JS-->
<script src="/resources/vendor/jquery/jquery.min.js"></script>


<!-- Main JS-->
<script src="/resources/js/global.js"></script>
</body>
<html>