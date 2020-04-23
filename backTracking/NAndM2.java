package com.leeyunbo.backjoon.backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

/*
 * https://www.acmicpc.net/problem/15650
 * 백준 15650번 N과M (2) 
 * 시간 제한 1초, 메모리 제한 512MB 
 */
public class NAndM2 {
	static LinkedList<Integer> array;
    static int n,m;
    static BufferedReader br; 
    static BufferedWriter bw; 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] line = br.readLine().split(" "); 
		n = Integer.parseInt(line[0]);
		m = Integer.parseInt(line[1]);
		
		array = new LinkedList<Integer>();
		
		NMFunc(1);	
		bw.close();	
	}
	
	private static void NMFunc(int start) throws IOException {
		//1. base-case
		if(array.size() == m) {
			for(int i=0; i<array.size(); i++) {
				bw.write(array.get(i)+ " ");
			}
			bw.newLine();
			bw.flush();
			return;
		}
		
		//2. recursion-case
		for(int i=start; i<=n; i++) {
			array.add(i); 
			NMFunc(i);
			array.pollLast();
		}
	}
}
