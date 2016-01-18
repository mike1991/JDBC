package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean_json.BeanToJson;
import db.DBConnect;
import db.ExecuteSQL;
import url.URLtoSQL;

public class Search extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		// 1.��ȡǰ���������
		System.out.println("\n*********get search request");
		String table = request.getParameter("table");
		String data = request.getParameter("data");
		String query = request.getParameter("query");
		String begin = request.getParameter("begin");
		String count = request.getParameter("count");
		System.out.println("table=" + table + "\ndata=" + data + "\nquery="
				+ query + "\nbegin=" + begin + "\ncount=" + count);

		// 2.�Բ�������ƴ�ӳ�SQL���
		URLtoSQL urltoSQL = new URLtoSQL();
		String searchsql = urltoSQL.getSearchSQLFromURL(table, data, query,
				begin, count);

		// 3.�������ݿ�ִ�еõ����
		ExecuteSQL executeSQL = new ExecuteSQL();
		ResultSet resultSet = executeSQL.getSelectResult(searchsql);

		// 4.��SQLִ�н�����д���ӳ��Ϊjson��Ӧ��
		BeanToJson resultJson = new BeanToJson();
		String searchJson = resultJson.getSearchJson(resultSet, begin, count);
		System.out.println("searchJson=" + searchJson);

		// 5.����json��ǰ��
		try {
			DBConnect.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getOutputStream().write(searchJson.getBytes("utf-8"));
		System.out.println("response successfully");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}

}
