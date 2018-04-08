package token;

import java.util.function.Function;

public class BinaryOperator extends Operator {
	
	private Function<Double, Function<Double,Double>> evaluation;
	
	public BinaryOperator(String name) {
		super(name);
		setAssociativity("left");
		setPrecedences(BinaryOperatorGenerator.setPrecedences(name));
		evaluation = BinaryOperatorGenerator.setFunction(name);
	}
	
	public double evaluate(double x, double y) {
		return evaluation.apply(x).apply(y);
	}
	
	
}

class BinaryOperatorGenerator {
	static Function<Double, Function<Double,Double>> setFunction(String name) {
		switch(name) {
		case "+":
			return x -> y -> x + y;
		case "-":
			return x -> y -> x - y;
		case "/":
			return x -> y -> x / y;
		case "*":
			return x -> y -> x * y;
		default: 
			return null;
		}
	}
	
	static int setPrecedences(String name) {
		switch(name) {
		case "+":
			return 4;
		case "-":
			return 4;
		case "/":
			return 3;
		case "*":
			return 3;
		default: 
			return 100;
		}
	}
}