package com.keduit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keduit.domain.TodoVO;
import com.keduit.domain.Criteria;
import com.keduit.domain.PageDTO;
import com.keduit.service.TodoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/todo/*")
@RequiredArgsConstructor
public class TodoController {
	
	private final TodoService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("************* list : " + cri);
		model.addAttribute("list",service.getList(cri));
		
		int total = service.getTotalCount(cri);
		log.info("************** total : " + total);
		model.addAttribute("pageMaker",new PageDTO(cri,total));
	}
	
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(TodoVO todo,RedirectAttributes rttr) {
		log.info("--------Register------");
		service.register(todo);
		
		rttr.addFlashAttribute("result", todo.getNo());
		
		return "redirect:/todo/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("no")Long no, @ModelAttribute("cri") Criteria cri, Model model) {
		
		
		log.info("/get or /modify");
		model.addAttribute("todo", service.get(no));
	}
	
	@PostMapping("/modify")
	public String modify(TodoVO todo, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		
		log.info("----------controller modify-----" + todo);
		
		if (service.modify(todo)) {
			rttr.addFlashAttribute("result", "sucesss");
		}
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/todo/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("no") Long no, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
		
		log.info("--------controller remove----" + no);
		
		service.remove(no);
		
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		return "redirect:/todo/list";
	}
}
