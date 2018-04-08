package test;
import java.util.ArrayList;

import model.Tokenizer;
public class TokenizerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tokenizer tokenizer = new Tokenizer();
		String testString = "3 + 5 - 3 * (-3) + sin(2)";
		ArrayList<String> tokens = tokenizer.scan(testString);
		for(String token : tokens) {
			System.out.println(token);
		}
	}

}
