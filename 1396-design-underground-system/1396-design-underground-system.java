import java.util.HashMap;

class UndergroundSystem {

    // Stores information about customers who are currently checked in
    HashMap<Integer, String> checkInStation;
    HashMap<Integer, Integer> checkInTime;

    // Stores total travel time and number of trips for each route
    HashMap<String, Double> totalTime;
    HashMap<String, Integer> tripCount;

    public UndergroundSystem() {
        checkInStation = new HashMap<>();
        checkInTime = new HashMap<>();
        totalTime = new HashMap<>();
        tripCount = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInStation.put(id, stationName);
        checkInTime.put(id, t);
    }

    public void checkOut(int id, String stationName, int t) {

        String startStation = checkInStation.get(id);
        int startTime = checkInTime.get(id);

        int travelTime = t - startTime;

        String route = startStation + "#" + stationName;

        totalTime.put(route, totalTime.getOrDefault(route, 0.0) + travelTime);
        tripCount.put(route, tripCount.getOrDefault(route, 0) + 1);

        checkInStation.remove(id);
        checkInTime.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "#" + endStation;

        double total = totalTime.get(route);
        int count = tripCount.get(route);

        return total / count;
    }
}