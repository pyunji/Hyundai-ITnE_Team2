-- 코드를 입력하세요
SELECT o.animal_id, o.name
  FROM ANIMAL_OUTS o LEFT JOIN ANIMAL_INS i
    ON o.animal_id = i.animal_id
 WHERE i.animal_id is null
 ORDER BY animal_id;