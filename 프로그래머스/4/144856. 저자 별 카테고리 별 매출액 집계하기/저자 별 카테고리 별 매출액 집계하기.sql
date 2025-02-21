-- 코드를 입력하세요
select a.author_id,a.author_name,c.category,sum(total_sales) as total_sale
from (
        select book.book_id,category, (book.price*sales.pr) as total_sales,book.author_id
        from book
        inner join(
            SELECT book_id,sum(sales) as pr
            from book_sales
            where date_format(sales_date,'%Y-%m') = '2022-01'
            group by book_id
        ) as sales
        on book.book_id = sales.book_id
) as c
inner join author as a
on c.author_id = a.author_id
group by author_id,category
order by author_id, category desc;