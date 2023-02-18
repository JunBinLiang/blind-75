/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Study Java Stream with Blind75 23.Merge k Sorted Lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        /*List<Integer> list = new ArrayList<>();
        list.add(0); list.add(1);
        list.stream().map(i -> new ListNode(i)).forEach(n -> {
            System.out.println(n.val);
        });*/
        
        return IntStream.range(0, lists.length).mapToObj(i -> Stream.iterate(lists[i], t -> t != null, t -> t.next).map(node -> node.val).collect(Collectors.toList())).flatMap(l -> l.stream()).sorted((u, v) -> v - u).map(i -> new ListNode(i)).reduce(null, (acc, cur) -> new ListNode(cur.val, acc));       
    }
}