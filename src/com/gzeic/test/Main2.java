package com.gzeic.test;

import java.util.Scanner;

public class Main2 {
	public static void main(String[] args){
		Manager manager = new Manager();
		int n = 0;
		Scanner sc = new Scanner(System.in);
		while(n!=4){
			System.out.println("ÊäÈëÄãµÄ²Ù×÷£º");
			System.out.println("1.query			2.update		3.add		4.exit");
			n = sc.nextInt();
			switch(n){
			case 1 : manager.query();
			case 2 : manager.update();
			case 3 : manager.add();
			
			}
			System.out.println("\n");
		}
		sc.close();
	}
}

