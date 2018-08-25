package com.app.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.bean.User;
import com.app.rowmapper.UserMapper;

@Repository
public class Repo {

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public void addNewKeyTerm(User user) {
		/*try
		{
			String sql = "INSERT INTO "+table+"(KEY_TERMS) VALUES(?)";
			res = jdbcTemplate.update(sql, keyTerm);
		} catch (EmptyResultDataAccessException e) {

			logger.error(methodName + " : EmptyResultDataAccessException  " + e);
		} catch (BadSqlGrammarException e) {
			logger.error(methodName + " : BadSqlGrammarException  " + e);
		} catch (DataAccessException e) {
			logger.error(methodName + " : DataAccessException  " + e);
		} catch (Exception e) {
			logger.error(methodName + " : Exception  " + e);
		}
		return res;*/
	}

	public User findUserByEmail(String email) {
		List<User> userList=new LinkedList<User>();
		try
		{
			String sql = "SELECT U.user_id,active,email,name,last_name,UR.role_id,R.role FROM user as U"
					+ " inner join user_role as UR on U.user_id=UR.user_id "
					+ "inner join role as R on R.role_id=UR.role_id  WHERE EMAIL=?";

			userList = jdbcTemplate.query(sql,new UserMapper(),email);

		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();

		} catch (BadSqlGrammarException e) {
			e.printStackTrace();
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(userList==null || userList.isEmpty()) {
			return null;
		}
		return userList.get(0);

	}





}
