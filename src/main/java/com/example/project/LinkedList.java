package com.example.project;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> current;
	
    public LinkedList() {
		head = current = null;
	}
	public boolean empty() {
		return head == null;
	}
	public boolean last() {
		return current.next == null;
	}
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T e) {
        current.data = e;
    }
    public void insert(T e) {
        if (empty()) {
            current = head = new Node<T>(e);
        } else {
            Node<T> tmp = current.next;
            current.next = new Node<T>(e);
            current = current.next;
            current.next = tmp;
        }
    }
    public void remove() {
        if (current == head) {
            head = head.next;
        } else {
            Node<T> tmp = head;
            while (tmp.next != current) {
                tmp = tmp.next;
            }
            tmp.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }
    public T mostFrequentElement() {
        int countA=0,countB=0,countC=0,countD=0,countE=0;
        Node<T> temp=head;
        while(temp.next!=null) {
            switch (((char)temp.data)) {
                case 'A':countA++;
                case 'B':countB++;
                case 'C':countC++;
                case 'D':countD++;
                case 'E':countE++;
                default:break;
            }
        }

        if (countB > countA && countB >= countC && countB >= countD && countB >= countE) {
            return (T) Character.valueOf('B');
        } else if (countC > countA && countC > countB && countC >= countD && countC >= countE) {
            return (T) Character.valueOf('C');
        } else if (countA >= countB && countA >= countC && countA >= countD && countA >= countE) {
            return (T) Character.valueOf('A');
        } else if (countD >= countA && countD >= countB && countD >= countC && countD >= countE) {
            return (T) Character.valueOf('D');
        } else {
            return (T) Character.valueOf('E');
        }
    }
}
