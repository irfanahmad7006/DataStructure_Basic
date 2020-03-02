class Node{
			private Node next; //This is called self referecening.
			private int data;
			Node(int data){
				this.data= data;
				this.next=null; //This line of code is optional as compiler would intialize "this.next" as null automatically
				}
}
	
