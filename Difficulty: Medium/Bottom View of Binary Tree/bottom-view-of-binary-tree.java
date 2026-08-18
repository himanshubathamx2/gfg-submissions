

//User function Template for Java

class Pair{
    int ver;
    Node node;
    Pair(int ver, Node node){
        this.ver = ver;
        this.node = node;
    }
}
class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()){
            Pair popped = q.poll();
            int ver = popped.ver;
            Node node = popped.node;
            // if(!map.containsKey(ver))
                map.put(ver, node.data);
            if(node.left != null) q.offer(new Pair(ver-1,node.left));
            if(node.right != null) q.offer(new Pair(ver+1,node.right));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int value : map.values())
            ans.add(value);
        return ans;    
    }
}