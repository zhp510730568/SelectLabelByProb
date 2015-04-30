package com.zhp.ml.app;

import java.util.HashMap;

import com.zhp.ml.text.Util;

public class Test {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("1", 10);
		map.put("2", 20);
		map.put("3", 30);
		map.put("4", 40);
		System.out.println(Util.selectItemByProb(map));
	}
}
