SELECT SUBSTR('Oracle Server', 2, 3) AS "2文字目から3文字",
SUBSTR('Oracle Server', 2, LENGTH('Oracle Server')) AS "2文字目以降"
FROM DUAL
/
