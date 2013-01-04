package org.springframework.samples.jpetstore.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.jpetstore.dao.AccountDao;
import org.springframework.samples.jpetstore.dao.AccountValidationDao;
import org.springframework.samples.jpetstore.domain.AccountValidationBean;
import org.springframework.samples.jpetstore.enums.Sex;
import org.springframework.samples.jpetstore.validators.AccountValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Accountvalidation")
public class AccountValidationController {
	
	@Autowired
	private AccountValidationDao accountDao;
	
	@ModelAttribute("Sex")
	public Sex[] getSex()
	{
		return Sex.values();
	}
	@RequestMapping(value="/Detail",method=RequestMethod.GET)
	public ModelAndView viewAccount(@RequestParam("Id")String userName){
		AccountValidationBean account = this.accountDao.getAccount(userName);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("account", account);
		return new ModelAndView("Detail", map);
	}
	@RequestMapping(value="/Update",method=RequestMethod.POST)
	public String updateAccount(@ModelAttribute("account")@Valid AccountValidationBean account,BindingResult result){
		//new AccountValidator().validate(account, result);
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
		AccountValidationBean account = this.accountDao.getAccount(userName);
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("object", account);
		return new ModelAndView("xml_account_info", "object",account);
	}
	@InitBinder
	public void initBinder(WebDataBinder binder){
		
	}
}
