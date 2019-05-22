<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>

<!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="/resources/images/favicon.png" type="image/png">
        <title>Learn IT Education</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/resources/cssindex/bootstrap.css">
        <link rel="stylesheet" href="/resources/vendors/linericon/style.css">
        <link rel="stylesheet" href="/resources/cssindex/font-awesome.min.css">
        <link rel="stylesheet" href="/resources/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="/resources/vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="/resources/vendors/nice-select/css/nice-select.css">
        <link rel="stylesheet" href="/resources/vendors/animate-css/animate.css">
        <!-- main css -->
        <link rel="stylesheet" href="/resources/cssindex/style.css">
        <link rel="stylesheet" href="/resources/cssindex/responsive.css">

</head>


<body>
<%@include file="/WEB-INF/incl/menu.app"%>
 <!--================Home Banner Area =================-->
        <section class="banner_area">
            <div class="banner_inner d-flex align-items-center">
            	<div class="overlay bg-parallax" data-stellar-ratio="0.9" data-stellar-vertical-offset="0" data-background=""></div>
				<div class="container">
					<div class="banner_content text-center">
						<h2>Aktualności</h2>
						<div class="page_link">
							<a href="/index1">Home</a>
							<a href="/index1">Elements</a>
						</div>
					</div>
				</div>
            </div>
        </section>
<!--================End Home Banner Area =================-->

<div algin="center">
        <h2><s:message code="post.posts"/></h2>
</div>

<div class="whole-wrap">
        <c:forEach var="u" items="${postList }">
				<div class="container">
					<div class="section-top-border">
						<h3 class="mb-30 title_color"><c:out value="${u.author }"/></h3>
						<div class="row">
							<div class="col-md-3">
							      <img src="data:image/jpeg;base64,${u.image}" width="150" height="225" alt="" class="img-fluid">
							</div>
							<div class="col-md-9 mt-sm-20 left-align-p">
								<p class="text-right"><c:out value="${u.createdOn }"/></p>
								<p><strong><c:out value="${u.title }"/></strong></p>
								<p><c:out value="${u.content }"/></p>
							</div>
						</div>
					</div>
                </div>
        </c:forEach>
</div>

<!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="/resources/js/jquery-3.3.1.min.js"></script>
        <script src="/resources/js/popper.js"></script>
        <script src="/resources/js/bootstrap.min.js"></script>
        <script src="/resources/js/stellar.js"></script>
        <script src="/resources/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/resources/vendors/nice-select/js/jquery.nice-select.min.js"></script>
        <script src="/resources/vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="/resources/vendors/isotope/isotope.pkgd.min.js"></script>
        <script src="/resources/vendors/popup/jquery.magnific-popup.min.js"></script>
        <script src="/resources/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="/resources/vendors/jquery-ui/jquery-ui.js"></script>
        <script src="/resources/js/jquery.ajaxchimp.min.js"></script>
        <script src="/resources/vendors/counter-up/jquery.waypoints.min.js"></script>
        <script src="/resources/vendors/counter-up/jquery.counterup.js"></script>
        <script src="/resources/js/mail-script.js"></script>
        <script src="/resources/js/theme.js"></script>

</body>
</html>