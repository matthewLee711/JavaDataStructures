package deepCopyLinkedList;

import java.util.Random;

public class RandomLinkedList
{
	// reference to the head node.
	private Node head;
	public int listCount;
	public Node modded;
	public String outputModded;
	Random rand = new Random();
	int n;
	
	// LinkedList constructor
	public RandomLinkedList()
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
	//appends the specified element with index
	public void add(int index, Object data)
	{
		Node temp = new Node(index, data);
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
	//returns the number of elements in this list
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
	//returns random node
	public Node randomizer() {
		//generate random number
		n = rand.nextInt(listCount) + 1;//dies here
		
		Node current = head;
		//go to random number to extract 
		for(int i = 1; i < n; i++)
		{
			current = current.getNext();
		}
		return current;
	}
	//returns random node
	public Object randomizerData(String stuff) {
		//generate random number to count up to
		n = rand.nextInt(listCount) + 1;
		//re pass data back into ll node
		add(stuff);
		Node current = head;
		//count to random number to extract data
		for(int i = 1; i < n + 1; i++)
		{
			current = current.getNext();
		}
		System.out.println(current.getData());
		return current.getData();
	}
	
	public String randomPoints(Node point, int trigger, String stuff)
	{
		if(trigger == 0) {
			//add random point + data to node
			modded = new Node(point, randomizerData(stuff));//need to pass back data
		}
		else if(trigger == 1) {
			//print based on index
			Node current = modded.getNext();
			//String output = "";
			while(current != null)
			{//shits itself bc point to itself
				outputModded += "[" + current.getData().toString() + "]";
				current = current.getNext();
			}
		}
		return outputModded;
	}
	
	
	private class Node
	{
		// reference to the next node in the chain,
		// or null if there isn't one.
		Node next;
		// data carried by this node.
		// could be of any type you need.
		Object data;
		int number;
		
		// Node constructor
		public Node(Node _next, Object _data)
		{
			next = _next;
			data = _data;//retain old data
		}
		public Node(Object _data)
		{
			next = null;
			data = _data;
		}
		// another Node constructor if want to
		// specify the node to point to.
		public Node(Object _data, Node _next)
		{
			next = _next;
			data = _data;
		}
		// allows indexing of node
		public Node(int _number, Object _data)
		{
			data = _data;
			number = _number;
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
		public int getIndex()
		{
			return number;
		}
	}
	
	
	public static void main(String[] args){
		RandomLinkedList ll = new RandomLinkedList();
		String[] test = {"hi", "my", "name", "is", "matt"};
		//append index and data to ll
		for(int i = 0; i < test.length; i++){
			ll.add(i, test[i]);
		}
		//point to random based on deep copy
		RandomLinkedList ll2 = new RandomLinkedList();
		ll2 = ll;
		int counter = ll2.listCount;
		//pass random node to ll based on index 
		for(int i = 0; i < counter; i++){
			//pass deep copy ll into regular ll 
			ll.randomPoints(ll2.randomizer(), 0, test[i]);
		}
		

//		for(int i = 0; i < counter; i++) {
//			//pass data to randomizer
//			ll.randomizerData(test[i]);
//		}
		
		//System.out.println(ll.randomPoints(ll2.randomizer(), 1, test[1]));
	}
}