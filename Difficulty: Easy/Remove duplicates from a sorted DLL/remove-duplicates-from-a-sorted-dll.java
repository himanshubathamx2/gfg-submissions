
class Solution {
    Node removeDuplicates(Node head) {
        Node dummy = new Node(-1);
        Node curr = dummy;
        int prev = -1;
        Node tmp = head;
        while(tmp != null){
            if(tmp.data != prev){
                curr.next = tmp;
                tmp.prev = curr;
                curr = tmp;
                prev = curr.data;
            }
            tmp = tmp.next;
        }
        curr.next = null;
        return dummy.next;
    }
}