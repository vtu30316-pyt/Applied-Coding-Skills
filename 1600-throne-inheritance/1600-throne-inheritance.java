import java.util.*;

class ThroneInheritance {

    String kingName;

    // Stores each person's children
    HashMap<String, List<String>> children;

    // Stores whether a person is dead
    HashSet<String> dead;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;

        children = new HashMap<>();
        dead = new HashSet<>();

        children.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {

        // If parent doesn't have a children list, create one
        children.putIfAbsent(parentName, new ArrayList<>());

        // Add child at the end
        children.get(parentName).add(childName);

        // Create an empty list for the new child
        children.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {

        List<String> result = new ArrayList<>();

        dfs(kingName, result);

        return result;
    }

    private void dfs(String person, List<String> result) {

        // Add person only if they are alive
        if (!dead.contains(person)) {
            result.add(person);
        }

        // Visit all children in birth order
        for (String child : children.get(person)) {
            dfs(child, result);
        }
    }
}