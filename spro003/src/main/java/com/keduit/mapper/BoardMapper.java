package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

public interface BoardMapper {
//	   @Select("select * from tbl_board order by bno desc")
	   public List<BoardVO> getList();
	   
	   public List<BoardVO> getListWithPaging(Criteria cri);
	   
//	   @Select("select sysdate from dual")
	   public String getTime();
	   
	   public void insert(BoardVO board);
	   
	   public long insertSelectKey(BoardVO board);
	   
	   public BoardVO read(Long bno);
	   
	   public int delete(Long bno); 
	   
	   public int update(BoardVO board);
	   
	   public int getTotalCount(Criteria cri);
}
