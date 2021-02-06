# 1005 self 정리 guru

EC2 권한을 크게 3가지로 나눠봤다. 

< EC2 Admin, EC2 support, S3 Support >

순서대로 EC2를 추가 제거 중지 시작 가능 / EC2 읽기만 가능 / S3읽기만 가능하다.



뒤의 2가지의 경우, EC2를 중지/시작/제거/추가가 불가능하다.

S3 Support는 버킷을 읽을 수 는 있지만, 버킷을 만들거나 삭제는 불가능하다.

EC2 Support의 EC2에서도 동일하다.





버킷 생성시 액세스 권한을 줄 수 있다.

여기서 주지 않으면, 파일을 업로드할 때 액세스권한을 주더라도 접근이 거부된다. 버킷 - 속성 - 버킷 정책에

```
{
    "Version": "2012-10-17",
    "Id": "unique-id-to-describe-below-statement",
    "Statement": [
        {
            "Sid": "unique-sid",
            "Effect": "Allow",
            "Principal": "*",
            "Action": [
                "s3:GetObject"
            ],
            "Resource": "arn:aws:s3:::내 버킷이름/*"
        }
    ]
}
```

이것을 추가해주면 접근이 가능해진다.





Glacier와 Deep Glacier.

**버킷 - 관리 - 수명 주기**에서  수명 주기를 설정할 수 있다.

수명 주기란, 현재 버전과 이전 버전의 파일에 일정시간 접근이 없었을 경우, 각각을 Glacier와 Deep Glacier로 이동시키는 것이다.





**static 호스팅도 가능하다.** 버킷 속성에서 설정하면 된다.

redirect도 가능한데, url이 복잡할 때 사용한다. Route 53 DNS Record로 .info 주소를 만들고, 새로운 버켓을  www.를 붙여서 만들어 redirect로 이어주면된다.

