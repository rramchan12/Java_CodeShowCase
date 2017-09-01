package com.ravi.algorithms.datastructures;

public class MapEntry<K,V> {
	
	K key;
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	V value;
	
	public MapEntry(K key, V value){
		key = this.key;
		value = this.value;
	}

	
	

}
