SELECT name, count(name)
FROM ANIMAL_INS
GROUP BY name
HAVING count(name) > 1
ORDER BY name;