# android2
2021학년도 2학기 안드로이드 프로그래밍 강의 과제입니다.

hw1_customview
커스텀뷰에서 터치할 때마다 터치한 위치에 사각형, 삼각형, 원을 랜덤하게 그린다.

hw2_notification
액티비티에 버튼을 만들고 버튼을 누를 때 알림을 표시하되, 2개 이상의 알림이 중복되어 나타나지 않도록 한다. 
알림의 내용에 액티비치가 시작한 이후 버튼을 누른 횟수가 표시되도록 한다. 
버튼을 계속 누르면서 알림을 지우지 않으면 알림에 버튼 누른 수가 계속 업데이트가 된다.

hw3_animation
Student를 선택한 화면에는 EditText 2개와 1,2,3,4를 선택하는 라디오버튼이 보이고 Worker를 선택한 화면에는 EditText 2개와 Coffee를 체크하는 체크박스가 보인다. 
Worker 화면에서 2번째 EditText는 다른 것보다 높이가 2배 크다.
만드는 방법은 Transition을 사용해도 되고 Property 애니메이션을 사용해도 된다.

hw4_room
학생 ID를 입력하고  ENROLL 버튼을 누르면 임의의 과목과 학생의 id를 enrollment에 추가, 학생 ID를 입력하고 DELETE 버튼을 누르면 해당 학생을 삭제

hw5_internet
EditText에 Username을 입력하면 해당 사용자의 github repository를 텍스트뷰에 표시한다.
이 때 해당 사용자의 Username과 repository 목록을 캐시에 저장한다.
캐시는 파일, Room, 메모리 저장 등 어떤 방법을 써도 상관 없다.
네트워크 연결을 강제로 끊고(비행기 모드) 한번도 입력한적 없는 Username을 입력하면 오류가 출력되고, 한번 입력한적이 있는 Username을 입력하면 캐시에서 해당 내용을 가져와 출력한다.

hw6_repositoryworkmanager
