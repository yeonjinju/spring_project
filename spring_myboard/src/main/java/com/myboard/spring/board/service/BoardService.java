package com.myboard.spring.board.service;

import javax.servlet.http.HttpServletRequest;

import com.myboard.spring.board.dto.BoardCommentDto;
import com.myboard.spring.board.dto.BoardDto;

public interface BoardService {
	public void getList(HttpServletRequest request);
	public void getDetail(HttpServletRequest request);
	public void saveContent(BoardDto dto);
	public void updateContent(BoardDto dto);
	public void deleteContent(int num, HttpServletRequest request);
	public void getData(HttpServletRequest request); //글 수정하기 위해 정보 불러오는 기능
	
	public void saveComment(HttpServletRequest request);//댓글 저장 
	public void deleteComment(HttpServletRequest request);//댓글 삭제
	public void updateComment(BoardCommentDto dto);//댓글 수정
	public void moreCommentList(HttpServletRequest request);//댓글 더보기 기능	
}








