const scholar = [
    {
        "id": 1,
        "name": "James Gosling",
        "introduction": "캐나다 출신의 컴퓨터 과학자로, 자바(Java) 프로그래밍 언어의 창시자",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/14/James_Gosling_2008.jpg/225px-James_Gosling_2008.jpg"
    },
    {
        "id": 2,
        "name": "Linus Torvalds",
        "introduction": "태어난 스웨덴계 핀란드인으로서 소프트웨어 엔지니어이자 리눅스 커널과 깃을 최초로 개발한 사람",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg/255px-LinuxCon_Europe_Linus_Torvalds_03_%28cropped%29.jpg"
    },
    {
        "id": 3,
        "name": "Steven Paul Jobs",
        "introduction": "처음으로 PC에 GUI를 사용, mouse를 PC에 적용하여 대중화, 온라인 음악시장의 성공적인 모델을 보여준 인물",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dc/Steve_Jobs_Headshot_2010-CROP_%28cropped_2%29.jpg/225px-Steve_Jobs_Headshot_2010-CROP_%28cropped_2%29.jpg"
    },
    {
        "id": 4,
        "name": "Tim Berners-Lee",
        "introduction": "1990년에 인터넷과 하이퍼텍스트의 개념을 합치면서 WWW{World Wide Web}을 만들어 냈다",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Sir_Tim_Berners-Lee_%28cropped%29.jpg/220px-Sir_Tim_Berners-Lee_%28cropped%29.jpg"
    },
    {
        "id": 5,
        "name": "Bill Gates",
        "introduction": "마이크로소프트를 창립하고 윈도우즈 운영체제를 개발하여 개인용 컴퓨터 보급에 큰 역할을 했다",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fc/Bill_Gates_-_2023_-_P062021-967902_%28cropped%29.jpg/220px-Bill_Gates_-_2023_-_P062021-967902_%28cropped%29.jpg"
    },
    {
        "id": 6,
        "name": "Richard Stallman",
        "introduction": "오픈 소스 운동과 GNU 프로젝트의 창시자로 알려져 있다.",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Richard_Stallman_at_LibrePlanet_2019.jpg/220px-Richard_Stallman_at_LibrePlanet_2019.jpg"
    },
    {
        "id": 7,
        "name": "Ted Codd",
        "introduction": "영국의 컴퓨터 과학자로, 관계형 데이터베이스의 개념을 처음 제안한 주요 인물 ",
        "img": "https://upload.wikimedia.org/wikipedia/en/thumb/5/58/Edgar_F_Codd.jpg/150px-Edgar_F_Codd.jpg"
    },
    {
        "id": 8,
        "name": "Alan Turing",
        "introduction": "컴퓨터 과학과 인공지능 분야의 선구자로, 튜링 기계 개념과 튜링 테스트 등을 제시한 수학자",
        "img": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/17/Alan_Turing_%281912-1954%29_in_1936_at_Princeton_University.jpg/220px-Alan_Turing_%281912-1954%29_in_1936_at_Princeton_University.jpg"
    },{
        "id":9,
        "name" : "Evan You",
        "introduction" : "Vue.js와 프론트엔드 빌드 도구 Vite 프레임워크의 창시자로 해당 프레임워크의 대부분을 개발하고 오픈 소스로 공개하여 많은 개발자가 사용할 수 있도록 함.",
        "img" : "https://images.ctfassets.net/s5uo95nf6njh/5PpFIeuDxz2T89nZNED1EP/48d62a69f31a3ab6dfc58938eb7b8c2a/evan-you-portrait.jpg?w=1200&fm=jpg"
    }
] ;

