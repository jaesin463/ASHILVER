<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
<style>
svg:hover {
	color: red;
}
</style>
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
	<div class="d-inline p-2 d-flex justify-content-between">
		<!---버튼-->
		<form action="gym" method="POST">
			<input type="hidden" name="act" value="videolist">
			<button class="btn btn-outline-primary" style="width: 70px;">
				목록</button>
		</form>
		<div>
			<form action="gym" method="POST">
				<input type="hidden" name="act" value="updateform">
				<input type="hidden" name="youtubeId" value="${youtubeId }">
				<input type="hidden" name="id" value="${Review.id }">
				<button class="btn btn-primary"
					style="background-color: #1e90ff; margin-left: 7px; width: 70px">
					수정</button>
			</form>
			<form action="gym" method="POST">
				<input type="hidden" name="act" value="delete">
				<input type="hidden" name="youtubeId" value="${youtubeId }">
				<input type="hidden" name="id" value="${Review.id }">
				<button class="btn btn-warning"
					style="margin-left: 7px; width: 70px;">삭제</button>
			</form>
		</div>

	</div>

	<!---글상자-->
	<div class="d-inline p-2 d-flex justify-content-around">
		<div class="border border-3"
			style="width: 100%; height: 500px; color: #757E8B;">
			<h1 style="text-align: center; margin: 30px;">${Review.title}</h1>
			<p style="text-align: center;">
				작성자 : ${Review.writer}<br> 작성일 : ${Review.regDate}<br> 조회수
				: ${Review.viewCnt}
			</p>
			<hr style="color: gray; margin: 30px">
			<p style="text-align: center;">${Review.content}</p>
		</div>
	</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="./main.js"></script>

</body>
</html>