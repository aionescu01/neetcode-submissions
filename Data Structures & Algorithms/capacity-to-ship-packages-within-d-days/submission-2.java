class Solution {
    public int shipWithinDays(int[] weights, int days) {
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