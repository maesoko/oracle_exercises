alter session set nls_date_format = 'RR-MM-DD'
/
alter session set nls_date_language = 'JAPANESE'
/
SELECT TO_DATE('2011年01月01日', 'YYYY"年"MM"月"DD"日"')
FROM DUAL
/
