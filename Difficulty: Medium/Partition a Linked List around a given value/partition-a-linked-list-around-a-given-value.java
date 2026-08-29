



// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node node, int x) {
       Node dummyLesser = new Node(-1);
       Node lesser = dummyLesser;
       Node dummyGreater = new Node(-1);
       Node greater = dummyGreater;
       Node dummyEqual = new Node(-1);
       Node equal = dummyEqual;
       
       Node tmp = node;
      
       while(tmp != null){
           if(tmp.data < x){
               lesser.next = tmp;
               lesser = tmp;
           }else if(tmp.data > x){
               greater.next = tmp;
               greater = tmp;
           }else if(tmp.data == x){
               equal.next = tmp;
               equal = tmp;
           }
           tmp = tmp.next;
       }
       
  
     
        lesser.next = dummyEqual.next != null ? dummyEqual.next : dummyGreater.next;
        equal.next = dummyGreater.next;
    
        // Important: Terminate the greater list to avoid cycles
        greater.next = null;
    
        return dummyLesser.next;    
    }
}