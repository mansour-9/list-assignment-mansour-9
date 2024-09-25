package com.example.project;

public static <T> void circularLeftShift(DLL<T> list, int n) {
    if (list.empty()) {
        return; 
    }
    int size = 0;
    list.findFirst();
    while (!list.last()) {
        size++;
        list.findNext();
    }
    size++; 
    n = n % size;
    if (n == 0) {
        return; 
    }
    for (int i = 0; i < n; i++) {
        list.findFirst(); 
        T firstElement = list.retrieve(); 
        for (int j = 0; j < size - 1; j++) {
            list.update(list.retrieveNext()); 
            list.findNext();
        }      
        list.update(firstElement);
    }
}
   public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2) {
    if (l1.empty()) 
        return;
    l1.findLast();
    while (true) {
        l2.insert(l1.retrieve());
        if (l1.first()) {
            break;
        }   
        l1.findPrevious();
    }
}


