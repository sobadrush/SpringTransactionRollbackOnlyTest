USE DB_Emp_Dept;
--DROP TABLE EMP_TB;
--DROP TABLE DEPT_TB;
CREATE TABLE DEPT_TB
(
    deptno	int IDENTITY(10,10) PRIMARY KEY  not null,
	dname	varchar(14),
	loc		varchar(13)
);
CREATE TABLE EMP_TB
(
    empno	 int IDENTITY(7001,1) PRIMARY KEY not null,
	ename	 varchar(14),
	job		 varchar(13),
	hiredate  date,
	deptno int not NULL FOREIGN KEY REFERENCES DEPT_TB(deptno)
	--Hibernate 做關聯查詢其實可以不用在實體表格設定foreign-key
);

INSERT INTO DEPT_TB VALUES ('財務部','臺灣台北');
INSERT INTO DEPT_TB VALUES ('研發部','臺灣新竹');
INSERT INTO DEPT_TB VALUES ('業務部','美國紐約');
INSERT INTO DEPT_TB VALUES ('生管部','中國上海');

INSERT INTO EMP_TB VALUES ('king','president','1981-11-17',10);
INSERT INTO EMP_TB VALUES ('blake','manager','1981-05-01',30);
INSERT INTO EMP_TB VALUES ('clark','manager','1981-01-09',10);
INSERT INTO EMP_TB VALUES ('jones','manager','1981-04-02',20);
INSERT INTO EMP_TB VALUES ('martin','salesman','1981-09-28',30);
INSERT INTO EMP_TB VALUES ('allen','salesman','1981-02-2',30);
INSERT INTO EMP_TB VALUES ('turner','salesman','1981-09-28',30);
INSERT INTO EMP_TB VALUES ('james','clerk','1981-12-03',30);
INSERT INTO EMP_TB VALUES ('ward','salesman','1981-02-22',30);
INSERT INTO EMP_TB VALUES ('ford','analyst','1981-12-03',20);
INSERT INTO EMP_TB VALUES ('smith','clerk','1980-12-17',20);
INSERT INTO EMP_TB VALUES ('scott','analyst','1981-12-09',20);
INSERT INTO EMP_TB VALUES ('adams','clerk','1983-01-12',20);
INSERT INTO EMP_TB VALUES ('miller','clerk','1982-01-23',10);


--UPDATE dbo.DEPT_TB SET dname='數位金融部',loc='B棟18樓' WHERE deptno=90;
--DELETE FROM dbo.DEPT_TB WHERE deptno=60;

