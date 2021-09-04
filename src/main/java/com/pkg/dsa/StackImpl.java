package com.pkg.dsa;

public class StackImpl {
	int top, arr[], capacity;

	StackImpl() {

		this.top = -1;
		this.capacity = 10;
		this.arr = new int[capacity];

	}

	public boolean isEmpty() {

		if (top == -1) {
			System.out.println("isEmpty :Stack is Empty");
			return true;
		} else {
			System.out.println("isEmpty :Stack is Not Empty");
			return false;
		}
	}

	public boolean isFull() {

		if (top < capacity - 1) {
			System.out.println("isFull : Stack is not Full");
			return false;
		} else {
			System.out.println("isFull : Stack is Full");
			return true;
		}

	}

	public void push(int data) {

		if (isFull()) {
			System.out.println("Push: Stack will OverFlow");
		} else {
			arr[++top] = data;
			System.out.println(data + " pushed into Stack");
			

		}

	}

	public void pop() {

		if (isEmpty()) {
			System.out.println("Pop: Stack Underflow");

		} else {

			int pop_element = arr[top--];
			System.out.println(pop_element + " popped  from  Stack");
		}

	}

	int peek() {
		if (top < 0) {
			System.out.println("Peek: Stack Underflow");
			return 0;
		} else {
			int x = arr[top];
			return x;
		}
	}

	void print() {
		for (int i = top; i > -1; i--) {
			System.out.print("[" + arr[i] + "]");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StackImpl s = new StackImpl();
		s.push(10);
		s.print();
		s.push(20);
		s.print();
		s.push(30);
		s.print();
		s.push(40);
		s.print();
		s.push(50);
		s.print();
		s.push(60);
		s.print();
		s.push(70);
		s.print();
		s.push(80);
		s.print();
		s.push(90);
		s.print();
		s.push(100);
		s.print();
		s.push(110);
		s.print();
		s.pop();
		s.print();

	}
}
