package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo); //update
	
	public ReplyVO read(Long rno); //read
	
	public int delete(Long rno); //delete 
	
	public int update(ReplyVO vo); //update
	
	public List<ReplyVO> getListWithPaging(
			@Param("cri") Criteria cri,
			@Param("bno") Long bno);
	
	public int getCountByBno(Long bno);
}
