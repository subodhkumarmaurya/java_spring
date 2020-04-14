package come.codingdojo.calculator;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.setOperandOne(10);
		c.setOperaion("/");
		c.setOperandTwo(10);
		
		c.performOperation();

	}

}
