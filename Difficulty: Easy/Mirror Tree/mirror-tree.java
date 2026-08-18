/* Structure of Binary Tree Node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    void mirror(Node root) {
        invert(root);        
    }
    
       public void invert(Node root){
        if(root == null)
            return;
        Node tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invert(root.left);
        invert(root.right);

    }
}