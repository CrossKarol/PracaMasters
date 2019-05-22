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
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

                <script type="text/javascript">
                function addMessage(id) {

                 $("#form_"+id).toggle();
                }
                </script>
    </head>

    <body>
        <div>
            <%@include file="/WEB-INF/incl/menu.app" %>

            <div class="container">
                <c:forEach var="u" items="${spottedPostList }">
                    <div class="card">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-2">
                                    <img src="data:image/jpeg;base64,${u.image}" alt="" class="img img-rounded img-fluid"/>
                                    <p class="text-secondary text-center"><c:out value="${u.author }"/></p>
                                </div>
                                <div class="col-md-10">
                                    <p>
                                        <a class="float-left" ><strong><c:out value="${u.title }"/></strong></a>
                                        <span class="float-right"><c:out value="${u.createOn }"/></span>
                                   </p>
                                   <div class="clearfix"></div>
                                        <p><c:out value="${u.content }"/></p>
                                        <p>
                                              <button class="float-right btn btn-outline-primary ml-2" type="button" id="formButton" onclick="addMessage(${u.id });"><i class="fa fa-reply"></i> Reply</button>
                                              <form id="formularz1" action="spottedall/likepost/${u.id }" >
                                                      <input type="hidden" name="spottedLike" id="spottedLike" value="${u.spottedLike + 1 }"/>
                                                      <button class="float-right btn text-white btn-danger" type="submit" id="submit"><i class="fa fa-heart"></i>Like! <c:out value="${u.spottedLike }"/></button>
                                              </form>
                                       </p>
                                </div>
                            </div>
                            <div id="form_${u.id }" style = "display:none;" >

                                    <%@include file="/WEB-INF/incl/comment.app" %>
                                    <%@include file="/WEB-INF/incl/commentForm.app" %>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <%@include file="/WEB-INF/incl/postForm.app" %>
        </div>
    </body>
</html>