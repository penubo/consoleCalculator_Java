package app;
import acm.program.*;
import model.Calculator;

public class MyCalculatorCommandLine extends ConsoleProgram {
	Calculator calculator;
	double result;
	String userInput;
	
	public void setup() {
		this.setSize(800, 300);
		calculator = new Calculator();
	}
	
	public void introView() {
		println("hello this is console based calculator");
		println("if you want to know what kind of functions you can use, just type 'h'!");
		println("if you want to go home, just type 'q'!");
	}
	
	public void helperView() {
		clear();
		println("unaryOperator you can use");
		println("'-', 'sqrt', 'sin', 'cos', 'tan', log', 'exp'");
		println("binaryOperator you can use");
		println("'+', '-', '*', '/'");
	}
	public void clear() {
		//TODO how to clear that console?
	}

	public void run() {
		
		setup();
		introView();

		while(true) {
			userInput = readLine("input expression >> ");
			
			if (userInput.equalsIgnoreCase("q")) {
				System.exit(-1);
			} else if (userInput.equalsIgnoreCase("h")) {
				helperView();
				continue;
			}
			
			try {
				result = calculator.evaluate(userInput);
			} catch (IllegalArgumentException exception) {
				println(exception);
				println("wrong expression sorry about that.");
				continue;
			}
			println("infix is " + calculator.getInfixTokenQueue());
			println("postfix is " + calculator.getPostfixTokenQueue());
			println("result is " + result);
		}
	}

}
