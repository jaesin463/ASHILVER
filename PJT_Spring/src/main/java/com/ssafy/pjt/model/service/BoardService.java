package com.ssafy.pjt.model.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Board;

public interface BoardService {
	// 게시판 카테고리 불러오기
	List<Board> selectAll();
}
