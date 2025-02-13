# API 목록
# 일정관련 API
| Method | Path                | Request    | Response                                        | Description | StatusCode |
|--------|---------------------|------------|-------------------------------------------------|-------------|------------|
| GET    | /api/schedules      | -          | [{"id":1, "title": "회의", "date": "2025-02-04"}] | 전체 일정 조회    |  200 |
| GET    | /api/schedules/{id} | id (일정 ID) | {"id": 1, "title": "회의", "date": "2025-02-04"}   | 특정 일정 조회    | 200 |
|POST    | /api/schedules      | {"title": "회의", "date": "2025-02-04", "description": " 팀 회의", "author": "홍길동", "password": "1234"} | {"id": 1, "title": "회의"} | 일정생성 | 201|
|PUT | /api/schedules/{id} | {"title": "수정된 회의", "date": "2025-02-04"} | {"id": 1, "title": "수정된 회의"} | 일정 수정 | 200|
|DELETE | /api/schedules/{id} | id (일정 ID) | {"messaage": "삭제 완료"} | 일정 삭제 | 200 |

# 유저관련 API
| Method | Path                | Request                                                            | Response              | Description | StatusCode |
|--------|---------------------|--------------------------------------------------------------------|-----------------------|-------------|------------|
| GET    | /api/users          | -                                                                  | [{"id":1, "username": "홍길동"}] | 유저 전체 조회    |  200 |
| GET    | /api/users/{id}     | -                                                                  | {"id": 1, "username": "홍길동"} | 특정 유저 조회    | 200 |
| POST   | /api/users/signup   | {"username": "홍길동", "email": "test@email.com", "password": "1234"} | {"id": 1, "username": "홍길동"} | 회원가입        | 201|
| POST   | /api/users/login    | {"email": "test@email.com", "password": "1234"}                    | {"message": "로그인 성공"} | 로그인         | 200|






