/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        f(root, new ArrayList<>(), ans);
        return ans;
    }
    
    public void f(Node root, List<Integer> sub, ArrayList<ArrayList<Integer>> ans){
        if(root == null)
            return;
        sub.add(root.data);
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(sub));
            sub.remove(sub.size()-1);
            return;
        }
        f(root.left, sub, ans);
        f(root.right, sub, ans);
        sub.remove(sub.size()-1);
    }
}