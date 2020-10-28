package leastInterval;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int maxFrequencyCnt = 0;
        int numWithMaxFrequency = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (maxFrequencyCnt == counter[task - 'A']) {
                numWithMaxFrequency++;
            } else if (maxFrequencyCnt < counter[task - 'A']) {
                maxFrequencyCnt = counter[task - 'A'];
                numWithMaxFrequency = 1;
            }
        }

        int sectorsCount = maxFrequencyCnt - 1;
        int sectorLength = n - (numWithMaxFrequency - 1);
        int emptySlots = sectorsCount * sectorLength;
        int availableTasks = tasks.length - maxFrequencyCnt * numWithMaxFrequency;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
//        System.out.println(s.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(s.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
