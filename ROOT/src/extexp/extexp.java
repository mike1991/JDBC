package extexp;

import java.util.*;
import org.wltea.expression.*;
import org.wltea.expression.datameta.Variable;

public class extexp {
	public static void main(String[] args){
		if(args.length == 0){
		args = new String[1];
		args[0] = "IK Expression";
		}
		//������ʽ
		String expression = "\"Hello World \" + �û���";
		//�����ʽ�еı������û������������ĵ�ֵ
		List<Variable> variables = new ArrayList<Variable>();
		variables.add(Variable. createVariable ("�û���", args[0]));
		//ִ�б��ʽ
		Object result = ExpressionEvaluator. evaluate (expression,
		variables);
		System. out .println("Result = " + result);
		}
}
