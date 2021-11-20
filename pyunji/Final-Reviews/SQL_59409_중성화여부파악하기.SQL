select animal_id, name, 
    case when (sex_upon_intake like 'Intact%') then 'X'
    else 'O'
    end
from animal_ins
order by animal_id;