package undergroundSystem;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    static class UndergroundSystem {

        Map<Integer, CheckInInfo> checkIns;
        Map<String, Map<String, Stats>> routeStats;

        public UndergroundSystem() {
            checkIns = new HashMap<>();
            routeStats = new HashMap<>();

        }

        static class Stats {
            double avg;
            int tripsCnt;
        }

        static class CheckInInfo {
            String stationName;
            int time;

            public CheckInInfo(String s, int t) {
                stationName = s;
                time = t;
            }
        }

        public void checkIn(int id, String stationName, int t) {
            if (checkIns.containsKey(id)) return;
            checkIns.put(id, new CheckInInfo(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            if (!checkIns.containsKey(id)) return;
            CheckInInfo chechInInfo = checkIns.get(id);

            calculateStats(chechInInfo, stationName, t);
        }

        private void calculateStats(CheckInInfo info, String stationName, int time) {
            String from = info.stationName;
            double tripLength = time - info.time;

            if (!routeStats.containsKey(from) || !routeStats.get(from).containsKey(stationName)) {
                if (!routeStats.containsKey(from)) routeStats.put(from, new HashMap<>());

                Map<String, Stats> routeS = routeStats.get(from);

                routeS.put(stationName, getFirstStats(tripLength));
                routeStats.put(from, routeS);
            } else {
                Map<String, Stats> routeS = routeStats.get(from);
                Stats stats = routeS.get(stationName);

                double totalTripsTime = stats.avg * stats.tripsCnt;
                stats.tripsCnt++;
                stats.avg = (totalTripsTime + tripLength) / (double) stats.tripsCnt;
                routeS.put(stationName, stats);
            }
        }

        private Stats getFirstStats(double time) {
            Stats s = new Stats();
            s.avg = time;
            s.tripsCnt = 1;
            return s;
        }

        public double getAverageTime(String startStation, String endStation) {
            if (routeStats.get(startStation) != null && routeStats.get(startStation).get(endStation) != null)
                return routeStats.get(startStation).get(endStation).avg;
            return 0.0;
        }
    }
}
