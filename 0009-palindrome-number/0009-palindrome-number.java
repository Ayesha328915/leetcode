class Solution {
    public boolean isPalindrome(int x) {
        int dup=x;
        int revN=0;
        while(x>0){
            int lastdigit=x%10;
            revN=(revN*10)+lastdigit;
            x=x/10;
        }
        if(dup==revN){
            return true;
        }
        else{
            return false;
        }

        
    }
}