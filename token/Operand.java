package token;

public class Operand extends Token {
	private double rawValue;
	
	public Operand(String name) {
		super(name);
		try {
			if (name.equalsIgnoreCase("PI"))
				rawValue = Math.PI;
			else if (name.equalsIgnoreCase("E"))
				rawValue = Math.E;
			else
				rawValue = Double.parseDouble(getName());
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException("check numbers guess you type character instead of numbers?");
		}
	}
	
	public double getRawValue() {
		return rawValue;
	}
}
