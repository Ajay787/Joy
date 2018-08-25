package com.app.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.app.bean.User;


public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User  user = new User();
		//user_id, active, email, name, last_name, role_id, role
		user.setUserId(rs.getInt("user_id"));
		user.setActive(rs.getInt("active"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setLastName(rs.getString("last_name"));
		user.setRoleId(rs.getInt("role_id"));
		user.setRole(rs.getString("role"));
		//user.set
		
		
		return user;
	}

}
