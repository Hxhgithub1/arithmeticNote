

public class linknode {
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    //反转链表
    //核心思想是设置三个指针pre，curr,next,先把curr连上pre，然后把curr和pre都后移一格，next在每次循环开始时标记下一个节点
    public static Node reverse(Node list){
        Node curr = list;
        Node pre =null;
        while (curr!=null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        return pre;
    }
    //    链表中环的检测:使用快慢指针遍历链表如果重合则有环，注意链表中有0,1,2个元素的情况
    public static boolean checkCircle(Node list){
        if (list==null) return false;
        Node fast = list.next;
        Node slow = list;
        while (fast!=null&&fast.next!=null){
            if (fast==slow)return true;
            slow=slow.next;
            fast=fast.next.next;
        }
        return false;
    }
    //    两个有序的链表合并:两个指针分别指向两个链表，判断两个指针的值大小，小的插入新链表，并将该条链表的指针后移以为继续比较，直至一条链表为空，将另一条链表剩下的之加入
    public static Node twoListMerge(Node l1,Node l2){
        Node newList = new Node(0, null);
        Node p =newList;
        while (l1!=null&&l2!=null){
            if (l1.data<l2.data){
                p.next = l1;
                l1=l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1==null){p.next = l2;}
        if(l2==null){p.next = l1;}
        return newList.next;
    }
    //    删除链表倒数第 n 个结点:两个指针开始时指向表头,一个pre指针为null，将其中一个指针向前移动k-1个时，另一个指针开始移动，直至第一个指针移到表尾，则删除第二个指针所指的节点既可
    public static Node removeNNode(Node list,int k){
        if (list==null) return list;
        Node fast = list;
        Node slow = list;
        Node pre = null;
        for (int i = 0; i <k-1; i++) {
            //链表长度小于指定的k返回链表
            if (fast.next==null)return list;
            fast = fast.next;
        }
        //链表长度等于指定的k，返回list.next
        if (fast.next==null)return list.next;
        while (fast.next!=null){
            pre = slow;
            fast = fast.next;
            slow = slow.next;
        }
        pre.next = pre.next.next;
        return list;
    }
    //    求链表的中间结点
    public static Node medNode(Node list){
        if (list==null)return list;
        Node fast = list;
        Node slow = list;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    public static Node creatList(int[] list){
        Node head = new Node(list[0],null);
        Node curr = head;
        for (int i = 1; i < list.length; i++) {
            Node next = new Node(list[i],null);
            curr.next = next;
            curr = next;
        }
        return  head;
    }
    public static void printList(Node list){
        Node curr = list;
        StringBuilder str= new StringBuilder();
        while (curr!=null){
            str.append(curr.data).append(" ");
            curr=curr.next;
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        int[] list ={1,2,2,2,1};
        int[] list1 ={1,3,5,7,9};
        int[] list11 ={2,4,6,8,10};
        int[] list2 ={-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5,-1};

        Node node = creatList(list1);
        Node node1 = creatList(list11);


        printList(removeNNode(creatList(list1),5));
    }
}


