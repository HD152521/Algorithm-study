-- 코드를 입력하세요
SELECT rest_review.rest_id, rest_name, food_type, favorites, address, round(sum(review_score)/count(*),2) as score from rest_info
join rest_review on rest_review.rest_id=rest_info.rest_id
group by rest_id
having rest_info.address like '서울%'
order by score desc,favorites desc;
