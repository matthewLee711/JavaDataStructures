package deepCopyLinkedList;

import java.util.Random;
import java.util.Scanner;

public class LL
{
	// reference to the head node.
	private Node head;
	private int listCount;
	
	// LinkedList constructor
	public LL()
	{
		// this is an empty list, so the reference to the head node
		// is set to a new node with no data
		head = new Node(null);
		listCount = 0;
	}
	//appends the specified element to the end of this list.
	public void add(Object data)
	{
		Node temp = new Node(data);
		Node current = head;
		// starting at the head node, crawl to the end of the list
		while(current.getNext() != null)
		{
			current = current.getNext();
		}
		// the last node's "next" reference set to our new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	//inserts the specified element at the specified position in this list.
	public void add(Object data, int index) 
	{
		Node temp = new Node(data);
		Node current = head;
		// crawl to the requested index or the last element in the list,
		// whichever comes first
		for(int i = 1; i < index && current.getNext() != null; i++)
		{
			current = current.getNext();
		}
		// set the new node's next-node reference to this node's next-node reference
		temp.setNext(current.getNext());
		// now set this node's next-node reference to the new node
		current.setNext(temp);
		listCount++;// increment the number of elements variable
	}
	
	//returns the element at the specified position in this list.
	public Object get(int index) 
	{
		// index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node current = head.getNext();
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return null;
			
			current = current.getNext();
		}
		return current.getData();
	}
	
	//removes the element at the specified position in this list.
	public boolean remove(int index)
	{
		// if the index is out of range, exit
		if(index < 1 || index > size())
			return false;
		
		Node current = head;
		for(int i = 1; i < index; i++)
		{
			if(current.getNext() == null)
				return false;
			
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--; // decrement the number of elements variable
		return true;
	}
	
	//returns the number of elements in this list.
	public int size()
	{
		return listCount;
	}
	
	//Prints Linked List
	public String toString()
	{
		Node current = head.getNext();
		String output = "";
		while(current != null)
		{//shits itself bc point to itself
			output += "[" + current.getData().toString() + "]";
			current = current.getNext();
		}
		return output;
	}
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;
		
		// Node constructor
		public Node(Object _data)
		{
			next = null;
			data = _data;
		}
		
		// another Node constructor if we want to
		// specify the node to point to.
		public Node(Object _data, Node _next)
		{
			next = _next;
			data = _data;
		}
		
		// these methods should be self-explanatory
		public Object getData()
		{
			return data;
		}
		
		public void setData(Object _data)
		{
			data = _data;
		}
		
		public Node getNext()
		{
			return next;
		}
		
		public void setNext(Node _next)
		{
			next = _next;
		}
	}
	
	
	public static void main(String[] args){
		LL ll = new LL();
		String[] test = {"hi", "my", "name", "is", "matt"};
		for(int i = 0; i < test.length; i++){
			ll.add(test[i]);
		}
		LL ll2 = new LL();
		for(int i = 0; i < test.length; i++){
			ll2.add(test[i]);
		}
		System.out.println("Current Linked List");
		System.out.println(ll.toString());
		
		Scanner scanner = new Scanner (System.in);
		int number;
		int input;
		
		boolean exit = true;
		while(exit != false) {
			System.out.println("enter choice");
			System.out.println("press 0 to print current linked list");
			System.out.println("press 1 to exit");
			System.out.println("press 2 to delete based on index");
			System.out.println("press 3 to load deep copy");
			System.out.println("press 4 to save to deep copy");
			number = scanner.nextInt();
			if(0 == number) {
				System.out.println(ll.toString());
			}
			else if(1 == number) {
				exit = false;
			}
			else if(2 == number) {
				System.out.println("Currently: " + ll.listCount + " elements");
				input = scanner.nextInt();
				if(input >= ll.listCount) 
					System.out.println("please input valid number");
				else
					ll.remove(input);
			}
			else if(3 == number) {
				ll = ll2;
			}
			else if(4 == number) {
				ll2 = ll;
			}
			else {
				System.out.println("Please enter valid choice");
			}
		}
		
		
	}
}
