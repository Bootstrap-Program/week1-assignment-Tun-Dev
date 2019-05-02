package com.count.helper;

public class Logger {
	
	public String calc(String x, String op, String y) {

		int a = Integer.parseInt(x);  //“ABCD”
		int b = Integer.parseInt(y);

		int result = Integer.MIN_VALUE;

		switch(op) {	
		
		
		case "*":
		result = a*b;
		break;

		case "/":
		result = a/b;
		break;


		case("+"):
		result = a+b;
		break;

		case("-"):
		result = a-b;
		break;

		default:
		//exception
		break;
		}

		return String.valueOf(result);
		    
		
		
	}


}
