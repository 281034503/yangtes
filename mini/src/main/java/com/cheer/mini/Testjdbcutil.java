package com.cheer.mini;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.RowMapper;

public class Testjdbcutil {

	public static void main(String[] args) {
		//DataBaseUtil.execute(new jdbcUperator() {
			//public int callbanck(Statement stmt)throws SQLException{
				//String executeSql="insert into sys_student(id,name,age,height,weight)('+UUID"
		List<Student>rt=DataBaseUtil.query("select*from sys_student",new RowMapper<Student>() {
			public Student mapper(ResultSet rs)throws SQLException{
				Student student=new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
				
			}
		});
		
		
	

	}

}
