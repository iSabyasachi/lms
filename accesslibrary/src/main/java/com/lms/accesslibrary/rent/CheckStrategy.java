package com.lms.accesslibrary.rent;
/*
 * The strategy pattern lets you build software as a loosely coupled collection of interchangeable parts/
 * Each strategy encapsulates algorithm.
 * 
 * It allows grouping related algorithms under an abstraction, which client code against.
 * It allows switching out one algorithm for another without changing client.Ex Sort interface has BubbleSort & QuickSort strategies to sort.
 * */
public interface CheckStrategy {
	public boolean check(String word);
}
