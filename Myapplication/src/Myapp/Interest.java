package Myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Interest {

	

public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("Please enter the account ID");
	String str = br.readLine();
	ArrayList<Integer> t = new ArrayList<Integer>();
	for(String s : str.split(""))
		try {
			int i= Integer.parseInt(s);
			t.add(i);
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	Collections.sort(t);
 
	int n = t.get(t.size()-1);
	System.out.println(n);
	LinkedList<Integer> amount = new LinkedList<Integer>(); //add and put & remove is fast but get and set  is slow 
	for(int i = 1;i<= n ;i++) {
		
		System.out.println("Enter the amount for account" +i);
		amount.add(Integer.parseInt(br.readLine()));
	}
	System.out.println(amount);
	ArrayList<Double> interests = new ArrayList<>();
	for(int d : amount)
		interests.add(interest(d));
	System.out.println("AVG "+interests.stream().reduce((ans,e) -> ans+e).get()/interests.size());
    System.out.println("No Interest " + interests.stream().filter(x -> x<=0).count());
    System.out.println("Max "+interests.stream().max((a,b) -> a.compareTo(b)).get()  );
    System.out.println("Min " + interests.stream().min(Double::compareTo).get());
    
	System.out.println(interests);		
}

public static double interest(int amount) {
	
	if(amount >= 0 && amount<= 1000) 
		return 0;
	else if (amount >= 1001 && amount <= 5000)
		return (amount * 2.5)/100;
	else if (amount >= 5001 && amount <= 10000)
		return (amount * 5)/100;
	else if (amount >= 10001)
		return (amount * 8)/100;
	else 
		return 0;
}







}
