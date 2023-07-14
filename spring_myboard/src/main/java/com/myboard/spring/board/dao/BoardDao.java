package com.myboard.spring.board.dao;

import java.util.List;

import com.myboard.spring.board.dto.BoardDto;


public interface BoardDao {
	//글목록
	public List<BoardDto> getList(BoardDto dto);
	//글의 갯수
	public int getCount(BoardDto dto);
	//글 추가
	public void insert(BoardDto dto);
	//글정보 얻어오기
	public BoardDto getData(int num);
	//키워드를 활용한 글정보 얻어오기 (키워드에 부합하는 글중에서 이전글, 다음글의 글번호도 얻어올수 있도록)
	public BoardDto getData(BoardDto dto);
	//조회수 증가 시키기
	public void addViewCount(int num);
	//글 삭제
	public void delete(int num);
	//글 수정
	public void update(BoardDto dto);
}


