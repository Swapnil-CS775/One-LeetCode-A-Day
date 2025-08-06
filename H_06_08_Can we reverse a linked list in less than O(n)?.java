/*
Can we reverse a linked list in less than O(n)?

📌 Answer (for Interview):
No, we cannot reverse a linked list in less than O(n) time complexity, because:

We must visit every node at least once to rearrange the next pointers.

A linked list does not allow random access, unlike arrays — we must traverse node-by-node.

Even for in-place reversal, we need three pointers:

prev, current, and next,

and iterate through the entire list once.

Hence, O(n) is the best possible time complexity.

In all types of linked lists — singly, doubly, circular singly or doubly — we must traverse every node at least once to reverse the structure.
❌ There is no way to reverse in less than O(n) time.

*/
