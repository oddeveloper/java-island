### Java-Island

##### 구현조건

1. m x n 의 격자를 생성
   - m, n 모두 1 < m, n < 10001 사이의 정수
2. i 개의 점을 격자의 좌표에 삽입하는 함수: generateIsland(n)
   - n < m x n
   - 다중호출 (o)
   - 중첩 (x)
   - 중복 (x)
   - return: 실제 할당된 갯수
3. i 개의 만큼 격자의 좌표에 제거하는 함수: removeIsland(n)
   - n < assigned dot count
   - 다중호출 (o)
   - return: 실제 삭제된 갯수
4. 격자와 섬좌표를 파일에 read/write


##### 개선할 사항

1. Application, GridService 코드부 개선: Console 입출력, 점 생성, 제거 관련, etc..
2. 격자가 더 큰 조건일 경우의 File IO 개선 고려
3. Junit 테스트코 추가
