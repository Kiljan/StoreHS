package webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControler {

	@RequestMapping("/")
	public String welcome(Model model) {
		
//		model.addAttribute("greeting", "Welcome to web strore");
//		model.addAttribute("tagline", "First paragraph ever");
		return "redirect:/products";
	}
}
