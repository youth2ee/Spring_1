<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Home</title>
<c:import url="./layout/bootStrap.jsp" />
</head>
<body>
	<c:import url="./layout/nav.jsp" />

	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="./test">Go Test</a><br>
	<a href="./notice/noticeList">Go Notice List</a><br>

	<a href="./member/memberJoin">Go Member Join</a><br>
	<a href="./member/memberLogin">Go Member Login</a><br>
	
	<img alt="" src="./resources/images/cha2.jpg">
	
</body>
</html>

