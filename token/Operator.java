package token;

public class Operator extends Token{
	private int precedences;
	private String associativity;
	
	public Operator(String name) {
		super(name);
		precedences = 1;
		associativity = "right";
	}
	
	public int getPrecedences() {
		return precedences;
	}
	
	public String getAssociativity() {
		return associativity;
	}
	
	public void setAssociativity(String associativity) {
		if (associativity.equalsIgnoreCase("rigth")) {
			this.associativity = "right";
		} else if (associativity.equalsIgnoreCase("left")) {
			this.associativity = "left";
		} 
	}
	
	public void setPrecedences(int precedences) {
		if (precedences < 0) {
			precedences = 0;
		} else {
			this.precedences = precedences;
		}
	}
	
}
