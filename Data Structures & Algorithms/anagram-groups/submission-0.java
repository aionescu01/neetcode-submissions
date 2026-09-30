class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sol = new HashMap<>();
        for(String s: strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(!sol.containsKey(key)){
                sol.put(key,new ArrayList<String>());
            }
            sol.get(key).add(s);
        }
        return new ArrayList<>(sol.values());
    }
}
