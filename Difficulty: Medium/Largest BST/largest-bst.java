
class NodeValues{
    int maxSize;
    int maxNode;
    int minNode;
    NodeValues(int maxSize, int maxNode, int minNode){
        this.maxSize = maxSize;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }
}


class Solution {
    public int largestBst(Node root) {
        return f(root).maxSize;    
    }
    
    public NodeValues f(Node root){
        if(root == null){
            return new NodeValues(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        NodeValues left = f(root.left);
        NodeValues right = f(root.right);
        
        if(left.maxNode <  root.data && right.minNode > root.data){
            return new NodeValues(1 + left.maxSize + right.maxSize, 
            Math.max(root.data, right.maxNode), Math.min(root.data, left.minNode));    
        }
        return new NodeValues(Math.max(left.maxSize, right.maxSize), Integer.MAX_VALUE, Integer.MIN_VALUE); 
    }
}