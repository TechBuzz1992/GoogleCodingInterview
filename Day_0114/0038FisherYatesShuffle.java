package Day_0114;

/**
 * The Fisher–Yates shuffle is an algorithm for generating a random permutation of a finite sequence—in plain terms, the algorithm shuffles the sequence.
 * The algorithm produces an unbiased permutation: every permutation is equally likely. It takes time proportional to the number of items being shuffled and shuffles them in place.
 *
 * A real life application of Fisher-Yates Shuffle algorithm is to shuffle a deck of cards.
 */

class FisherYatesShuffle {
    public int[] shuffle(int[] input){
        if(input.length<2){
            return input;
        }
        shuffleHelper(input, input.length-1);
        return input;
    }

    private void shuffleHelper(int[] input, int index){
        if(index<1){
            return;
        }
        shuffleHelper(input, index-1);
        int randomIndex = rand(0, index);
        if(randomIndex == index){
            return;
        }

        swap(input, randomIndex, index);
    }

    private int rand(int lower, int higher){
        return lower + (int)(Math.random()*(higher-lower+1));
    }

    private void swap(int[] input, int randomIndex, int index){
        int temp = input[randomIndex];
        input[randomIndex] = input[index];
        input[index] = temp;
    }

    public int[]shuffleIterative(int[] input){
        for(int i = 0;i<input.length;i++){
            int randomIndex = rand(0, i);
            swap(input, randomIndex, i);
        }
        return input;
    }
}
