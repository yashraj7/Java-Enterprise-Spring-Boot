import java.util.*;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>((w1, w2) -> {
            int count1 = wordCount.get(w1);
            int count2 = wordCount.get(w2);
            if (count1 == count2) {
                return w2.compareTo(w1); // Lexicographical order for words with same frequency
            } else {
                return count1 - count2; // Higher frequency words come first
            }
        });

        for (String word : wordCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        Collections.reverse(result); // Reverse the list to get highest frequency words first
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentWords solution = new TopKFrequentWords();
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        int k = 2;
        List<String> topKWords = solution.topKFrequent(words, k);
        System.out.println("Top " + k + " frequent words: " + topKWords);
    }
}
