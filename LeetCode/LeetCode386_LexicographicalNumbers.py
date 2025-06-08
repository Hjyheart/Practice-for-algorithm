class Solution:
    def lexicalOrder(self, n: int) -> list[int]:
        result = []
        def generate(num):
            if num > n:
                return []
            sub = [num]
            if num * 10 <= n:
                sub += generate(num * 10)
            if num % 10 == 0:
                for i in range(1, 10):
                    sub += generate(num + i)
            return sub

        for i in range(1, 10):
            result += generate(i)
        return result

if __name__ == '__main__':
    s = Solution()
    print(s.lexicalOrder(25))
    print(s.lexicalOrder(150))