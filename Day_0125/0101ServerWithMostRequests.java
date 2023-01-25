package Day_0125;

import java.util.*;

class ServerWithMostRequests{
    static class Process {
        int end, server;
        Process(int end, int server) {
            this.end = end;
            this.server = server;
        }
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Queue<Process> minHeap = new PriorityQueue<Process>((p1, p2) -> Integer.compare(p1.end, p2.end));

        TreeSet<Integer> availableServers = new TreeSet();
        for (int server = 0; server < k; server++) {
            availableServers.add(server);
        }
        int requests = arrival.length;
        int[] serversUsed = new int[k];
        int max = Integer.MIN_VALUE;
        for (int request = 0; request < requests; request++) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= arrival[request]) {
                Process process = minHeap.remove();
                availableServers.add(process.server);
            }

            if (availableServers.isEmpty()) continue;
            Integer nextAvailableServer = availableServers.ceiling(request % k);
            if (nextAvailableServer == null) nextAvailableServer = availableServers.first();
            minHeap.offer(new Process(arrival[request] + load[request], nextAvailableServer));
            serversUsed[nextAvailableServer]++;
            max = Math.max(max, serversUsed[nextAvailableServer]);
            availableServers.remove(nextAvailableServer);
        }
        List<Integer> result = new ArrayList();
        for (int server = 0; server < k; server++) {
            if (serversUsed[server] == max) {
                result.add(server);
            }
        }
        return result;
    }
}