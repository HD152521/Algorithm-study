-- 코드를 입력하세요
select a.product_id, a.product_name,(a.price*cnt) as total_sales
from food_product as a
join (
    SELECT *,sum(amount) as cnt
    from food_order
    where date_format(PRODUCE_DATE,'%Y-%m') = '2022-05'
    group by product_id
) as b
on a.product_id = b.product_id
order by total_sales desc, product_id;