package Day_0112;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class T9Keyboard{
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        Map<String, List<String>> mapping = createMapping();
        backtrack(0, digits.toCharArray(), new StringBuilder(), res, mapping, digits.length());
        return res;
    }

    private void backtrack(int index, char[] digits, StringBuilder partialSolution, List<String> solutions, Map<String, List<String>> mapping, int N) {
        if (partialSolution.length() == N) {
            solutions.add(partialSolution.toString());
            return;
        }
        List<String> candidates = mapping.get(Character.toString(digits[index]));
        for (String digit : candidates) {
            partialSolution.append(digit); // makeMove
            backtrack(index + 1, digits, partialSolution, solutions, mapping, N); // recursively call backtrack( ... ) for next index
            partialSolution.setLength(partialSolution.length() - 1);
        }
    }

    private Map<String, List<String>> createMapping() {
        Map<String, List<String>> mapping = new HashMap<>();
        mapping.put("0", new ArrayList<String>(){{add("0");}});
        mapping.put("1", new ArrayList<String>(){{add("1");}});
        mapping.put("2", new ArrayList<String>(){{add("a"); add("b"); add("c");}});
        mapping.put("3", new ArrayList<String>(){{add("d"); add("e"); add("f");}});
        mapping.put("4", new ArrayList<String>(){{add("g"); add("h"); add("i");}});
        mapping.put("5", new ArrayList<String>(){{add("j"); add("k"); add("l");}});
        mapping.put("6", new ArrayList<String>(){{add("m"); add("n"); add("o");}});
        mapping.put("7", new ArrayList<String>(){{add("p"); add("q"); add("r"); add("s");}});
        mapping.put("8", new ArrayList<String>(){{add("t"); add("u"); add("v");}});
        mapping.put("9", new ArrayList<String>(){{add("w"); add("x"); add("y"); add("z"); }});

        return mapping;
    }
}