package dboperation;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCreateTable
{
	private Statement	statement	= null;
	private String		sql			= null;

	public DBCreateTable(Connection connection) throws SQLException
	{
		statement = connection.createStatement();
	}

	// ����7���������ÿձ�������ݿ����Ѵ���ͬ��������ɾ���ٴ����¿ձ�
	public void initDatabase() throws SQLException
	{
		// ��ʼ�����ݿ⽫����ɾ����ֻɾ������7�ű�Ȼ�����½���Ӧ�ձ�
		sql = "drop table if exists wpindex;" + "drop table if exists vertex;  "
				+ "drop table if exists edge;"
				+ "drop table if exists evaluate;"
				+ "drop table if exists rawdata;"
				+ "drop table if exists wpidxcache;"
				+ "drop table if exists experiment;";
		statement.executeUpdate(sql);
		create_table_wpindex();
		create_table_vertex();
		create_table_edge();
		create_table_evaluate();
		create_table_rawdata();
		create_table_wpidxcache();
		create_table_experiment();
	}

	// 1ָ�����ñ�
	private void create_table_wpindex() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table wpindex("
				+ "id            char(8)         not null,"
				+ "name  varchar(256)    not null,"
				+ "expression  varchar(1024)   not null," + "primary key (id)"
				+ ");";
		statement.executeUpdate(sql);
	}

	// 2�ڵ����ñ�
	private void create_table_vertex() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table vertex (" + "evaluateid  char(8)         not null,"
				+ "id            char(8)         not null,"
				+ "name  varchar(256)    not null,"
				+ "class char(1)         not null,"
				+ "vertextype  char(1)           not null,"
				+ "wpindexid char(8)," + "nmidx char(2),"
				+ "nmidxexp      varchar(1024)," + "vertexlevel varchar(64),"
				+ "nmlvl char(2)," + "nmlvlexp      varchar(1024),"
				+ "mbsp  varchar(1024)," + "conclude      char(2),"
				+ "primary key (evaluateid,id)" + ");";
		statement.executeUpdate(sql);
	}

	// 3�����ñ�
	private void create_table_edge() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table edge (" + "evaluateid    char(8)         not null,"
				+ "child char(8)         not null,"
				+ "parent        char(8)         not null,"
				+ "weight        double(8,8)     not null,"
				+ "weighting     char(2),"
				+ "primary key (evaluateid,child,parent)" + ");";
		statement.executeUpdate(sql);
	}

	// 4�������ñ�
	private void create_table_evaluate() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table evaluate ("
				+ "id            char(8)         not null,"
				+ "name  varchar(256)    not null,"
				+ "expid char(8)         not null," + "primary key (id)" + ");";
		statement.executeUpdate(sql);
	}

	// 5ԭʼ���ݱ�
	private void create_table_rawdata() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table rawdata ("
				+ "id            char(8)         not null,"
				+ "name  char(8)         not null,"
				+ "environmentid char(8) not null,"
				+ "nodeid        char(8)         not null,"
				+ "datatype      char(1)         not null,"
				+ "value varchar(256)," + "time  char(22)        not null,"
				+ "primary key (id,environmentid,nodeid)" + ");";
		statement.executeUpdate(sql);
	}

	// 6ָ�����ݻ����
	private void create_table_wpidxcache() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table wpidxcache ("
				+ "evaluateid    char(8)         not null,"
				+ "wpindexid     char(8)         not null,"
				+ "experimentid char(8)  not null,"
				+ "datatype      char(1)         not null,"
				+ "value varchar(256),"
				+ "primary key (evaluateid,wpindexid,experimentid)" + ");";
		statement.executeUpdate(sql);
	}

	// 7������Ϣ�������ñ�
	private void create_table_experiment() throws SQLException
	{
		// TODO Auto-generated method stub
		sql = "create table experiment ("
				+ "id            char(8)         not null,"
				+ "name  varchar(256)    not null,"
				+ "wptype        char(1)         not null,"
				+ "tester        varchar(256)    not null,"
				+ "bgtime        date            not null,"
				+ "edtime        date            not null," + "primary key (id)"
				+ ");";
		statement.executeUpdate(sql);
	}
}
