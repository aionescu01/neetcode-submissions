class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Set<Character> sub = new HashSet<>();
        sub.add(s.charAt(0));
        int i=0, j=1, max = 0;
        while(j<s.length()){
            while(sub.contains(s.charAt(j))){
                sub.remove(s.charAt(i));
                i++;
            }
            
            sub.add(s.charAt(j));
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
