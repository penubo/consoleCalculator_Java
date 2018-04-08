package core;

import token.*;

public class TokenStack {
	public TokenNode head;
	int manyItems;
	
	public TokenStack() {
		head = null;
	}
	
	public boolean isEmpty() {
		return (manyItems == 0);
	}
	
	public int size() {
		return manyItems;
	}
	
	public boolean hasNext() {
		return (head != null);
	}

	public Token pop() {
		if (isEmpty())
			throw new IllegalArgumentException("Stack underflow.");
		
		Token tokenToReturn = head.getToken();
		head = head.getNext();
		manyItems--;
		return tokenToReturn;		
	}
	
	public void pushToken(Token token) {
		head = new TokenNode(token, head);
		manyItems++;
	}
	
	public void pushTokenNode(TokenNode node) {
		node.setNextNode(head);
		head = node;
	}
	
	public Token seeLastToken() {
		if (head == null) {
			return null;
		}
		return head.getToken();
	}
	
	public String toString() {
		TokenNode current = head;
		String stringToReturn = "";
		while(current != null) {
			//TODO how to print pretty way? like "1 + 1 * (-1 + 1)"
			Token currentToken = current.getToken();
			stringToReturn += currentToken.getName();
			current = current.getNext();
		}
		return stringToReturn;
	}
	
}
