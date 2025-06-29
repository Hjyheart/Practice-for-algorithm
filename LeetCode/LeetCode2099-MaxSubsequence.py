class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        ans = []
        nums_with_idxs = [(num, idx) for idx, num in enumerate(nums)]

        nums_with_idxs.sort(key=lambda x: x[0], reverse=True)
        ans = nums_with_idxs[:k]
        ans.sort(key=lambda x:x[1])

        return [num for num, _ in ans]
