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
</head>
<body style="margin: 0px 350px; height: 1000px;">
	<header>
		
	</header>

	<main> <!-- 메인 -->
	<hr>
	<div>
		<h4 style="margin: 30px 0px;">
			<b>실시간 급상승 영상</b>
		</h4>
		<div class="d-flex justify-content-center grid gap-3" id="video-area1"></div>
		<!--유튜브-->
		<div class="d-flex justify-content-around grid gap-3"
			style="margin-top: 10px; display: flex; flex-flow: wrap;">
			<c:forEach items="${sortlist }" var="video">
				<div style="display: flex; flex-direction: column;">
					<iframe width="450" height="200"
						src="https://www.youtube.com/embed/${video.youtubeId}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
					<a href="gym?act=reviewlist&youtubeId=${video.youtubeId }">${video.title }</a>
					<div style="display: flex; justify-content: space-between;">
						<div>${video.channelName }</div>
						<div>${video.viewCnt }</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<hr>

	<h4 style="margin-top: 30px;">
		<b>부위별 운동 영상</b>
	</h4>
	<div style="margin: 20px 0px; display: flex; flex-direction: row;">
		<form action="gym" method="POST">
			<input type="hidden" name="act" value="partsort"> <input
				type="hidden" name="fitpartname" value="전신">
			<button class="btn btn-outline-primary" style="margin: 0px 7px;">전신</button>
		</form>
		<form action="gym" method="POST">
			<input type="hidden" name="act" value="partsort"> <input
				type="hidden" name="fitpartname" value="상체">
			<button class="btn btn-outline-primary">상체</button>
		</form>
		<form action="gym" method="POST">
			<input type="hidden" name="act" value="partsort"> <input
				type="hidden" name="fitpartname" value="하체">
			<button class="btn btn-outline-primary" style="margin: 0px 7px;">하체</button>
		</form>
		<form action="gym" method="POST">
			<input type="hidden" name="act" value="partsort"> <input
				type="hidden" name="fitpartname" value="복부">
			<button class="btn btn-outline-primary">복부</button>
		</form>
	</div>
	<div class="d-flex justify-content-center grid gap-3" id="video-area2">
		<!--유튜브-->
		<div class="d-flex justify-content-around grid gap-3"
			style="margin-top: 10px; display: flex; flex-flow: row-wrap;">
			<c:forEach items="${partlist }" var="video">
				<div style="display: flex; flex-direction: column;">
					<iframe width="450" height="200"
						src="https://www.youtube.com/embed/${video.youtubeId}"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
						allowfullscreen></iframe>
					<a href="gym?act=reviewlist&youtubeId=${video.youtubeId }">${video.title }</a>
					<div style="display: flex; justify-content: space-between;">
						<div>${video.channelName }</div>
						<div>${video.viewCnt }</div>
					</div>
				</div>
			</c:forEach>
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