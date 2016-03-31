package com.ufu.weka;

public class WekaMain {

	
	public static Integer idSequencial =0;
	
	public static void main(String[] args) {
		
		try {
			GeneretaFile.process(1000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}
	
}
