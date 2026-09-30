class Solution {
    public int lastStoneWeight(int[] stones) {
        
        int l = stones.length - 2;
        int r = stones.length - 1;

        List<Integer> st = new ArrayList<>();
        for (int num : stones) {
            st.add(num);
        }

        while(l>=0){
            //st.sort();
            Collections.sort(st);

            int x = st.get(l);
            int y = st.get(r);
            if(x<y){
                st.set(l,y-x);
                st.remove(r);
            }else if(x==y){
                //st.set(l,0);
                st.remove(st.size()-1);
                st.remove(st.size()-1);
                l--;
                r--;
            }
            l--;
            r--;
        }
        if(st.size()>0){
            return st.get(0);
        }else{
            return 0;
        }

    }
}
