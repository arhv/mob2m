package com.mob2m.initial;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = null;

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", this.message);
		return "index";
	}

	@RequestMapping("/test")
	public String welcome1(Map<String, Object> model) {
		model.put("message1", "Come back later here to get brilliant ideas");
		return "secondPage";
	}
}
