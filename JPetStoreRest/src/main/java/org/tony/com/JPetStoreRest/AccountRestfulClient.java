package org.tony.com.JPetStoreRest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.web.client.RestTemplate;


public class AccountRestfulClient 
{
    public Account getAccount(String userName){
    	RestTemplate template = new RestTemplate();
    	Account account = template.getForObject("http://localhost:8080/JPetStoreWebApp/Account/AccountInfo.do?Id={userName}", Account.class, userName);
    	return account;
    }
   
}
