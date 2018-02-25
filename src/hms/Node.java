package hms;

public class Node {
	
	int data;
	Node next, previous;
	
	Node(int data, Node next,Node previous)
	{
		this.data=data;
		this.next=next;
		this.previous=previous;
	}

	public static void main(String[] args) {
		
		Node a=new Node(10, null,null);
		Node b=new Node(20, null,null);
		Node c=new Node(30, null,null);
		Node d=new Node(40, null,null);
		Node e=new Node(50, null,null);
		
		a.next=b;
		a.previous=null;
		b.next=c;
		b.previous=a;
		c.next=d;
		c.previous=b;
		d.next=e;
		d.previous=c;
		e.next=null;
		e.previous=d;
		
		System.out.print(" The Linked list: ");
		for ( Node pointer=e;pointer!=null;pointer=pointer.previous)
		{
			System.out.print("-->"+pointer.data);
		}
		System.out.print(" End of linked list");
	
	}

}
