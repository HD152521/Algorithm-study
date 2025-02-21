-- 코드를 입력하세요
select a.flavor
from (
    select *,sum(total_order) as s from first_half
    group by flavor
) as a
inner join (
    select *,sum(total_order) as s from july
    group by flavor
) as b
on a.SHIPMENT_ID = b.SHIPMENT_ID
order by (a.s+b.s) desc
limit 3;
