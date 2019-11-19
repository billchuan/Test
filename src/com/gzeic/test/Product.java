package com.gzeic.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
class Product{
	private int id;
	private String name;
	private double price;
	private int store;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	
	public Product(int id, String name, double price, int store) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.store = store;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + ", price=" + price + ", store=" + store + "]";
	}
}
 
class SuperMarket{
	private List<Product> products = new ArrayList<Product>();
	
	public SuperMarket(){
		
	}
 
	public List<Product> getProducts() {
		return products;
	}
 
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
 
class Manager{
	private SuperMarket market;
	private File file;
	
	private void init(String[] strs){
		int id = 0;
		String name = null;
		double price = 0;
		int store = 0;
		List<Product> products = new ArrayList<Product>();
		for(int i = 0; i < strs.length; i++){
			if((i+1)%4==1){
				id = Integer.parseInt(strs[i]);
			}
			if((i+1)%4==2){
				name = strs[i];
			}
			if((i+1)%4==3){
				price = Double.valueOf(strs[i]);
			}
			if((i+1)%4==0){
				store = Integer.parseInt(strs[i]);
				Product product = new Product(id, name, price, store);
				products.add(product);
			}
		}
		market.setProducts(products);
	}
 
	private void save(){
		int id;
		String name;
		double price;
		int store;
		String str = new String("");
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for(int i = 0 ;i < market.getProducts().size();i++){
			id = market.getProducts().get(i).getId();
			name = market.getProducts().get(i).getName();
			price = market.getProducts().get(i).getPrice();
			store = market.getProducts().get(i).getStore();
			str += String.valueOf(id) + "#" + name + "#" + String.valueOf(price) + "#" + String.valueOf(store) + "#";
		}
		byte[] b = new byte[str.length()+1];
		b = str.getBytes();
		try {
			fos.write(b);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Manager(){
		market = new SuperMarket();
		file = new File("E:\\21810\\study\\market.txt");
	}
	
	public SuperMarket getMarket() {
		return market;
	}
 
	public void setMarket(SuperMarket market) {
		this.market = market;
	}
	
	public void query(){
		System.out.println(" id		 name		 price		 store");
		FileInputStream fis = null;
		String str = null;
		try {
			fis = new FileInputStream(file);
			int length = fis.available();
			byte[] b = new byte[length];
			fis.read(b);
			str = new String(b,"GB2312");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String[] strs = str.split("#");
		for(int i = 0 ; i < strs.length ; i++){
			System.out.print(" "+strs[i]);
			if((i+1)%4!=0){
				System.out.print("		");
			}else{
				System.out.println();
			}
		}

	}
	
	public void update(){
		query();System.out.println("输入要修改的产品id");
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String name;
		double price;
		int store;
		System.out.println("input the info:");
		System.out.print("name:");
		name = sc.next();
		System.out.print("price:");
		price = sc.nextDouble();
		System.out.print("store:");
		store = sc.nextInt();
		market.getProducts().get(n-1).setName(name);
		market.getProducts().get(n-1).setPrice(price);
		market.getProducts().get(n-1).setStore(store);
		save();
	}
	
	public void add(){
		System.out.println("现在有如下产品：");
		query();
		System.out.println("输入你想添加的产品：");
		Scanner sc = new Scanner(System.in);
		String name;
		double price;
		int store;
		System.out.println("input the info:");
		System.out.print("name:");
		name = sc.next();
		System.out.print("price:");
		price = sc.nextDouble();
		System.out.print("store:");
		store = sc.nextInt();
		int id = market.getProducts().size() + 1;
		Product product = new Product(id, name, price, store);
		market.getProducts().add(product);
		save();
	}
}
 
