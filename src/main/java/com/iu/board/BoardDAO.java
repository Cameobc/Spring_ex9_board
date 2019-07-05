package com.iu.board;

import java.util.List;

import com.iu.util.PageMaker;

public interface BoardDAO {

	//총 글의 개수
	public int getTotalCount(PageMaker pageMaker) throws Exception;

	//글 등록
	public int setWrite(BoardDTO boardDTO) throws Exception;
	
	//글 리스트 가져오기
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception;
	
	//글 하나 가져오기
	public BoardDTO getSelect(int num) throws Exception;
	
	//글 수정하기
	public int setUpdate(BoardDTO boardDTO) throws Exception;
	
	//글 삭제
	public int setDelete(int num) throws Exception;
	
}
