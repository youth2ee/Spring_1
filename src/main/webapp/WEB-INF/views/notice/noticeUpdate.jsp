<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice update</title>
<c:import url="../layout/bootStrap.jsp" />
</head>
<body>
<c:import url="../layout/nav.jsp" />
	
	<h1>Notice Update</h1>
	
	<form action="./noticeUpdate" method="post">
		
				<div class="form-group">
					<label for="title">Title:</label> 
					<input type="text" name="title" class="form-control" id="title" placeholder="Enter title">
				</div>

				<div class="form-group">
					<label for="contents">Contents:</label>
					<textarea rows="20" cols="" name="contents" class="form-control" id="contents" placeholder="Enter contents"></textarea>
				</div>

				<button type="submit" class="btn btn-default">Submit</button>
				
		<button>Write</button>
	
	</form>

</body>
</html>