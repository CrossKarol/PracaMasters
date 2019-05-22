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
              <title>Front page</title>

              <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
              <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900" rel="stylesheet">

              <link rel="stylesheet" href="/resources/csslistprof/bootstrap.css">
              <link rel="stylesheet" href="/resources/csslistprof/font-awesome.min.css">
              <link rel="stylesheet" href="/resources/csslistprof/owl.carousel.min.css">
              <link rel="stylesheet" href="/resources/csslistprof/owl.theme.default.min.css">
              <link rel="stylesheet" href="/resources/csslistprof/style.css">
              <link rel="stylesheet" href="/resources/csslistprof/responsive.css">

</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>






<div id="divplus">
    <c:forEach var="u" items="${userList }">

        <div class="container">
            <div class="row">
                <div class="span2">
                  <img src="data:image/jpeg;base64,${u.image}" width="200" height="300" alt="" class="img-rounded">
                </div>
                <div class="span4">
                  <blockquote>
                    <p><c:out value="${u.name}"/> <c:out value="${u.lastName}"/></p>
                    <small><cite title="Source Title">Politechnika Łódzka  <i class="icon-map-marker"></i></cite></small>
                  </blockquote>
                  <p>
                    <i class="icon-envelope"></i> <c:out value="${u.email}"/> <br>
                    <i class="icon-globe"></i> Aktywny: <c:choose>
                                                  <c:when test="${u.active == 1 }">
                                                      <s:message code="word.tak"/>
                                                  </c:when>
                                                  <c:otherwise>
                                                      <s:message code="word.nie"/>
                                                  </c:otherwise>
                                              </c:choose> <br>
                    <i class="icon-gift"></i> <c:out value="${u.konsultacje}"/> <br>
                    <i class="icon-globe"></i> <c:out value="${u.phone}"/> <br>
                    <i class="icon-gift"></i> <c:out value="${u.titleP}"/> <br>
                    <i class="icon-globe"></i> <c:out value="${u.myPage}"/> <br>
                    <i class="icon-globe"></i> <c:out value="${u.infoStudent}"/> <br>
                    <i class="icon-gift"></i> <c:out value="${u.room}"/>
                  </p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

 <script src="/resources/js/jquery-3.1.1.min.js"></script>
     <script src="/resources/js/animationCounter.js"></script>
     <script src="/resources/js/bootstrap.min.js"></script>
     <script src="/resources/js/owl.carousel.min.js"></script>
     <script src="/resources/js/active.js"></script>

     <script type="text/javascript">
         var _gaq = _gaq || [];
         _gaq.push(['_setAccount', 'UA-36251023-1']);
         _gaq.push(['_setDomainName', 'jqueryscript.net']);
         _gaq.push(['_trackPageview']);

         (function() {
             var ga = document.createElement('script');
             ga.type = 'text/javascript';
             ga.async = true;
             ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
             var s = document.getElementsByTagName('script')[0];
             s.parentNode.insertBefore(ga, s);
         })();
     </script>


</body>
</html>