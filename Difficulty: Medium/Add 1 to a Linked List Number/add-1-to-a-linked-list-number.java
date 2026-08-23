/* Structure of linked list Node
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution {
    int c = 0;
    public Node addOne(Node head) {
        int c = f(head);
        if(c == 1){
            Node node = new Node(c);
            node.next = head;
            head = node;
        }
        return head;
    }
    
    public int f(Node head){
        if(head == null)
            return 0;
        Node node = head;
        if(node.next != null){
            c = f(node.next);
            int data = node.data + c;
            node.data = data % 10;
            c = data / 10;
            return c;
        }else{
            int data = node.data + 1;
            node.data = data % 10;
            c = data / 10;
            return c;
        }
        
    }
}