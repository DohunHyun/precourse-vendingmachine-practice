# 미션 - 자판기


## 기능 요구사항
반환되는 동전이 최소한이 되는 자판기 구현.

- 자판기가 보유하고 있는 금액으로 동전을 무작위로 생성한다.
- 잔돈을 줄땐 최소 개수로
- 지폐를 잔돈으로 반환하지 않는다.
- 상품명, 가격, 수량을 입력해서 상품 추가 가능
  - 상품 가격은 100원부터, 10원으로 나누어 떨어져야함
- 사용자가 투입한 금액으로 상품 구매
- 남은 금액이 상품의 최저 가격보다 적거나, 상품이 소진되면 잔돈을 돌려준다.
- 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
  - 반환되지 않은 금액은 자판기에 남는다.
- 사용자의 입력이 잘못된 경우 에러메세지 출력 후 해당부분부터 다시 입력받는다.


### 입출력 요구사항

#### 입력
- 상품명, 가격, 수량은 쉼표로, 개별 상품은 대괄호로 묶어 세미콜론으로 구분.
[콜라,1500,20];[사이다,1000,10]

#### 출력
자판기가 보유한 동전
500원 - 0개
100원 - 4개
50원 - 1개
10원 - 0개

잔돈은 반환된 동전만 출력한다.
100원 - 4개
50원 - 1개

예외상황 시 에러문구 출력.


### 클래스 분리
- Coin enum, 
  - 500, 100, 50, 10
  - 인자 amount. 금액.
- Item 상품
  - name, price, amount
  - 상품가격은 10원단위로 떨어져야함
- VendingMachine 자판기
  - 보유 Coin, 보유 Item, 반환할 돈
  - 반환할 돈을 돌려줄 수 있는 판단.
- Customer 사용자
  - 투입금액,
- ProgramManager
  - 전반적인 프로그램 진행
    - 자판기 보유금액 설정
    - 동전 개수 랜덤 설정
    - 상품 입력
    - 투입 금액
    - 상품 구매 반복
    - 잔돈 반환
- InputView, OutputView