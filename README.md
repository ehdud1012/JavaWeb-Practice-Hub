# Java 웹 개발 연습 저장소

이 저장소는 **Java 기반 웹 개발**을 연습하기 위한 프로젝트입니다. 
다양한 웹 기술과 패턴을 실습하였으며, 개발 환경으로 **Eclipse**를 사용하였습니다.

## 📌 개발 환경

- **언어:** Java, HTML, CSS, JavaScript
- **웹 프레임워크:** Servlet, JSP
- **빌드 도구:** Maven
- **서버:** Apache Tomcat
- **데이터베이스:** MySQL (필요시 사용)
- **Java 버전:** 1.8 이상

## 📂 실습 내용

### 📅 8월 실습

- **Aug26_1_HTML** → HTML 기본 구조
- **Aug27_1_HTML** → HTML 태그 활용
- **Aug27_2_CSS** → CSS 스타일 적용
- **Aug27_3_Website** → 간단한 웹사이트 제작
- **Aug28_1_TomcatTest1** → Tomcat 실행 테스트
- **Aug28_2_Servlet** → Servlet 기초
- **Aug29_1_Servlet** → Servlet 실습
- **Aug29_2_DoYoung** → Servlet 연습 프로젝트
- **Aug29_3_InputOutput** → Servlet에서 입출력 처리
- **Aug30_1_FileUpload** → 파일 업로드 기능 구현
- **Aug30_2_ValidCheck** → 입력값 검증
- **Aug30_3_JavaScript** → JavaScript 기본

### 📅 9월 실습

- **Sep02_1_JavaScript** → JavaScript 활용
- **Sep02_2_VaildCheck** → JavaScript 유효성 검사
- **Sep03_1_JSP** → JSP 기초
- **Sep03_2_JSP** → JSP 활용
- **Sep04_1_JSP** → JSP 실습
- **Sep04_2_PageTrans_JSPNote** → JSP 페이지 전환
- **Sep04_3_JSPModel2** → JSP Model 2 패턴
- **Sep05_1_JSPModel2** → MVC 적용
- **Sep05_2_EL** → Expression Language (EL)
- **Sep05_3_EL** → EL 심화
- **Sep05_4_Random** → 랜덤 기능 구현
- **Sep06_1_RockScissorsPaper** → 가위바위보 게임
- **Sep06_2_NumderBaseball** → 숫자 야구 게임
- **Sep09_1_CustomTag** → JSP 커스텀 태그
- **Sep10_CustomTag** → 커스텀 태그 심화
- **Sep11_1_DB** → 데이터베이스 연동
- **Sep11_2_DB** → DB 활용 실습
- **Sep12_1_JSPNote** → JSP 정리 노트
- **Sep26_1_XML_JSON_Server** → XML & JSON 서버 실습

## 🏗️ 웹 개발 개념 정리

### 1. HTML + CSS + JavaScript
- **HTML** → 웹사이트의 구조 (코어)
- **CSS** → 웹사이트의 디자인 스타일 지원
- **JavaScript** → 웹사이트의 이벤트 및 동적 기능 지원
- 📌 **단점**: 백엔드 프로그램 기능 부족 (JavaScript로 가능하지만 불편함)

### 2. Servlet
- **역할:** 클라이언트 요청을 받아 HTML, CSS, JS를 동적으로 생성하여 응답하는 프로그램
- **특징:** Java 기반으로 동작하며 HTML, CSS, JS가 문자열로 처리됨 (자동완성 불가)
- 📌 **단점**: 불편한 작업 환경 (코드 가독성이 떨어짐)

### 3. JSP (Java Servlet Page)
- **역할:** HTML, CSS, JS 코드에 Java를 포함하여 동적인 페이지 생성
- **특징:** 자동완성이 가능하여 작업이 편리하지만, Java와 HTML이 섞여 코드가 복잡해질 수 있음
- 📌 **단점**: 소스 코드가 혼합되어 가독성이 떨어짐

### 4. JSP Model 2 (MVC 패턴 적용)
- **역할:** JSP 프로젝트에서 MVC 패턴을 적용하여 코드 구조를 정리
- **특징:** 분업 가능하지만 여전히 JSP에서 일부 Java 코드가 존재
- 📌 **단점**: View(JSP)에 Java 코드가 남아 있어 완벽한 분업이 어려움

### 5. JSP Model 2 + EL + CustomTag
- **목표:** JSP에서 Java 코드를 완전히 제거
- **방법:**
  - **EL (Expression Language)** → JSP에서 데이터를 표현하는 방식
  - **JSTL (Java Standard Tag Library)** → Java 로직을 대신하는 태그 사용
  - **Custom Tag** → 직접 태그를 만들어 Java 기능을 수행
- 📌 **장점**: 코드가 명확해지고, 개발자 간 역할 분리가 용이해짐

## 📄 라이선스

이 프로젝트는 자유롭게 활용할 수 있습니다. 😊
