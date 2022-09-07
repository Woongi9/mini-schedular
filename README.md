# Mini-Scheduler

---
## 목차

- [개발 목적](#목적)
- [개발 환경](#환경)
- [사용 기술](#기술)
    + [백엔드](#백엔드)
    + [DB](#데베)
    + [프론트엔드](#프론트)
    + [인프라](#인프라)
- [주요 내용](#주요)
- [패키징 구조](#패키지)
- [실행 화면](#화면)
- [시스템 아키텍처](#아키텍처)
- [클래스 다이어그램](#다이어그램)
- [핵심 기능](#핵심)
    + [계층형 구조 아키텍처 설계](#핵심0)
    + [부트스트랩을 사용한 웹 페이지](#핵심1)
    + [Full Calendar 오픈 소스 달력](#핵심2)
    + [JPA를 사용한 일정 CRUD 구현](#핵심3)
    + [DTO 계층과 서비스 계층 구성](#핵심4)
    + [Spring Security와 소셜 로그인](#핵심5)
    + [Thymeleaf를 통한 기능 구현](#핵심6)
        + [세션 값 일정 등록시 자동 입력](#핵심6-1)
        + [유저의 역할에 다른 구현](핵심6-2)
    + [일정 엔티티와 세션 이름 매칭](#핵심7)
    + [Query 문에 따른 다른 순서의 출력](#핵심8)
    + [Junit Test](#핵심9)
    + [AWS EC2 리눅스 환경과 AWS RDS 환경](#핵심10)
    + [EC2 서버에 배포](#핵심11)
    + [Travis CI, AWS S3, AWS CodeDeploy 연동으로 배포 자동화](#핵심12)
    + [AWS Route 53를 통해 도메인 DNS 서비스 등록](#13)
    + [Nginx를 통한 무중단 배포 및 리버스 프록시 환경 구축](#핵심14)

- [프로젝트를 통해 느낀점](#느낀점)

---
## <div id="목적">개발 목적</div>

* ***평소 사용하던 정적인 순서에 스케줄러가 아닌 내가 원하는 칼럼 순으로 일정 목록이 다르게 생성될 수 있도록 하는 웹 페이지 설계 및 운영***  
* 유저 별로 저장된 일정 기록, 수정, 삭제, 목록 페이지를 가지면서 Full-Calendar 사용으로 보기 편한 웹 페이지를 구현
* Spring Boot와 Spring Security, Thymeleaf, JPA 등을 통한 웹 애플리케이션을 만들고, 만든 WAS를 항상 접근할 수 있게 AWS와 Travis CI를 활용해 인프라 구축 후 배포 과정 전개발 경험

<br></br>

---

## <div id="환경">개발 환경</div>

* IntelliJ
* Postman
* Github
* h2 Database
* MySQL

<br></br>

---

## <div id="기술">사용 기술</div>

<br></br>

### 주요 프레임워크/라이브러리

### <div id="백엔드">백엔드</div>
+ Java 11 openjdk
+ Spring Boot 2.6.0
+ Spring Security
+ Thymeleaf
+ Lombok
+ JPA
+ Querydsl

### Build tool
+ Gradle


#### <div id="데베">DB</div>
+ h2
+ MySQL
+ AWS RDS

#### <div id="프론트">프론트엔드</div>
+ Javascript
+ Bootstrap
+ Ajax
+ JSON
+ FullCalendar

#### <div id="인프라">인프라</div>
+ AWS EC2 (Linux)
+ AWS RDS
+ AWS S3
+ AWS CodeDeploy
+ Travis CI
+ Nginx
+ Git

<br></br>

---

## <div id="주요">주요 내용</div>

* 웹 애플리케이션 계층형 아키텍처 설계부터 구현, 무중단 배포까지 전과정 경험
* 오픈 소스 부트스트랩과 Full-Calendar를 사용으로 기초적인 UI 제공
* MVC 프레임워크 기반 백엔드 서버 구축
* JPA 사용, Hibernate를 사용한 도메인 설계
* Spring Security를 사용한 로그인 과정
* 구글, 네이버 소셜 로그인 구현
* Git, AWS EC2, RDS, S3, CodeDeploy, TravisCI, Nginx, Docker를 이용한 리눅스 기반 리버스 프록시 인프라 구축

<br></br>

---
## <div id="패키지">패키징 구조</div>

<img width="363" alt="image" src="https://user-images.githubusercontent.com/79649052/181879497-4a0a3222-da2f-4a08-b20d-5801cb7cb1e2.png">
<img width="363" alt="image" src="https://user-images.githubusercontent.com/79649052/181879524-6ef6164f-5069-4720-91f4-321bc3ca3cf9.png">

<br></br>

---

## <div id="화면">실행 화면</div>

### 1. 로그인 & 로그아웃

![로그인 1](https://user-images.githubusercontent.com/79649052/181902743-4c45b071-f4ed-44c0-8602-434d87dedb28.gif)

#### 1.1 로그인 없이 접근

![로그인 1-2](https://user-images.githubusercontent.com/79649052/181902736-7754110f-b774-4420-adc6-f32bee4a50ee.gif)

<br></br>


### 2. 일정 목록 출력

#### 2.1 시간순 목록

<img width="1273" alt="image" src="https://user-images.githubusercontent.com/79649052/181902777-68f2dd74-c10d-4178-b5b9-a2d929788625.png">

#### 2.2 중요도순 목록

<img width="1273" alt="image" src="https://user-images.githubusercontent.com/79649052/181902784-378bdfa3-4a78-4b16-aa6e-88592604ab93.png">

<br></br>

### 3. CRUD

#### 3.1 일정 등록

![Create](https://user-images.githubusercontent.com/79649052/181902892-8446fbe1-289d-4e0b-98a4-767bfde6541f.gif)

#### 3.2 개별 일정 읽기

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903582-0f52ddf2-efd0-419b-824e-db4455b14c57.png">

#### 3.3 일정 수정

* 수정 전

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903675-1de831e4-15a8-42e3-8a75-799167505583.png">

* 수정 후

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903693-3e42a97c-cd6b-40ac-822f-7cd6df4d3e61.png">


#### 3.4 일정 삭제

* 삭제 전

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903722-9b83ac88-16be-42df-8080-244e8c13b226.png">

* 삭제 후

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903783-a737fd68-1462-4957-9b98-349b75184e84.png">


<br></br>

### 4. Full-Calendar 달력 페이지

<img width="636" alt="image" src="https://user-images.githubusercontent.com/79649052/181903806-f07a734d-871d-4359-842d-eca67135628d.png">

<br></br>

---

## <div id="아키텍처">시스템 아키텍처</div>

<img width="482" alt="image" src="https://user-images.githubusercontent.com/79649052/188944769-bf68fdc5-7268-4be2-8654-5029c8968ea3.png">


<br></br>

---

## <div id="다이어그램">클래스 다이어그램</div>

<img width="691" alt="image" src="https://user-images.githubusercontent.com/79649052/181937303-0445214a-689f-4753-a106-8ced494fdb11.png">

<br></br>

---
## <div id="핵심">핵심 기능</div>

### <div id="핵심0">계층형 구조 아키텍처 설계</div>

<img width="319" alt="image" src="https://user-images.githubusercontent.com/79649052/188583339-85b16ac1-7963-43b0-806c-e0bdc4be69df.png">

* **구조를 바꾸는 경우 문제에 경우 전체를 수정하는게 아닌 적절한 객체에 책임을 할당하는 3계층 아키텍처가 적절하다고 판단** 

_토비의 스프링 3계층 아키텍처 참고_

[계층형 구조 블로그 정리](https://velog.io/@woongi9/%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98-%EA%B3%84%EC%B8%B5%ED%98%95-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98) 

<br></br>

### <div id="핵심1">부트스트랩을 사용한 웹 페이지</div>

<img width="1280" alt="image" src="https://user-images.githubusercontent.com/79649052/181903857-c2e1cfe3-8c17-47a7-8c99-addc6cf01f26.png">

* 오픈 소스 부트스트랩을 사용하여 모바일 환경은 물론 태블릿 화면에서도 작동하는 반응형 웹 구현

<br></br>

### <div id="핵심2">Full Calendar 오픈 소스 달력</div>

<img width="638" alt="image" src="https://user-images.githubusercontent.com/79649052/181937344-d04b4cf9-8752-4f36-9ace-1a7a23bff7f6.png">

* 오픈 소스 Full-Calendar를 사용하여 달력 화면 페이지 구현

<br></br>

### <div id="핵심3">JPA를 사용한 일정 CRUD 구현</div>

<img width="603" alt="image" src="https://user-images.githubusercontent.com/79649052/182013088-a5776af0-e55c-428c-9a26-54eba4a40ee5.png">
<img width="461" alt="image" src="https://user-images.githubusercontent.com/79649052/182013107-ecc474dd-031d-460b-880d-061509be20d5.png">

* JPA 엔티티로 생성한 Posts와 Users 엔티티와 JPA Repository를 통해 구현한 PostsRepository와 UserRepository

<img width="639" alt="image" src="https://user-images.githubusercontent.com/79649052/181903313-ee293aca-94ac-49c5-953d-57770376066c.png">

* 위의 실행화면 3.1 일정 생성 직후 EC2 서버에서의 Create 이후 AWS RDS

<br></br>


### <div id="핵심4">DTO 계층과 서비스 계층 구성</div>

<img width="219" alt="image" src="https://user-images.githubusercontent.com/79649052/182013669-b2997995-a1a6-463a-a5cf-68ff78c5231a.png">
<img width="219" alt="image" src="https://user-images.githubusercontent.com/79649052/182013678-e07c696f-2b74-4e7a-a987-63bdcdb3b749.png">

* 화면에 전달하는 데이터이거나 화면 쪽에서 전달되는 데이터 기준으로 DTO 구성
* 서비스 계층에는 기본적으로 DTO에서 Entity로 Entity에서 DTO로 하는 함수와 추가적으로 DTO를 파라미터로 받을 때의 검색, 삭제, 수정 등 필요 함수 구현

### <div id="핵심5">Spring Security와 소셜 로그인</div>

<img width="237" alt="image" src="https://user-images.githubusercontent.com/79649052/182014208-8cda1792-e798-4894-8e2b-f644f2a8bfbc.png">

* OAuth2 인증방식을 사용

* 회원가입이 되지 않은 경우는 OAuthAttributes 형식으로 구글과 네이버의 로그인 유저 정보를 받아 CustomOAuth2UserService의 loaduser 메서드에서 저장 후 Security의 DefaultOAuth2User로 리턴되면서 회원 정보를 전달

* 회원가입이 된 회원인 경우 SaveOrUpdate 메서드에서 이메일 검색 가능시 Security의 DefaultOAuth2User로 리턴되면서 회원 정보를 전달

<br></br>

### <div id="핵심6">Thymeleaf를 통한 기능 구현</div>

<img width="378" alt="image" src="https://user-images.githubusercontent.com/79649052/182014350-70bf22e5-0592-47f9-8871-df14f7ffa335.png">


* Timesort.html의 일정 리스트 정보 출력 부분
* Controller에서 GetMapping시 Model로 전송된 DTO 정보를 출력

#### <div id="핵심6-1">일정 등록</br>

<img width="681" alt="image" src="https://user-images.githubusercontent.com/79649052/182014377-5662e5e0-a4ea-41c4-8eed-d1c4ae508ba3.png">

* register.html의 POST 부분 Thymeleaf 사용

#### <div id="핵심6-2">유저의 역할에 다른 구현</br>

<img width="701" alt="image" src="https://user-images.githubusercontent.com/79649052/182014459-f0688a9f-0925-4dce-9864-f83381a415ee.png">

* 로그인 여부에 따른 Navbar의 로그인, 로그아웃 표시 숨기기, 보이기

<br></br>

### <div id="핵심7">일정 엔티티와 세션 이름 매칭</div>

<img width="537" alt="image" src="https://user-images.githubusercontent.com/79649052/182014434-c3eddf6a-fd32-4474-bfef-481dba164c33.png">

* register.html의 POST 부분 이후 setName을 통한 Principal 세션 이름을 Posts의 Name 칼럼에 저장

<br></br>

### <div id="핵심8">Query 문에 따른 다른 순서의 출력</div>

<img width="691" alt="image" src="https://user-images.githubusercontent.com/79649052/182014533-9c6e888f-d3b3-4dd6-b7a4-9fed2923f494.png">

* PostsRepository에 Query를 사용하는 시간순 일정 페이지, 중요도에 따른 페이지에 출력되는 일정들을 순서대로 리스트로 만드는 Query
* endDate가 현재 날짜보다 과거인 경우는 출력 안함

<br></br>

### <div id="핵심9">Junit Test</div>

<img width="252" alt="image" src="https://user-images.githubusercontent.com/79649052/182014619-a39e9ca0-651a-48db-9e64-680770529c6e.png">

* 다양한 메서드의 기능을 Junit5 Test 코드를 통해 확인

<br></br>

### <div id="핵심10">AWS EC2 리눅스 환경과 AWS RDS 환경</div>

<img width="279" alt="image" src="https://user-images.githubusercontent.com/79649052/182015247-391a6be8-1192-465c-a8cb-40c8b6141427.png">

* EC2는 Amazon Linux 1 OS 인스턴스 사용

<img width="425" alt="image" src="https://user-images.githubusercontent.com/79649052/182015228-db783bb7-5cf4-4eaa-85ae-df6102f2cb75.png">

* RDS는 MySQL 사용하고, IntelliJ에 DB Browser 환경을 통해 콘솔 접근

<br></br>


### <div id="핵심11">EC2 서버에 배포</div>

<img width="418" alt="image" src="https://user-images.githubusercontent.com/79649052/182015372-b3424232-1ff6-4be5-9c7b-1936c6bbc39a.png">

* EC2 내의 deploy.sh 파일로 배포 스크립트 저장

<img width="1274" alt="image" src="https://user-images.githubusercontent.com/79649052/182015356-7b6d6e1a-a093-4524-8d44-f71c0493785b.png">

* nohup.out 을 통해 배포 과정 로그 확인을 통해 오류 확인과 성공 여부 확인 가능

<br></br>

### <div id="핵심12">Travis CI, AWS S3, AWS CodeDeploy 연동으로 배포 자동화</div>

<img width="622" alt="image" src="https://user-images.githubusercontent.com/79649052/182014925-72e6481e-7b20-42c4-b1d4-003bf299dc97.png">

* Travis CI의 빌드 성공 확인

* Jenkins는 설치형이므로 EC2 인스턴스가 하나 더 필요하여 프리티어 유지를 위해 Travis CI 사용

<img width="870" alt="image" src="https://user-images.githubusercontent.com/79649052/182014822-bdeb7761-6c84-4a64-8d95-69c7c53168a0.png">

* AWS S3에 저장되어 있는 Travis CI에서 받은 jar 파일 zip 

<img width="1095" alt="image" src="https://user-images.githubusercontent.com/79649052/182014782-316e6ce6-62d8-4b91-98e1-63329de2c8e7.png">

* AWS CodeDeploy의 배포 내역에서의 성공

<br></br>
---

### <div id="핵심13">AWS Route 53를 통해 도메인 DNS 서비스 등록</div>

<img width="710" alt="image" src="https://user-images.githubusercontent.com/79649052/188927538-4f41d73e-49e8-4f59-a9b2-cdb58579075c.png">

* AWS Route 53에서 www.mini-scheduler.com 도메인 구매 기존의 가독성이 떨어진 EC2 인스턴스 주소를 DNS 서버를 통해 연결

<br></br>

---

### <div id="핵심14">Nginx를 통한 무중단 배포 및 리버스 프록시 환경 구축</div>

<img width="542" alt="image" src="https://user-images.githubusercontent.com/79649052/188943936-c93cf828-9c17-45bd-8d30-55739ee90e39.png">

_출처 : [엔진엑스를 사용한 무중단 배포](https://velog.io/@hwana/%EC%8A%A4%ED%94%84%EB%A7%81-%EB%B6%80%ED%8A%B8%EC%99%80-AWS%EB%A1%9C-%ED%98%BC%EC%9E%90-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%9B%B9-%EC%84%9C%EB%B9%84%EC%8A%A4-%EC%97%94%EC%A7%84%EC%97%91%EC%8A%A4%EB%A5%BC-%EC%82%AC%EC%9A%A9%ED%95%9C-%EB%AC%B4%EC%A4%91%EB%8B%A8-%EB%B0%B0%ED%8F%AC)_

* 배포할 시에 서버가 접속이 안되는 문제를 해결하기 위해 웹 서버, 리버스 프록시, 캐싱, 로드 밸런싱 등을 위한 오픈소스 소프트웨어 Nginx를 사용해 리버스 프록시 무중단 배포 환경 설정
* 9월 8일 현재 Travis CI credit 문제로 빌드 안되는 문제(결제 비용 문제)

<br></br>

---


## <div id="느낀점">프로젝트를 통해 느낀점</div>

* 처음에 비하면 장족의 발전을 했다. 인프라와 관련된 기술도 다양하게 찾아보고 하다보니 배포까지 구현할 수 있었다. 하지만 아직까지 배포 중의 사이트가 끊겨 무중단 배포를 시도하려 했지만 EC2의 인스턴스가 하나 더 필요할 것 같아 프리티어 유저로서 할 수 없었다.
* 아직까지도 처음 데이터 모델링 과정에서 확실하게 구현하지 못해 중간의 수정 과정을 거치는 경우가 많았다. 데이터 모델링을 좀 더 공부할 필요가 있을 것 같다. 그리고 JPA를 주로 사용하고 있기는 한데 편리하기는 하지만 과연 이게 왜 그렇게 까지 좋은 기술인지는 아직까지도 잘 모르겠다.
* 이제 다른 프로젝트 또한 이번 프로젝트에서 사용했던 방법을 통해 배포와 무중단 배포 과정까지 시도할 생각이다.

<br></br>

---
