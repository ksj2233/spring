package com.keduit.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SampleTxServiceTest {

	@Setter(onMethod_ = @Autowired)
	private SampleTxService service;
	
	@Test
	public void testLong() {
		String str = "INFO: 서버 엔진을 시작합니다: [Apache Tomcat/9.0.70]\r\n"
				+ "1월 18, 2023 2:20:38 오후 org.apache.catalina.core.StandardContext reload\r\n"
				+ "INFO: 이름이 [/controller]인 컨텍스트를 다시 로드하는 것을 완료했습니다.";
		log.info("글자 수는 : "+str.getBytes().length);
		
		service.addDate(str);
	}
}
