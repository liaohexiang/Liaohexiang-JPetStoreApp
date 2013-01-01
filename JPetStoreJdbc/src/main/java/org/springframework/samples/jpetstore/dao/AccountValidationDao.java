package org.springframework.samples.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.samples.jpetstore.domain.AccountValidationBean;

public interface AccountValidationDao {

  AccountValidationBean getAccount(String username) throws DataAccessException;

  AccountValidationBean getAccount(String username, String password) throws DataAccessException;

  void insertAccount(AccountValidationBean account) throws DataAccessException;

  void updateAccount(AccountValidationBean account) throws DataAccessException;

	List getUsernameList() throws DataAccessException;

}
