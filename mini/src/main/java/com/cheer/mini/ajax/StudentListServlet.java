package com.cheer.mini.ajax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheer.mini.Student;
import com.cheer.mini.ajax.bean.MiniPackage;
import com.cheer.mini.ajax.bean.Pageinfo;
import com.cheer.mini.ajax.bean.StrudentView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentListServlet extends AjaxServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6073988565246098334L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String pageNo = req.getParameter("pageNo");
		final String pageSize = req.getParameter("pageSize");

		log.debug("Varible[pageNo]->" + pageNo);
		log.debug("Varible[pageSize]->" + pageSize);

		List<Student> store = new ArrayList<Student>();
		
		{
			Student student=new Student();
			student.setId("1");
			student.setName("张三");
			student.setAge(27);
			student.setHeigth(176);
			student.setWeight(80);
			store.add(student);	
		}
		
		{
			Student student = new Student();
			student.setId("2");
			student.setName("李四");
			student.setAge(22);
			student.setHeigth(165);
			student.setWeight(55);
			store.add(student);
		}
		
		{
			Student student = new Student();
			student.setId("3");
			student.setName("王五");
			student.setAge(22);
			student.setHeigth(165);
			student.setWeight(55);
			store.add(student);
		}
		
		
		{
			Student student = new Student();
			student.setId("4");
			student.setName("赵六");
			student.setAge(22);
			student.setHeigth(165);
			student.setWeight(55);
			store.add(student);
		}
		
		{
			Student student = new Student();
			student.setId("5");
			student.setName("田七");
			student.setAge(22);
			student.setHeigth(165);
			student.setWeight(55);
			store.add(student);
		}
	

		Pageinfo pageinfo = new Pageinfo();
		pageinfo.setPageNo(Integer.parseInt(pageNo));
		pageinfo.setPageSize(Integer.parseInt(pageSize));

		pageinfo.setTotal(100);
		pageinfo.setCount(
				pageinfo.getTotal() % pageinfo.getPageSize() == 0 ? pageinfo.getTotal() / pageinfo.getPageSize()
						: pageinfo.getTotal() / pageinfo.getPageSize() + 1);

		StrudentView view = new StrudentView();

		view.setPageinfo(pageinfo);
		view.setRecords(store);
		MiniPackage miniPackage = new MiniPackage();
		miniPackage.setData(view);
		log.debug("Varible [miniPackage] -> " + miniPackage);
		ObjectMapper mapper = new ObjectMapper();
		
		
		String json = null;
		try {
			json = mapper.writeValueAsString(miniPackage);
		} catch (JsonProcessingException e) {
			
		}
		log.debug("Varible [json] -> " + json);
		resp.setContentType("applcation/json");
		resp.getWriter().print(json);
		resp.getWriter().flush();

		

	}
}