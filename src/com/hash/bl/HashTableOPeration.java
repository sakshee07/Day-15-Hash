package com.hash.bl;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Objects;


public class HashTableOPeration {
	MyMapNode[] table;
	String[] strArray;
	int bucketSize;

	HashTableOPeration(String str, int bucketSize) {
		this.table = new MyMapNode[bucketSize];
		this.bucketSize = bucketSize;
		this.strArray = str.split(" ");
		hashTable();
	}

	private boolean isEmpty() {
		for (MyMapNode element : table) {
			if (element != null) {
				return false;
			}
		}
		return true;
	}

	private void hashTable() {
		for (int i = 0; i < strArray.length; i++) {
			int bucketIndex = Math.abs(strArray[i].hashCode() % bucketSize);
			if (table[bucketIndex] == null) {
				table[bucketIndex] = new MyMapNode(strArray[i]);
			} else {
				MyMapNode currentNode = table[bucketIndex];
				while (currentNode != null) {
					if (currentNode.data.equals(strArray[i])) {
						currentNode.frequency++;
						break;
					}
					if(currentNode.next == null) {
						currentNode.next = new MyMapNode(strArray[i]);
						break;
					}
					currentNode = currentNode.next;
					
				}
				
			}
		}
	}
//show table
	public void showTable() {
		if (isEmpty()) {
			return;
		} else {
			for (MyMapNode element : table) {
				MyMapNode currNode =element;
				while (currNode != null) {
					System.out.println(currNode.data + " " + currNode.frequency);
					currNode = currNode.next;
				}
				
			}
		}
	}
// delete data
	public void deleteData(String data) {
		int bucketIndex = Math.abs(data.hashCode() % bucketSize);
		if(isEmpty()) {
			return;
		}
		MyMapNode currNode = table[bucketIndex];
		while(currNode != null) {
			if(currNode.data.equals(data)) {
				MyMapNode temp = currNode.next;
				table[bucketIndex] = temp;
				break;
			}
			currNode = currNode.next;
		}
	}

}