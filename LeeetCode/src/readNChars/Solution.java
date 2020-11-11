package readNChars;

public class Solution {
    /**
     * ptr is iteration pointer
     * localBuffer is changed only when previosly quered values finished
     */
    private int localCounter = 0;
    private int readCharsCnt = 0;
    private char[] localBuffer = new char[4];

    public int read(char[] buf, int n) {
        int iterPointer = 0;
        // We need to read maximum n chars
        while (iterPointer < n) {
            if (localCounter == 0) {
                readCharsCnt = read4(localBuffer);
            }

            if (readCharsCnt == 0) break;
            while (iterPointer < n && localCounter < readCharsCnt) {
                buf[iterPointer++] = localBuffer[localCounter++];
            }

            if (localCounter >= readCharsCnt) localCounter = 0;
        }

        return iterPointer;
    }

    private int read4(char[] buf) {
        return 0;
    }
}
