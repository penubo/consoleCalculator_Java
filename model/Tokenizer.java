package model;

import java.util.regex.Pattern;

import core.TokenQueue;

import java.util.ArrayList;
import java.util.regex.Matcher;
import token.*;

public class Tokenizer {
	String calculatorTokenRegex = "[0-9.]+|\\w+|\\S";
	Pattern pattern;
	Matcher matcher;
	
	public Tokenizer() {
		pattern = Pattern.compile(calculatorTokenRegex);
	}
	
	public ArrayList<String> scan(String rawString) {
		matcher = pattern.matcher(rawString);
		ArrayList<String> tokens = new ArrayList<String>();
		while(matcher.find()) {
			tokens.add(matcher.group(0));
		}
		return tokens;
	}
	
	public TokenQueue tokenize(String rawString) {
		if (rawString == null) 
			throw new IllegalArgumentException("invalid argument");
		
		ArrayList<String> tokenNameArray = scan(rawString);
		TokenQueue tokenQueue = new TokenQueue();
		Token previousToken = null;
		Token newToken = null;
		
		for(String tokenName : tokenNameArray) {
			if (previousToken == null) {
				if (isUnaryOperator(tokenName)) {
					newToken = new UnaryOperator(tokenName);
					tokenQueue.enqueueToken(newToken);
					continue;
				}
			} else if (previousToken.isOpenParentheses() || previousToken.isOperator()) {
				if (isUnaryOperator(tokenName)) {
					newToken = new UnaryOperator(tokenName);
					tokenQueue.enqueueToken(newToken);
					continue;
				}
			}
			if (isParentheses(tokenName)) {
				newToken = new Operator(tokenName);
			} else if (isBinaryOperator(tokenName)) {
				newToken = new BinaryOperator(tokenName);
			} else if (isUnaryOperator(tokenName)){
				newToken = new UnaryOperator(tokenName);
			} else {
				newToken = new Operand(tokenName);
			}
			previousToken = newToken;
			tokenQueue.enqueueToken(newToken);
		}
		
		return tokenQueue;
	}
	
	private boolean isParentheses(String name) {
		return (name.equalsIgnoreCase("(") || name.equalsIgnoreCase(")"));
	}
	
	private boolean isBinaryOperator(String name) {
		switch (name) {
		case "+": return true;
		case "-": return true;
		case "*": return true;
		case "/": return true;
		default: return false;
		}
	}
	
	private boolean isUnaryOperator(String name) {
		
		switch (name) {
		case "-": return true;
		case "sqrt": return true;
		case "sin" : return true;
		case "cos" : return true;
		case "tan" : return true;
		case "log" : return true;
		case "exp" : return true;
		default: return false;
		}
	}
	
	
	
}
