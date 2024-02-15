# [392. Is Subsequence](https://leetcode.com/problems/is-subsequence/description/?envType=daily-question&envId=2024-02-15)

- Easy

Given two strings `s` and `t`, return `true` _if `s` is a subsequence of `t`, or `false` otherwise._

A **subsequence** of a string is a new string that is formed from the original string by deleting some (can be none) of
the characters without disturbing the relative positions of the remaining characters. (i.e., `"ace"` is a subsequence
of `"abcde"` while `"aec"` is not).

<br><br>
**Example 1:** \
**Input:** `s = "abc", t = "ahbgdc"` \
**Output:** `true`

**Example 2:** \
**Input:** `s = "axc", t = "ahbgdc"` \
**Output:** `false` \

<br><br>
**Constraints:**

- `0 <= s.length <= 100`
- `0 <= t.length <= 104`
- `s` and `t` consist only of lowercase English letters.