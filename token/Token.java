package token;

public class Token {
	private String name;
	
	public Token(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isOperator() {
		return this instanceof Operator;
	}
	
	public boolean isUnaryOperator() {
		return this instanceof UnaryOperator;
	}
	
	public boolean isBinaryOperator() {
		return this instanceof BinaryOperator;
	}

	public boolean isOperand() {
		return this instanceof Operand;
	}

	public boolean isOpenParentheses() {
		return this.name.equals("(");
	}
	
	public boolean isClosedParentheses() {
		return this.name.equals(")");
	}


}
