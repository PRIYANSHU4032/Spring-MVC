<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	welcome to jsp....
	<form action="addAlien" method="post">
	Enter your id please : <input type="text" name="aid"><br>
	Enter your name: <input type="text" name="aname"><br>
	<input type="submit">
	</form>
	
	<form action="getAlien">
	<input type="submit" value="alien">
	</form>
	
	
	
	<form action="getoneAlien">
	Enter your id please : <input type="text" name="aid"><br>
	<input type="submit" value="alien"><br>
	</form>
	
	<form action="removeAlien">
	Enter your id please : <input type="text" name="aid"><br>
	<input type="submit" value="remove"><br>
	</form>
	
	<form action="getAlienName">
	Enter your id please : <input type="text" name="aname"><br>
	<input type="submit" value="alienName"><br>
	</form>
	
	<form action="login" method="post">
	Enter your id please : <input type="text" name="aid"><br>
	Enter your name: <input type="text" name="aname"><br>
	<input type="submit">
	</form>
	
</body>
</html>