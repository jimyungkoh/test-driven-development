# test-driven-development

[전체 학습 내용에 대한 포스팅](https://jimyungkoh.github.io/web%20study/2022/01/11/web-study02.html)

***'test-driven-development' 리포지토리는 [테스트 주도 개발. 켄트 벡 저 김창준, 강규영 역 인사이트] 책을 읽으며 학습한 내용을 기록했습니다.***

테스트 주도 개발은 ‘개발 → 테스트’ 사이클에서 벗어나 ‘테스트 → 개발’ 사이클을 지향하는 소프트웨어 개발 방법론입니다.

테스트 주도 개발은 ‘더 깔끔한, 더 완성도 높은 코드’를 작성할 수 있게 해주며 동시에 ‘개발 시간 단축, 소프트웨어 결함 최소화'를 가능하게 합니다.

~~극단적으로 테스트를 하지 않고 대기업 시스템을 개발하고 배포했을 때 문제가 생긴다면 얼마나 많은 시간과 비용이 소모될까요?~~

테스트 주도 개발의 목표는 ‘작동하는 깔끔한 코드’입니다. 그리고 이 목표를 위해 두 가지 원칙을 지켜야 합니다.

1. 오직 자동화된 테스트가 실패할 경우에만 새로운 코드를 작성한다.
    1. 빨강: 실패하는 작은 테스트를 작성한다. 처음에는 컴파일조차 되지 않을 수 있다.
    2. 초록: 빨리 테스트가 통과되게끔 만든다. 어떤 수단과 방법(복붙, 하드 코딩 등)을 동원해서든. 
2. 중복을 제거한다.
- 테스트를 통과하는 과정에서 생긴 모든 중복을 제거한다.

본 리포지토리는 책의 내용 순서에 맞추어 세 가지 세션으로 구성되었으며 책의 내용을 따라가며 ‘테스트 주도 개발’을 익히는 것이 목적입니다.

목차 📚
- [section1-다중 통화를 지원하는 money 객체](section1/moneyExample/README.md)
- [section1-타락한 객체](section1/degenerateObjects/README.md)
- [section1-모두를 위한 평등](section1/equalityForAll/README.md)
- [section1-프라이버시](section1/privacy/README.md)
- [section1-솔직히 말하자면](section1/franclySpeaking/README.md)
- [section1-돌아온 모두를 위한 평등](section1/equalityForAllRedux/README.md)
- [section1-사과와 오렌지](section1/applesAndOranges/README.md)