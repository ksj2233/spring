package com.keduit.controller;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.keduit.domain.Criteria;
import com.keduit.domain.ReplyVO;
import com.keduit.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class ReplyMapperTest {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	private Long[] bnoArr = {147455L, 147454L, 147453L, 147452L, 147451L};
	
	@Test
	public void testMapper() {
		log.info("***mapper***"+mapper);
	}
	
	@Test
	public void testCreate() {
		
		IntStream.rangeClosed(1,10).forEach( i ->{
		
			ReplyVO vo = new ReplyVO();
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글테스트 " + i);
			vo.setReplyer("replyer"+i);
			
			mapper.insert(vo);
			
		});
	}
	
	@Test
	public void testSelect() {
		
		Long targetRno = 9L;
		
		ReplyVO vo = mapper.read(targetRno);
		
		log.info(vo);
	}
	
	
	@Test
	public void testDelete() {
		int result = mapper.delete(2L);
		log.info("*********** delete => " + result);
		
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = mapper.read(10L);
		vo.setReply("수정했지롱");
		int result = mapper.update(vo);
		log.info("********* update count => " + result);
	}
	
	@Test
	public void testList() {
		Criteria cri = new Criteria();
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[3]);
		log.info("**** testList ****" + replies);
		log.info(cri);
		
	}
	
	@Test
	public void testList2() {
		Criteria cri = new Criteria(2, 10);
		List<ReplyVO> replies = mapper.getListWithPaging(cri, 147455L);
		replies.forEach(reply -> log.info(reply));
	}
}
