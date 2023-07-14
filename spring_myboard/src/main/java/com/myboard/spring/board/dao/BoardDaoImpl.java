package com.myboard.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.spring.board.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao{
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return session.selectList("board.getList", dto);
	}

	@Override
	public int getCount(BoardDto dto) {
		
		return session.selectOne("board.getCount", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		session.insert("board.insert", dto);
	}

	@Override
	public BoardDto getData(int num) {
		return session.selectOne("board.getData", num);
	}

	@Override
	public BoardDto getData(BoardDto dto) {
		
		return session.selectOne("board.getData2", dto);
	}

	@Override
	public void addViewCount(int num) {
		session.update("board.addViewCount", num);
	}

	@Override
	public void delete(int num) {
		session.delete("board.delete", num);
	}

	@Override
	public void update(BoardDto dto) {
		session.update("board.update", dto);
	}


}