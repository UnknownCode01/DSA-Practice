import java.util.*;

class Pair {
    String f;
    int s;
    Pair(String f, int s){
        this.f = f;
        this.s = s;
    }   
}
class Solution{
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        Queue<Pair> q = new LinkedList<>();
        set.remove(beginWord);
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            String word = q.peek().f;
            int step = q.peek().s;
            q.remove();
            if(word.equals(endWord)){
                return step;
            }
            for(int i=0;i<word.length();i++){
                char[] replacementArray = word.toCharArray();
                for(char c='a';c<='z';c++){
                    replacementArray[i]=c;
                    String replacedString = new String(replacementArray);
                    if(set.contains(replacedString)){
                        set.remove(replacedString);
                        q.add(new Pair(replacedString, step+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList =  Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}