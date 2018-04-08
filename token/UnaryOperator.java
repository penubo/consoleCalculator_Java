package token;

import java.util.function.Function;

public class UnaryOperator extends Operator {
	
	private Function<Double, Double> evaluation;
	
	public UnaryOperator(String name) {
		super(name);
		setAssociativity("right");
		setPrecedences(2);
		evaluation = UnaryOperatorGenerator.setFunction(name);
	}
	
	public double evaluate(double x) {
		return evaluation.apply(x);
	}
}

class UnaryOperatorGenerator {
	static Function<Double, Double> setFunction(String name) {
		switch(name) {
		case "-":
			return x -> -x;
		case "sqrt":
			return x -> Math.sqrt(x);
		case "sin":
			return x -> Math.sin(x);
		case "cos":
			return x -> Math.cos(x);
		case "tan":
			return x -> Math.tan(x);
		case "log":
			return x -> Math.log(x);
		case "exp":
			return x -> Math.exp(x);
		default: 
			return null;
		}
	}
}