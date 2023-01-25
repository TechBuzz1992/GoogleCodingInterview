package Day_0125;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ReorganizeString{
    public String reorganizeString(String str){
        int strLength = str.length();
        Map<Character,Integer> count = new HashMap<>();
        for(char c : str.toCharArray()){
            count.put(c, count.getOrDefault(c, 0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
                (a,b) -> Integer.compare(b.getValue(), a.getValue())
        );
        for(Map.Entry<Character, Integer> entry : count.entrySet()){
            heap.offer(entry);
        }
        if(heap.peek().getValue() > (strLength+1)/2){
            return "";
        }
        char[] result = new char[strLength];
        int pointer = 0;
        while(!heap.isEmpty()){
            Map.Entry<Character, Integer> entry = heap.poll();
            for(int i = 0;i<entry.getValue();i++){
                result[pointer] = entry.getKey();
                pointer+=2;
                if(pointer>strLength){
                    pointer = 1;
                }
            }
        }
        return new String(result);
    }
}