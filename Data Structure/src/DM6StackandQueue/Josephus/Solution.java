package DM6StackandQueue.Josephus;
class Solution{
    static class Stack{
        Node head, tail;
        class Node{
            int data;
            Node next;
        }
        void insert(int data){
            Node obj = new Node();
            obj.data = data;
            if(head == null){
                head = obj;
                tail = obj;
            }
            else{
                tail.next = obj;
                tail = obj;
            }
            tail.next = head;
        }
        int length(){
            int count = 0;
            if(head != null){
                Node temp = head;
                count = 1;
                while(temp.next != head){
                    temp = temp.next;
                    count++;
                }
            }
            return count;
        }
    }
    public static String Josephus(int a, int b){
        Stack list = new Stack();
        String printString = "";
        for(int i = 0; i < a; i++)
            list.insert(i);
        Stack.Node current = list.head;
        while(list.length() > 1){
            int position = b;
            while(position > 1){
                current = current.next;
                position--;
            }
            if(current == list.head){
            	Stack.Node temp = list.head;
                printString += current.data+" ";
                list.head = list.head.next;
                temp.next = null;
                current = list.head;
                list.tail.next = list.head;
            }
            else{
            	Stack.Node temp = list.head;
                while(temp.next != current)
                    temp = temp.next;
                if(current == list.tail){
                    printString += current.data+" ";
                    temp.next = list.head;
                    list.tail = temp;
                    current = list.head;
                }
                else{
                    printString += current.data+" ";
                    temp.next = current.next;
                    current.next = null;
                    current = temp.next;
                }
            }
        }
        printString += current.data;
        return printString;
    }
}