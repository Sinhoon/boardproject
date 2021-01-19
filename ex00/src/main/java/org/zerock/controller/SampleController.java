package org.zerock.controller;

import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	@RequestMapping("")
	public void basic() {
		log.info("basic .. ");
	}

	@RequestMapping(value = "/basic", method = { RequestMethod.GET, RequestMethod.POST })
	public void basicGet() {
		log.info("basic get...");
	}

	@GetMapping("/basicGet")
	public void basicOnlyGet() {
		log.info("basicget get...");
	}

	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		log.info("" + dto);
		return "ex01";
	}

	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		log.info("name" + name);
		log.info("age" + age);
		return "ex02";
	}

	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		// String[] ids => log.info("ids" + Arrays.toSting(ids));
		log.info(ids);
		return "ex02List";
	}

	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info(list);
		return "ex02Bean";
	}

	/*
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	*/
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info(todo);
		return "ex03";
	}
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto , @ModelAttribute("page") int page) {
		log.info(dto);
		log.info(page);
		return "sample/ex04";
	}
	
	@RequestMapping("/ex004")
	public String ex004(RedirectAttributes rttr) {
		rttr.addFlashAttribute("page",44);
		rttr.addFlashAttribute("sampleDTO",new SampleDTO());
		return "redirect:/sample/ex04";
	}
	
	
	@GetMapping("/ex06")
	public @ResponseBody SampleDTO ex06() {
		SampleDTO dto = new SampleDTO();
		dto.setAge(14);
		dto.setName("sinun");
		return dto;
	}
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07() {
		log.info("/ex07");
		// {"name": "홍길동"}
		String msg="{\"name\":\"홍길동\"}";
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	

}
