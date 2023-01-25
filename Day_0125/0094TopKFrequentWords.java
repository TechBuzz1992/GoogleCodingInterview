package Day_0125;

import java.util.*;

class TopKFrequentWords{
    public List<String> topKWords(String[] words, int k){
        Map<String, Integer> count = new HashMap<>();
        for(String word : words){
            count.put(word, count.getOrDefault(word, 0)+1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return count.get(o1).equals(count.get(o2))?o2.compareTo(o1) : count.get(o1) - count.get(o2);
            }
        });

        for(String word : count.keySet()){
            minHeap.offer(word);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!minHeap.isEmpty()){
            result.add(minHeap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}