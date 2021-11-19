-- 코드를 입력하세요
-- 대소문자를 구분하지 않는다고 하면 검색하는 내용을 LOWER로 바꿔서 검색하기 LIKE, IN 공부 좀 더하기
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE LOWER(NAME) LIKE '%el%' AND ANIMAL_TYPE = 'Dog'
ORDER BY NAME;