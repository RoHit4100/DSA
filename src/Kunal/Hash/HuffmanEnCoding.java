package Kunal.Hash;

import Kunal.Heaps.Heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HuffmanEnCoding {
    HashMap<Character, String> encoder;
    HashMap<String, Character> decoder;

    // we have to do everything in the constructor only
    HuffmanEnCoding(String feeder) throws Exception{
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // now count the frequency of each character present in the string
        for(int i = 0; i < feeder.length(); i++){
            char ch = feeder.charAt(i);
            if(freqMap.containsKey(ch)){
                // get the original value
                int originalValue = freqMap.get(ch);
                // increase the original value and put it into the hashMap
                originalValue++;
                freqMap.put(ch, originalValue);
            }else{
                // if it is the first time encounter
                // then just put it into the hash map with value 1
                freqMap.put(ch, 1);
            }
        }


        // now create the min heap
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        // this line will basically give all the entries present in the frequency map as a set to traverse
        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();

        for(Map.Entry<Character, Integer> entry: entrySet){
            // now for each entry create a new node with key and value of the entry
            Node node= new Node(entry.getKey(), entry.getValue());
            // after creating node insert that into min heap
            minHeap.add(node);
        }
        // now after adding all the nodes into the heap then remove them with the set of two

        while (minHeap.size() != 1){
            // remove first two elements from the minHeap
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            // now create a new node by adding cost of the both removed node
            Node newNode = new Node('\0', first.cost + second.cost);
            // left will first remove node
            newNode.left = first;
            // right will be second removed node
            newNode.right = second;
            // now add new Node into the minHeap
            minHeap.add(newNode);
        }


        // now there will be only one node at the end of above while loop, that will be the root node of the heap
        Node root = minHeap.remove();

        // now form the new encoder and decoder
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        // use the decoder function
        this.initDecoder(root, "");
    }

    private void initDecoder(Node node, String outputSorFar){
        if(node == null){
            return;
        }

        // whenever you are at the leaf node then add outSoFar in the encoder and decoder
        if(node.left == null && node.right == null){
            this.encoder.put(node.data, outputSorFar);
            this.decoder.put(outputSorFar, node.data);
        }

        initDecoder(node.left, outputSorFar + '0');
        // whenever we are going right then add 1 and vise versa for left
        initDecoder(node.right, outputSorFar + '1');
    }


    public String encode(String source){
        String ans = "";

        for(int i = 0; i < source.length(); i++){
            // get the value of each key, which means the character of the given string
            ans = ans + encoder.get(source.charAt(i));
        }

        return ans;
    }

    public String decode(String code){
        // first take the key to get the value out of the hashMap
        String key = "";
        String ans = "";

        for(int i = 0; i < code.length(); i++){
            // now get the key
            key += code.charAt(i);
            // check if current key is the actual key or not
            if(decoder.containsKey(key)){
                // if it is then just add it into the ans
                ans += decoder.get(key);
                // and reset the key to empty
                key = "";
            }
        }

        return ans;
    }

    class Node implements Comparable<Node>{
        Character data;
        int cost; // frequency of each character
        Node left;
        Node right;

        Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }


    public static void main(String[] args) throws Exception {
        String str = "aabaacd";
        HuffmanEnCoding coder = new HuffmanEnCoding(str);
        String codedString = coder.encode(str);
        System.out.println(codedString);
        System.out.println(coder.decode(codedString));
    }
}
