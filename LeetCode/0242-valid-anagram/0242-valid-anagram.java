class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        if(s.length()!=t.length()) return false;

        for(int i=0;i<s.length(); i++){
            count[s.charAt(i)-97]++;
        }

        for(int i=0; i<t.length(); i++){
            if(count[t.charAt(i)-97]==0)return false;
            count[t.charAt(i)-97]--;
        }

        return true;
    }
}