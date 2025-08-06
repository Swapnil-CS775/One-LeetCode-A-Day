/*

✅ Why Quicksort is Preferred for Arrays
Quicksort:

Works in-place on arrays → no extra memory needed.

Has excellent cache performance due to sequential memory access.

Partitioning is fast because array elements are accessible by index → arr[i] is O(1).

⚙️ Key Points:
| Property        | Explanation                                                                         |
| --------------- | ----------------------------------------------------------------------------------- |
| Random Access   | Arrays allow O(1) access → ideal for partitioning.                                  |
| In-place        | Quicksort uses constant space (no need for auxiliary array).                        |
| Cache Friendly  | Accessing consecutive array indices leverages CPU cache.                            |
| Average Time    | O(n log n), but with small constants.                                               |
| Worst-case Time | O(n²), but with good pivot strategies (e.g., random/median-of-three), this is rare. |


✅ Why Merge Sort is Preferred for Linked Lists
Merge sort:

Doesn’t need random access → perfect for linked lists.

Can be implemented with O(1) extra space (unlike arrays, which need O(n) temp array).

Splitting a list in half and merging sorted halves is easy with pointer manipulation.

⚙️ Key Points:
| Property             | Explanation                                                          |
| -------------------- | -------------------------------------------------------------------- |
| No Random Access     | Linked lists don’t support indexing → quicksort is inefficient here. |
| Stable & Predictable | Merge sort has guaranteed O(n log n) time.                           |
| In-place Merge       | Possible with pointer tricks → minimal extra space.                  |
| Easy to Split        | Fast and slow pointer can divide the list in O(n).                   |


🚫 Why Quicksort is Not Preferred for Linked Lists:
Needs random access to do partitioning (like swapping around a pivot).

Swapping nodes is costly in linked lists (unlike arrays where it's O(1)).

Partitioning in linked lists without auxiliary arrays is tricky and inefficient.

🚫 Why Merge Sort is Not Preferred for Arrays:
Needs extra memory (O(n) space) for the temporary merged array.

Poor cache performance due to non-local memory access.

Slower in practice than quicksort, even though both are O(n log n) on average.



*/
