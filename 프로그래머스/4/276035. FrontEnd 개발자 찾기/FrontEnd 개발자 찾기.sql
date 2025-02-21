SELECT distinct d.id, d.email,d.first_name, d.last_name
FROM DEVELOPERS d JOIN SKILLCODES s
where d.skill_code & s.code
and s.category = 'Front End'
ORDER BY d.ID;