<%@include file="../includeTop.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is JSP Dynamic Include Page</title>
</head>
<body>
<c:out value="${includeURL }"></c:out>
<jsp:include page="${includeURL}"></jsp:include>
</body>
</html>