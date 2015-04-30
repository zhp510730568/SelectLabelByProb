package com.zhp.ml.text;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 具体实现
 * @author zhp
 *
 */
public class Util {
	/**
	 * 根据label的点击概率选择label
	 * @param map label点击分布
	 * @return 选择的label
	 */
	public static String selectItemByProb(HashMap<String, Integer> map) {
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> iter1 = entrySet.iterator();
		int totalNum = 0;
		// 遍历求出各项对应数量
		while(iter1.hasNext()) {
			Entry<String, Integer> entry = iter1.next();
			int count = entry.getValue();
			totalNum += count;
		}
		
		HashMap<Integer, List<ItemInfo>> itemMap = new HashMap<Integer, List<ItemInfo>>();
		
		Iterator<Entry<String, Integer>> iter2 = entrySet.iterator();
		double accuNum = 0;
		while(iter2.hasNext()) {
			Entry<String, Integer> entry = iter2.next();
			String name = entry.getKey();
			double count = entry.getValue() * 1.0;
			// 计算概率范围下届
			double least_boundary = accuNum / totalNum;
			// 插入字典的key
			int key = (int)(least_boundary * 10);
			ItemInfo item = new ItemInfo(name, least_boundary, least_boundary + count / totalNum);
			if(itemMap.containsKey(key)) {
				itemMap.get(key).add(item);
			} else {
				List<ItemInfo> items = new LinkedList<ItemInfo>();
				items.add(item);
				itemMap.put(key, items);
			}
			System.out.println(item.toString());
			accuNum += count;
		}
		
		// 产生随机数，作为选择
		Random rand = new Random();
		double prob = rand.nextDouble();
		int selectedKey = (int) (prob * 10);
		for(int index = 0; index < 10; index++) {
			if(itemMap.containsKey(selectedKey)) {
				List<ItemInfo> items = itemMap.get(selectedKey);
				for(ItemInfo item: items) {
					if(prob >= item.getLeast_boundary() && prob < item.getMost_boundary()) {
						return item.getName();
					}
				}
			}
			selectedKey -= 1;
		}
		
		return "";
	}
}
