![프로젝트 로고](https://github.com/user-attachments/assets/b0e8519c-4520-43c8-8c3a-bc4fd46819d3)

# Lol-Hae-Duo 롤해듀오

롤(League of Legends) 유저들을 위한 듀오 매칭 및 전적 분석 서비스
요청 URL: http://lolhaeduo.site

## 목차

1. 프로젝트 소개
2. 주요 기능
3. 실행 방법
4. 기술 스택
5. 구조 및 설계
6. 팀원 소개 및 역할분담
7. 문의
8. 참고 자료

## 프로젝트 소개

지긋지긋한 연패, 실버 4 LP 0점! 한번만 더 지면 브론즈로 강등이라니 ㅠㅠ

내 상황으로부터 날 구해줄 백마탄 버스기사님 어디 없을까??

게임을 혼자 즐기기 심심할 때, 같이 소통할 게임 친구가 필요할 때, 등을 맡기고 팀의 승리를 거머쥘 전우가 필요할 때!!

나만큼 게임 잘하는 사람 어디 없나? ***너, 내 동료가 돼라.***

날 웃음 짓게 만드는 버스기사님, 든든한 내 친구! **롤해 듀오**에서는 모두 만나볼 수 있습니다!

부담 갖지 말고 사용하세요!

## 주요 기능

1. 계정 연동(멤버당 최대 3개 계정 연동 가능)    URL: baseUrl/link/riot  [POST]
   * ![image](https://github.com/user-attachments/assets/95679c23-7de7-48f5-b58a-fb75ccd8cfdd)
   * accountType: RIOT(롤)
   * accountUsername / accountPassword: 롤 계정 아이디 / 패스워드 (RSO 미적용)
   * summonerName / tagLine: 소환사명 / 태그라인
   * server: 서버

2. 듀오 신청    URL: baseUrl/duo  [POST]
   * ![image](https://github.com/user-attachments/assets/9f948c5f-d2e7-45b9-b1ce-5969b68ccc64)
   * summonerName / tagLine: 소환사명 / 태그라인
   * queueType: 게임 모드(빠른 대전: QUICK, 솔로 랭크: SOLO, 자유 랭크: FLEX)
   * primaryRole / primaryChamp: 희망 라인 / 주라인 희망 챔피언(빠른 대전 전용)
   * secondaryRole / secondaryChamp: 희망 부라인(빠른 대전 전용) / 부라인 희망 챔피언(빠른 대전 전용)
   * targetRole: 상대방이 했으면 좋은 라인
   * memo: 메모
   * mic: 마이크 on/off 유무(boolean)

3. 듀오 조회    URL: baseUrl/duo   [GET]
   * ![image](https://github.com/user-attachments/assets/7413b26b-a91b-4fd8-97c5-a16d16a4dac9)
   * ![image](https://github.com/user-attachments/assets/fe60496a-cd00-4d45-9daa-e48cc52ecb7c)
   * 게임 모드, 라인, 티어 상세 필드로 상세 조회 가능

4. 듀오 수정    URL: baseUrl/duo/{duoId}  [PUT]
   * ![image](https://github.com/user-attachments/assets/db7e23eb-1d21-4915-91e4-4598643b7c04)
  
5. 듀오 삭제    URL: baseUrl/duo/{duoId}  [DELETE]
   * ![image](https://github.com/user-attachments/assets/c7a61507-ed91-4f08-b1b2-c7c5b707fc19)
  
## 실행 방법

### 요구 사항
> 추가한 의존성
> ![image](https://github.com/user-attachments/assets/117a43fb-1a33-4e9e-8bc0-a0e55a696901)

### 외부 API 키
> 라이엇 개발자 포털에서는 API Key를 지급합니다. 라이엇 서버에서 제공하는 실제 데이터를 가져오기 위해서는 이 Key가 필요합니다.
> API Key 지급 방법
  >> 라이엇 개발자 포털에 접속한다. [라이엇 개발자 포털](https://developer.riotgames.com/)

  >> ![image](https://github.com/user-attachments/assets/4af7ba85-bde9-425a-b065-c3fc8dc08fd8)
  >> 로봇이 아닙니다 인증 후 **Regenerate API Key**를 눌러서 Development API Key를 지급받는다. 

  >> 추가로 **Register Product**를 눌러서 더 높은 수준의 API Key를 받을 수도 있다. (자세한 획득 방법은 생략합니다.)
  >> ![image](https://github.com/user-attachments/assets/aacb0f04-ea8a-4fa2-b178-9f6e5f55517f)

  >> Development API Key는 개발 목적의 API Key로 호출 제한은 다음과 같고, 만료 시간은 24시간이다.
  >> ![image](https://github.com/user-attachments/assets/2f4ca34b-910d-4ccb-830a-b05908fd232d)

  >> Personal API Key는 간단한 프로젝트에 적합한 API Key로, 호출 제한은 Development API Key와 같고, 만료 시간은 없다.

  >> Production API Key는 복잡한 오픈소스용 프로젝트를 위한 API Key로, 호출 제한은 다음과 같고, 만료 시간은 없다.
  >> ![image](https://github.com/user-attachments/assets/52295c52-196d-430e-90cf-fe24aed12e29)

### API 문서
API 테스트를 위해 [Postman 워크스페이스]()를 활용하세요.

1. Postman에서 'Import' 버튼 클릭
2. 다운로드한 'lol-hae-duo_postman_workspace.json' 파일을 선택
3. 워크스페이스에서 API 테스트 진행

---

## 기술 스택

| 영역        | 기술 스택                          |
|-------------|------------------------------------|
| 백엔드      | Java 11, Spring Boot 3.4.0         |
| 데이터베이스 | Amazon RDS + MySQL 8.0             |
| API 호출    | RestTemplate                       |
| 이벤트 관리  | Spring Event, Spring Retry         |
| 빌드 및 배포 | Gradle, Docker, AWS EC2            |
| 외부 API    | Riot Games API                     |

## 구조 및 설계

1. 시스템 아키텍처 다이어그램
  * ![image](https://github.com/user-attachments/assets/8c6bdf79-44ea-4fdf-a44f-971686b2961f)

2. 주요 클래스
  * AccountService: Account 엔티티의 서비스 로직; 계정 연동 기능
  * RiotClientService / RiotClient: 전적 정보를 라이엇 서버(그리고 대체 서버)로부터 받아오는 클래스, 전달하는 데이터 중 프로젝트에서 필요로 하는 데이터만 추출하도록 조정
  * AccountGameDataService: 추출해 온 데이터를 DB에 저장하고, 갱신에 필요한 데이터만 aggregate하는 클래스

3. 데이터 흐름
  * 사용자 경험을 고려해서 듀오를 신청할 때 실시간으로 전적을 조회해 오는 것처럼 사용자가 듀오 객체를 생성하는 시간 부터 조회되는 시점까지의 시간을 최소로 줄여야 한다.
  * 따라서 듀오를 신청할 때는 이미 DB에 저장되어 있는 전적을 Query 문을 사용해서 가져오는 형태로 동작한다.
  * 계정을 연동하면 비동기 호출로 전적 정보를 조회해온다. (Event Publisher: AccountService의 linkAccount 메서드; Event Consumer: AccountGameDataService의 createGameDataEvent 메서드)
  * 워커 스레드가 RestTemplate을 사용해서 외부 API 호출을 수행하고, RiotClient -> RiotClientService -> AccountGameDataService 순으로 데이터가 전달되어 DB에 저장된다.
  * DB에 저장되어 있는 데이터를 현재 수동으로 업데이트 하는 로직은 없으며, 지금은 하루에 한번 자동으로 모든 계정의 정보를 업데이트하는 스케쥴러를 사용해서 업데이트한다.
  * 듀오를 생성할 시 DB에 저장되어 있는 전적 정보를 가져와서 사용자에게 보여준다.

## 팀원 소개 및 역할 분담 (각자 적어주시기 바랍니다.)

1. 육심헌(팀장)
   * 프로젝트 방향성 지도, 계획 수립, 전체 총괄
   * 외부 API 호출 Client 코드 작성(RestTemplate, 데이터 가공 로직)
   * Spring Event를 사용한 비동기 로직 작성, 스레드 풀 조정
   * Lambda Function을 사용해 대체 서버 생성 및 운용
   * Spring Retry를 사용해 메서드 재처리 로직 도입
   * 서버 분리 도입 고려 -> 반려함
   * API 문서화, README
     
2. 이은영(부팀장)
   
3. 백현욱
   
4. 이지훈
   
5. 박인선

## 문의

[팀장 이메일](yooksi53@gmail.com)로 연락주시면 친절하게 답변해 드리겠습니다.

## 참고 자료 및 FAQ

[노션 페이지](https://www.notion.so/teamsparta/b953cd528364428a9c2fa6c5433efc38)
