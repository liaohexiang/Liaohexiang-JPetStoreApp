package org.springframework.samples.jpetstore.dao.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.samples.jpetstore.dao.AccountDao;
import org.springframework.samples.jpetstore.domain.Account;


public class JdbcAccountDaoImplTest extends TestCase {

	private ApplicationContext ctx;
	public void setUp(){
		this.ctx = new ClassPathXmlApplicationContext("/org/springframework/samples/jpetstore/config/application-*.xml");
	}
	public void tearDown(){
		this.ctx = null;
	}
	public void testGetAccountByName(){
		
		AccountDao accountDao = (AccountDao)ctx.getBean("accountDao");
		Account account = accountDao.getAccount("j2ee");
		Assert.assertEquals("j2ee", account.getUsername());
	}
	
	public void testGetAccountByNameAndPassword(){
		
		AccountDao accountDao = (AccountDao)ctx.getBean("accountDao");
		Account account = accountDao.getAccount("j2ee","liaohexiang");
		Assert.assertEquals("j2ee", account.getUsername());
	}
	public void testGetNamelist(){
		AccountDao accountDao = (AccountDao)ctx.getBean("accountDao");
		List list = accountDao.getUsernameList();
		Assert.assertNotNull(list);
	}
	public void testupdateAccountInList(){
		
		/*List<Account> list = new ArrayList<Account>();
		Account acct1 = new Account();
		acct1.setUsername("j2ee");
		acct1.setFirstName("123");
		acct1.setLastName("456");
		list.add(acct1);
		
		Account acct2 = new Account();
		acct1.setUsername("ACID");
		acct1.setFirstName("XYZ");
		acct1.setLastName("UVW");
		list.add(acct2);
		JdbcAccountDaoImpl accountDao = (JdbcAccountDaoImpl)ctx.getBean("accountDao");
		
		int[] updateCount = accountDao.updateAccountInList(list);
		
		Assert.assertEquals(1, updateCount.length);*/
		
		
	}
	public void testUpdateAccount(){
		AccountDao accountDao = (AccountDao)ctx.getBean("accountDao");
		Account account = new Account();
		account.setAddress1("shanghai");
		account.setAddress2("shanghai pudong");
		account.setBannerName("xxx");
		account.setBannerOption(true);
		account.setCity("shanghai");
		account.setEmail("heliao@ebay.com");
		account.setCountry("China");
		account.setFavouriteCategoryId("DOGS");
		account.setFirstName("hexiang");
		account.setLanguagePreference("Chinese");
		account.setLastName("liao");
		account.setListOption(true);
		account.setPassword("liaohexiang");
		account.setPhone("28913919");
		account.setState("pudong");
		account.setStatus("OK");
		account.setUsername("j2ee");
		account.setZip("200123");
		
		accountDao.updateAccount(account);
		System.out.print("shit");
	}
  public void testInsertAccount(){
	  /*AccountDao accountDao = (AccountDao)ctx.getBean("accountDao");
		Account account = new Account();
		account.setAddress1("shanghai");
		account.setAddress2("shanghai pudong");
		account.setBannerName("xxx");
		account.setBannerOption(true);
		account.setCity("shanghai");
		account.setEmail("heliao@ebay.com");
		account.setCountry("China");
		account.setFavouriteCategoryId("DOGS");
		account.setFirstName("tony");
		account.setLanguagePreference("Chinese");
		account.setLastName("liao");
		account.setListOption(true);
		account.setPassword("liaohexiang");
		account.setPhone("28913919");
		account.setState("pudong");
		account.setStatus("OK");
		account.setUsername("tony1");
		account.setZip("200123");
		accountDao.insertAccount(account);*/
  }
}
