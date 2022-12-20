package com.grang.controller;

import com.grang.dto.ResponseDto;
import com.grang.model.Reply;
import com.grang.service.BoardService;
import com.grang.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class BoardController {

	BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@Autowired
	private ReplyService replyService;

	@GetMapping(value = {"", "/"})
	public String index(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("board", boardService.글전체보기(pageable));
		model.addAttribute("replys", replyService.댓글목록());
		return "/index";
	}

	@GetMapping("/userPage/{id}")
	public String detail(Model model, @PathVariable int id, @PageableDefault Pageable pageable) {
		model.addAttribute("board", boardService.글전체보기(pageable));
		model.addAttribute("userId", id);
		return "/userPage";
	}

	@GetMapping("/boardForm")
	public String upload() {
		return "/boardForm";
	}

	@GetMapping("/updateBoardForm/{id}")
	public String findById(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.글상세보기(id));
		return "/updateBoardForm";
	}


	@GetMapping({"/index"})
	public String story(Model model) {
		model.addAttribute("replys", replyService.댓글목록());
		return "/index";
	}

	@PutMapping("/index/{id}")
	public ResponseDto<Integer>
	editreply(@PathVariable int id, @RequestBody Reply reply) {
		replyService.댓글수정(id, reply);
		return new
				ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
