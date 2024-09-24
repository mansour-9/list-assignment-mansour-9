package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List <T> list, int n)
    {
        for(int i=0;i<n;i++){
           list.findFirst();
           T temp=list.retrieve();
           int size=0;
           while (!list.last()){
               size++;
               list.findNext();
           }
           for(int j=0;j<size-1;j++) {
               list.findNext();
               list.insert(list.retrieve());
           }
           list.insert(temp);
       }
    }
    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2)
    {
        DoubleLinkedList<T> temp = l1;
        temp.findLast();
        while (temp.retrieve() != null) {
            l2.insert(temp.retrieve());
            temp.findPrevious();

        }
    }
}
