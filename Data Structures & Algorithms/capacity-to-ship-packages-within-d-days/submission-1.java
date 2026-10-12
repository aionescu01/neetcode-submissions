class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // left = max(weight)
        // right = sum(weight)
        // res = max(weight)
        //then same as koko bananas, if we can send all in days, and res<capacity res=capacity
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();
        int res = r;

        while(l<=r){
            int c = l + (r-l)/2;
            int d = 1;
            int rc = c;
            for(int i : weights){
                if(rc-i<0){
                    d++;
                    rc=c;
                }
                rc-=i;
            }
            //what is the thing to change l or r?? is it d<=days ->move r=c-1 or d>days l = c+1 ??
            if(d<=days){
                if(c<res){
                    res=c;
                }
                r = c - 1;
            }else{
                l = c + 1;
            }
        }
        return res;

    }
}