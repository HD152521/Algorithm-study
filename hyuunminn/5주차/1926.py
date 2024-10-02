from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = []

for i in range(n):
    arr.append(list(map(int, input().split())))

dx = [0, 0, -1, 1]
dy = [1, -1, 0 ,0]


def bfs(r, c):
    que = deque()
    que.append((r, c))
    arr[r][c] = 0
    count = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if arr[nx][ny] == 1:
                arr[nx][ny] = 0
                que.append((nx, ny))
                count += 1
    return count

paint = []
for i in range(n):
    for j in range(m):
        if arr[i][j] == 1:
            paint.append(bfs(i, j))

if len(paint) == 0:
    print(len(paint))
    print(0)
else:
    print(len(paint))
    print(max(paint))
