-- 코드를 작성해주세요

select count(*) as 'FISH_COUNT'
from FISH_INFO i
inner join fish_name_info n
on i.fish_type = n.fish_type
where n.fish_name in ('BASS', 'SNAPPER');