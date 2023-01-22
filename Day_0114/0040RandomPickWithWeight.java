package Day_0114;

import java.util.Random;
import java.util.TreeMap;

class RandomPickWithWeight{
    int cnt = 0;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    Random rand = new Random();

    public RandomPickWithWeight(int[] w){
        for(int idx = 0;idx<w.length;idx++){
            cnt += w[idx];
            map.put(cnt, idx);
        }
    }

    public int pickIndex(){
        int key = map.higherKey(rand.nextInt(cnt));
        return map.get(key);
    }

}