package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import url_db.DBConnect;
import url_db.ExecuteSQL;
import url_db.URLtoSQL;
import bean_json.BeanToJson;

public class Insert extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 1.��ȡǰ���������
		System.out.println("\n*********get insert request");
		String table = request.getParameter("table");
		String data = request.getParameter("data");
		System.out.println("table=" + table + "\ndata=" + data);

		// 2.�Բ�������ƴ�ӳ�SQL���
		URLtoSQL urltoSQL = new URLtoSQL();
		String insertsql = urltoSQL.getInsertSQLFromURL(table, data);

		// 3.�������ݿ�ִ�еõ����
		ExecuteSQL executeSQL = new ExecuteSQL();
		int result = executeSQL.getInsertResult(insertsql);

		// 4.��SQLִ�н�����д���ӳ��Ϊjson��Ӧ��
		BeanToJson resultJson = new BeanToJson();
		String insertJson = resultJson.getInsertJson(result);
		System.out.println("insertJson=" + insertJson);

		// 5.����json��ǰ��
		response.getOutputStream().write(insertJson.getBytes("utf-8"));
		System.out.println("response successfully");

	}

}