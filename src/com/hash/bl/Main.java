package com.hash.bl;

public class Main {
	public static void main(String[] args) {
		HashTableOPeration func = new HashTableOPeration("Paranoids are"
				+ " not paranoid because they are paranoid but because they keep putting"
				+ " themselves deliberately into paranoid avoidable situation",4);
		
		func.deleteData("Paranoids");
		func.showTable();
		
	}
}