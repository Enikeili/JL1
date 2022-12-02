package com.enikeili.lab1;

import com.enikeili.lab1.MyNode;

/**
 * MyContainer2.0, List
 * @author enikeili
 */
public class MyList<T>
{
	private int size; //list size
	private MyNode<T> head; //list head
	/**
	 * Default constructor, creates an empty list
	 */
	public MyList()
	{
		head=null;
		size=0;
	}
	/**
	 * Constructor with given data _val, creates a list with a single node with in the node stored data _val
	 * @param _val data stored in the single node lists
	 */
	public MyList(T _val)
	{
		MyNode<T> p = new MyNode<T>(_val);
		head = p;
		size=1;
	}
	/**
	 * Getters head list
	 * @return the head list - MyNode<T>
	 */
	public MyNode<T> getHead()
	{
		return head;
	}
	/**
	 * Checks, if the list is empty, returns true, if the list is empty, or false, if the list isn't empty
	 * @return true or false
	 */
	public boolean isEmpty()
	{
		return head==null;
	}
	/**
	 * Getter for list size
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}
	/**
	 * Deletes the node from head, if the list isn't empty
	 */
	public void delFromHead()
	{
		if(isEmpty()) return;
		MyNode<T> n = head;
		head = n.getNext();
		size=size-1;
	}
	/**
	 * Deletes all list nodes 
	 */
	public void delAll()
	{
		while(head!=null)
			delFromHead();
	}
	/**
	 * Adds a node with data stored in the node _val to list head
	 * @param _val data stored in the added node
	 */
	public void addToHead(T _val)
	{
		MyNode<T> n = new MyNode<T>(_val);
		n.setNext(head);
		head = n;
		size=size+1;
	}
	/**
	 * Adds a node with data stored in the node _val after a node with the link = n
	 * @param n the list node link after which adds the node
	 * @param _val data stored in the added node
	 */
	private void addAfterNode(MyNode<T> n, T _val) throws IndexOutOfBoundsException
	{
	    if(n==null) 
	    	throw new IndexOutOfBoundsException();
		MyNode<T> newN = new MyNode<T>(_val);
		newN.setNext(n.getNext());
		n.setNext(newN);
		size=size+1;
	}
	/**
	 * Finds the node with index=_index (head has index 0), returns null, if the list is empty
	 * @param _index index of the searched node 
	 * @return null or the searched node link
	 */
	public MyNode<T> findPos(int _index)
	{
		MyNode<T> n = head;
		for(int i=0; i<_index; i++)
			n = n.getNext();
		return n;
	}
	/**
	 * Returns container element by index
	 * @param index index of container element 
	 * @return container element by index
	 * @throws IndexOutOfBoundsException 
	 */
	public T getElement_by_index(int _index) throws IndexOutOfBoundsException
	{
	    if (_index < 0 || _index > getSize() - 1)
	        throw new IndexOutOfBoundsException();
	    else
	        return findPos(_index).getVal();
	}
	/**
	 * Sets container element by index
	 * @param index index of container element
	 * @param new_value new value of container element
	 * @throws NullPointerException
	 * @throws IndexOutOfBoundsException 
	 */
	public void setElement_by_index(int _index, T new_value) throws NullPointerException, IndexOutOfBoundsException
	{
	    if (new_value == null)
	        throw new NullPointerException();
	    else
	        if (_index < 0 || _index > getSize() - 1)
	            throw new IndexOutOfBoundsException();
	        else
	            this.findPos(_index).setVal(new_value);
	 }
	public void insert_element_by_index(int index, T new_value) throws NullPointerException, IndexOutOfBoundsException
	{
	    if (new_value == null)
	        throw new NullPointerException();
	    else
	        if (index < 0 || index > getSize() - 1)
	            throw new IndexOutOfBoundsException();
	        else
	        {
	        	MyNode<T> p = head;
	        	for(int i=0; i < index-1; i++)
	        		p=p.getNext();
	            addAfterNode(p,new_value);
	        }
	 }
    /**
	 * Deletes container element by index
	 * @param index index of container element
	 * @throws IndexOutOfBoundsException 
	 */
	public void delete_element_by_index(int index) throws IndexOutOfBoundsException
	{
		if (index < 0 || index > getSize() - 1)
	        throw new IndexOutOfBoundsException();
	    else
	    {     	
	        MyList<T> new_container = new MyList<>();
	        for (int i = 0; i < this.getSize(); i++)
	        {
	            if (i < index)
	                new_container.addToHead(this.getElement_by_index(i));
	            else 
	            	if (i > index)
	            		new_container.addToHead(this.getElement_by_index(i)); 
	        }
	        this.delAll();
	        for (int i = 0; i < new_container.getSize() ; i++)
	        {
	            this.addToHead(new_container.getElement_by_index(i));
	        }
	    }
	}
	/**
	 * Extracts container element by index, returns value of container element and delets container element
	 * @param index index of container element
	 * @return container element with index = given index
	 */
	public T extract_element_by_index(int index)
	{
	    T return_val = getElement_by_index(index);
	    delete_element_by_index(index);
	    return return_val;
	}
	/**
	 * Prints the list, type T should be printable!
	 */
	public void print()
	{
		MyNode<T> i = head;
		while(i!=null)
		{
			System.out.println(i.getVal());
			i = i.getNext();
		}
	}
};