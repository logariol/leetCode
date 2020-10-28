package topKFrequentWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PQ {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freqCounter = new HashMap<>();

        for (String w : words) {
            freqCounter.put(w, freqCounter.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<WordFreq> pq = new PriorityQueue<>();


        for (String key : freqCounter.keySet()) {
            pq.add(new WordFreq(key, freqCounter.get(key)));
            if (k < pq.size()) {
                pq.poll();
            }
        }

        List<String> temp = new ArrayList<>();
        while (pq.peek() != null) {
            temp.add(pq.poll().word);
        }

        List<String> ret = new ArrayList<>();

        for (int i = temp.size() - 1; i >= 0; i--) {
            ret.add(temp.get(i));
        }

        return ret;
    }

    static class WordFreq implements Comparable {
        final String word;
        final int freq;

        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o) {
            WordFreq that = (WordFreq) o;

            if (freq != that.freq) return Integer.compare(freq, that.freq);
            else {
                int comp = word.compareTo(that.word);
                if (comp < 0) return 1;
                if (comp > 0) return -1;
                else return comp;
            }
        }
    }

    public static void main(String[] args) {
        PQ s = new PQ();
        System.out.println(s.topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
    }
}
