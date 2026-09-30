class Solution {
    public int maxArea(int[] heights) {
        if(heights.length==2){
            int m = Math.min(heights[0],heights[1]);
            return m*m;
        }
        int i=0, j=heights.length-1, maxvol = 0;
        while(i<j){
            int vol = (j-i) * Math.min(heights[i],heights[j]);
            if(vol>maxvol){
                maxvol=vol;
            }
            if(heights[i]<heights[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxvol;
    }
}
