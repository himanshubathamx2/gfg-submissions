class Solution {
    public static void reverseStack(Stack<Integer> st) {
        rev(st);        
    }
    
    public static void rev(Stack<Integer> stack){
        if(stack.isEmpty())
            return;
        int tmp = stack.pop();
        rev(stack);    
        instertAtBottom(stack ,tmp);  
        // stack.push(tmp);
    }
    
    public static void instertAtBottom(Stack<Integer> st, int tmp){
        if(st.isEmpty()){
            st.push(tmp);
            return;
        }
        int tmp2 = st.pop();
        instertAtBottom(st, tmp);
        st.push(tmp2);
    }
    
}
