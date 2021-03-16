

## 세션 관리와 개인 정보 출력
```
웹서버가 사용자를 어케 관리하는가에 대한 세션!

클라이언트가 로그인을 하면 서버가 내부적으로 처리르 하게되는게 그 중 하나가 세션을 생성하는것이다. 그 후에 사용자에게 응답을 한다.
세션을 생성하게되면 세션을 관리할 수 있게된다. 각각의 세션은 사용자이다. 서버에서는 사용자가 어떤사용자인지 알 수 있게 세션을 이용한다.
클라이언트가 세션이라는 각각의 인증키를 가지고있다 라고 보면된다. 
세션을 탈취당하면? 해커가 신원을 복제해서 속일수 있다. 웹서버에 개인정보 요구, 글쓰기 요청 드 다양한 행위를 속이며 할 수 있다(세션탈취)
서버가 각각의 사용자를 세션을 통해 관리하는 것이 핵심이다.
세션값을 알고 있으면 그 사용자가 할 수 있는 거의 모든것을 할 수 있다. 
웹 서버는 무엇을 보고 권한을 판단하나?
세션으로 현재 접속한 아이디를 구별 한 후 웹주소로 다른 아이디로 접속하려고 하면 세션이 불일치 하기에 접속할 수 없도록 권한을 준다. 

세션은 자기 자신으 나타내느 신원 증명과도 같다. 
```
## 세션을 이용한 개인 정보 해킹과 세션 보안의 중요성
```
세션을 탈취하기만 한다면, 해당 아이디에대한 모든것을 내 마음대로 바꿀 수 있다.
일반적으로는 회원의 비밀번호를 다시 물어봄으로써 세션을 탈취당하더라도 그것을 방지할 수 있다.(회원정보수정에 필요한것을 오직 세션에만 맡겨두지 않는다) 
```
## XSS(Cross Site Scripting) 공격의 개요와 실습
```
Cross site Scripting 공격은 자바스크립트를 통해 공격한다 (alert와 on, location을 통해서)
변칙적이고 모든 경우의수를 다 막기는 어렵다. 
```
## 해킹용 서버 구축과 XSS(Cross Site Scripting)을 통한 세션 탈취

XSS는 간단한 스크립팅 문장을 작성함으로써 서버가 스크립트문장으 보여줄수 있다는 취약점을 이용하여 자신이 원하는 형태로 스크립트 문장으 다루어 읽는 사람의 정보를 취한다.
간단하게 알림창을 띄우는것을 시작하여 한다.
세션을 탈취하여 그 사람인척 다양한 행위를 한다.
개인 웹서버가 필요하다 .
## XST(Cross Site Tracing) 공격기법
```

```
