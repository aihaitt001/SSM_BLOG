<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>用户id</td>
		<td>用户名</td>
	</tr>
	<c:forEach items="${users}" var="c" varStatus="st">
		<tr>
			<td>${c.id}</td>
			<td>${c.username}</td>

		</tr>
	</c:forEach>
</table>