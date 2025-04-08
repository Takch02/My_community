# 커뮤니티 만들기

![Image](https://github.com/user-attachments/assets/1d9c3636-312b-4d1d-83ce-8404c15a0f04)

전혀 비슷하지 않지만 제가 원하는 방향으로 커뮤니티를 만들어보고 있습니다.

url : https://port-0-my-community-m8s7vyos76b8c8ef.sel4.cloudtype.app/home

(현재 주변 지인들에게 사이트를 배포하여 테스트중인데 이상한 글이 좀 있습니다...ㅎㅎ)

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
4. bootstrap을 이용하여 modal을 쉽게 적용했습니다.
5. sql문에서 시간 순서대로 정렬해서 select 하는 방법을 배웠습니다.


## 어려운 점

1. html에서 위치 설정이 어렵습니다. css를 적용해도 원하는대로 잘 적용이 안되네요.
2. isAuth, user 객체는 모든 페이지마다 사용되므로 처음부터 interceptor로 빼서 코드를 작성해야 했는데 뒤늦게 깨닫고 리펙토링하여 시간이 많이 소비됐습니다. ㅠㅠ
3. modal 기능을 직접 구현하니 오류가 잡히질 않아 bootstrap을 이용하여 간편하게 바꾸는 과정을 리펙토링했습니다.
4. loginForm, header 의 html 소스코드가 중복되어 thymeleaf의 fragments로 빼서 적용했습니다.
5. 인증 방법이 조잡합니다. session이나 model에서 받는 값을 조작하면 해킹 위험이 큽니다. spring security, jwt 방식을 배워서 나중에 리펙토링 해야겠네요.


## 개발일지

### 3/25

user table을 만들고 회원가입 로직을 만듦. html에 홈화면 및 회원가입 ui를 만듦.

### 3/26

post table을 만들고 글쓰기 로직을 만듦. 로그인 하지 않아도 public하게 글을 볼 수 있게 만듦.

### 3/27

작성된 글을 볼 수 있게 만들고 내 정보 ui를 만듦.

### 3/28

글 수정 기능 및 modal 기능, loginForm, header를 리펙토링했습니다.

### 3/29

CloudType에 mysql 서버를 열었습니다. 글 수정, 삭제 기능 및 유저 수정기능 까지 넣은 후 spring boot 서버도 올릴 예정입니다.

### 3/30

아이디 및 제목은 중복 불가능하게 만들었습니다. (처음 설계 시 고려해야 하는데 못했네요. 또 배웁니다.)

드디어 DB에 이어서 spring 프로젝트도 cloudType에 올렸습니다! 위 링크로 접속 가능합니다.

## 3/31

글 마다 댓글 기능은 구현했습니다. 그리고 github, 정보 버튼을 만들었습니다!

(초기 설계 시 고려하지 않은 부분이라 역시 초기 설계가 중요함을 느낍니다..)
