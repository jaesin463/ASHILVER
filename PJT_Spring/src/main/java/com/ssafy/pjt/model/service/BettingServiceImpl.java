package com.ssafy.pjt.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pjt.model.dao.BettingDao;
import com.ssafy.pjt.model.dto.Betting;

@Service
public class BettingServiceImpl implements BettingService {

	@Autowired
	BettingDao bettingDao;
	
	@Override
	public List<Betting> selectAll(int group_id) {
		return bettingDao.selectAll(group_id);
	}

	@Override
	public List<Betting> selectByKeyword(String keyword) {
		return bettingDao.selectByKeyword(keyword);
	}
	
	@Override
	public Betting selectOne(int id) {
		return bettingDao.selectOne(id);
	}

	@Override
	public int insertBetting(Betting betting) {
		return bettingDao.insertBetting(betting);
	}

	@Override
	public int updateBetting(Betting betting) {
		return bettingDao.updateBetting(betting);
	}

	@Override
	public int deleteBetting(int id) {
		return bettingDao.deleteBetting(id);
	}

}
