-- 코드를 입력하세요
SELECT i.name, i.datetime
  FROM ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o
    ON i.animal_id = o.animal_id
 WHERE o.animal_id is null
 ORDER BY i.datetime
 FETCH FIRST 3 ROWS ONLY;