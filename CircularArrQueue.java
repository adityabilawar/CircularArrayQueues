//import java.lang.reflect.Array;

public class CircularArrQueue
{
	private Object[] arrayQ;
	private int front;
	private int count;
	int checker = 0;
	public CircularArrQueue(int n) {
		arrayQ = new Object[n];
		front = 0;
		count = 0;
	}
	public void add(Object obj) {
		if(checker == 1) {
			doubleCapacity();
			checker = 0;
		}
		if(((count + 1)%arrayQ.length) == front) 
			 checker = 1;
		arrayQ[count] = obj;
		count = (count+1)%(arrayQ.length);

	}


	//fix remove method
	public Object remove() {
		//change to overwrite and null
//		if(isEmpty())
//			return null;
		Object read = arrayQ[front];
		arrayQ[front] = null;
		front = (front + 1)%(arrayQ.length);
		return read;
	}
	public boolean isEmpty() {
		return front == count;
	}
	public void doubleCapacity() {
		Object[] ArrayAdd = new Object[arrayQ.length*2];
			
		for(int i = 0; i< arrayQ.length; i++) {
			ArrayAdd[i] = arrayQ[(i + front) % arrayQ.length];
		}

		front = 0;
		count = arrayQ.length - 1;
		arrayQ =  ArrayAdd;
	}
	public int size() {
		return arrayQ.length;
	}
	public String toString() {
		String print = " ";
		//for(int i = front; i!=count; i = (i + 1) % arrayQ.length) {
		for(int i = 0; i < arrayQ.length; i++) {
			print+=arrayQ[i] + " ";
		}
		return print;
	}
	public static void main(String[] args) {
		CircularArrQueue a = new CircularArrQueue(10);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		a.add(8);
		a.add(9);
		System.out.println(a);
		System.out.println("\nREMOVE NEXT: " + a.remove() + " is removed");
		System.out.println("REMOVE NEXT: " + a.remove()+ " is removed");
		System.out.println("REMOVE NEXT: " + a.remove()+ " is removed");
		System.out.println(a);
		a.add(10);
		System.out.println(a);
		a.add(11);
		System.out.println(a);
		a.add(12);
		System.out.println(a);
		System.out.println("\nREMOVE NEXT: " + a.remove()+ " is removed");
		//fix
		System.out.println(a);
		a.add(13);
		 //System.err.println("Read: " + a.front + "Write: " + a.count);
		System.out.println(a);
		a.add(14);
		System.out.println(a);
		a.add(15);
		System.out.println(a);
		System.out.println("(Notice that adding 15 caused the array to double in size)\n");
		System.out.println("\nREMOVE NEXT: " + a.remove()+ " is removed");
		System.out.println(a);
	}
}