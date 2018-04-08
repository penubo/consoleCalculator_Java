package test;

import core.*;
import model.InfixToPostfixConvertor;
import model.PostfixEvaluator;
import model.Tokenizer;

public class CalculatorDemo {
	
	public static void main(String[] args) {
		String testString = "1 + (-3)";
		Tokenizer tokenizer = new Tokenizer();
		InfixToPostfixConvertor convertor = new InfixToPostfixConvertor();
		PostfixEvaluator evaluator = new PostfixEvaluator();
		
		TokenQueue infixTokenQueue = tokenizer.tokenize(testString);
		System.out.println("infix is "+ infixTokenQueue.toString());
		
		TokenQueue postfixTokenQueue = convertor.convert(infixTokenQueue);
		
		System.out.println("postfix is " + postfixTokenQueue.toString());
		
		double result = evaluator.evaluate(postfixTokenQueue);
		System.out.println("result is " + result);
	}
}
