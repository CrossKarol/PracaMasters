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
<title><s:message code="deangroup.description"/></title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
function changeTrBg(row){
	row.style.backgroundColor = "#e6e6e6";
}
function defaultTrBg(row){
	row.style.backgroundColor = "white";
}
function startSearch(){
	var searchWord = document.getElementById('searchString').value;

	if(searchWord.length < 3){
		document.getElementById("errorSearch").innerHTML = "<s:message code="error.searchString.toShort"/>";
		return false;
	} else {
		document.getElementById("errorSearch").innerHTML = "";
		var searchLink = '${pageContext.request.contextPath}/admin/users/search/' + searchWord;
		window.location.href=searchLink;
	}
}
</script>

</head>


<body>
<%@include file="/WEB-INF/incl/menu.app" %>

<h2><s:message code="deangroup.description"/></h2>

<p align="center">
		<c:out value="${message }" />
</p>

<div class="container">
	<div class="row">

	    <div class="col-md-8 col-md-offset-2">

    		<h1>Create Dean Group</h1>

    		<form id="deanGroupAction" action="adddeangroup" modelAttribute="post"
                  		enctype="multipart/form-data" method="POST">


    		    <div class="form-group">
    		        <label for="title">Department<span class="require">*</span></label>
    		        <input type="text" class="form-control" name="department" />
    		    </div>

    		    <div class="form-group">
                    <label for="title">Field of Study<span class="require">*</span></label>
                    <input type="text" class="form-control" name="fieldOfStudy" />
                </div>

                <div class="form-group">
                    <label for="title">Group<span class="require">*</span></label>
                    <input type="text" class="form-control" name="group" />
                </div>

                <div class="form-group">
                    <label for="title">Specialization<span class="require">*</span></label>
                    <input type="text" class="form-control" name="specialization" />
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


<h2><s:message code="deangroup.list"/></h2>

<c:set var="licznik" value="${recordStartCounter }"/>
    <div id="dean" align="center" >

        <table width="1000" border="0" cellpadding="6" cellspacing="0">
            <tr bgcolor="#57b846">
                <td width="40" align = "center"></td>
                <td width="40" align = "center"><b><s:message code="deangroup.id"/></b></td>
                <td width="190" align = "center"><b><s:message code="deangroup.department"/></b></td>
                <td width="190" align = "center"><b><s:message code="deangroup.fieldofstudy"/></b></td>
                <td width="120" align = "center"><b><s:message code="deangroup.group"/></b></td>
                <td width="180" align = "center"><b><s:message code="deangroup.specialization"/></b></td>
                <td width="50"></td>
            </tr>

            <c:forEach var="u" items="${deanGroupList }">
            <c:set var="licznik" value="${licznik+1}"/>
                <tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
                    <td align="center"><c:out value="${licznik }"/></td>
                    <td align="center"><c:out value="${u.id }"/></td>
                    <td align="center"><c:out value="${u.department }"/></td>
                    <td align="center"><c:out value="${u.fieldOfStudy }"/></td>
                    <td align="center"><c:out value="${u.group }"/></td>
                    <td align="center"><c:out value="${u.specialization }"/></td>

                    <td>
                        <a href="delete/${u.id }">
                                <img src="/resources/images/delicon.png" width="16" height="16" title="<s:message code="delete.user"/>"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <table width="1000" border="0" cellpadding="6" cellspacing="0"  bgcolor="#57b846">
            <tr bgcolor="#57b846">
                <td width="300" align="left">
                        <s:message code="info.page"/> ${currentPage} <s:message code="info.from"/> ${totalPages}
                </td>
                <td align="right">
                    <c:if test="${currentPage > 1}">
                        <input type="button"
                            onclick="window.location.href='${pageContext.request.contextPath}/admin/deangroup/${currentPage - 1}'"
                            value="<s:message code ="link.poprzedni"/>"/>&nbsp;&nbsp;
                    </c:if>

                     <c:if test="${currentPage < totalPages}">
                        <input type="button"
                            onclick="window.location.href='${pageContext.request.contextPath}/admin/deangroup/${currentPage + 1}'"
                            value="<s:message code ="link.nastepny"/>"/>
                    </c:if>

                </td>
            </tr>
        </table>
    </div>

</body>
</html>