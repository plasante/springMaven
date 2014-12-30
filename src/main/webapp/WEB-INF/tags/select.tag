<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:select path="privilege">
	<c:forEach items="${privilegesMap}" var="priv">
		<c:choose>
			<c:when test="${role.privilege.privilegeName eq aut.value}">
				<option value="${priv.key}" selected>${priv.value}</option>
			</c:when>
			<c:otherwise>
				<option value="${priv.key}">${priv.value}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</form:select>