package org.springframework.samples.jpetstore.dao.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.samples.jpetstore.dao.AccountDao;
import org.springframework.samples.jpetstore.domain.Account;
import org.springframework.stereotype.Component;


public class JdbcAccountDaoImpl extends NamedParameterJdbcDaoSupport implements AccountDao {

	
	public Account getAccount(String username) throws DataAccessException {
		String sqlStr = "select signon.username as username,signon.password as password,account.email," +
		"account.firstName,account.lastName," +
		"account.status,account.addr1 as address1,account.addr2 as address2," +
		"account.city,account.state,account.zip,account.country," +
		"account.phone,profile.langpref as languagePreference,profile.favcategory as favouriteCategoryId," +
		"profile.mylistopt as listOption,profile.banneropt as bannerOption,bannerdata.bannerName"+
		" from account, profile, signon, bannerdata"+
		" where account.userid = ? "+
		" and signon.username = account.userid"+
		" and profile.userid = account.userid"+
		" and profile.favcategory = bannerdata.favcategory";
		Account acct = (Account) this.getJdbcTemplate().queryForObject(sqlStr, new String[]{username},ParameterizedBeanPropertyRowMapper.newInstance(Account.class));
		return acct;
	}

	
	public Account getAccount(String username, String password)
			throws DataAccessException {
		String sqlStr = "select signon.username as username,signon.password as password,account.email," +
		"account.firstName,account.lastName," +
		"account.status,account.addr1 as address1,account.addr2 as address2," +
		"account.city,account.state,account.zip,account.country," +
		"account.phone,profile.langpref as languagePreference,profile.favcategory as favouriteCategoryId," +
		"profile.mylistopt as listOption,profile.banneropt as bannerOption,bannerdata.bannerName"+
		" from account, profile, signon, bannerdata" +
		" where account.userid = :username " +
	    " and signon.password = :password " +
	    " and signon.username = account.userid "+
	    " and profile.userid = account.userid "+
	    " and profile.favcategory = bannerdata.favcategory";
		Map<String,String> paramMap = new HashMap<String, String>();
		paramMap.put("username", username);
		paramMap.put("password", password);
		Account acct = (Account)this.getNamedParameterJdbcTemplate().queryForObject(sqlStr, paramMap, ParameterizedBeanPropertyRowMapper.newInstance(Account.class));
		return acct;
	}

	
	public void insertAccount(Account account) throws DataAccessException {
		String sqlStr = " insert into account (email, firstname, lastname, status, addr1, addr2, city, state, zip, country, phone, userid) values (:email, :firstName, :lastName, :status, :address1, :address2, :city, :state, :zip, :country, :phone, :username)";
		this.getNamedParameterJdbcTemplate().update(sqlStr, new BeanPropertySqlParameterSource(account));
	}

	public void updateAccount(Account account) throws DataAccessException {
		String sqlStr = "update account set email = :email, firstname = :firstName, lastname = :lastName, status = :status, addr1 = :address1, addr2 = :address2, city = :city, state = :state, zip = :zip, country = :country, phone = :phone where userid = :username";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(account);
		this.getNamedParameterJdbcTemplate().update(sqlStr, paramSource);
		
		this.updateProfile(account);
		if (account.getPassword() != null && account.getPassword().length() > 0) {
			this.updateSignon(account);
		}
	}
	public void updateProfile(Account account)
	{
		String sqlStr = "update profile set langpref = :languagePreference, favcategory = :favouriteCategoryId, mylistopt = :listOptionAsInt, banneropt = :bannerOptionAsInt where userid = :username";
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(account);
		this.getNamedParameterJdbcTemplate().update(sqlStr, paramSource);
	}
	public void updateSignon(Account account){
		String sqlStr = "update signon set password = :password where username = :username";
		this.getNamedParameterJdbcTemplate().update(sqlStr, new BeanPropertySqlParameterSource(account));
	}
	public int[] updateAccountInList(final List<Account> list){
		String sqlStr ="update account set firstname=?, lastname=? where userid=?";
		return this.getJdbcTemplate().batchUpdate(sqlStr, new BatchPreparedStatementSetter() {
			
			
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setString(1, ((Account)list.get(i)).getFirstName());
				ps.setString(2, ((Account)list.get(i)).getLastName());
				ps.setString(3, ((Account)list.get(i)).getUsername());
			}
			
			
			public int getBatchSize() {
				return list.size();
			}
		});
	}

	
	public List getUsernameList() throws DataAccessException {
		String sqlStr = "select firstname as firstName,lastname as lastName,userid as username from account";
		return this.getJdbcTemplate().query(sqlStr, new BeanPropertyRowMapper(Account.class));
	}

}
