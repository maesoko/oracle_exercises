CREATE TABLE emp1(
        empno NUMBER(4) CONSTRAINT emp1_empno_pk PRIMARY KEY,
        ename VARCHAR2(10) CONSTRAINT emp1_ename_nn NOT NULL,
        deptno NUMBER(4), CONSTRAINT emp1_dept1_deptno_fk
        FOREIGN KEY (deptno) REFERENCES dept1(deptno))
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (100, '前底', 100)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (100, '前底', 100)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (101, NULL, 100)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (102, '前底', 101)
/
