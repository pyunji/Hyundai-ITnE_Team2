SELECT i.animal_id, i.animal_type, i.name
FROM ANIMAL_INS i LEFT JOIN ANIMAL_OUTS o 
    on (i.animal_id = o.animal_id)
WHERE i.sex_upon_intake like 'Intact%'
and o.sex_upon_outcome not like 'Intact%'
ORDER BY i.animal_id;