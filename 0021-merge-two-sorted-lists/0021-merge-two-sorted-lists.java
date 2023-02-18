// Study Java Stream with Blind75 21.Merge Two Sorted Lists

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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*List<Integer> list = new ArrayList<>();
        list.add(1); list.add(2); list.add(3);
        /*list.stream().reduce(0, (a, b) -> {
            System.out.println(a + " "  + b);
            return a + b;
        });*/
        
        //Stream.iterate(l1, t -> t != null, t -> t.next).mapToInt(node -> node.val).boxed().sorted((u, v) -> v - u).forEach(System.out::println);
        
        return Stream.concat(Stream.iterate(l1, t -> t != null, t -> t.next).map(node -> node.val), Stream.iterate(l2, t -> t != null, t -> t.next).map(node -> node.val)).sorted((u, v) -> v - u).
            map(i -> new ListNode(i)).reduce(null, (acc, cur) -> new ListNode(cur.val, acc));
    }
}