package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
public class GuestBookController {

	@Autowired
	private GuestbookVo gService;

	// 게시판폼
	@RequestMapping(value = "/guestbook/addList", method = { RequestMethod.GET, RequestMethod.POST })
	public String addList(Model model) {
		System.out.println("GuestController >> addList()");

		List<GuestbookVo> guestList;
		try {
			guestList = GuestbookService.getGuestList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("guestList", guestList);

		return "guestbook/addList";
	}

	@RequestMapping(value = "/add", method = { RequestMethod.GET, RequestMethod.POST })
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("Controller > add");
		// Service를 통해서 저장한다
		int count = gService.insert(guestbookVo);
		return "redirect:/addList";

	}

	@RequestMapping(value = "/deleteForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String deleteForm() {
		System.out.println("Controller>deleteForm()");
		return "guestbook/deleteForm";
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam("no") int no, @RequestParam("password") String password) {
		System.out.println("Controller>delete()");
		// vo로 묶기
		GuestbookVo guestbookVo = new GuestbookVo(no, password);
		System.out.println(guestbookVo);
		// Service를 통해서 삭제한다
		GuestbookService.delete(guestbookVo);
		return "redirect:/addList";
	}

}