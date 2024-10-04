import java.util.*;
class Solution{
    public static String frequencySort(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
	    for (char c: s.toCharArray()) {
	    	cnt.put(c, cnt.getOrDefault(c, 0) + 1);
	    }

	    // Build heap
	    List<Character> chars = new ArrayList(cnt.keySet());
		Collections.sort(chars, (a, b) -> (cnt.get(b) - cnt.get(a)));

	    // Build string
	    StringBuilder sb = new StringBuilder();
	    for (Object c : chars) {
			for (int i = 0; i < cnt.get(c); i++) {
				sb.append(c);
			}
		}
	    return sb.toString();
    }
    public static void main(String[] args){
        String s = "anamika";
        System.out.println(frequencySort(s));
    }
}