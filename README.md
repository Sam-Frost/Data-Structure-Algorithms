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

- **Completed:** `86 / 455`
- **Completion Percentage:** `19%`

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

---
