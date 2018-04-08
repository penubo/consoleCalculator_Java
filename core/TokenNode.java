package core;

import token.Token;

public class TokenNode {
	private Token token;
	private TokenNode nextNode;
	
	public TokenNode(Token token, TokenNode link) {
		this.token = token;
		nextNode = link;
	}
	
	public TokenNode getNext() {
		return nextNode;
	}
	
	public Token getToken() {
		return token;
	}
	
	public void setNextNode(TokenNode node) {
		nextNode = node;
	}
	
	public boolean hasNext() {
		return (nextNode != null);
	}
}
