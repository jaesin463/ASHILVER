<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
#review:hover {
	color: #1e90ff
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

	<!-- 메인 -->
	<main>
	<hr style="margin-bottom: 30px;">
	<p align="middle">
		<iframe style="justify-content: center;" width="560" height="315"
			src="https://www.youtube.com/embed/${youtubeId}"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
			allowfullscreen></iframe>
	</p>
	<hr style="margin-top: 30px;">
	<div>
		<div class="d-flex justify-content-between grid gap-3">
			<form action="gym" method="POST">
				<input type="hidden" name="act" value="writeform"> <input
					type="hidden" name="youtubeId" value="${youtubeId }">
				<button class="btn btn-primary"
					style="background-color: #1e90ff; margin-left: 7px;">글
					작성</button>
			</form>
			<form action="gym" method="POST">
				<input type="hidden" name="act" value="videolist">
				<button class="btn btn-primary"
					style="background-color: #1e90ff; margin-left: 7px;">목록</button>
			</form>
		</div>
		<!-- 글 목록 -->
		<table class="table" style="margin-top: 30px;">
			<tr>
				<th scope="col">번호</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
				<th scope="col">조회수</th>
				<th scope="col">등록일</th>
			</tr>
			<c:if test="${review_list != null}">
				<c:forEach items="${review_list }" var="review">
					<tr>
						<td>${review.id }</td>
						<td><a href="gym?act=detail&youtubeId=${youtubeId }&id=${review.id }">${review.title }</a>
						</td>
						<td>${review.writer }</td>
						<td>${review.viewCnt }</td>
						<td>${review.regDate }</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</div>
	</main>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
	<script src="./main.js"></script>
</body>
</html>