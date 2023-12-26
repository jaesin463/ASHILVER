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
		<!-- 헤더 -->
		<nav>
			<div class="d-flex justify-content-between d-flex align-items-center">
				<h1 class="d-inline p-2">
					<b><span style="color: #1E90FF;">S</span>SAFIT</b>
				</h1>
				<form
					class="d-inline p-2 d-flex justify-content-around d-flex align-items-center"
					action="#" style="width: 600px;">
					<input class="form-control" type="text" placeholder="검색"
						aria-label="default input example">
					<button class="btn btn-secondary" type="button"
						style="width: 100px; margin-left: 10px;">검색</button>
				</form>
				<form class="d-inline p-2" action="#">

					<c:if test="${empty loginUser}">
						<a href="loginform" class="btn btn-primary"
							style="background-color: #1e90ff; margin-left: 7px;">로그인</a>
						<a href="joinform" class="btn btn-warning"
							style="margin-left: 7px;">회원가입</a>
					</c:if>
					<c:if test="${not empty loginUser}">
						<svg xmlns="http://www.w3.org/2000/svg" width="40" height="40"
							fill="currentColor" class="bi bi-person-circle"
							viewBox="0 0 16 16">
                    	<path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z" />
                    	<path fill-rule="evenodd"
								d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z" />
						</svg>
						<a href="logout" class="btn btn-primary"
							style="background-color: #1e90ff; margin-left: 7px;">로그아웃</a>
					</c:if>
				</form>
			</div>
		</nav>
	</header>

	<main>
		<!-- 메인 -->
		<hr>
		<div>
			<h4 style="margin: 30px 0px;">
				<b>실시간 급상승 영상</b>
			</h4>
			<div class="d-flex justify-content-center grid gap-3"
				id="video-area1"></div>
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