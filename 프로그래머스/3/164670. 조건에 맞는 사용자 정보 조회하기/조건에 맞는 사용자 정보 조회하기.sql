-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, 
CONCAT(CITY," ",STREET_ADDRESS1," ",STREET_ADDRESS2) as "전체주소",
CONCAT(SUBSTRING(TLNO,1,3),"-",SUBSTRING(TLNO,4,4),"-",SUBSTRING(TLNO,8)) as "전화번호"
FROM used_goods_user uu inner join used_goods_board ub on uu.user_id = ub.writer_id
GROUP BY user_id
HAVING count(writer_id) >= 3
ORDER BY user_id DESC

