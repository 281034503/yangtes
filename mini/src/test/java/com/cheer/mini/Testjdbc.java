package com.cheer.mini;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Testjdbc {
	private static transient Log log=LogFactory.getLog(Testjdbc.class);
	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://rm-uf65vj6gv77pyiy25o.mysql.rds.aliyuncs.com:3306/guochen","guochen","12345678");
		Statement stmt=connection.createStatement();
		String insertSql="insert into sys_student(id,name,age,height,weight)values('"
		+java.util.UUID.randomUUID().toString().replaceAll("-", "")+"',"+"'����'.22,167,55)";
   log.info(insertSql);
   stmt.execute(insertSql);
   
    insertSql="insert into sys_student(id,name,age,height,weight)values('"
			+java.util.UUID.randomUUID().toString().replaceAll("-", "")+"',"+"'����'.22,167,55)";
log.info(insertSql);
stmt.execute(insertSql);

insertSql="insert into sys_student(id,name,age,height,weight)values('"
			+java.util.UUID.randomUUID().toString().replaceAll("-", "")+"',"+"'����'.22,167,55)";
log.info(insertSql);
stmt.execute(insertSql);


insertSql="insert into sys_student(id,name,age,height,weight)values('"
			+java.util.UUID.randomUUID().toString().replaceAll("-", "")+"',"+"'����'.22,167,55)";
log.info(insertSql);
stmt.execute(insertSql);




ResultSet rs=stmt.executeQuery("select*from sys_student");
while(rs.next()) {
	Student student=new Student();
	student.setId(rs.getString(1));
	student.setName(rs.getString(2));
	student.setAge(rs.getInt(3));
	student.setHeigth(rs.getInt(4));
	student.setWeight(rs.getInt(5));
	log.info(student);
	
}
rs.close();
stmt.close();
connection.close();
		
	}

}
