<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
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
<h1>MyPage</h1>
<h2>ID : ${member.id} </h2>
<h2>NAME : ${member.name} </h2>
<h2>EMAIL : ${member.email}</h2>
<h2>GRADE : ${member.grade}</h2>
<h2>PHOTO</h1>
<img alt="${member.memberFileDTO.oname}" src="../resources/member/${member.memberFileDTO.fname}">
</div>
</body>
</html>