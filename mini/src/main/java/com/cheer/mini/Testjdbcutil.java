package com.cheer.mini;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.RowMapper;

public class Testjdbcutil {
	private static transient Log log = LogFactory.getLog(Testjdbcutil.class);

	public static void main(String[] args) {
		int count=DataBaseUtil.getCount("select * from sys_student");
		log.info("Varible[count]->"+count);
		
		
		List<Student> rt = DataBaseUtil.pageQuery("select * from sys_student" ,1,3, new RowMapper<Student>(){
			@Override
			public Student mapper(ResultSet rs) throws SQLException{
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
			}
		});
		log.info ("Varible [rt] -> " + rt);
		
		rt = DataBaseUtil.pageQuery("select * from sys_student" ,2,3, new RowMapper<Student>(){
			@Override
			public Student mapper(ResultSet rs) throws SQLException{
				Student student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setHeigth(rs.getInt(4));
				student.setWeight(rs.getInt(5));
				return student;
			}
		});
		log.info ("Varible [rt] -> " + rt);
		
		/*DataBaseUtil.execute(new jdbcUperator() {
			public int callbanck(Statement stmt)throws SQLException{
				String executeSql="insert into sys_student(id,name,age,height,weight)('+UUID"
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
		});*/
		
		
	

	}

}

class Area{
	private String areaName;
	private String areaFullName;
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaFullName() {
		return areaFullName;
	}
	public void setAreaFullName(String areaFullName) {
		this.areaFullName = areaFullName;
	}
	@Override
	public String toString() {
		return "Area [areaName=" + areaName + ", areaFullName=" + areaFullName + "]";
	}
	
}

