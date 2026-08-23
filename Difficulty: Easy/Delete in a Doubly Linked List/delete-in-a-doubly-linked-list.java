/* Structure of a Doubly Linked List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node delPos(Node head, int x) {
        x--;
        if(head == null)
            return null;
        Node tmp = head;
        if(x <= 0){
            head = head.next;
            head.prev = null;
        }else{
            int i = 1;
            while(i < x){// 2
                tmp = tmp.next;
                i++;
            }
            if(tmp.next.next == null){
                tmp.next = null;
            }else{
                tmp.next.next.prev = tmp;
                tmp.next = tmp.next.next;
            }
        }
        return head;
    }
}