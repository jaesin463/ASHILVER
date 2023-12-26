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
	<div class="mb-3">
		<label for="exampleFormControlInput1" class="form-label">제목</label> <input
			type="email" class="form-control" id="exampleFormControlInput1"
			placeholder="">
	</div>
	<div class="mb-3">
		<label for="exampleFormControlTextarea1" class="form-label">수정할
			내용</label>
		<textarea class="form-control" id="exampleFormControlTextarea1"
			rows="3" style="height: 350px;"></textarea>
	</div>
	<div>
		<button type="button" class="btn btn-primary"
			style="background-color: #1e90ff; margin-left: 7px; width: 70px;"
			onclick="location.href='detail.html'">수정</button>
		<button type="button" class="btn btn-warning"
			style="margin-left: 7px; width: 70px;"
			onclick="location.href='detail.html'">취소</button>
	</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="./main.js"></script>

</body>
</html>