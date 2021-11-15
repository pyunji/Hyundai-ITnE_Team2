-- 코드를 입력하세요
-- DEcode 함수(컬럼 이름, 조건일 경우, 조건에 맞게, 조건이없으면)
SELECT ANIMAL_TYPE, DECODE(NAME,NULL,'No name',Name) as NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
order by ANIMAL_Id;