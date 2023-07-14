package com.myboard.spring.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myboard.spring.board.dto.BoardCommentDto;

@Repository
public class BoardCommentDaoImpl implements BoardCommentDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public List<BoardCommentDto> getList(BoardCommentDto dto) {

		return session.selectList("boardComment.getList", dto);
	}

	@Override
	public void delete(int num) {
		
		session.update("boardComment.delete", num);
	}

	@Override
	public void insert(BoardCommentDto dto) {
		session.insert("boardComment.insert", dto);
	}

	@Override
	public int getSequence() {
		return session.selectOne("boardComment.getSequence");
	}

	@Override
	public void update(BoardCommentDto dto) {
		session.update("boardComment.update", dto);
		
	}

	@Override
	public BoardCommentDto getData(int num) {
		return session.selectOne("boardComment.getData", num);
	}

	@Override
	public int getCount(int ref_group) {
		return session.selectOne("boardComment.getCount", ref_group);
	}
	

}