/* class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
} */

class Solution {
    public Node createDLL(int arr[]) {
        int n = arr.length;
        if(n==0)
            return null;
        Node head = new Node(arr[0]);
        Node tmp = head;
        for(int i=1; i<n; i++){
            Node node = new Node(arr[i]);
            tmp.next = node;
            node.prev = tmp;
            tmp = node;
        }
        return head;
        
    }
}