import sys
sys.setrecursionlimit(111111)

def dfs(v):
    visited[v] = True
    global result
    cycle.append(v)
    number = arr[v]

    if visited[number]:
        if number in cycle:
            result += cycle[cycle.index(number):]
            # print(result)
        return
    else:
        dfs(number)

T = int(input())


for _ in range(T):
    n = int(input())
    arr = [0] + list(map(int, input().split()))
    visited = [True] + [False] * n
    result = []

    for i in range(1, n + 1):
        if not visited[i]:
            cycle = []
            dfs(i)

    print(n - len(result))


