-- 코드를 입력하세요
-- DECODE 사용하기
SELECT ANIMAL_ID, NAME, DECODE(SEX_UPON_INTAKE, 'Neutered Male', 'O', 'Spayed Female', 'O', 'X') as 중성화
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;