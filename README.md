### Java-Island

```text
조건
1. m x n 의 격자를 생성 (m, n 모두 1 < m, n < 10001 사이의 정수)
2. i 개의 점을 격자의 좌표에 삽입하는 함수: generateIsland(n) (여러 번 호출 가능하나 중첩 불가능, 중복 불가, n < m x n)
    - 다중호출 (o)
    - 중첩 (x)
    - 중복 (x)
    - return: 실제 할당된 갯수
3. i 개의 만큼 격자의 좌표에 제거하는 함수: removeIsland(n) (남은 섬 만큼만 제거 가능, n < assigned dot count)
    - 다중호출 (o)
    - 중첩 (x)
    - 중복 (x)
    - return: 실제 삭제된 갯수
4. 격자와 섬좌표를 파일에 read/write
```

```text
개선해야 할 사항
1. Application, GridService 코드 개선: Console 입출력, 점 생성, 제거 관련
2. 격자가 더 큰 조건일 경우의 File IO 개선
3. Test Code 추가
```