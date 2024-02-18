
public class CircularSinglyLinkedList {

	public Node head;
	public Node tail;
	public int size;
	
	public Node createCSLL(int nodeValue) {
		//instances of Node class
		head = new Node();
	Node node = new Node();
	//assign value 
    node.value = nodeValue;
    //link node 
	node.next = node;
	//link head and tail to node 
	head = node;
	tail = node;
	size=1;
	return head;
	//Circular Singly Linked List !!!!
		
	}
	
	public void insertInCSLL(int nodeValue,int location) {
		Node node = new Node();
		node.value = nodeValue;
		if (head ==null) {
			createCSLL(nodeValue);
			return;
		}
		else if (location == 0) {
			node.next = head;
			head = node;
			tail.next = head;
		}
		else if (location>=size) {
		tail.next = node;
		tail = node; 
		tail.next = head;
		
		}else {
			Node tempNode = head;
			int index =0;
			while (index <location-1) {
				tempNode = tempNode.next;
				index++;
			}
			node.next = tempNode.next;
			tempNode.next =node;
			
		}
		size++;
	}
	
	public void traverseCSLL() {
		if (head!=null) {
			Node tempNode = head;
			for (int i =0;i<size;i++) {
				System.out.print(tempNode.value);
				if (i!= size-1) {
					System.out.print("->");
				}
			
				tempNode = tempNode.next;
			}
		}	
	   else { 
					System.out.println("csLL does not exist");
			
			}
			System.out.println();
		
	}
	
	public boolean searchNode(int nodeValue) {
		if (head !=null) {
			Node tempNode= head;
			for (int i =0;i<size;i++) {
				if (tempNode.value ==nodeValue) {
				System.out.println("Found node at location"+i);
				return true;
				}
				tempNode = tempNode.next;
			}
			
			
		}
		System.out.println("Node no found");
		return false; 
	}
	
	public void deleteNode (int location) {
		if (head == null) {
			System.out.println("The CsLL does not exist");
		}
		else if (location==0) {
			head = head.next;
			tail.next = head;
			size --;
			if (size ==0) {
				tail = null;
				head.next =null;
				head = null;
			}
		}
		else if (location >= size) {
			Node tempNode = head;
			for (int i =0;i<size-1;i++) {
				tempNode = tempNode.next;
			}
			if (tempNode == head) {
				head.next = null;
				tail = head = null;
				size --;
				return;
			}
			tempNode.next = head;
			tail = tempNode;
			size--;
			
		}else {
			Node tempNode = head;
			for (int i =0;i<location-1;i++) {
				tempNode = tempNode.next;
			}
			tempNode.next = tempNode.next.next;
			size--;
		}
		
	}
	
	public void deleteCSLL() {
		if (head ==null) {
			System.out.println("The CSLL does not exist");
		}else {
			head = null;
			tail.next = null;
			tail = null;
			System.out.println("The Csll has been deleted");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CircularSinglyLinkedList csll = new CircularSinglyLinkedList ();
		csll.createCSLL(5);
		System.out.println(csll.head.value);
		//System.out.println(csll.head.next.value);
		csll.insertInCSLL(4,0);
		csll.insertInCSLL(4,1);
		csll.insertInCSLL(4,8);
		System.out.println(csll.head.value);
		csll.traverseCSLL();
		csll.searchNode(10);
		csll.deleteNode(0);
		csll.traverseCSLL();
		csll.deleteCSLL();
		csll.traverseCSLL();
	}

}
