package com.ssafy.pjt.model.dao;

import java.util.List;

import com.ssafy.pjt.model.dto.Board;

public interface BoardDao {
	// 게시판 카테고리 불러오기
	List<Board> selectAll();
}
