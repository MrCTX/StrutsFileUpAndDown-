package com.panda.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.panda.bean.MyFile;
import com.panda.dao.FileDaoImpl;

/*
* @author MrC
* @date 2016��10��29������2:32:39
* @parameter
* @version
*/
public class ShowAllFiles extends SimpleTagSupport {

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		//���jspContext����
		JspContext context = this.getJspContext();
		List arrayList = new FileDaoImpl().getAllFilesPath();
		//���out����
		JspWriter out = context.getOut();
		out.println("<table>");
		out.println("<tr>");
		out.println("<td>�ļ���</td>");
		out.println("</tr>");
		for (int i = 0 ; i < arrayList.size() ; i++) {
			MyFile my = (MyFile) arrayList.get(i);
			out.println("<tr>");
			out.println("<td>"+"<a href=\"download?filename="+my.getFilePath()+"\"/>"+my.getFilePath()+"<td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
	
}
