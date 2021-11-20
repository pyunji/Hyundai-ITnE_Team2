SELECT i.animal_id, i.name
FROM animal_ins i inner join animal_outs o
on o.animal_id = i.animal_id
where i.datetime > o.datetime
ORDER BY i.datetime;