package com.keduit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;

public interface TodoMapper {
	
	   public List<TodoVO> getList();
	   
	   public List<TodoVO> getListWithPaging(Criteria cri);
	   
	   public String getTime();
	   
	   public void insert(TodoVO todo);
	   
	   public long insertSelectKey(TodoVO todo);
	   
	   public TodoVO read(Long no);
	   
	   public int delete(Long no); 
	   
	   public int update(TodoVO todo);
	   
	   public int getTotalCount(Criteria cri);
}
