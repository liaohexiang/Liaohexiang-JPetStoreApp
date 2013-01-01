package org.springframework.samples.jpetstore.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.samples.jpetstore.dao.AccountDao;
import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.samples.jpetstore.enums.Sex;
import org.springframework.samples.jpetstore.validators.AccountValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

@Controller
@RequestMapping("/Account")
public class AccountController  { 

	@Autowired
	@Qualifier("account")
	private AccountDao accountDao;
	
	
	@ModelAttribute("Sex")
	public Sex[] getSex()
	{
		return Sex.values();
	}
	@RequestMapping(value="/Detail",method=RequestMethod.GET)
	public ModelAndView viewAccount(@RequestParam("Id")String userName){
		Account account = this.accountDao.getAccount(userName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		return new ModelAndView("Detail", map);
	}
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String updateAccount(@ModelAttribute("account")Account account,BindingResult result){
		new AccountValidator().validate(account, result);
		if(result.hasErrors())
			return "Detail";
		this.accountDao.updateAccount(account);
		return "redirect:Detail.do?Id="+account.getUsername();
	}
	@RequestMapping("/ViewAll")
	public ModelAndView viewAllAccount(){
		List account = this.accountDao.getUsernameList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Accounts", account);
		return new ModelAndView("ViewAllAccount", map);
	}
	@RequestMapping(value = "/AccountInfo",method= RequestMethod.GET)
	public ModelAndView getAccount(@RequestParam("Id")String userName)
	{
		Account account = this.accountDao.getAccount(userName);
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("object", account);
		return new ModelAndView("xml_account_info", "object",account);
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
	}
}
