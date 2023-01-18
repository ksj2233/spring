package com.keduit.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		, "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class TodoControllerTests {
	
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception{
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testListPaging() throws Exception{
		log.info(mockMvc.perform(
				MockMvcRequestBuilders.get("/borad/list")
				.param("pageNum", "5")
				.param("amount", "10"))
				.andReturn().getModelAndView().getModelMap()
				);
	}
	
	@Test
	public void testRegister() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "컨트롤 테스트")
				.param("content", "controll test 내용")
				.param("writer", "컨트롤 쓰기"))
				.andReturn().getModelAndView().getViewName();
		
		log.info("------resultPage ====> " + resultPage);
	}
	

	@Test
	public void testGet() throws Exception{
		log.info("-----------testGet------------");
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
				.param("bno", "20"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
	
	@Test
	public void testModify() throws Exception{
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "87")
				.param("title", "모디파이 타이틀")
				.param("content", "모디파이 컨텐트")
				.param("writer", "모디파이 라이터"))
				.andReturn().getModelAndView().getViewName();
		
		log.info("resultPage------------" + resultPage);
	}
	
	@Test
	public void testRemove() throws Exception{
		log.info("-------testRemove-------");
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "17"))
				.andReturn()
				.getModelAndView()
				.getModelMap());
	}
}
