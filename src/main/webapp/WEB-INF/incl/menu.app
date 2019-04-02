<html lang=''>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/styles.css">
<link rel="stylesheet" href="/resources/css/style.css">

<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
<script src="/resources/js/script.js"></script>
<title>CSS MenuMaker</title>
</head>
<body>

<div id="cssmenu">
	<ul>
				<li><a class="active" href="/"><s:message code="menu.mainPage"/></a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/admin/users/1"><s:message code="menu.adminPage"/></a></li>
					<li><a href="/index"><s:message code="menu.spotted"/></a></li>
					<li><a href="/adminposts"><s:message code="menu.news"/></a></li>
					<li><a href="/index"><s:message code="menu.group"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
					<li><a href="/userposts"><s:message code="menu.news1"/></a></li>
					<li><a href="/listprofesor"><s:message code="menu.prof"/></a></li>
					<li><a href="/index"><s:message code="menu.save"/></a></li>
					<li><a href="/profilusers"><s:message code="menu.account"/></a></li>
					<li><a href="/index"><s:message code="menu.spotted1"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_PROFESOR')">
					<li><a href="/profilprof"><s:message code="menu.konto"/></a></li>
					<li><a href="/index"><s:message code="menu.konsmanage"/></a></li>
					<li><a href="/adminposts"><s:message code="menu.aktualno"/></a></li>
					<li><a href="/index"><s:message code="menu.spotted2"/></a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ANONYMOUS')">
					<li class="marginLeft"><a href="/login"><s:message code="menu.login"/></a></li>
					<li class="marginLeft"><a href="/register"><s:message code="menu.register"/></a></li>
				</sec:authorize>
				<sec:authorize access="isAuthenticated()">
          <li class="marginLeft"><a href="/profilusers"><s:message code="menu.profil"/></a></li>
          <li class="marginLeft"><a href="/logout"><s:message code="menu.logout"/></a></li>
				</sec:authorize>
	</ul>
</div>

</body>
<html>