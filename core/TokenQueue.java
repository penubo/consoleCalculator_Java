package core;

import token.*;

import java.util.NoSuchElementException;

public class TokenQueue implements Cloneable {
	private TokenNode front;
	private	TokenNode rear;
	private int manyItems;
	
	public TokenQueue() {
		front = null;
		rear = front;
	}
	
	public TokenQueue clone() throws CloneNotSupportedException {
		TokenQueue cloneQueue = (TokenQueue) super.clone();
		return cloneQueue;
	}
	
	public boolean isEmpty() {
		return (manyItems == 0);
	}
	
	public int size() {
		return manyItems;
	}
	
	public boolean hasNext() {
		return (rear != null);
	}
	
	public static boolean hasNext(TokenNode current) {
		return (current.getNext() != null);
	}
	
	public Token dequeueToken() {
		
		if(isEmpty()) 
			throw new NoSuchElementException("Queue underflow.");
		
		Token tokenToReturn = front.getToken();
		front = front.getNext();
		manyItems--;
		
		if(isEmpty()) // check we just make queue empty
			rear = null;
		
		return tokenToReturn;
	}
	
	public void enqueueToken(Token token) {
		if(isEmpty()) {
			front = new TokenNode(token, null);
			rear = front;
		} else {
			rear.setNextNode(new TokenNode(token, null));
			rear = rear.getNext();
		}
		manyItems++;
	}
	
	/**
	 * 
	 * @return return string of all Tokens in queue if node is empty then return ""
	 *
	 * 
	 */
	public String toString() {
		TokenNode current = front;
		String stringToReturn = "";
		while(current != null) {
			//TODO how to print pretty way? like "1 + 1 * (-1 + 1)"
			Token currentToken = current.getToken();
			stringToReturn += currentToken.getName() + " ";
			current = current.getNext();
		}
		return stringToReturn;
	}
}
