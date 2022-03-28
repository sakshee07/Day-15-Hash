package com.hash.bl;

public class MyMapNode {
	
	String data;
	int frequency;
	MyMapNode next;
	
	MyMapNode(String data){
		this.data=data;
		this.next=null;
		this.frequency +=1;
	}
}

