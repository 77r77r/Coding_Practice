-- 코드를 입력하세요
SELECT pt_name, PT_NO, gend_cd, age,
    case when tlno is null then 'NONE' else tlno end as TLNO
from PATIENT 
where age <= 12
and gend_cd = 'W'
order by age desc, pt_name;