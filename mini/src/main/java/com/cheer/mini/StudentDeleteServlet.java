package com.cheer.mini;

import java.beans.Statement;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.cheer.mini.util.DataBaseUtil;
import com.cheer.mini.util.JdbcOperator;
public class StudentDeleteServlet extends HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6151344718938329827L;
	private transient Log log=LogFactory.getLog(getClass());
	
	public void init(ServletConfig config) {
		log.debug("delete Servlet init");
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
		 final String id=req.getParameter("id");
		 
		 DataBaseUtil.execute(new JdbcOperator() {
			 

			@Override
			public int callback(java.sql.Statement stmt) throws SQLException {
				String executeSql="delete from sys_student where id='"+id+"'";
				 log.debug("execute SQL:"+executeSql);
				 stmt.execute(executeSql);
				return 0;
			}
			 
		 });
		 resp.sendRedirect(req.getContextPath()+"/student/list");
	}

}
