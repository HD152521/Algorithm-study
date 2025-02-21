-- 코드를 작성해주세요
select a.dept_id,dept_name_en,pr as avg_sal
from HR_DEPARTMENT as a

inner join (
    select dept_id, round(avg(sal),0) as pr
    from HR_EMPLOYEES 
    group by dept_id
) as b

on a.dept_id = b.dept_id

order by pr desc;