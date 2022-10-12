# Server With Message Queue (Event Driven Architecture)

Message Queue 를 활용한 서버 아키텍처를 구현하고 성능 테스트를 진행합니다.


## 1차

구성

Message Producer: 사용자 요청 정보를 바탕으로 메세지 생성 -> Message Queue 로 전달, 요청 경로에 따라 타겟 파티션을 다르게 적용

Kafka: Message Queue, Topic 생성 및 파티셔닝

Message Processor: 파티션 당 하나의 Listener 를 두고 이벤트 감지, 클라이언트와 웹소켓 커넥션을 만들고 처리된 메세지 publishing

기능 테스트 및 코드 첨부 완료

![카프카 001](https://user-images.githubusercontent.com/51109514/195386278-9e4708c9-77da-48d0-a50b-a3faced24e37.png)



