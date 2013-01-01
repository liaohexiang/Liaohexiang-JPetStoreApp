<%@include file="includeTop.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Account</title>
</head>
<body>
<form:form modelAttribute="account" action="Update.do" method="POST">
	<table>
		<tr>
			<td>user name:</td>
			<td><form:input path="username"/><form:errors path="username" /></td>
		</tr>
		<tr>
			<td>first name:</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>last name:</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>address1:</td>
			<td><form:input path="address1"/></td>
		</tr>
		<tr>
			<td>address2:</td>
			<td><form:input path="address2"/></td>
		</tr>
		<tr>
			<td>city:</td>
			<td><form:input path="city"/></td>
		</tr>
		<tr>
			<td>state:</td>
			<td><form:input path="state"/></td>
		</tr>
		<tr>
			<td>zip:</td>
			<td><form:input path="zip"/></td>
		</tr>
		<tr>
			<td>email:</td>
			<td><form:input path="email"/></td>
		</tr>
		<tr>
			<td>country:</td>
			<td><form:input path="country"/></td>
		</tr>
		<tr>
			<td>phone:</td>
			<td><form:input path="phone"/></td>
		</tr>
		<tr>
			<td>languagePreference:</td>
			<td><form:input path="languagePreference"/></td>
		</tr>
		<tr>
			<td>favouriteCategoryId:</td>
			<td><form:input path="favouriteCategoryId"/></td>
		</tr>
		<tr>
			<td>listOptionAsInt:</td>
			<td><form:input path="listOptionAsInt"/></td>
		</tr>
		<tr>
			<td>bannerOptionAsInt:</td>
			<td><form:input path="bannerOptionAsInt"/></td>
		</tr>
	</table>
	<input type="submit" value="submit"/>
</form:form>
</body>
</html>