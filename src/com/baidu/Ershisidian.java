package com.baidu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ershisidian {
	public static String[] fuhao= {"+","-","*","/"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while ((str = br.readLine()) != null) {
			String[] split = str.split(" ");
			int[] pai=new int[4];
			for (int i = 0; i < split.length; i++) {
				if(change(split[i])==-1) {
					System.out.println("ERROR");
					return;
				}else {
					pai[i]=change(split[i]);
				}
			}
			computer(pai);
		}
	}
	public static int jiSuan(int m,int n,String sym) {
		switch (sym) {
		case "+": return m+n;
		case "-": return m-n;
		case "*": return m*n;
		case "/": return m/n;
		default: return 0;
		}
	}
	public static void computer(int[] arr) {
		String[][] yunSuan=new String[64][3];
		int p=0;
		for (int i = 0; i < fuhao.length; i++) {
			for (int j = 0; j < fuhao.length; j++) {
				for (int j2 = 0; j2 < fuhao.length; j2++) {
					yunSuan[p++]= new String[]{fuhao[i],fuhao[j],fuhao[j2]};
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				for (int j2 = 0; j2 < arr.length; j2++) {
					for (int k = 0; k < arr.length; k++) {
						if(i!=j&&i!=j2&&i!=k&&j!=j2&&j!=k&&j2!=k) {
							for (int k2 = 0; k2 < yunSuan.length; k2++) {
								int sum=jiSuan(arr[i], arr[j],yunSuan[k2][0]);
								sum=jiSuan(sum,arr[j2],yunSuan[k2][1]);
								sum=jiSuan(sum, arr[k], yunSuan[k2][2]);
								if(sum==24) {
									System.out.println(change2(arr[i])+yunSuan[k2][0]+arr[j]+yunSuan[k2][1]+arr[j2]+yunSuan[k2][2]+arr[k]+"");
									return;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("NONE");
	}
	public static String change2(int str) {
		switch (str) {
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default:
			return String.valueOf(str);
		}
	}
	public static int change(String str) {
		switch (str.toUpperCase()) {
		case "A": return 1;
		case "J": return 11;
		case "Q": return 12;
		case "K": return 13;
		case "JOKER": return -1;
		default:
			return Integer.parseInt(str);
		}
	}
}