const msaSkill = [
    {
        "id" : 1,
        "skill" : "컨테이너",
        "list" : ["Podman","Docker", "Buildah" ],
        "introduction" : "컨테이너는 애플리케이션과 그 의존성을 하나의 패키지로 묶어 배포 및 실행할 수 있도록 하는 기술",
        "imgs" : [
            "https://blog.kakaocdn.net/dn/DOrtu/btrtwkC0Syd/Lp9pyw9zWtoMvmiMJgFZSk/img.png",
            "https://blog.kakaocdn.net/dn/crVZJi/btsB7PtWTW1/RjPjZM14myutvk0Zb6Fuck/img.png",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRktLoqt1MECTjk_yJBvNCBf1tJcYuHSZ2nCY0eQRtvQMNobVzF71TeMtyNg_qCjU6ZHGo&usqp=CAU"
        ]
    },
    {
        "id" : 2,
        "skill" : "오케스트레이션",
        "list" : ["Kubernetes", "Docker Swarm", "Nomad"],
        "introduction" : "오케스트레이션 기술은 여러 컨테이너를 관리하고 조율하는 데 사용",
        "imgs" : [
            "https://velog.velcdn.com/images/squarebird/post/a6dd8c26-b133-4e51-9241-92f1631954b2/image.png",
            "https://getcarina.github.io/jupyterhub-tutorial/slides/img/docker-swarm.png",
            "https://www.ibm.com/content/dam/adobe-cms/instana/media_logo/Nomad.png/_jcr_content/renditions/cq5dam.web.1280.1280.png"
        ]
    },
    {
        "id":3,
        "skill" :"API 게이트웨이",
        "list" : ["Spring Cloud Gateway","Netflix Zuul", "AWS API Gateway"],
        "introduction" : "API 게이트웨이는 클라이언트와 마이크로서비스 간의 통신을 중개하는 역할",
        "imgs":[
            "https://velog.velcdn.com/images/junyoungs7/post/868647fc-b2e6-439a-8260-6956b734fd2c/image.png",
            "https://camo.githubusercontent.com/c9c03fc8fd1261971c38aafd0b95f59eee0af2b435277586949579dfe8b5198d/68747470733a2f2f692e696d6775722e636f6d2f6d52536f7345702e706e67",
            "https://www.prolim.com/wp-content/uploads/2019/09/amazon-api-gatewat-1.jpg"
        ]
    },
    {
        "id":4,
        "skill" :"서비스 디스커버리",
        "list": ["eureka", "Consul","ZooKeeper"],
        "introduction" : "서비스 디스커버리는 클라이언트가 필요한 서비스를 찾을 수 있도록 하는 기술",
        "imgs":[
            "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcyuEGB%2Fbtra4XyMBh7%2FNoYCojKK2FJKxo9LnquKKK%2Fimg.png",
            "https://connect.redhat.com/s3api/prod-s3api/1627597739-logo-url-60f9f0a2457b3a081d621c41.png",
            "https://www.ibm.com/content/dam/adobe-cms/instana/media_logo/Zookeeper.component.complex-narrative-xl.ts=1690899249998.png/content/adobe-cms/kr/ko/products/instana/supported-technologies/monitoring-zookeeper/_jcr_content/root/table_of_contents/body/content_section_styled/content-section-body/complex_narrative/logoimage"
        ]
    },
    {
        "id":5,
        "skill" : "지속적인 통합 및 배포(ci/cd)",
        "list" : ["gitbub actions", "jenkins", "circleci"],
        "introduction" : "CD는 코드 변경을 자동으로 테스트, 빌드, 배포하는 프로세스",
        "imgs":[
            "https://avatars.githubusercontent.com/u/44036562?s=280&v=4",
            "https://miro.medium.com/v2/resize:fit:860/1*ByoJvUAuB0L00yk1UhkEiw.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/8/82/Circleci-icon-logo.svg/220px-Circleci-icon-logo.svg.png"
        ]
    },
    {
        "id":6,
        "skill" : "모니터링 및 로그 분석",
        "list": ["Prometheus","grafana", "elk"],
        "introduction" : "모니터링 및 로그 분석은 서비스의 상태 및 성능을 추적",
        "imgs":[
            "https://prometheus.io/assets/favicons/android-chrome-192x192.png",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a1/Grafana_logo.svg/1200px-Grafana_logo.svg.png",
            "https://burnhamforensics.com/wp-content/uploads/2019/03/elk-2.png?w=768"
        ]
    },
    {
        "id":7,
        "skill" : "데이터 관리",
        "introduction" : " MSA에서 데이터 관리는 여러 서비스 간에 데이터를 일관되게 관리하는 것을 의미.",
    },
    {
        "id":8,
        "skill" : "보안",
        "introduction" : "MSA에서 보안은 각 서비스를 보호하고 서비스 간의 통신을 안전하게 유지",
    },
    {
        "id":9,
        "skill" : "네트워킹",
        "introduction" : "MSA에서 네트워킹은 서비스 간의 통신을 효율적이고 안정적으로 유지하는 것을 의미",
    },
]
