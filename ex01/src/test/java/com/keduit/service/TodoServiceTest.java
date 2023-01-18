package com.keduit.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoServiceTest {
	
	@Autowired
	private TodoService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		TodoVO TodoVO = new TodoVO();
		TodoVO.setNo(50);
		TodoVO.setTodoDate("23/01/01");
		TodoVO.setContent("서비스 콘텐트");
		service.register(TodoVO);
		log.info(TodoVO);
		log.info(TodoVO.getNo());
	}
	
	@Test
	public void testGetList() {
//	    service.getList().forEach(boardVO -> log.info("실험실" + boardVO));
		service.getList(new Criteria(5,10)).forEach(todo -> log.info(todo));;
	}
	
	@Test
	public void testGet() {
		log.info(service.get(10L));
	}
	
	@Test
	public void testUpdate() {
		//BoardVO boardVO = service.get(23L);
		TodoVO todoVO = new TodoVO();
		todoVO.setNo(11);
		todoVO.setTodoDate("23/01/01");
		todoVO.setContent("업데이트 콘텐트");
	
		log.info(service.modify(todoVO));
	}
	
	@Test
	public void testDelete() {
		log.info(service.remove(10L));
	}
	
}
