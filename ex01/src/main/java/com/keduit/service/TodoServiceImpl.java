package com.keduit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;
import com.keduit.mapper.TodoMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@ToString
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final TodoMapper mapper;
	
	@Override
	public long register(TodoVO todoVO) {
		log.info("----------register-------" + todoVO);
		
		return mapper.insertSelectKey(todoVO);
	}

	@Override
	public TodoVO get(Long no) {
		log.info("-------get------");
	
		return mapper.read(no);
	}

	@Override
	public boolean modify(TodoVO todoVO) {
		log.info("------modify-----");		
		
		return mapper.update(todoVO) == 1;
	}

	@Override
	public boolean remove(Long no) {
		log.info("-----remove-----");
		
		return mapper.delete(no) == 1;
	}

	@Override
	public List<TodoVO> getList(Criteria cri) {
		log.info("********* get list with Criteria =>" +cri);
		
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		log.info("get total count **********");
		return mapper.getTotalCount(cri);
	}

//	@Override
//	public List<BoardVO> getList() {
//		log.info("-----getList-----");
//		
//		mapper.getList();
//		return mapper.getList();
//	}
	
	

}
