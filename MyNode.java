package com.enikeili.lab1;

/**
 * MyContainer2.0, Node
 * @author enikeili
 */

public class MyNode<T>
{
	
	private T val; //data stored in the node
	
	private MyNode<T> next; //pointer to the next node

	/**
	 * Default constructor, creates an empty node 
	 */
	public MyNode()
	{
		this.next=null;
	}
	
	/**
	 * Constructor with given data _val, creates container with val = _val
	 * @param _val data stored in the node
	 */
	public MyNode(T _val)
	{
		this.next=null;
		this.val=_val;
	}

	/**
	 * Getter for the data stored in the node
	 * @return the val - data stored in the node
	 */
	public T getVal()
	{
		return val;
	}

	/**
	 * Setter for the data stored in the node
	 * @param val the val to set
	 */
	public void setVal(T val)
	{
		this.val = val;
	}

	/**
	 * Getter for the next node link 
	 * @return the next - the next node link
	 */
	public MyNode<T> getNext()
	{
		return next;
	}

	/**
	 * Setter for the next node link
	 * @param next the next node link to set
	 */
	public void setNext(MyNode<T> next)
	{
		this.next = next;
	}
};