class Solution {
    public void sortStack(Stack<Integer> st) {
        sort(st);            
    }
    
    public void sort(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int tmp = stack.pop();
        sort(stack);    
        insert(stack ,tmp);
    }
    
    
    public void insert(Stack<Integer> stack, int tmp){
        if(stack.isEmpty()){
            stack.push(tmp);
            return;
        }
        if(stack.peek() > tmp){
            int tmp2 = stack.pop();
            insert(stack, tmp);
            stack.push(tmp2);
            return;
        }
        stack.push(tmp);
    }
    
}