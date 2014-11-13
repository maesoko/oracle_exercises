CREATE TABLE emp1(
        empno NUMBER(4) CONSTRAINT emp1_empno_pk PRIMARY KEY,
        ename VARCHAR2(10) CONSTRAINT emp1_ename_nn NOT NULL,
        deptno NUMBER(4), CONSTRAINT emp1_dept1_deptno_fk
        FOREIGN KEY (deptno) REFERENCES departments(deptno))
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (10, '前底', 10)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (10, '前底', 10)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (101, NULL, 10)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (102, '前底', 101)
/
DROP TABLE emp1
/
