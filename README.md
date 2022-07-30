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
    + [부트스트랩 사용](#핵심1)
    + [Full Calendar 오픈 소스 달력](#핵심2)
    + [JPA를 사용한 일정 CRUD 구현](#핵심3)
    + [Spring Security와 소셜 로그인](#핵심4)
    + [Thymeleaf를 통한 기능 구현](#핵심5)
        + [세션 값 일정 등록시 자동 입력](#핵심5-1)
        + [유저의 역할에 다른 구현](핵심5-2)
    + [일정 엔티티와 세션 이름 매칭](#핵심6)
    + [Query 문에 따른 다른 순서의 출력](#핵심7)
    + [Junit Test](#핵심8)
    + [AWS EC2 리눅스 환경](#핵심9)
    + [AWS RDS에 DB 환경](#핵심10)
    + [EC2 서버에 배포](#핵심11)
    + [Travis CI, AWS S3, AWS CodeDeploy 연동으로 배포 자동화](#핵심12)

- [프로젝트를 통해 느낀점](#느낀점)

---
## <div id="목적">개발 목적</div>

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

#### <div id="프론트">프론트엔드</div>
+ Javascript
+ Bootstrap
+ Ajax
+ JSON
+ FullCalendar

#### <div id="인프라">인프라</div>
+ AWS EC2
+ AWS RDS
+ AWS S3
+ AWS CodeDeploy
+ Travis CI
+ Git

<br></br>

---

## <div id="주요">주요 내용</div>

* 웹 애플리케이션 설계부터 구현, 배포까지 전과정
* 오픈 소스 부트스트랩과 Full-Calendar 사용
* MVC 프레임워크 기반 백엔드 서버 구축
* JPA 사용, Hibernate를 사용한 도메인 설계
* Spring Security를 사용한 로그인 과정
* 구글, 네이버 소셜 로그인 구현
* Git, AWS EC2, RDS, S3, CodeDeploy, TravisCI를 이용한 인프라 구축

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

#### 3.3 일정 수정

#### 3.4 일정 삭제

<br></br>

### 4. Full-Calendar 달력 페이지

<br></br>

### 6. 리뷰 수정 & 삭제

<br></br>

---

## <div id="아키텍처">시스템 아키텍처</div>

<br></br>

---

## <div id="다이어그램">클래스 다이어그램</div>

<br></br>

---
## <div id="핵심">핵심 기능</div>

### <div id="핵심1">부트스트랩</div>

<br></br>

### <div id="핵심2">Full Calendar 오픈 소스 달력</div>

<br></br>

### <div id="핵심3">JPA를 사용한 일정 CRUD 구현</div>

<br></br>

### <div id="핵심4">Spring Security와 소셜 로그인</div>

<br></br>

### <div id="핵심5">Thymeleaf를 통한 기능 구현</div>

#### <div id="핵심5-1">세션 값 일정 등록시 자동 입력</br>

#### <div id="핵심5-2">유저의 역할에 다른 구현</br>

<br></br>

### <div id="핵심6">일정 엔티티와 세션 이름 매칭</div>

<br></br>

### <div id="핵심7">Query 문에 따른 다른 순서의 출력</div>

<br></br>

### <div id="핵심8">Junit Test</div>

<br></br>

### <div id="핵심9">AWS EC2 리눅스 환경</div>

<br></br>

### <div id="핵심10">AWS RDS에 DB 환경</div>

<br></br>


### <div id="핵심11">EC2 서버에 배포</div>

<br></br>

### <div id="핵심12">Travis CI, AWS S3, AWS CodeDeploy 연동으로 배포 자동화</div>

<br></br>

---

## <div id="느낀점">프로젝트를 통해 느낀점</div>

<br></br>

---
