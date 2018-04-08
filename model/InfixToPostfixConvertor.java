package model;

import token.*;
import java.util.NoSuchElementException;

import core.TokenQueue;
import core.TokenStack;

public class InfixToPostfixConvertor {

	public TokenQueue convert(TokenQueue originQueue) {
		if (originQueue == null) {
			throw new NoSuchElementException("please set infixQueue first before convert.");
		}
		
		TokenStack operatorStack = new TokenStack();
		TokenQueue postfixTokenQueue = new TokenQueue();
		
		while(originQueue.hasNext()) {
			Token currentToken = originQueue.dequeueToken();
			
			if (currentToken.isOperand()) {
				postfixTokenQueue.enqueueToken(currentToken);
			} else if (currentToken.isOpenParentheses()) {
				operatorStack.pushToken(currentToken);
			} else if (currentToken.isClosedParentheses()) {
				// TODO sin(1)) handle this
				try {
					while (!operatorStack.seeLastToken().isOpenParentheses()) {
						postfixTokenQueue.enqueueToken(operatorStack.pop());
					}
					operatorStack.pop(); // remove OpenParetheses
				} catch (NullPointerException exception) {
					throw new IllegalArgumentException("check pairs of parentheses!");
				}
			} else if (currentToken.isOperator()) {
				Operator currentOperatorToken = (Operator)currentToken;
				while (true) {
					if(operatorStack.isEmpty()) {
						break;
					}
					Operator topOperator = (Operator) operatorStack.seeLastToken();

					if(!topOperator.isOpenParentheses() &&
						topOperator.getPrecedences() < currentOperatorToken.getPrecedences() ||
						(topOperator.getPrecedences() == currentOperatorToken.getPrecedences() &&
						topOperator.getAssociativity().equalsIgnoreCase("left")))
					{
						postfixTokenQueue.enqueueToken(operatorStack.pop());
					} else {
						break;
					}	
				}
				operatorStack.pushToken(currentOperatorToken);
			}
		}
		if (originQueue.isEmpty()) {
			while (operatorStack.hasNext()) {
				postfixTokenQueue.enqueueToken(operatorStack.pop());
			}
		}
		
		return postfixTokenQueue;
	}
}
