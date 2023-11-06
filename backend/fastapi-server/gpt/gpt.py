import os
from dotenv import load_dotenv
import openai
import time
from googletrans import Translator

# .env 파일 로드
load_dotenv()

# API 키 가져오기
openai.api_key = os.getenv("OPENAI_API_KEY")

# GPT로부터 댓글을 생성하는 함수를 정의합니다.
def generate_comment(prompt):
    response = openai.Completion.create(
        engine="text-davinci-003",
        prompt=prompt,
    )
    comment = response.choices[0].text.strip()
    return comment

# 개인 방송 중인 아이에게 격려하는 댓글을 생성하기 위한 프롬프트를 정의합니다.
prompt = "먹방 개인 방송을 하고 있는 아이에게 실시간 댓글을 달아주세요"

# 댓글을 생성합니다.
comment = generate_comment(prompt)

# 생성된 댓글을 출력합니다.
print(comment)