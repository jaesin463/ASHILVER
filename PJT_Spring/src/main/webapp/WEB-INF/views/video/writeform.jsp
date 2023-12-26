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
		<p class="fs-1">
			<b>운동영상 리뷰</b>
		</p>

	</header>
	<main>
	<hr style="margin-bottom: 30px;">
	<!-- 리뷰쓰기 -->
	<form action="gym" method="POST">
		<input type="hidden" name="act" value="write">
		<input type="hidden" name="youtubeId" value="${youtubeId }"> 
		제목<br>
		<input type="text" class="form-control" name="title" placeholder="제목을 입력하세요">
		글쓴이<br>
		<input type="text" class="form-control" name="writer">
		내용<br>
		<textarea rows="3" style="height: 350px;" class="form-control" name="content">
		</textarea>
		<br>
		<button class="btn btn-primary"
			style="background-color: #1e90ff; margin-left: 7px; width: 70px;">등록</button>
	</form>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="./main.js"></script>

</body>
</html>