<table width="100%" border="0" cellpadding="8" cellspacing="4" class="tableMenuBg" bgcolor="#e6f2ff" >
	<tr>
		<td align="left" width="900">
			<a href="/"><s:message code="menu.mainPage"/></a>&nbsp;&nbsp;
			<sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="marginLeft" href="/admin"><s:message code="menu.adminPage"/></a>
				<a class="marginLeft"  href="/admin/users/1"><s:message code="menu.spotted"/></a>
				<a class="marginLeft"  href="/admin/users/1"><s:message code="menu.news"/></a>
			</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
				<a class="marginLeft"  href="/index"><s:message code="menu.news1"/></a>
				<a class="marginLeft"  href="/index"><s:message code="menu.prof"/></a>
				<a class="marginLeft"  href="/index"><s:message code="menu.save"/></a>
				<a class="marginLeft"  href="/index"><s:message code="menu.account"/></a>
				<a class="marginLeft"  href="/index"><s:message code="menu.spotted1"/></a>
				</sec:authorize>
		</td>
		<td align="right">
		<sec:authorize access="hasRole('ANONYMOUS')">
			<a class="marginLeft"  href="/login"><s:message code="menu.login"/></a>&nbsp;&nbsp;
			<a class="marginLeft"  href="/register"><s:message code="menu.register"/></a>&nbsp;&nbsp;
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<a class="marginLeft" href="/profil"><s:message code="menu.profil"/></a>
			<a class="marginLeft" href="/logout"><s:message code="menu.logout"/></a>
		</sec:authorize>
		</td>
	</tr>
</table>