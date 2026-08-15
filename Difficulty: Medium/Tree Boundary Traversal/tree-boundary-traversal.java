





//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
	ArrayList <Integer> boundaryTraversal(Node node)
	{
	    ArrayList <Integer> ans = new ArrayList<>();
	    if(node == null)
	        return ans;
	    if(!isLeaf(node)) ans.add(node.data);     
	    addLeft(node.left, ans);
	    addLeaves(node, ans);
	    addRight(node.right, ans);
	    return ans;
	}
	
	public boolean isLeaf(Node node){
	    return node.left==null && node.right==null;
	}
	
	public void addLeft(Node node, ArrayList <Integer> ans ){
	    if(node == null)
	        return;
	    Node tmp = node;      
	    while(!isLeaf(tmp)){
	        ans.add(tmp.data);
	        if(tmp.left != null){
	            tmp = tmp.left;
	        }else if(tmp.right != null){
	            tmp = tmp.right;
	        }
	    }       
	}
	public void addRight(Node node, ArrayList <Integer> ans ){
	    if(node == null)
	        return;
	    Node tmp = node; 
	    Stack<Integer> stack = new Stack<>();
	    while(!isLeaf(tmp)){
	       stack.push(tmp.data);
	        if(tmp.right != null){
	            tmp = tmp.right;
	        }else if(tmp.left != null){
	            tmp = tmp.left;
	        }
	    }    
	    while(!stack.isEmpty()){
	        ans.add(stack.pop());
	    }
	}
	public void addLeaves(Node node, ArrayList <Integer> ans){
	    if(node == null)
	        return;
	    addLeaves(node.left, ans);
	    
	    addLeaves(node.right, ans);
	    	    if(isLeaf(node)) ans.add(node.data);     

	}
}
