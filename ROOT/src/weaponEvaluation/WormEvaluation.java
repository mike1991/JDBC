package weaponEvaluation;

public class WormEvaluation {
	//��������������ݣ������������������Լ����������ݣ�����ӵ������붨��Ϊpublic
	public int id;
	public String name = new String();
	public String weaponType = new String();
	public String weaponName = new String();
	public String tester = new String();
	public String time = new String();
	
	
	//�����������
	public long timeOfSaturation;	//�ﵽ��������ʱ��
	public long timeOfPeak;		//�ﵽ��ֵ����ʱ��
	public long sumOfNumber;	//�����н������
	public long infectedNumberOfSaturation;		//�ﵽ����ʱ�ܸ�Ⱦ�Ľ����
	public long infectedNumberOfPeak;		//�ܸ�Ⱦ������ķ�ֵ
	public long timeStep;	//ʱ����
	public long maxOfNewInfectedNumber;		//��ʱ��������������Ⱦ�������ֵ
	public long sumOfTraffic;		//��ͨ����
	public long infectedTraffic;	//��������ͨ����
	
	
	//��Ҫ����õ�������
	public double _scoreOfSaturationTime;		//�������ﵽ����ʱ�������
	public double _prevalenceOfInfectionAtSaturation;		//�ﵽ����ʱ�ܸ�Ⱦ��������н���еı���
	public double _prevalenceOfInfectionAtPeak;	//�ﵽ��ֵʱ�ܸ�Ⱦ��������н���еı���
	public double meanSpeedOfInfection;		//��洫Ⱦ��ƽ������
	public double maxSpeedOfInfection;	//��洫Ⱦ���������
	public double _scoreOfMeanSpeed;		//ƽ����Ⱦ��������
	public double _scoreOfMaxSpeed;		//���Ⱦ��������
	public double _prevalenceOfInfectedTraffic;	//���ͨ����ռ��ͨ�����ı���
	
	
	
	/**�˴�Ϊ��������������ֵΪ�գ���ֱ�ӽ���������ֵ���������*/
	public void wormEvaluation(){
		_scoreOfSaturationTime = 
				1 - Math.atan((double)timeOfSaturation/30) * 2 / Math.PI;
		
		_prevalenceOfInfectionAtSaturation = 
				(double)infectedNumberOfSaturation / (double)sumOfNumber;
		
		_prevalenceOfInfectionAtPeak = 
				(double)infectedNumberOfPeak / (double)sumOfNumber;
		
		meanSpeedOfInfection = 
				(double)infectedNumberOfSaturation / (double)timeOfSaturation;
		
		_scoreOfMeanSpeed = 
				Math.atan((double)meanSpeedOfInfection) * 2 / Math.PI;
		
		maxSpeedOfInfection = 
				(double)maxOfNewInfectedNumber / (double)timeStep;
		
		_scoreOfMaxSpeed = 
				Math.atan((double)maxSpeedOfInfection) * 2 / Math.PI;
		
		_prevalenceOfInfectedTraffic = 
				(double)infectedTraffic / (double)sumOfTraffic;
		
	}

}
