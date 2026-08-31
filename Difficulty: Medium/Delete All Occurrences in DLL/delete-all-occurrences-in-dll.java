class Solution {
    static Node deleteAllOccurOfX(Node head, int x) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        Node tmp = head;
        while(tmp != null){
            if(tmp.data != x){
                curr.next = tmp;
                tmp.prev = curr;
                curr = tmp;
            }
            tmp = tmp.next;
        }  
        curr.next = null;
        return dummy.next;
    }
}