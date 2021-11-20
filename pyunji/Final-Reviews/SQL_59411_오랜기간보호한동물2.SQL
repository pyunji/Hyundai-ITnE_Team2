-- 코드를 입력하세요
SELECT i.animal_id, i.name
  FROM ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o
    ON i.animal_id = o.animal_id
 WHERE o.animal_id is not null
 ORDER BY (o.datetime - i.datetime) desc
 FETCH FIRST 2 ROWS ONLY;