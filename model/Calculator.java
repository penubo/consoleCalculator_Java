package model;

import core.TokenQueue;

public class Calculator {
	Tokenizer tokenizer;
	InfixToPostfixConvertor convertor;
	PostfixEvaluator evaluator;
	TokenQueue infixTokenQueue;
	TokenQueue postfixTokenQueue;
	private double result;
	private boolean isObserving;
	
	public Calculator() {
		tokenizer = new Tokenizer();
		convertor = new InfixToPostfixConvertor();
		evaluator = new PostfixEvaluator();
		isObserving = false;
	}
	
	public void setObserving(boolean b) {
		isObserving = b;
	}

	public double evaluate(String expression) throws IllegalArgumentException {
		try {
		infixTokenQueue = tokenizer.tokenize(expression);
		postfixTokenQueue = convertor.convert(infixTokenQueue.clone());
		result = evaluator.evaluate(postfixTokenQueue.clone());
		} catch (CloneNotSupportedException e) {
			postfixTokenQueue = convertor.convert(infixTokenQueue);
			result = evaluator.evaluate(postfixTokenQueue);
			isObserving = false;
			System.out.println("expression Queue cannot be cloned");
		} 
		
		if(isObserving) {
			System.out.println("infix is >> "+ infixTokenQueue);
			System.out.println("postfix is >> " + postfixTokenQueue);
			System.out.println("result is >> " + result);
		}
		
		return result;
	}
	
	public TokenQueue getInfixTokenQueue() {
		//TODO add precondition
		return infixTokenQueue;
	}
	
	public TokenQueue getPostfixTokenQueue() {
		//TODO add precondition
		return postfixTokenQueue;
	}
	
}
