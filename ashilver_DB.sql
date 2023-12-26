INSERT INTO `user`(id, password, name, email, birthday, gender)
VALUES ("bumup", "1234", "이서윤", "bumup@ssafy.com", "2000-02-28", "female"),
("babo", "1234", "이재신", "babo@ssafy.com", "1997-02-28", "male"),
("ssafy", "1234", "김싸피", "bumup@ssafy.com", "2023-02-28", "female"),
("test1", "1234", "테스트", "test@ssafy.com", "2000-02-28", "female"),
("test2", "1234", "테스트", "test@ssafy.com", "2000-02-28", "female"),
("test3", "1234", "테스트", "test@ssafy.com", "2000-02-28", "female"),
("test4", "1234", "테스트", "test@ssafy.com", "2000-02-28", "female");

INSERT INTO `group` (`name`, `leader`, `intro`)
		VALUES
		('toto', '최은희', '스포츠 toto 아닙니다'),
		('ttotto', '이서윤', '저희는 ttotto 입니다!'),
		('bumbum', '이재신', '발끝까지 boomboom!'),
		('group123', '서만기', '좋은데?'),
		('대전 3반', '정민우', '대전 3반 최고최고!');


INSERT INTO `group_post` (group_id, user_id, title, content)
VALUES (1, "babo", "그룹 포스트 테스트", "테스트입니다."),
(1, "bumup", "그룹 포스트 테스트2", "테스트입니다."),
(2, "ssafy", "그룹 포스트 테스트3", "테스트입니다."),
(3, "test1", "그룹 포스트 테스트4", "테스트입니다."),
(4, "test2", "그룹 포스트 테스트5", "테스트입니다."),
(5, "test3", "그룹 포스트 테스트6", "테스트입니다."),
(5, "test4", "그룹 포스트 테스트7", "테스트입니다.");

INSERT INTO `group_review` (post_id, user_id, content)
VALUES (1, "babo", "1번 글에 댓글"),
(1, "bumup", "1번 글에 댓글"),
(2, "babo", "2번 글에 댓글"),
(3, "babo", "3번 글에 댓글"),
(4, "babo", "4번 글에 댓글"),
(5, "babo", "5번 글에 댓글"),
(6, "babo", "6번 글에 댓글");

INSERT INTO betting (group_id, name, keyword, goal, award, fee)
VALUES (1, "운동중독자", "1번그룹내기테스트1", "골격근 증가", "5만원", "2천원"),
(1, "팻커터", "근성장", "1번그룹내기테스트2", "5만원", "2천원"),
(2, "다이어트머신", "근성장", "2번그룹내기테스트1", "5만원", "2천원"),
(3, "지방탈곡기", "근성장", "3번그룹내기테스트1", "5만원", "2천원"),
(4, "헬스보이", "근성장", "4번그룹내기테스트1", "5만원", "2천원"),
(5, "필라걸스", "근성장", "5번그룹내기테스트1", "5만원", "2천원"),
(5, "누워서유산소", "근성장", "5번그룹내기테스트1", "5만원", "2천원");


INSERT INTO `board` (name)
VALUES ("전체"), ("공지"), ("리뷰"), ("정보"), ("자유");


INSERT INTO `board_post`(board_id, user_id, title, content)
VALUES (1, "babo", "1번게시판테스트1", "테스트"),
(1, "bumup", "1번게시판테스트2", "테스트"),
(1, "ssafy", "1번게시판테스트3", "테스트"),
(1, "test1", "1번게시판테스트4", "테스트"),
(2, "babo", "2번게시판테스트1", "테스트"),
(2, "bumup", "2번게시판테스트2", "테스트"),
(3, "babo", "3번게시판테스트1", "테스트"),
(4, "babo", "4번게시판테스트1", "테스트");

INSERT INTO `board_review`(post_id, user_id, content)
VALUES (1, "babo", "1번글댓글테스트1"),
(1, "bumup", "1번글댓글테스트2"),
(1, "babo", "1번글댓글테스트3"),
(1, "ssafy", "1번글댓글테스트4"),
(2, "babo", "2번글댓글테스트1"),
(2, "test1", "2번글댓글테스트2"),
(3, "babo", "3번글댓글테스트1"),
(4, "babo", "4번글댓글테스트1"),
(5, "babo", "5번글댓글테스트1");

INSERT INTO `group_membership`(user_id, group_id)
VALUES ("babo", 1), ("babo", 2), ("babo", 3), ("babo", 4), ("babo", 5),
("bumup", 1), ("bumup", 2), ("bumup", 3),
("test1", 1), ("test1", 2), ("test1", 3), ("test1", 4), ("test1", 5),
("test2", 1), ("test2", 2), ("test2", 3), ("test2", 4), ("test2", 5),
("test3", 1), ("test3", 2), ("test3", 3), ("test3", 4), ("test3", 5);

INSERT INTO `friendship`(user1_id, user2_id)
VALUES ("babo", "bumup"),
("babo", "ssafy"),
("babo", "test1"),
("babo", "test2"),
("babo", "test3"),
("babo", "test4"),
("bumup", "babo"),
("bumup", "test1");

USE ash;

SELECT * FROM `user`;

SELECT * From `friendship`;

SELECT * From `group_membership`;

SELECT * FROM `group`;

SELECT * FROM `group_post`;

SELECT * FROM `group_review`;

SELECT * FROM `betting`;

SELECT * FROM `board`;

SELECT * FROM `board_post`;

SELECT * FROM `board_review`;

DESC `board_post`;

DESC `group`;