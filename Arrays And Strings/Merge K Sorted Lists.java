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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] idx = new ListNode[lists.length];
        for(int i = 0; i < lists.length; i++){
            idx[i] = lists[i];
        }
        ListNode nL = null;
        ListNode head = null;
        ListNode tmp = null;
        while(getMinValIdx(idx) != -1){
            int index = getMinValIdx(idx);
            if(nL == null){
                nL = idx[index];
                head = nL;
                tmp = nL.next;
            }else{
                tmp = idx[index].next;
                nL.next = idx[index];
                nL = nL.next;
            }
            idx[index] = tmp;
        }
        return head;
        
    }
    public int getMinValIdx(ListNode[] idx){
        int minVal = Integer.MAX_VALUE, minIdx = -1;
        for(int i = 0; i < idx.length; i++){
            if(idx[i] != null){
                if(minVal > idx[i].val){
                    minVal = idx[i].val;
                    minIdx = i;
                }
            }
        }
        return minIdx;
    }
}