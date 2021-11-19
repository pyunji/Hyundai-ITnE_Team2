-- 코드를 입력하세요
SELECT ins.ANIMAL_ID, ins.NAME
FROM ANIMAL_INS ins FULL OUTER JOIN ANIMAL_OUTS outs
ON ins.ANIMAL_ID = outs.ANIMAL_ID
WHERE ins.datetime > outs.datetime
ORDER BY ins.datetime;
