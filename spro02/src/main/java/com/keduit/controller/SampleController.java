package com.keduit.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.keduit.domain.SampleDTO;
import com.keduit.domain.SampleDTOList;
import com.keduit.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*") // sample 다음 경로로 들어오는 모든것 처리
@Log4j
public class SampleController {

	@RequestMapping("") // sample/aa 경로로 들어왔을 경우 처리
	public void basic() {
		log.info("****basic****");
	}

//	RequestMethod.GET,RequestMethod.POST
	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get***********");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("*****dto*****" + dto);
		return "ex0111111111";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name : " + name);
		log.info("age : " + age);

		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}

	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam("ids") String[] ids) {
		log.info("array ids : " + Arrays.toString(ids));
		return "ex02Array";
	}
	
	// 객체를 배열로 전달
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("**** list dtos : " + list);
		return "ex02Bean";
	}
	// ?list%5B0%5D.name=hong&list%5B0%5D.age=25&list%5B1%5D.name=kim
	

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
//	}

	@GetMapping("/ex03")
	public String ex03(TodoDTO todoDTO) {
		log.info("***todo***" + todoDTO);
		return "ex03";
	}
	// localhost:8090/sample/ex03?title=kim&dueDate=2023/01/05

	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {
		log.info("dto : " + dto);
		log.info("page : " + page);
		return "/sample/ex04";
	}
	// http://localhost:8090/sample/ex04?name=hong&age=25&page=10
	// page를 불러오는
	
	@GetMapping("/rel")
	public String rel() {
		log.info("***rel***");
		return "redirect:/sample/ex03";
	}
	
	@GetMapping("/re2")
	public void re2() {
		log.info("****re2****");
	}
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		log.info("/ex06 *******");
		SampleDTO dto = new SampleDTO();
		dto.setAge(10);
		dto.setName("김성진");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		log.info("/ex07 ****");
		String msg="{\'name\'  :  \'홍길동\'}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header,HttpStatus.OK);
	}
	// 값이 보임
	
	@GetMapping("/exUpload")
	public void exUpload() {
		log.info("******/exUpload******");
		
	}
	
	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {log.info("*************************");
									log.info("name : " + file.getOriginalFilename());
									log.info("size : " + file.getSize());
									log.info("contentType : " + file.getContentType());
		});
	
	}
	
}
