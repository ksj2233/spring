package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.BoardVO;

public interface BoardMapper {

	 //거꾸로 가져오기
	public List<BoardVO> getList();
	
//	@Select("select sysdate from dual")
//	public String getTime();
	
	public void insert(BoardVO board);
	
}
