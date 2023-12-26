package com.ssafy.pjt.model.service;

import java.util.List;

import com.ssafy.pjt.model.dto.Betting;

public interface BettingService {
	// 전체 내기 목록
	List<Betting> selectAll(int group_id);

	// 조건으로 검색
	List<Betting> selectByKeyword(String keyword);

	// 내기 상세 보기
	Betting selectOne(int id);

	// 내기 등록
	int insertBetting(Betting betting);

	// 내기 수정
	int updateBetting(Betting betting);

	// 내기 삭제
	int deleteBetting(int id);
}
