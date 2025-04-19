/*
Minimum rotations to unlock a circular lock
Difficulty: EasyAccuracy: 44.01%Submissions: 4K+Points: 2Average Time: 7m
Given a lock made up of N different circular rings. Each ring has 0-9 digit printed on it. There is only one particular code which can open the lock. You can rotate each ring any number of times in either direction. Given the random sequence R and the desired sequence D, find the minimum number of rotations required to open the lock. 

 

Example 1:

Input: R = 222, D = 333
Output: 3
Explaination: Optimal number of rotations for 
getting 3 from 2 is 1. There are three 2 to 3 
transformations. So answer is 1+1+1 = 3.
 

Example 2:

Input: R = 2345, D = 5432
Output: 8
Explaination: The optimal shifts for pairs are: 
(2, 5) = 3, (3, 4) = 1, (4,3) = 1, (5,2) = 3. 
So total shifts = 3+1+1+3 = 8.
 

Your Task:
You do not need to read input or print anything. Your task is to complete the function rotationCount() which takes R and D as input parameters and return the minimum number of rotations required to make R = D.

 

Expected Time Complexity: O(logR)
Expected Auxiliary Space: O(1)

 

Constraints:
1 ≤ R, D < 1018
*/

//code - 
class Solution {
    static int rotationCount(long R, long D) {
        int rotation = 0;
        while (R != 0 || D != 0) {
            int r = (int)(R % 10);
            int d = (int)(D % 10);

            int clockwise = (d - r + 10) % 10;
            int anticlockwise = (r - d + 10) % 10;

            rotation += Math.min(clockwise, anticlockwise);

            R /= 10;
            D /= 10;
        }
        return rotation;
    }
}

/*
### 🔐 Intuition: Minimum Rotations to Unlock a Circular Lock

Each digit (0–9) on the lock is circular — you can rotate clockwise or anticlockwise.

We’re given:
- `r` = current digit (from Random R)
- `d` = desired digit (from Desired D)

#### 🎯 Goal:
Find the **minimum number of rotations** (clockwise or anticlockwise) from `r` to `d`.

---

### ✅ Clockwise Rotation:
To move **forward** from `r` to `d`:

```java
int clockwise = (d - r + 10) % 10;
```

- `(d - r)` gives the direct difference.
- If it's negative (e.g., 2 → 9), we add 10 to wrap around the circle.
- `% 10` ensures we stay within the 0–9 range.

---

### ✅ Anticlockwise Rotation:
To move **backward** from `r` to `d`:

```java
int anticlockwise = (r - d + 10) % 10;
```

- Same idea: difference + wrap + modulo.

---

### 🧠 Final Answer:
Take the minimum of both:
```java
rotation += Math.min(clockwise, anticlockwise);
```

---

### 🔄 Example:
R = 9, D = 2  
- Clockwise: (2 - 9 + 10) % 10 = 3  
- Anticlockwise: (9 - 2 + 10) % 10 = 7  
✔ Minimum = 3 (correct)

---

### ✅ Summary:
| Direction     | Formula                        | Purpose                 |
|---------------|---------------------------------|--------------------------|
| Clockwise     | `(d - r + 10) % 10`             | Forward rotation         |
| Anticlockwise | `(r - d + 10) % 10`             | Backward rotation        |
| Final step    | `Math.min(clockwise, anticlockwise)` | Pick shortest path |

This way, you correctly handle all circular edge cases in a modular and efficient way!

*/
