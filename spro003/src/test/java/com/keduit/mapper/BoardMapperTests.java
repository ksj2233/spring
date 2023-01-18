package com.keduit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.BoardVO;
import com.keduit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
   @Setter(onMethod_ = @Autowired)
   private BoardMapper mapper;
   
   @Test
   public void testGetList() {
      log.info("안됨??");
      mapper.getList().forEach(board -> log.info("실험실" + board));
   }
   
   @Test
   public void testPaging() {
	   Criteria cri = new Criteria();
	   cri.setPageNum(5);
	   cri.setPageNum(10);
	   List<BoardVO> list = mapper.getListWithPaging(cri);
	   list.forEach(board -> log.info(board));
   }
   
   
   
   
   
   @Test
   public void testGetTime() {
      log.info(mapper.getClass().getName());
      log.info(mapper.getTime());
   }
   
   @Test
   public void testInsert() {
	   BoardVO board = new BoardVO();
	   board.setTitle("test작성 글");
	   board.setContent("test작성글 내용");
	   board.setWriter("user09");
	   
	   mapper.insert(board);
	   
	   log.info("--board---" + board);
   }
   
   @Test
   public void testInsertSelectKey() {
	   BoardVO board = new BoardVO();
	   board.setTitle("새로 작성하는 글 select key test");
	   board.setContent("새로 작성하는 글 내용 select key test");
	   board.setWriter("user99");
	   
	   mapper.insertSelectKey(board);
	   
	   log.info("--board---" + board);
   }
   
   @Test
   public void testRead() {
	   BoardVO board = new BoardVO();
	   board = mapper.read(10L);
	   
	   log.info(board);
   }
   
   @Test
   public void testDelete() {
	   log.info(mapper.delete(2L));
   }
   
   @Test
   public void testUpdate() {
	   BoardVO board= new BoardVO();
	   board.setBno(9L);
	   board.setTitle("업데이트");
	   board.setContent("업데이트 콘텐트");
	   board.setWriter("업데이트 라이터");
	   
	   int result = mapper.update(board);
	   
	   log.info(board);
	   log.info(result);
   }
   
   @Test
   public void testSearch() {
	   Criteria cri = new Criteria();
	   cri.setKeyword("3");
	   cri.setType("TC");
	   
	   List<BoardVO> list = mapper.getListWithPaging(cri);
	   list.forEach(board->log.info(board));
	   
   }
   
   
}