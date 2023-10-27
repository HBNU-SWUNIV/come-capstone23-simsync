# 한밭대학교 컴퓨터공학과 SimSync팀

**팀 구성**
- 20167089 김현진

## <u>Teamate</u> Project Background
- ### 필요성
  - 본 프로젝트는 심전도 및 다른 건강 지표를 실시간으로 모니터링하여 개인의 건강 상태를 지속적으로 추적하는 모바일 어플리케이션입니다. 이 어플리케이션은 사용자의 건강 데이터를 신속하게 분석하고, 이상 징후를 감지하면 즉시 사용자 및 등록된 보호자에게 알림을 보내는 기능을 제공합니다.
      1. 편의성 : 사용자는 언제 어디서든 건강 상태를 확인하고 모니터링할 수 있습니다.
      2. 보호자와의 연결 : 사용자의 건강 상태를 확인하고 사용자가 위급한 상황에 처했을 때 적절한 조치를 취할 수 있게 도와줍니다.
      3. 의료비 및 사망률 감소: 적시의 건강 관리로 초기 진단 및 대응이 가능해져 의료비 절감과 사망률 감소에 기여합니다.
 
- ### 기존 해결책의 문제점
  - 접근성 : 전문적인 ECG 장비는 일반 소비자가 접근하기 어려운 경우가 많음
  - 휴대성 : 기존 전문 ECG 장비는 크고 무거워 이동에 제약이 있음
  - 사용성 : 전문적인 지식 없이는 사용하기 어려우며, 제대로 된 결과를 얻기 어려움
  - 실시간 모니터링 : 많은 장비가 데이터를 저장하기만 하며, 실시간으로 분석하거 알림을 주는 기능이 없음
  - 보호자 연결 부재 : 위급한 상황에서 보호자나 으읍서비스와 연결해주는 기능은 대부분의 장비에 포함되어 있지 않음
  - 데이터 저장 및 공유 : 사용자의 데이터를 저장하고, 필요시 데이터를 공유하는 기능에 제한이 있음
  
## System Design
  - ### System Requirements
    1. 실시간 모니터링 기능: 시스템은 사용자의 심전도 데이터를 실시간으로 모니터링 할 수 있는 기능 필요
    2. 알림 메커니즘: 이상 징후 감지 시 사용자와 보호자에게 즉시 알림을 보낼 수 있는 메커니즘 구현
    3. 데이터 저장 및 검색: 사용자의 심전도 데이터를 안전하게 저장하고 필요시 조회하는 기능 필요
    4. 사용자 친화적인 인터페이스: 사용자가 쉽게 접근하고 사용할 수 있는 직관적인 인터페이스 제공
   
  - ### 시스템 구성도
    ![구성도](https://github.com/HBNU-SWUNIV/come-capstone23-simsync/assets/57193435/d59c7b05-55c5-4b19-bda3-98e7da31c662)
  - ### 플로우 차트
    ![다이어그램](https://github.com/HBNU-SWUNIV/come-capstone23-simsync/assets/57193435/4f3fc842-b2b1-401d-9008-6a0da11cad1c)
## Result
<img width="972" alt="스크린샷 2023-10-27 오후 7 17 36" src="https://github.com/HBNU-SWUNIV/come-capstone23-simsync/assets/57193435/36aba73b-97c5-4b18-a347-b7cf122e6752">

<img width="611" alt="스크린샷 2023-10-27 오후 6 13 00" src="https://github.com/HBNU-SWUNIV/come-capstone23-simsync/assets/57193435/a3d39f32-55c9-4bfb-8f54-cbbff4b8b751">
  
  - ### Emergency test
![나의 동영상](https://github.com/HBNU-SWUNIV/come-capstone23-simsync/assets/57193435/71a8ae1f-29d2-4782-b679-d37e34923344)

## Conclusion
  - ### 사용자와 연결된 보호자는 실시간 건강 데이터 공유를 통해 적시에 의학적 조치를 취할 수 있어 응급 상황에서의 사망률 감소 및 생명을 구할 수 있는 기회 증가
  - ### 개인화된 건강 관리를 통한 일반적인 건강 상태 개선 및 의료비 절감
  - ### 익명화된 데이터를 이용한 건강 관리 연구 및 서비스 개선에 대한 실질적 기여
