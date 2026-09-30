class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> freqS = new HashMap<>(), freqT = new HashMap<>();
        for(Character c : s.toCharArray()){
            if(freqS.containsKey(c)){
                freqS.put(c, freqS.get(c)+1);
            }else{
                freqS.put(c, 1);
            }
        }
        for(Character c : t.toCharArray()){
            if(freqT.containsKey(c)){
                freqT.put(c, freqT.get(c)+1);
            }else{
                freqT.put(c, 1);
            }
        }
        
        for(Character c : freqS.keySet()){
            if(freqT.containsKey(c)){
                if(!freqS.get(c).equals(freqT.get(c))){
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
}
