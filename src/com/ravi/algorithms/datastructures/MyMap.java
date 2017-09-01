package com.ravi.algorithms.datastructures;

public class MyMap<K, V> {

	private int size = 0;
	private MapEntry<K, V>[] values = new MapEntry[INITIAL_CAPACITY];
	private static final int INITIAL_CAPACITY = 10;

	public boolean put(K key, V value) {
		boolean insert = true;
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					insert = false;
					values[i].setValue(value);
					break;
				}
			}

		}
		if (insert) {
			values[size++] = new MapEntry<K, V>(key, value);
		}
		return true;
	} 	

	public V get(K key) {
		for (int i = 0; i < size; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		MyMap<String, Integer> map = new MyMap<String, Integer>();
		map.put("Lars", 1);
		map.put("Lars", 2);
		map.put("Lars", 1);

		System.out.println(map.get("Lars"));
	}
}
