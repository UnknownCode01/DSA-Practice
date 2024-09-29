import java.util.*;
class Solution{
    static class HashMap<K,V>{  //generic
        private class Node{
            K key;
            V value;
            Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        private int n;  //Nodes
        private int N;  //Array size orno of buckets
        private double threshold = 2.0;  
        private LinkedList<Node>[] buckets;
        @SuppressWarnings("unchecked")
        HashMap(){
            this.n=0;
            this.N=4;
            this.buckets = new LinkedList[N];
            for(int i=0;i<N;i++){
                this.buckets[i]=new LinkedList<>();
            }
        }
        private int hashFunction(K key){
            int hc = key.hashCode();
            return Math.abs(hc)%N;
        }
        private int searchInLL(K key, int bi){
            LinkedList<Node> ll = buckets[bi];
            int di=0;
            for(Node x:ll){
                if(x.key==key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node>[] oldBuckets=buckets;
            N*=2;
            buckets=new LinkedList[N];
            for(int i=0;i<N;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldBuckets.length;i++){
                LinkedList<Node> ll = oldBuckets[i];
                for(int j=0;j<ll.size();j++){
                    Node x = ll.remove();
                    put(x.key,x.value);
                }
            }
        }
        public void put(K key, V value){
            int bi = hashFunction(key);     //bucket index
            int di = searchInLL(key,bi);    //data index
            if(di!=-1){
                Node x = buckets[bi].get(di);
                x.value=value;
            }else{
                buckets[bi].add(new Node(key,value));
                n++;
            }
            //check if array or buckets need increment
            double lambda = (double)n/N;
            if(lambda>threshold){
                rehash();
            }
        }
        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di==-1){
                return false;
            }else{
                return true;
            }
        }
        public V remove(K key){
            int bi = hashFunction(key);     
            int di = searchInLL(key,bi);    
            if(di!=-1){
                Node x = buckets[bi].remove(di);
                n--;
                return x.value;
            }else{
                return null;
            }
        }
        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key,bi);
            if(di!=-1){
                Node x = buckets[bi].get(di);
                return x.value;
            }else{
                return null;
            }
        }
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll = buckets[i];
                for(Node x:ll){
                    keys.add(x.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        System.out.println(hm.isEmpty());
        hm.put("India",100);
        hm.put("US",99);
        hm.put("Russia",98);
        ArrayList<String> keys = hm.keySet();
        for(String str:keys){
            System.out.print(str+" ");
        }
        System.out.println("\n"+hm.containsKey("India"));
        int x = hm.get("India");
        System.out.println(x);
        System.out.println(hm.remove("US"));
        System.out.println(hm.remove("US"));
        System.out.println(hm.containsKey("US"));
        System.out.println(hm.isEmpty());

    }
}