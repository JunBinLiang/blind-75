class Solution {
    public int[][] merge(int[][] intervals) {
        /*return Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]).reduce(new LinkedList<int[]>(), (list, in) -> (((list.isEmpty() || list.getLast()[1] < in[0]) && list.add(in)) || ((list.getLast()[1] = Math.max(list.getLast()[1], in[1])) == list.getLast()[1])) ? list : list).toArray(new int[0][]);*/
        System.out.println(Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]));
        return Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]).reduce(new LinkedList<int[]>(), (list, in) -> (((list.isEmpty() || list.getLast()[1] < in[0]) && list.add(in)) || ((list.getLast()[1] = Math.max(list.getLast()[1], in[1])) == list.getLast()[1])) ? list : list, (list, in) -> list).toArray(new int[0][]);
    }
}