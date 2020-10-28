package slidingWindow;

import java.util.LinkedList;

public class RecentCounter {
    LinkedList<Integer> slideWindow;

    public RecentCounter() {
        this.slideWindow = new LinkedList<>();
    }

    public int ping(int t) {
        // step 1). append the current call
        this.slideWindow.addLast(t);

        // step 2). invalidate the outdated pings
        while (this.slideWindow.size() > 0) {
            if (this.slideWindow.getFirst() < t - 3000)
                this.slideWindow.removeFirst();
            else
                break;
        }

        return this.slideWindow.size();
    }


}
