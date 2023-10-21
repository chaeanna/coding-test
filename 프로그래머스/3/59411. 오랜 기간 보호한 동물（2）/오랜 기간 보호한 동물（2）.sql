-- 코드를 입력하세요
SELECT ai.ANIMAL_ID, ai.NAME
FROM animal_ins as ai join animal_outs as ao on ai.animal_id = ao.animal_id
ORDER BY ao.datetime - ai.datetime desc
LIMIT 2