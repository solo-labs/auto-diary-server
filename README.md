# 📝 auto-diary-server
## 키워드를 입력하면 자동으로 재밌는 일기를 생성하는 앱

### 테스트 하기
1. Open AI api key 발급받기 - https://openai.com/api/
2. OpenAI-Organization key 찾기
3. ```application-local.yml``` 내부에 ```api-key```, ```org-key``` 기입
4. ```io.solabs.autodiary.service``` 패키지의 ```OpenAiServiceTest``` 클래스 실행하면 됨


### Request Ex
```
{
  "model": "text-davinci-003",
  "prompt": "아래 단어를 조합해서 일기를 써줘.\n날씨:맑음\n기분:안좋음\n활동:스키타기\n누구랑:김효정\n특별했던 일:지갑을 잃어버렸다",
  "max_tokens": 200,
  "temperature": 0.5
}
```

### Response Ex
```
{
    "id": "cmpl-6m05FMfDna0aHaWLANoh8DmGZdvNr",
    "object": "text_completion",
    "created": 1676898085,
    "model": "text-davinci-003",
    "choices": [
        {
            "text": "\n\n오늘은 맑고 화창한 날씨였지만 감정적으로는 안좋은 기분이었다. 스키타기를 하면서 김효정과 함께 특별한 일을 했다. 지갑을 잃어버리면서 시간을 보냈는데, 너무 즐거웠다",
            "index": 0,
            "logprobs": null,
            "finish_reason": "length"
        }
    ],
    "usage": {
        "prompt_tokens": 141,
        "completion_tokens": 200,
        "total_tokens": 341
    }
}
```
