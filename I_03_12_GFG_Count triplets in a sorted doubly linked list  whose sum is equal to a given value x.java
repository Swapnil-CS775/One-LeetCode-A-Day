/*
Count triplets in a sorted doubly linked list
 whose sum is equal to a given value x

 Count triplets in a sorted doubly linked list whose sum is equal to a given value x
Last Updated : 13 Apr, 2023
Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. Count triplets in the list that sum up to a given value x.


Method 1 (Naive Approach): 
Using three nested loops generate all triplets and check whether elements in the triplet sum up to x or not.
*/

//Method 1 (Naive Approach): 
//code - 

public static int findTriplet(Node head,int target){
        int count=0;

        Node ithNode=head;
        //assume LL length is >=3
        if(ithNode.next.next.next==null )
            if((ithNode.data+ithNode.next.data+ithNode.next.next.data)==target) return 1;
            else return 0;

        while (ithNode.next.next!=null){
            int sum=0;
            sum+=ithNode.data;
            Node jthNode=ithNode.next;
            while (jthNode.next!=null){
                sum+=jthNode.data;
                Node kthNode=jthNode.next;
                while (kthNode!=null){
                    sum+=kthNode.data;
                    if(sum==target) count++;
                    sum-=kthNode.data;
                    kthNode= kthNode.next;
                }
                sum-=jthNode.data;
                jthNode=jthNode.next;
            }
            if (sum==target)count++;
            ithNode=ithNode.next;
        }

        return count;
    }


//second approach
public static int findTriplet1(Node head,int target){
        int count=0;
        HashSet<Integer>set=new HashSet<>();
        Node temp=head;
        while (temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }

        for(Node ith=head;ith!=null;ith=ith.next){
            for(Node jth=ith.next;jth!=null;jth=jth.next){
                int sumOfTwo=ith.data+jth.data;
                int rem=target-sumOfTwo;
                if(set.contains(rem) && rem!=ith.data && rem!=jth.data) count++;
            }
        }

        return count/3;
    }


//third optimal approach 
public static int findTriplet2(Node head,int target){
        int count=0;

        Node tail=null;
        Node temp=head;
        while (temp.next!=null) temp=temp.next;
        tail=temp;
        Node curr=head;
        while (curr.next.next!=null){
            Node f=curr.next;
            Node l=tail;
            int d=curr.data;
            int rem=target-d;
            while (f!=l && l.next!=f){
                int sum=0;
                sum=f.data+l.data;
                if(sum==rem){
                    count++;
                    f=f.next;
                    l=l.prev;
                }else if (sum>rem) l=l.prev;
                else f=f.next;
            }
            curr=curr.next;
        }

        return count;
    }



