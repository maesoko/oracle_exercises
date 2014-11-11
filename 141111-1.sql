CREATE TABLE dept1
        (deptno NUMBER(4) CONSTRAINT dept1_deptno_pk PRIMARY KEY,
         dname VARCHAR2(10) NOT NULL,
         loc VARCHAR2(10))
/
INSERT INTO dept1(deptno, dname, loc)
VALUES (100, 'システム', '那覇')
/
INSERT INTO dept1(deptno, dname, loc)
VALUES (100, 'システム', '那覇')
/
INSERT INTO dept1(deptno, dname, loc)
VALUES (101, NULL, '那覇')
/
DROP TABLE dept1
/
