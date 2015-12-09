package WeaponEvaluation;

import java.lang.Math;

public class TrojanEvaluation {
	//��������������ݣ������������������Լ����������ݣ�����ӵ������붨��Ϊpublic
	public int ʵ����;
	public String �������� = new String();
	public String �������� = new String();
	public String �������� = new String();
	public String ������ = new String();
	public String ����ʱ�� = new String();
	
	public int �ڵ���Ŀ;
	public int ����ȡ�ļ��Ľڵ���Ŀ;
    public int �������ļ��Ľڵ���Ŀ;
    public int ���޸��ļ��Ľڵ���Ŀ;
    public int �ɽ������ݵĽڵ���Ŀ;
    public int �ɷ������ݵĽڵ���Ŀ;
    public boolean �Ƿ����쳣����������Ϊ; 
    public boolean �Ƿ����쳣ִ���ļ�����;
    public boolean �Ƿ����쳣DLLע����Ϊ;
    public boolean �Ƿ����쳣DLL�ļ�����;
    public boolean �Ƿ������û�ģʽ�µ��쳣�½���������Ϊ;
    public boolean �Ƿ������û�ģʽ�µ��쳣���������;
    public boolean �Ƿ������ں�ģʽ�µ��쳣�½���������Ϊ;
    public boolean �Ƿ������ں�ģʽ�µ��쳣���������;
    public boolean �Ƿ����쳣�½�������Ϊ;
    public boolean �Ƿ����쳣�������;
    public boolean �Ƿ�����Ȩ��Ϊ����;
    public boolean �Ƿ���ԽȨ��Ϊ����;
    public int ��Ϊ��������Ŀ;
    public double ��Ϊ�����ܺ�ʱ;
    public double ���ƽ����Ϊ�����ܺ�ʱ;
    public double ��Сƽ����Ϊ�����ܺ�ʱ;
    
    public double _��Ⱦ���÷�;
    public double _�������÷�;
    public double _��Ϊ��ȵ÷�;
    public double _��ΪЧ�ʵ÷�;
	public double �ܷ�;
	
	/**�˴�Ϊ��������������ֵΪ�գ���ֱ�ӽ���������ֵ���������*/
	public void trojanEvaluation(){
        double rtOfFilePullable = (double)����ȡ�ļ��Ľڵ���Ŀ / �ڵ���Ŀ;
        double rtOfFilePushable = (double)�������ļ��Ľڵ���Ŀ / �ڵ���Ŀ;
        double rtOfFileModifiable = (double)���޸��ļ��Ľڵ���Ŀ / �ڵ���Ŀ;
        double rtOfDataReceivable = (double)�ɽ������ݵĽڵ���Ŀ / �ڵ���Ŀ;
        double rtOfDataSendable = (double)�ɷ������ݵĽڵ���Ŀ / �ڵ���Ŀ;
        _��Ⱦ���÷� = 0.5 * (0.25 * rtOfFilePullable + 0.25 * rtOfFilePushable + 0.5 * rtOfFileModifiable) + 0.5 * (0.5 * rtOfDataReceivable + 0.5 * rtOfDataSendable);
        double scOfExecutiveHiddenness;
        if (�Ƿ����쳣ִ���ļ�����){
            scOfExecutiveHiddenness = 0.0;
            }
        else if (�Ƿ����쳣����������Ϊ){
            scOfExecutiveHiddenness = 0.25;
            }
        else if (�Ƿ����쳣DLL�ļ�����){
            scOfExecutiveHiddenness = 0.5;
            }
        else if (�Ƿ����쳣DLLע����Ϊ){
            scOfExecutiveHiddenness = 0.75;
            }
        else{
            scOfExecutiveHiddenness = 1.0;
            }
        double scOfStartupHiddenness;
        if (�Ƿ������û�ģʽ�µ��쳣���������){
            scOfStartupHiddenness = 0.0;
            }
        else if (�Ƿ������û�ģʽ�µ��쳣�½���������Ϊ){
            scOfStartupHiddenness = 0.25;
            }
        else if (�Ƿ������ں�ģʽ�µ��쳣���������){
            scOfStartupHiddenness = 0.5;
            }
        else if (�Ƿ������ں�ģʽ�µ��쳣�½���������Ϊ){
            scOfStartupHiddenness = 0.75;
            }
        else{
            scOfStartupHiddenness = 1.0;
            }
        double scOfServiceHiddenness;
        if (�Ƿ����쳣�������){
            scOfServiceHiddenness = 0.0;
            }
        else if (�Ƿ����쳣�½�������Ϊ){
            scOfServiceHiddenness = 0.5;
            }
        else{
            scOfServiceHiddenness = 1.0;
            }
        _�������÷� = 0.75 * scOfExecutiveHiddenness + 0.25 * Math.min(scOfStartupHiddenness, scOfServiceHiddenness);
        _��Ϊ��ȵ÷� = 0.0;
        if (�Ƿ�����Ȩ��Ϊ����){
            _��Ϊ��ȵ÷� += 0.5;
            }
        if (�Ƿ���ԽȨ��Ϊ����){
            _��Ϊ��ȵ÷� += 0.5;
            }
        double avgTmOfBehaviorAccomplished = ��Ϊ�����ܺ�ʱ / ��Ϊ��������Ŀ;
        double nmlAvgTmOfBehaviorAccomplished = (avgTmOfBehaviorAccomplished - ��Сƽ����Ϊ�����ܺ�ʱ) / (���ƽ����Ϊ�����ܺ�ʱ - ��Сƽ����Ϊ�����ܺ�ʱ);
        _��ΪЧ�ʵ÷� = 1 - nmlAvgTmOfBehaviorAccomplished;
        �ܷ� = 0.3 * _��Ⱦ���÷� + 0.6 * _�������÷� + 0.05 * _��Ϊ��ȵ÷� + 0.05 * _��ΪЧ�ʵ÷�;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}
