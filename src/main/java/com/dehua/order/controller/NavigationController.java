package com.dehua.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value={"/", "upload/ali_order"}, method=RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("upload/ali_order");
	}
	
}
