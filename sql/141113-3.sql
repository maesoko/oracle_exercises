CREATE INDEX idx_emp3_ename
ON emp3(ename)
/
select table_name, column_name, index_name, index_type
from user_indexes natural join user_ind_columns
where table_name = 'EMP3'
/
DROP INDEX idx_emp3_ename
/
