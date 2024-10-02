from collections import deque

def bfs(c, r):
    que = deque()
    que.append((c, r))
    visited[r][c] = True
    cnt = 1

    while que:
        x, y = que.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue
            if not visited[ny][nx] and arr[r][c] == arr[ny][nx]: # 하 이색기땜에 개오래걸림;;;;;;;
                visited[ny][nx] = True
                que.append((nx, ny))
            
    return cnt

n = int(input())
dx = [0, 0, 1, -1]
dy = [-1, 1, 0, 0]
visited = [[False] * n for _ in range(n)]
arr = [list(input()) for _ in range(n)]

cnt1 = 0
paint = []
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            paint.append(bfs(j, i))

print(len(paint))
for i in range(n):
    for j in range(n):
        if arr[i][j] == 'G':
            arr[i][j] = 'R'


paint = []
visited = [[False] * n for _ in range(n)]
cnt = 0
for i in range(n):
    for j in range(n):
        if not visited[i][j]:
            paint.append(bfs(j, i))

print(len(paint))