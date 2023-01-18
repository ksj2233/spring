package com.keduit.service;

import java.util.List;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;

public interface TodoService {
	
	public long register(TodoVO todoVO);
	
	public TodoVO get(Long no);
	
	public boolean modify(TodoVO todoVO);
	
	public boolean remove(Long no);
	
//	public List<BoardVO> getList();
	
	public List<TodoVO> getList(Criteria cri);
	
	public int getTotalCount(Criteria cri);
}
