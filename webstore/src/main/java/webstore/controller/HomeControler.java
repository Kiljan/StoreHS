package webstore.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControler {

	@RequestMapping("/")
	public String welcome(Model model, Principal principal) {

		if (principal.getName().equals("admin")) {
			return "redirect:/products/add";
		} else {
			return "redirect:/products";
		}
	}
}
