-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.ANIMAL_TYPE, ai.NAME
FROM animal_ins ai join animal_outs ao on ai.animal_id = ao.animal_id
WHERE ai.sex_upon_intake LIKE "Intact%" and ao.sex_upon_outcome NOT LIKE "Intact%"
ORDER BY ai.animal_id