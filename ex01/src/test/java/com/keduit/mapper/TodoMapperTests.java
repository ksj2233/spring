package com.keduit.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	
   @Setter(onMethod_ = @Autowired)
   private TodoMapper mapper;
   
   @Test
   public void testGetList() {
      log.info("안됨??");
      mapper.getList().forEach(todo -> log.info("실험실" + todo));
   }
   
   @Test
   public void testPaging() {
	   Criteria cri = new Criteria();
	   cri.setPageNum(5);
	   cri.setPageNum(10);
	   List<TodoVO> list = mapper.getListWithPaging(cri);
	   list.forEach(board -> log.info(board));
   }
   
   
   
   
   
   @Test
   public void testGetTime() {
      log.info(mapper.getClass().getName());
      log.info(mapper.getTime());
   }
   
   @Test
   public void testInsert() {
	   TodoVO todo = new TodoVO();
	   todo.setTodoDate("23/01/01");
	   todo.setContent("test작성글 내용");
	   
	   mapper.insert(todo);
	   
	   log.info("--board---" + todo);
   }
   
   @Test
   public void testInsertSelectKey() {
	   TodoVO todo = new TodoVO();
	   todo.setTodoDate("23/01/01");
	   todo.setContent("새로 작성하는 글 내용 select key test");
	   
	   mapper.insertSelectKey(todo);
	   
	   log.info("--todo---" + todo);
   }
   
   @Test
   public void testRead() {
	   TodoVO board = new TodoVO();
	   board = mapper.read(10L);
	   
	   log.info(board);
   }
   
   @Test
   public void testDelete() {
	   log.info(mapper.delete(2L));
   }
   
   @Test
   public void testUpdate() {
	   TodoVO todo= new TodoVO();
	   todo.setNo(9L);
	   todo.setTodoDate("23/01/01");
	   todo.setContent("업데이트 콘텐트");
	   
	   int result = mapper.update(todo);
	   
	   log.info(todo);
	   log.info(result);
   }
   
   @Test
   public void testSearch() {
	   Criteria cri = new Criteria();
	   cri.setKeyword("3");
	   cri.setType("TC");
	   
	   List<TodoVO> list = mapper.getListWithPaging(cri);
	   list.forEach(board->log.info(board));
	   
   }
   
   
}