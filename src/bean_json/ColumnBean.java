package bean_json;

public class ColumnBean
{
	public String	id;			// ���ݿ���������Ӣ�ģ�
	public String	name;			// ����˵��
	public boolean	isShow;
	public boolean	isPrimaryKey;	// �����Ƿ�Ϊ����
	public int		type;			// �е���������0-string,1-long,2-double,3-boolean,4-Date
	public boolean	isSelect;		// �Ƿ���Ϊ�ɱ���ѯ����
	public int		selectType;	// ��ѯ���ͣ�0-=,1-like,2-<,3->,4-<=,5->=
	public int		candidate;		// �˴�Ϊ1ʱ��Ҫ����ΪK|V
}
