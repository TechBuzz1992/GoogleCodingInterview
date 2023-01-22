package Day_0114;

class ReservoirSampling{
    public int[] selectKSamples(int[] stream, int k){
        int[] reservoir = new int[k];
        int index;
        for(index = 0;index<k;index++){
            reservoir[index] = stream[index];
        }
        for(index = k;index<stream.length;index++){
            int randomIndex = rand(0, index);
            if(randomIndex<k){
                reservoir[randomIndex] = stream[index];
            }
        }
        return reservoir;
    }

    private int rand(int lower, int higher){
        return lower + (int)(Math.random()*(higher-lower+1));
    }
}