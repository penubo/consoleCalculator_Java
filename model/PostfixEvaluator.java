package model;

import java.util.NoSuchElementException;

import core.TokenQueue;
import core.TokenStack;
import token.*;

public class PostfixEvaluator {
	
	public double evaluate(TokenQueue postfixTokenQueue) throws IllegalArgumentException {
		TokenStack operandStack = new TokenStack();
		
		while (postfixTokenQueue.hasNext()) {
			Token currentToken = postfixTokenQueue.dequeueToken();
			if (currentToken.isOperand()) {
				operandStack.pushToken(currentToken);
			} else if (currentToken.isOperator()) {
				if (currentToken.isBinaryOperator()) {
					BinaryOperator currentBinaryOperator = (BinaryOperator) currentToken;
					double operandA = 0;
					double operandB = 0;
					try {
						operandB = ((Operand) operandStack.pop()).getRawValue();
						operandA = ((Operand) operandStack.pop()).getRawValue();
					} catch (NoSuchElementException e) {
						throw new IllegalArgumentException("invalid expression");
					}
					double newValue = currentBinaryOperator.evaluate(operandA, operandB);
					Operand newOperandToken = new Operand(String.valueOf(newValue));
					operandStack.pushToken(newOperandToken);
				} else if (currentToken.isUnaryOperator()) {
					UnaryOperator currentUnaryOperator = (UnaryOperator) currentToken;
					double operand = 0;
					try {
						operand = ((Operand) operandStack.pop()).getRawValue();
					} catch (NoSuchElementException e) {
						throw new IllegalArgumentException("invalid expression");
					} catch (ClassCastException e) {
					}
					//TODO make new function (double) -> Token		
					double newValue = currentUnaryOperator.evaluate(operand);
					Operand newOperandToken = new Operand(String.valueOf(newValue));
					operandStack.pushToken(newOperandToken);
				}
			} 
		}
		
		if (operandStack.size() > 1) {
			throw new IllegalArgumentException("invalid expression");
		} 
		
		return ((Operand) operandStack.pop()).getRawValue();
	}
}
