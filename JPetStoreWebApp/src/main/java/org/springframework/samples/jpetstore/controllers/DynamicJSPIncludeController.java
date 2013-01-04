package org.springframework.samples.jpetstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Dynamic")
public class DynamicJSPIncludeController {

	@RequestMapping("/CaseOne")
	public String getDynamicCaseOne(Model model){
		model.addAttribute("includeURL", "DynamicCaseOne.jsp");
		return "dynamicJSPinclude/DynamicJSPInclude";
	}
	@RequestMapping("/CaseTwo")
	public String getDynamicCaseTwo(Model model){
		model.addAttribute("includeURL", "DynamicCaseTwo.jsp");
		return "dynamicJSPinclude/DynamicJSPInclude";
	}
	
}
