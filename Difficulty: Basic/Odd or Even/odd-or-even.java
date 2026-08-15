class Solution {
    static boolean isEven(int n) {
        if((n & (1<<0)) != 0 )
            return false;
        return true;
    }
}