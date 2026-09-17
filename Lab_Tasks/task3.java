import java.util.*;
class Node {
int data;
Node next;
Node(int data) {
this.data= data;
this.next= null;
}
}
public class CircularDeliveryRouteRepair {
public static Node detectCycle(Node head) {
Node slow = head, fast= head;
while(fast!=null && fast.next!=null) {
slow=slow.next;
fast=fast.next.next;
if(slow==fast) return slow;
}
return null;
}
public static void removeCycle(Node head) {
Node meet = detectCycle(head);
if(meet== null) return;
Node start= head;
while(start!=meet) {
start = start.next;
meet= meet.next;
}
Node ptr= start;
while(ptr.next!= start) {
ptr = ptr.next;
}
ptr.next=null;
}
public static Node reverseKGroup(Node head, int k) {
if(head== null || k==1) return head;
Node dummy = new Node(0);
dummy.next= head;
Node prev= dummy, curr= dummy, next=dummy;
int count=0;
while(curr.next != null) {
curr = curr.next;
count++;
}
while(count>=k) {
curr = prev.next;
next= curr.next;
for(int i=1; i<k; i++) {
curr.next= next.next;
next.next= prev.next;
prev.next= next;
next= curr.next;
}
prev=curr;
count-= k;
}
return dummy.next;
}
public static void printList(Node head) {
Node temp = head;
while(temp!= null) {
System.out.print(temp.data+" ");
temp= temp.next;
}
}
public static void main (String[] args) {
Scanner sc= new Scanner(System.in);
int N= sc.nextInt();
int K= sc.nextInt();
Node head= new Node(sc.nextInt());
Node curr= head;
List<Node> nodes= new ArrayList<>();
nodes.add(head);
for(int i=1; i<N; i++) {
Node newNode= new Node(sc.nextInt());
curr.next= newNode;
curr= newNode;
nodes.add(newNode);
}
int cyclePos= sc.nextInt();
if(cyclePos != -1) {
curr.next = nodes.get(cyclePos);
}
removeCycle(head);
head= reverseKGroup(head,K);
printList(head);
sc.close();
}
}
