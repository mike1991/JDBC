package basic;

import java.util.*;

public abstract class Sts {	
	public Object max;
	public Object min;
	public Object sum;
	public long count;
	public double avg;
	public double var;
	public double tp; // ��ֵΪ�����ͻ����ַ����ͣ���tpΪ�������������еı���
	
	public abstract void setSts(String id) throws Exception;
	
	public abstract void setSts(List<Integer> range) throws Exception;
}