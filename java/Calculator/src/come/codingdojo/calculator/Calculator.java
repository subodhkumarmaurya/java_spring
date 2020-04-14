package come.codingdojo.calculator;

public class Calculator implements java.io.Serializable {
	private int operandOne;
	private String operation;
	private int operandTwo;
	
	public Calculator() {
		
	}
	public Calculator(int operandOne, String operation, int operandTwo) {
		this.operandOne = operandOne;
		this.operation = operation;
		this.operandTwo = operandTwo;
	}
	
	public void setOperandOne(int operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperaion(String operation) {
		this.operation = operation;
	}
	public void setOperandTwo(int operandTwo) {
		this.operandTwo = operandTwo;
	}
	
	public void performOperation() {
		if(operation == "+") {
			System.out.println(operandOne+operandTwo);
		} else if(operation == "-") {
			System.out.println(operandOne-operandTwo);
		} else if(operation == "/") {
			System.out.println(operandOne/operandTwo);
		} else if(operation == "*") {
			System.out.println(operandOne*operandTwo);
	}
	}
}
