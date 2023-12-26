<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SSAFIT</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css" />
</head>
<body style="margin: 0px 350px;">
	<header class="d-flex justify-content-center grid gap-3"
		style="margin-top: 20px;">
		<!-- 헤더 -->
		<h1 class="d-inline p-2" onclick="location.href='main.html'">
			<b><span style="color: #1E90FF;">S</span>SAFIT</b>
		</h1>
		<br>
	</header>
	<main style="width: 500px; margin: 50px 350px;">
		<p class="fs-1">
			<b>로그인</b>
		</p>
		<hr style="margin-bottom: 30px;">
		<form action="/login" method="POST">
			<div class="form-floating" style="margin: 10px 0px;">
				<textarea class="form-control" placeholder="Leave a comment here"
					id="floatingTextarea" name="id"></textarea>
				<label for="floatingTextarea">아이디</label>
			</div>
			<div class="form-floating" style="margin: 10px 0px;">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password" name="password"> <label
					for="floatingPassword">비밀번호</label>
			</div>
			<button class="btn btn-primary"
				style="background-color: #1e90ff; margin-left: 7px; width: 200px;">로그인</button>
		</form>
		<a href="videolist" class="btn btn-warning"
			style="margin-left: 7px; width: 200px;">취소</a>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="./main.js"></script>

</body>
</html>