import java.util.*;

class Solution {

    public int[] sortItems(int n, int m, int[] group,
                           List<List<Integer>> beforeItems) {

        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];

        List<List<Integer>> groupGraph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] groupIndegree = new int[m];

        for (int item = 0; item < n; item++) {

            for (int before : beforeItems.get(item)) {

                itemGraph.get(before).add(item);
                itemIndegree[item]++;

                if (group[before] != group[item]) {
                    groupGraph.get(group[before]).add(group[item]);
                    groupIndegree[group[item]]++;
                }
            }
        }

        List<Integer> itemOrder =
                topologicalSort(itemGraph, itemIndegree);

        if (itemOrder.size() != n) {
            return new int[0];
        }

        List<Integer> groupOrder =
                topologicalSort(groupGraph, groupIndegree);

        if (groupOrder.size() != m) {
            return new int[0];
        }

        List<List<Integer>> itemsInGroup = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            itemsInGroup.add(new ArrayList<>());
        }

        for (int item : itemOrder) {
            itemsInGroup.get(group[item]).add(item);
        }

        int[] result = new int[n];
        int index = 0;

        for (int g : groupOrder) {

            for (int item : itemsInGroup.get(g)) {
                result[index++] = item;
            }
        }

        return result;
    }

    private List<Integer> topologicalSort(
            List<List<Integer>> graph,
            int[] indegree) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();

            order.add(current);

            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return order;
    }
}
