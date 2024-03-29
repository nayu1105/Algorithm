## 성능
- 실행시간
194ms
- 메모리
19.04Mb

## 문제

어떤 부서의 업무 조직은 완전이진트리 모양이다. 즉, 부서장이 루트이고 부서장 포함 각 직원은 왼쪽과 오른쪽의 부하 직원을 가진다. 부하 직원이 없는 직원을 말단 직원이라고 부른다.



모든 말단 직원은 부서장까지 올라가는 거리가 동일하다. 조직도 트리의 높이는 H이다. 아래는 높이가 1이고 업무가 3개인 조직도를 보여준다.



![image](https://github.com/nayu1105/Algorithm/assets/72187208/32682d5e-b568-4eeb-8da9-a3a5afe92f4f)




업무는 R일 동안 진행된다. 처음에 말단 직원들만 각각 K개의 순서가 정해진 업무를 가지고 있다. 각 업무는 업무 번호가 있다. 각 날짜에 남은 업무가 있는 경우, 말단 직원은 하나의 업무를 처리해서 상사에게 올린다. 다른 직원들도, 대기하는 업무가 있는 경우 업무를 올라온 순서대로 하나 처리해서 상사에게 올린다. 단, 홀수 번째 날짜에는 왼쪽 부하 직원이 올린 업무를, 짝수 번째 날짜에는 오른쪽 부하 직원이 올린 업무를 처리한다.



부서장이 처리한 일은 완료된 것이다. 업무를 올리는 것은 모두 동시에 진행한다. 따라서 그날 올린 업무를 상사가 처리하는 것은 그 다음날에야 가능하다.



부서의 조직과 대기하는 업무들을 입력 받아 처리가 완료된 업무들의 번호의 합을 계산하는 프로그램을 작성하라.

제약조건
1 ≤ H ≤ 10

1 ≤ K ≤ 10

1 ≤ R ≤ 1,000

입력형식
첫 줄에 조직도의 높이 H, 말단에 대기하는 업무의 개수 K, 업무가 진행되는 날짜 수 R이 주어진다.

그 다음 줄부터 각각의 말단 직원에 대해 대기하는 업무가 순서대로 주어진다.

제일 왼쪽의 말단 직원부터 순서대로 주어진다.

출력형식
완료된 업무들의 번호 합을 정수로 출력한다.

입력예제1
```
1 1 1 1 2
```
출력예제1
```
0
```
입력예제2
```
1 3 2 9 3 7 5 11 2
```
출력예제2
```
5
```
## 언어별 시간/메모리

|언어|	시간	|메모리|
|---|---|---|
|C	|1초	|256MB|
|C++	|1초	|256MB|
|Java	|1초	|256MB|
|Python	|1초	|256MB|
|Javascript	|1초	|256MB|
