<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1>Member Join</h1>
	<form method="post" action="./memberJoin" enctype="multipart/form-data">
		<div class="form-group">
			<label for="id">Id</label>
			<input type="text" class="form-control" id="id" placeholder="Enter id" name="id">
		</div>	
	    <div class="form-group">
	      <label for="pw">Password:</label>
	      <input type="password" class="form-control" id="pw" placeholder="Enter password" name="pw">
	    </div>
	    <div class="form-group">
			<label for="name">Name</label>
			<input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
		</div>	
		<div class="form-group">
	      <label for="email">Email:</label>
	      <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
	    </div>
	    <div class="form-group">
	    	<label for="f1">Photo</label>
			<input type="file" name="f1">
		</div>	
	    <button class="btn btn-primary">Join</button>
	</form>
</div>
</body>
</html>