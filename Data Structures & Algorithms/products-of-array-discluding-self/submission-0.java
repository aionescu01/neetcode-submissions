class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] p = new int[len];
        int[] s = new int[len];
        p[0]=1;
        for(int i = 1; i<len; i++){
            p[i]=nums[i-1]*p[i-1];
        }

        s[len-1]=1;
        for(int i = len-2; i>=0; i--){
            s[i]=nums[i+1]*s[i+1];
        }

        int[] sol = new int[len];
        for(int i=0; i<len; i++){
            sol[i]=p[i]*s[i];
        }

        return sol;
    }
}  
