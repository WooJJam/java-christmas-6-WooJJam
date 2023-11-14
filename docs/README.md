# 미션 - 크리스마스 프로모션
## 파일 구조
```agsl
|── src
   ├── main
   │   └── java
   │       └── christmas
   │           ├── Application.java
   │           ├── constant
   │           │   ├── DateConstant.java
   │           │   ├── EventConstant.java
   │           │   ├── ExceptionMessage.java
   │           │   ├── MenuConstant.java
   │           │   ├── OrderConstant.java
   │           │   ├── ViewConstant.java
   │           │   └── VisitConstant.java
   │           ├── controller
   │           │   ├── DateController.java
   │           │   ├── EventController.java
   │           │   ├── OrderController.java
   │           │   └── PromotionController.java
   │           ├── exception
   │           │   ├── OrderException.java
   │           │   ├── VisitException.java
   │           │   └── message
   │           │       ├── OrderExceptionMessage.java
   │           │       └── VisitExceptionMessage.java
   │           ├── model
   │           │   ├── date
   │           │   │   ├── Visit.java
   │           │   │   └── Week.java
   │           │   ├── event
   │           │   │   ├── Badge.java
   │           │   │   ├── ChristmasDiscount.java
   │           │   │   ├── Discount.java
   │           │   │   ├── GiftDiscount.java
   │           │   │   ├── SpecialDiscount.java
   │           │   │   └── WeekOfDayDiscount.java
   │           │   ├── menu
   │           │   │   ├── Category.java
   │           │   │   └── Menu.java
   │           │   └── order
   │           │       ├── Order.java
   │           │       └── OrderItem.java
   │           ├── service
   │           │   ├── BadgeService.java
   │           │   ├── DateService.java
   │           │   ├── DiscountService.java
   │           │   └── OrderService.java
   │           ├── util
   │           │   └── OrderItemParserUtil.java
   │           ├── validator
   │           │   ├── OrderItemValidate.java
   │           │   └── VisitValidate.java
   │           └── view
   │               ├── InputView.java
   │               ├── OutputView.java
   │               └── message
   │                   ├── InputViewMessage.java
   │                   └── OutputMessage.java
   └── test
       └── java
           └── christmas
               ├── ApplicationTest.java
               └── model
                   ├── OrderTest.java
                   ├── VisitTest.java
                   └── event
                       ├── ChristmasDiscountTest.java
                       ├── GiftDiscountTest.java
                       ├── SpecialDiscountTest.java
                       └── WeekOfDayDiscountTest.java

```
##  📒 구현 기능 목록
#### 1. 방문 날짜를 입력받는다.
```agsl 
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
```
- [x] 해당 날짜가 주말인지 구한다. (주말: 금요일, 토요일) ```Visit#determineDayOfWeek()```
- [x] 해당 날짜가 평일인지 구한다. (평일: 일요일 ~ 목요일) ```Visit#determineDayOfWeek()```
- [x] 예외 사항
  - [x] 범위를 초과하는 경우 ```VisitValidate#validateRange()```
  - [x] 정수가 아닌 문자를 입력하는 경우 ```VisitValidate#validateNumeric()```

#### 2. 주문할 메뉴와 개수를 입력받는다.
```agsl
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
```
- [x] 문자열을 파싱하여 메뉴, 가격을 저장한다. ```Order#addOrder()```
- [x] 주문한 메뉴들의 총 갯수를 구한다. ```Order#calculateOrderAmount()```
- [x] 입력한 메뉴와 개수를 출력한다. ```OutputView#printMenuList()```
```agsl
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
``` 
- [x] 예외처리
  - [x] 주문한 메뉴들의 갯수가 20개를 초과한 경우 ```OrderItemValidate#validateMenuCount()```
  - [x] 주문한 메뉴가 없는 경우 ```OrderItemValidate#validateOrderItemName()```
  - [x] 음료만 주문하는 경우 ```OrderItemValidate#validateOnlyBeverageOrdered()```
  - [x] 형식이 올바르지 않은 경우 ```OrderItemValidate#validateOrderFormat()```
  - [x] 중복된 메뉴를 주문하는 경우 ```OrderItemValidate#validateDuplicate()```

#### 3. 할인 이벤트를 적용한다.
- [x] 주문 금액이 10,000원 미만일 경우 할인 이벤트를 적용하지 않고 없음을 출력한다. ```OutputView#printOrderAmount(order)```
- [x] 크리스마스 디데이 이벤트 ```ChristmasDiscount```
  - [x] 1,000원으로 시작하여 날이 다가올 수록 할인 금액이 100원씩 증가한다 ```ChristmasDiscount#applyDiscount()```
- [x] 평일 할인 이벤트 ```WeekOfDayDiscount```
  - [x] 디저트 메뉴 1개당 2,023원 할인한다. ```WeekOfDayDiscount#discountPolicy()```
- [x] 주말 할인 이벤트 ```WeekOfDayDiscount```
  - [x] 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인한다. ```WeekOfDayDiscount#discountPolicy()```
- [x] 특별 이벤트 ```SpecialDiscount```
  - [x] 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인 ```SpecialDiscount#applyDiscount()```

#### 4. 증정 이벤트를 적용한다.
- [X] 할인 전 총 주문 금액이 120,000원 이상인지 확인한다. ```GiftDiscount#applyDiscount()```
  - [x] 이상이면 샴페인을 지급하고 가격을 산정한다. ```GiftDiscount#applyDiscount()```

#### 5. 12월 이벤트 배지를 부여한다.
- [x] 총 혜택 금액을 산정한다. ```DiscountService#calculateTotalDiscountAmount```
  - [x] 5 천원 이상: 별 ```Badge```
  - [x] 1 만원 이상: 트리 ```Badge```
  - [x] 2 만원 이상: 산타 ```Badge```


