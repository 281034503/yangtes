<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="org.apache.commons.logging.Log"%>
<%@ page import="org.apache.commons.logging.LogFactory"%>
<%@ page import="com.cheer.mini.util.DataBaseUtil"%>
<%@ page import="com.cheer.mini.util.JdbcOperator"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.UUID"%>

<%
final Log log=LogFactory.getLog(getClass());
final String name=request.getParameter("name");
final String age=request.getParameter("age");
final String height=request.getParameter("height");
final String weight=request.getParameter("weight");




log.debug("Variblr[name]->"+name);
log.debug("Variblr[age]->"+age);
log.debug("Variblr[height]->"+height);
log.debug("Variblr[weight]->"+weight);

DataBaseUtil.execute(new JdbcOperator(){
	
	@Override
	public int callback(Statement stmt)throws SQLException{
		String executeSql="insert into sys_student(id,name,age,height,weight)values" +
		"('"+UUID.randomUUID().toString().replaceAll("-","")+"','"+
		name+"',"+
		age+","+
		height+","+
		weight+")";
		log.debug("execute sql->"+executeSql);
		stmt.execute(executeSql);
		return 0;
	}
});


response.sendRedirect(request.getContextPath()+"/student/list.jsp");
%>