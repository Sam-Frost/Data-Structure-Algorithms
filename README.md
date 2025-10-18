The purpose of this repository is to store the code, algorithms, and time/space complexities for the DSA questions I go through in Striver’s TUF A2Z sheet.
It serves as my personal notes/diary.

My target is to complete all the questions by the end of this year and gain a solid grip on them. I will also try to add daily logs here, noting which questions I have completed, the total count for the day, and my overall progress out of 455 questions.

# 📚 Striver's TUF A2Z DSA Tracker

The purpose of this repository is to store the **code**, **algorithms**, and **time/space complexities** for the DSA questions I go through in [Striver’s TUF A2Z Sheet](https://takeuforward.org/).  
It serves as my **personal notes/diary**.

## 🎯 Goal

- **Target Completion Date:** _31st December 2025_
- **Total Questions:** 455
- **Objective:** Gain a solid understanding and mastery over all problems in the sheet.

---

## 📊 Progress Tracker

- **Completed:** `137 / 455`
- **Completion Percentage:** `30%`

---

## 🗓 Notes

### 🔹 Sliding Window & Two Pointers

- A powerful technique for substring/subarray problems.
- Maintains a window with two pointers (`low`, `high`) to track a valid range.
- Window can **expand** (`high++`) or **shrink** (`low++`) depending on the condition.

### 🔹 Frequency Map vs. Index Map

- **Frequency Map:**

  - Stores the count of characters in the current window.
  - When a duplicate appears, shrink the window step by step until valid.

- **Index Map:**
  - Stores the last index of each character.
  - Allows directly jumping the `low` pointer past the duplicate’s previous index.
  - More efficient for longest substring problems.

### 🔹 Prefix Sum

- Commonly used for subarray problems.
- Helps in quickly calculating sums of ranges.
- Often combined with hash maps

### 🔹 Binary Tree

#### 📂 Types of Binary Trees

- **Full Binary Tree** → Every node has either 0 or 2 children.
- **Complete Binary Tree** → All levels are completely filled except possibly the last, which is filled from left to right.
- **Perfect Binary Tree** → All internal nodes have 2 children, and all leaves are at the same level.
- **Balanced Binary Tree** → Height difference between left and right subtrees of any node is at most 1.
- **Degenerate (Skewed) Tree** → Each parent node has only one child (like a linked list).

#### 🌳 DFS Traversals (Depth-First)

- **Inorder Traversal** → Left → Root → Right
- **Preorder Traversal** → Root → Left → Right
- **Postorder Traversal** → Left → Right → Root

#### 🌐 BFS Traversal (Breadth-First)

- **Level Order Traversal** → Visit nodes level by level, from left to right
