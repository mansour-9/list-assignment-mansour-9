package com.example.project;
public class ListTester {

    public static <T> void circularLeftShift(LinkedList<T> list, int n) {
        if (list.empty() || n <= 0) return;

        list.findFirst();
        int length = 1;
        while (!list.last()) {
            list.findNext();
            length++;
        }

        n = n % length;
        if (n == 0) return;

        for (int i = 0; i < n; i++) {
            list.findFirst();
            T elem = list.retrieve();
            list.remove();

            list.findFirst();
            while (!list.last()) {
                list.findNext();
            }

            list.insert(elem);
        }
    }

    public static <T> void reverseCopy(DLL<T> list1, DLL<T> list2) {
        DLLNode<T> temp = list1.head;

        // First, find the last node in list1
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }


        while (temp != null) {
            list2.insert(temp.data);
            temp = temp.previous;
        }
    }



}




