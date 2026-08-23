
class Solution {
    public Node segregate(Node head) {
        Node dummyZero = new Node(-1);
        Node dummyOne = new Node(-1);
        Node dummyTwo = new Node(-1);
        Node currZero = dummyZero;
        Node currOne = dummyOne;
        Node currTwo = dummyTwo;
        
        Node tmp = head;
        
        while(tmp != null){
            if(tmp.data == 0){
                currZero.next = tmp;
                currZero = tmp;
            }else if(tmp.data == 1){
                currOne.next = tmp;
                currOne = tmp;
            }else{
                currTwo.next = tmp;
                currTwo = tmp;
            }
            tmp = tmp.next;
        }
        
        currZero.next = dummyOne.next != null ? dummyOne.next : dummyTwo.next;
        currOne.next = dummyTwo.next;
        currTwo.next = null;
        return dummyZero.next;
    }
}