package Day_0125;

import java.util.Comparator;
import java.util.PriorityQueue;

class MergeKSortedLists{
    class ListNode{
        int value;
        ListNode next;

        ListNode(int value){
            this.value = value;
        }
    }

    public ListNode mergeKLists(ListNode[] lists){
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.value - o2.value;
            }
        });

        for(ListNode node : lists){
            if(node!=null){
                queue.offer(node);
            }
        }

        ListNode head = null;
        ListNode prev = new ListNode(-1);

        while(!queue.isEmpty()){
            ListNode minNode = queue.poll();
            if(head == null){
                head = minNode;
            }
            prev.next = minNode;
            prev = prev.next;
            if(minNode.next!=null){
                queue.offer(minNode.next);
            }
        }
        return head;
    }
}