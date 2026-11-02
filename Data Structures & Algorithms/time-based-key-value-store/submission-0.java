class TimeMap {

    private static class Entry {
        int timestamp;
        String value;
        Entry(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private final Map<String, List<Entry>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        // Timestamps strictly increase, so appending keeps the list sorted
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> list = map.get(key);
        if (list == null) {
            return "";
        }

        int l = 0, r = list.size() - 1;
        String result = "";

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (list.get(m).timestamp <= timestamp) {
                result = list.get(m).value;  // candidate, try to find a later one
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return result;
    }
}