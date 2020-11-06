package analyzeUserWebsite;

import java.util.*;

public class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> visitsByUsers = getVisitsByUsers(username, timestamp, website);
        Map<List<String>, Integer> tipletsVisited = getTripletsForUsers(visitsByUsers);
        List<String> ans = buildMaxTriplets(tipletsVisited);
        return ans;
    }

    static class Visit {
        int timestamp;
        String website;

        public Visit(int timestamp, String website) {
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    private List<String> buildMaxTriplets(Map<List<String>, Integer> tipletsVisited) {
        int max = 0;
        for (int val : tipletsVisited.values()) {
            max = Math.max(max, val);
        }

        List<String> ans = new ArrayList<>();
        for (List<String> triplet : tipletsVisited.keySet()) {
            if (tipletsVisited.get(triplet) == max) {
                if (ans.size() == 0) ans.addAll(triplet);
                else {
                    for (int i = 0; i < 3; i++) {
                        if (triplet.get(i).compareTo(ans.get(i)) > 0) break;
                        if (triplet.get(i).compareTo(ans.get(i)) < 0) {
                            ans.clear();
                            ans.addAll(triplet);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private Map<List<String>, Integer> getTripletsForUsers(Map<String, List<Visit>> visitsByUsers) {
        Map<List<String>, Integer> ans = new HashMap<>();
        for (String user : visitsByUsers.keySet()) {
            List<Visit> site = visitsByUsers.get(user);
            Set<String> set = new HashSet<>();

            for (int i = 0; i < site.size(); i++) {
                for (int j = i + 1; j < site.size(); j++) {
                    for (int k = j + 1; k < site.size(); k++) {
                        String str = site.get(i).website + " " + site.get(j).website + " " + site.get(k).website;
                        if (!set.contains(str)) {
                            List<String> triple = Arrays.asList(site.get(i).website, site.get(j).website, site.get(k).website);
                            ans.put(triple, ans.getOrDefault(triple, 0) + 1);
                            set.add(str);
                        }

                    }
                }
            }
        }


        return ans;
    }

    private Map<String, List<Visit>> getVisitsByUsers(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> ans = new HashMap<>();

        for (int i = 0; i < username.length; i++) {
            ans.putIfAbsent(username[i], new ArrayList<>());
            ans.get(username[i]).add(new Visit(timestamp[i], website[i]));
        }

        for (List<Visit> v : ans.values()) {
            v.sort(Comparator.comparingInt(o -> o.timestamp));
        }
        return ans;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] timestamps = new int[]{527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930};
        String[] usernames = new String[]{"h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq"};
        String[] websites = new String[]{"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi", "yljmntrclw", "hibympufi", "yljmntrclw"};

//        String[] usernames = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
//        String[] websited = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
//        int[] timestamps = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(s.mostVisitedPattern(usernames, timestamps, websites));

        System.out.println(s.mostVisitedPattern(usernames, timestamps, websites));

    }
}
