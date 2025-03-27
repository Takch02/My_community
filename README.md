# Velog 와 비슷하게 커뮤니티 만들기

전혀 비슷하지 않지만 제가 원하는 방향으로 커뮤니티를 만들어보고 있습니다.
(아직 진행중입니다. 3/25 ~ )

## 시작하게된 계기

Controller에 익숙해졌지만 sql과 연동하여 sql문 작성 및 테이블 설계에 취약하여 시작했습니다. 또한 html, css, js에 대해 스스로 학습하며
front-end의 작동 구조도 학습할 겸 혼자서 front까지 합니다.

## 구조

간단합니다. user를 생성(회원가입)하면 글쓰기 및 내 정보에 접속할 수 있습니다. 

글 작성을 하면 public하게 볼 수 있게 합니다. 

## 배운 점

1. thymeleaf에 대해 알아갑니다. th:object, th:field, th:errors 를 사용하며 html에 편하게 객체를 넘기고 사용합니다.
2. html, css 구조에 대해 배웠습니다. 특히 form 구조 및 css가 어떻게 적용되는지에 알게됐습니다.
3. Mybatis를 처음 사용해봤습니다. jdbc로 구현하면 더 간단하겠지만 Mybatis 사용 방법을 알고싶어 적용해봤습니다.
4. 일단 완성을 하면 더 적어야겠습니다.

## 어려운 점

1. html에서 위치 설정이 어렵습니다. css를 적용해도 원하는대로 잘 적용이 안되네요.
2. isAuth, user 객체는 모든 페이지마다 사용되므로 처음부터 interceptor로 빼서 코드를 작성해야 했는데 뒤늦게 깨닫고 리펙토링하여 시간이 많이 소비됐습니다. ㅠㅠ
3. 그냥 처음이라 어렵습니다.


## 개발일지

### 3/25

user table을 만들고 회원가입 로직을 만듦. html에 홈화면 및 회원가입 ui를 만듦.

### 3/26

post table을 만들고 글쓰기 로직을 만듦. 로그인 하지 않아도 public하게 글을 볼 수 있게 만듦.

### 3/27

작성된 글을 볼 수 있게 만들고 내 정보 ui를 만듦.
