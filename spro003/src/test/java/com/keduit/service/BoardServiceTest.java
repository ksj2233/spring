package com.keduit.service;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(50);
		boardVO.setTitle("서비스 타이틀");
		boardVO.setContent("서비스 콘텐트");
		boardVO.setWriter("서비스 라이트");
		service.register(boardVO);
		log.info(boardVO);
		log.info(boardVO.getBno());
	}
	
	@Test
	public void testGetList() {
//	    service.getList().forEach(boardVO -> log.info("실험실" + boardVO));
		service.getList(new Criteria(5,10)).forEach(board -> log.info(board));;
	}
	
	@Test
	public void testGet() {
		log.info(service.get(10L));
	}
	
	@Test
	public void testUpdate() {
		//BoardVO boardVO = service.get(23L);
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(11);
		boardVO.setTitle("업데이트 타이틀");
		boardVO.setContent("업데이트 콘텐트");
		boardVO.setWriter("업데이트 라이트");
	
		log.info(service.modify(boardVO));
	}
	
	@Test
	public void testDelete() {
		log.info(service.remove(10L));
	}
	
}