#### 6. 이벤트 내역을 출력한다.
- [x] 증정 메뉴를 출력한다 ```OutputView#printGiftMenu```
- [x] 혜택 내역과 금액을 출력한다.  ```OutputView#printBenefitsHistory()```
  - [x] 증정 메뉴가 없다면 없음을 출력한다. ```OutputView#printLowOrderAmount()```
  - [x] 이벤트에 해당하지 않으면 출력하지 않는다. ```OutputView#printBenefitsHistory()```
  
### 7. 최종 금액을 출력한다.
- [x] 할인 혜택을 정용한 최종 금액을 출력한다. ```OutputView#printTotalBenefitAmount()```

## 📝기능 요구 사항
#### 메뉴
```
<애피타이저>
양송이수프(6,000), 타파스(5,500), 시저샐러드(8,000)

<메인>
티본스테이크(55,000), 바비큐립(54,000), 해산물파스타(35,000), 크리스마스파스타(25,000)

<디저트>
초코케이크(15,000), 아이스크림(5,000)

<음료>
제로콜라(3,000), 레드와인(60,000), 샴페인(25,000)
```

#### 이벤트 목표
1. 중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것
2. 올해 12월에 지난 5년 중 최고의 판매 금액을 달성
3. 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참여하는 것

#### 12월 이벤트 계획
- 크리스마스 디데이 할인
  - 이벤트 기간: 2023.12.1 ~ 2023.12.25
  - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  - 총주문 금액에서 해당 금액만큼 할인  
    (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
- 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
- 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
- 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
- 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용
#### 혜택 금액에 따른 12월 이벤트 배지 부여

- 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다. 이 배지는 2024 새해 이벤트에서 활용할 예정입니다.
  배지에 따라 새해 이벤트 참여 시, 각각 다른 새해 선물을 증정할 예정입니다.
  - 5천 원 이상: 별
  - 1만 원 이상: 트리
  - 2만 원 이상: 산타

#### 고객에게 안내할 이벤트 주의 사항

- 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
- 음료만 주문 시, 주문할 수 없습니다.
- 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.  
  (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

#### '12월 이벤트 플래너' 개발 요청 사항

- 고객들이 식당에 방문할 날짜와 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주기를 기대합니다.
- 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
  - 방문할 날짜는 1 이상 31 이하의 숫자로만 입력받아 주세요.
  - 1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
  - 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
  - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.
- 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
- 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- 증정 메뉴
  - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.
- 혜택 내역
  - 고객에게 적용된 이벤트 내역만 보여 주세요.
  - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
  - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.
- 이벤트 배지
  - 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.
- 적용된 이벤트가 하나도 없는 경우는 아래 예시를 참고해 주세요.
  <12월 이벤트 배지>
  산타
```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
26 
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
타파스-1,제로콜라-1 
12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
타파스 1개
제로콜라 1개

<할인 전 총주문 금액>
8,500원
 
<증정 메뉴>
없음
 
<혜택 내역>
없음
 
<총혜택 금액>
0원
 
<할인 후 예상 결제 금액>
8,500원
 
<12월 이벤트 배지>
없음
```

#### 기대하는 '12월 이벤트 플래너'의 예시 모습

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
## 📌 프로그래밍 요구 사항
#### 1. JDK 17 버전에서 실행 가능해야 한다. JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.
#### 2. 프로그램 실행의 시작점은 Application의 main()이다.
#### 3. build.gradle 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
#### 4. Java 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
#### 5. 프로그램 종료 시 System.exit()를 호출하지 않는다.
#### 6. 프로그램 구현이 완료되면 ApplicationTest의 모든 테스트가 성공해야 한다. 테스트가 실패할 경우 0점 처리한다.
#### 7. 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
#### 8. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
#### 9. 3항 연산자를 쓰지 않는다.
#### 10. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
#### 11. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
#### 12. JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
#### 13. else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
#### 14.도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
#### 15.핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
#### 16.사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
#### 17.Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## ✏️ 추가된 요구 사항
- 아래 있는 `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
  - 입력과 출력을 담당하는 클래스를 별도로 구현한다.
  - 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.
  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```
  ```java
  public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```
  
## ✏️ 과제 진행 요구 사항
#### 1. 미션은 [java-christmas-6](https://github.com/woowacourse-precourse/java-christmas-6) 저장소를 비공개 저장소로 생성해 시작한다.
#### 2. **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
#### 3.**Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
#### 4.  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
#### 5. - 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://docs.google.com/document/d/1cmg0VpPkuvdaetxwp4hnyyFC_G-1f2Gr8nIDYIWcKC8/edit?usp=sharing) 문서를 참고한다.

## ❗️3주차 공통 피드백
#### 1. 함수(메서드) 라인에 대한 기준
#### 2. 발생할 수 있는 예외 상황에 대해 고민한다.
#### 3. 비즈니스 로직과 UI 로직을 분리한다.
#### 4. 연관성이 있는 상수는 static final 대신 enum을 활용한다.
#### 5. final 키워드를 사용해 값의 변경을 막는다.
#### 6. 객체의 상태 접근을 제한한다.
#### 7. 객체는 객체스럽게 사용한다.
#### 8. 필드(인스턴스 변수)의 수를 줄이기 위해 노력한다.
#### 9. 성공하는 케이스 뿐만 아니라 예외에 대한 케이스도 테스트한다.
#### 10. 테스트 코드도 코드다.
#### 11. 테스트를 위한 코드는 구현 코드에서 분리되어야 한다.
#### 12. 단위 테스트하기 어려운 코드를 단위 테스트하기
#### 13. private 함수를 테스트 하고 싶다면 클래스(객체) 분리를 고려한다



