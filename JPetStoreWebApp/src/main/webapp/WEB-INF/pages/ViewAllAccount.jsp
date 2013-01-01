<%@include file="includeTop.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>First Name</th><th>Last Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${Accounts}" var="account">
				<tr>
					<td><c:out value="${account.firstName }"/></td>
					<td><c:out value="${account.lastName }"/></td>
					<td><a href="Detail.do?Id=${account.username}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>