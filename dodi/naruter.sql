
/* Drop Tables */

DROP TABLE Commamd CASCADE CONSTRAINTS;
DROP TABLE FileList CASCADE CONSTRAINTS;
DROP TABLE Project CASCADE CONSTRAINTS;
DROP TABLE QnANIssue CASCADE CONSTRAINTS;
DROP TABLE WorkList CASCADE CONSTRAINTS;
DROP TABLE BoardType CASCADE CONSTRAINTS;
DROP TABLE messege CASCADE CONSTRAINTS;
DROP TABLE ChatRoom CASCADE CONSTRAINTS;
DROP TABLE ContactList CASCADE CONSTRAINTS;
DROP TABLE EduAndCareereAndLicense CASCADE CONSTRAINTS;
DROP TABLE Portfolio CASCADE CONSTRAINTS;
DROP TABLE Freelancer CASCADE CONSTRAINTS;
DROP TABLE MemberInfo CASCADE CONSTRAINTS;
DROP TABLE Client CASCADE CONSTRAINTS;
DROP TABLE ContactType CASCADE CONSTRAINTS;
DROP TABLE Manager CASCADE CONSTRAINTS;
DROP TABLE PMSMember CASCADE CONSTRAINTS;
DROP TABLE PMSList CASCADE CONSTRAINTS;
DROP TABLE SkillType CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_Ability_MemberNum;
DROP SEQUENCE SEQ_ChatRoom_crNum;
DROP SEQUENCE SEQ_Client_MemberNum;
DROP SEQUENCE SEQ_Commamd_cNum;
DROP SEQUENCE SEQ_EduAndCareereAndLicense_ECNum;
DROP SEQUENCE SEQ_EduAndCareere_ECNum;
DROP SEQUENCE SEQ_FileList_fNum;
DROP SEQUENCE SEQ_Freelancer_MemberNum;
DROP SEQUENCE SEQ_Manager_mNum;
DROP SEQUENCE SEQ_MemberInfo_MemberNum;
DROP SEQUENCE SEQ_messege_mNum;
DROP SEQUENCE SEQ_PMSList_PMSNum;
DROP SEQUENCE SEQ_PMSMember_memNum;
DROP SEQUENCE SEQ_Portfolio_PNum;
DROP SEQUENCE SEQ_Project_PJNum;
DROP SEQUENCE SEQ_Project_PNum;
DROP SEQUENCE SEQ_QnANIssue_qiNum;
DROP SEQUENCE SEQ_SkillData_SkillNum;
DROP SEQUENCE SEQ_SkillType_SkillNum;
DROP SEQUENCE SEQ_WorkList_wlnum;




/* Create Sequences */

CREATE SEQUENCE SEQ_Ability_MemberNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_ChatRoom_crNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Client_MemberNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Commamd_cNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_EduAndCareereAndLicense_ECNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_EduAndCareere_ECNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_FileList_fNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Freelancer_MemberNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Manager_mNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_MemberInfo_MemberNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_messege_mNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PMSList_PMSNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_PMSMember_memNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Portfolio_PNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Project_PJNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_Project_PNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_QnANIssue_qiNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_SkillData_SkillNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_SkillType_SkillNum INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_WorkList_wlnum INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE BoardType
(
	bType number NOT NULL UNIQUE,
	bName varchar2(50) NOT NULL UNIQUE,
	PRIMARY KEY (bType)
);


CREATE TABLE ChatRoom
(
	crNum number NOT NULL,
	PMSNum number NOT NULL UNIQUE,
	PRIMARY KEY (crNum)
);


CREATE TABLE Client
(
	-- 회원번호
	MemberNum number NOT NULL,
	-- 회사이름
	CompanyName varchar2(100) NOT NULL UNIQUE,
	-- 사업자등록번호
	-- (길이 필오)
	CompanyRegistrationNumber char(20) NOT NULL,
	-- 회사 주소
	CompanyAddress nvarchar2(300) NOT NULL,
	-- 기업형태
	CompanyType varchar2(60) NOT NULL,
	-- 업종
	BusinessVariety varchar2(300) NOT NULL,
	-- 기업 홈페이지 only En
	CompanySite varchar2(150),
	PRIMARY KEY (MemberNum)
);


CREATE TABLE Commamd
(
	cNum number NOT NULL,
	bType number NOT NULL UNIQUE,
	-- 쿼리로 가져와야해
	boradNum number NOT NULL,
	comMemId varchar2(100) NOT NULL,
	-- 댓글은 null
	-- 대댓글은 댓글의 number
	comParent number,
	-- 댓글 : 1
	-- 대댓글 : 2
	comLevel number NOT NULL,
	-- 댓글순서
	-- 
	ComOrder number,
	-- 날짜+시분초
	cdate char(14) NOT NULL,
	ctext varchar2(300) NOT NULL,
	PRIMARY KEY (cNum)
);


CREATE TABLE ContactList
(
	-- 회원번호 
	MemberNum number NOT NULL,
	ContactNum number(2,0) NOT NULL
);


CREATE TABLE ContactType
(
	ContactNum number(2,0) NOT NULL,
	ContactName varchar2(50) NOT NULL UNIQUE,
	ContactDesc varchar2(500) NOT NULL,
	PRIMARY KEY (ContactNum)
);


CREATE TABLE EduAndCareereAndLicense
(
	ECNum number NOT NULL,
	-- 회원번호 
	MemberNum number NOT NULL,
	-- Education : 1
	-- Career : 2
	-- license : 3
	-- 
	ECType char(1) NOT NULL,
	ECTitle varchar2(100) NOT NULL,
	-- 년 월만 저장 시작
	-- 자격증은 시작날짜만 받는다
	-- 
	ECStdate char(6) NOT NULL,
	-- 종료
	-- 
	ECEnddate char(6) NOT NULL,
	PRIMARY KEY (ECNum)
);


CREATE TABLE FileList
(
	fNum number NOT NULL,
	pnum number NOT NULL,
	-- 1 : project
	-- 2 : portfolio
	-- 3 : worklist
	ptype char(1) NOT NULL,
	PJNum number NOT NULL,
	wlnum number NOT NULL,
	PNum number NOT NULL,
	PRIMARY KEY (fNum)
);


CREATE TABLE Freelancer
(
	-- 회원번호 
	MemberNum number NOT NULL,
	SkillNum number(2,0) NOT NULL,
	-- 사용가능 기술 tag
	AbilityTag varchar2(500),
	PRIMARY KEY (MemberNum)
);


CREATE TABLE Manager
(
	mNum number NOT NULL,
	mId varchar2(50) NOT NULL UNIQUE,
	mPwd varchar2(1000) NOT NULL,
	PRIMARY KEY (mNum)
);


CREATE TABLE MemberInfo
(
	-- 회원번호 
	MemberNum number NOT NULL,
	-- 1 : 클라이언트
	-- 2 : 프리랜서
	MemberType char(1) NOT NULL,
	MemberId varchar2(100) NOT NULL UNIQUE,
	-- 회원비밀번호-암호화필요
	MemberPw varchar2(1000) NOT NULL,
	MemberName varchar2(60) NOT NULL,
	-- @뒷부분 모두 소문자 처리
	MemberEmail varchar2(100) NOT NULL UNIQUE,
	-- 회원 핸드폰 번호
	MemberPhone char(11) NOT NULL,
	-- 주소 api 사용?
	-- 시도, 군구, 컬럼 구분?
	MemberAddress varchar2(200),
	PRIMARY KEY (MemberNum)
);


CREATE TABLE messege
(
	mNum number NOT NULL,
	RoomNum number NOT NULL,
	memNum number NOT NULL,
	mText varchar2(1000) NOT NULL,
	-- 년월일 시분초
	-- 
	mDate char(14) NOT NULL,
	PRIMARY KEY (mNum)
);



CREATE TABLE PMSList
(
	PMSNum number NOT NULL,
	PJNum number NOT NULL UNIQUE,
	PRIMARY KEY (PMSNum)
);


CREATE TABLE PMSMember
(
	memNum number NOT NULL,
	PMSNum number NOT NULL,
	memName varchar2(30) NOT NULL,
	memId varchar2(50) NOT NULL,
	memPwd varchar2(500) NOT NULL,
	-- 직급
	memRank varchar2(50) NOT NULL,
	memPhone char(11) NOT NULL,
	PRIMARY KEY (memNum)
);


CREATE TABLE Portfolio
(
	PNum number NOT NULL,
	-- 회원번호 
	MemberNum number NOT NULL,
	PTitle varchar2(100) NOT NULL,
	PStDate char(8) NOT NULL,
	PEndDate char(8) NOT NULL,
	PMyPart number(2,0) NOT NULL,
	PDesc varchar2(1000) NOT NULL,
	PRIMARY KEY (PNum)
);


CREATE TABLE Project
(
	PJNum number NOT NULL,
	-- 회원번호
	MemberNum number NOT NULL,
	bType number NOT NULL UNIQUE,
	-- 프로젝트 명
	PTitle varchar2(100) NOT NULL,
	-- 계약금
	PPay number(10,0) NOT NULL,
	-- 작업 예상 기간
	-- 
	PDate char(8),
	-- 공고 기간 업로드
	PUploadDate char(8) NOT NULL,
	-- 프로젝트 타입
	-- ex)공공기관, 개인등
	PType varchar2(50) NOT NULL,
	-- 구하는 파트
	GetPartNum number(2,0),
	-- 구하는 인원
	GetPerMember number NOT NULL,
	-- 설명
	PDesc varchar2(1000) NOT NULL,
	-- PStayOrNot ==1이면
	-- 상주지역
	PStayArea varchar2(30),
	puploaddate char(16) NOT NULL,
	PRIMARY KEY (PJNum)
);


CREATE TABLE QnANIssue
(
	qiNum number NOT NULL,
	bType number NOT NULL UNIQUE,
	-- 쿼리문으로 가져오기
	-- 
	MemId varchar2(200) NOT NULL,
	title varchar2(100) NOT NULL,
	aidesc varchar2(1000) NOT NULL,
	cldate char(16) NOT NULL,
	PRIMARY KEY (qiNum)
);


CREATE TABLE SkillType
(
	SkillNum number(2,0) NOT NULL,
	-- 메인 스킬타입 정의
	MainSkill varchar2(30) NOT NULL UNIQUE,
	-- 세부 스킬 정의
	SubSkill varchar2(30) NOT NULL UNIQUE,
	-- 기술 설명
	SkillDesc varchar2(100),
	PRIMARY KEY (SkillNum)
);


CREATE TABLE WorkList
(
	wlnum number NOT NULL,
	PMSNum number NOT NULL,
	bType number NOT NULL UNIQUE,
	memNum number NOT NULL,
	wlTitle varchar2(50) NOT NULL,
	wldate char(14) NOT NULL,
	wlDesc varchar2(1000) NOT NULL,
	-- 미승인 : 0
	-- 승인 : 1
	wlgrant char(1) NOT NULL,
	PRIMARY KEY (wlnum)
);



/* Create Foreign Keys */

ALTER TABLE Commamd
	ADD FOREIGN KEY (bType)
	REFERENCES BoardType (bType)
;


ALTER TABLE Project
	ADD FOREIGN KEY (bType)
	REFERENCES BoardType (bType)
;


ALTER TABLE QnANIssue
	ADD FOREIGN KEY (bType)
	REFERENCES BoardType (bType)
;


ALTER TABLE WorkList
	ADD FOREIGN KEY (bType)
	REFERENCES BoardType (bType)
;


ALTER TABLE messege
	ADD FOREIGN KEY (RoomNum)
	REFERENCES ChatRoom (crNum)
;


ALTER TABLE MemberInfo
	ADD FOREIGN KEY (MemberNum)
	REFERENCES Client (MemberNum)
;


ALTER TABLE Project
	ADD FOREIGN KEY (MemberNum)
	REFERENCES Client (MemberNum)
;


ALTER TABLE ContactList
	ADD FOREIGN KEY (ContactNum)
	REFERENCES ContactType (ContactNum)
;


ALTER TABLE EduAndCareereAndLicense
	ADD FOREIGN KEY (MemberNum)
	REFERENCES Freelancer (MemberNum)
;


ALTER TABLE Portfolio
	ADD FOREIGN KEY (MemberNum)
	REFERENCES Freelancer (MemberNum)
;


ALTER TABLE ContactList
	ADD FOREIGN KEY (MemberNum)
	REFERENCES MemberInfo (MemberNum)
;


ALTER TABLE Freelancer
	ADD FOREIGN KEY (MemberNum)
	REFERENCES MemberInfo (MemberNum)
;


ALTER TABLE ChatRoom
	ADD FOREIGN KEY (PMSNum)
	REFERENCES PMSList (PMSNum)
;


ALTER TABLE PMSMember
	ADD FOREIGN KEY (PMSNum)
	REFERENCES PMSList (PMSNum)
;


ALTER TABLE Project
	ADD FOREIGN KEY (PJNum)
	REFERENCES PMSList (PJNum)
;


ALTER TABLE WorkList
	ADD FOREIGN KEY (PMSNum)
	REFERENCES PMSList (PMSNum)
;


ALTER TABLE messege
	ADD FOREIGN KEY (memNum)
	REFERENCES PMSMember (memNum)
;


ALTER TABLE WorkList
	ADD FOREIGN KEY (memNum)
	REFERENCES PMSMember (memNum)
;


ALTER TABLE FileList
	ADD FOREIGN KEY (PNum)
	REFERENCES Portfolio (PNum)
;


ALTER TABLE FileList
	ADD FOREIGN KEY (PJNum)
	REFERENCES Project (PJNum)
;


ALTER TABLE Freelancer
	ADD FOREIGN KEY (SkillNum)
	REFERENCES SkillType (SkillNum)
;


ALTER TABLE Portfolio
	ADD FOREIGN KEY (PMyPart)
	REFERENCES SkillType (SkillNum)
;


ALTER TABLE Project
	ADD FOREIGN KEY (GetPartNum)
	REFERENCES SkillType (SkillNum)
;


ALTER TABLE FileList
	ADD FOREIGN KEY (wlnum)
	REFERENCES WorkList (wlnum)
;



/* Comments */

COMMENT ON COLUMN Client.MemberNum IS '회원번호';
COMMENT ON COLUMN Client.CompanyName IS '회사이름';
COMMENT ON COLUMN Client.CompanyRegistrationNumber IS '사업자등록번호
(길이 필오)';
COMMENT ON COLUMN Client.CompanyAddress IS '회사 주소';
COMMENT ON COLUMN Client.CompanyType IS '기업형태';
COMMENT ON COLUMN Client.BusinessVariety IS '업종';
COMMENT ON COLUMN Client.CompanySite IS '기업 홈페이지 only En';
COMMENT ON COLUMN Commamd.boradNum IS '쿼리로 가져와야해';
COMMENT ON COLUMN Commamd.comParent IS '댓글은 null
대댓글은 댓글의 number';
COMMENT ON COLUMN Commamd.comLevel IS '댓글 : 1
대댓글 : 2';
COMMENT ON COLUMN Commamd.ComOrder IS '댓글순서
';
COMMENT ON COLUMN Commamd.cdate IS '날짜+시분초';
COMMENT ON COLUMN ContactList.MemberNum IS '회원번호 ';
COMMENT ON COLUMN EduAndCareereAndLicense.MemberNum IS '회원번호 ';
COMMENT ON COLUMN EduAndCareereAndLicense.ECType IS 'Education : 1
Career : 2
license : 3
';
COMMENT ON COLUMN EduAndCareereAndLicense.ECStdate IS '년 월만 저장 시작
자격증은 시작날짜만 받는다
';
COMMENT ON COLUMN EduAndCareereAndLicense.ECEnddate IS '종료
';
COMMENT ON COLUMN FileList.ptype IS '1 : project
2 : portfolio
3 : worklist';
COMMENT ON COLUMN Freelancer.MemberNum IS '회원번호 ';
COMMENT ON COLUMN Freelancer.AbilityTag IS '사용가능 기술 tag';
COMMENT ON COLUMN MemberInfo.MemberNum IS '회원번호 ';
COMMENT ON COLUMN MemberInfo.MemberType IS '1 : 클라이언트
2 : 프리랜서';
COMMENT ON COLUMN MemberInfo.MemberPw IS '회원비밀번호-암호화필요';
COMMENT ON COLUMN MemberInfo.MemberEmail IS '@뒷부분 모두 소문자 처리';
COMMENT ON COLUMN MemberInfo.MemberPhone IS '회원 핸드폰 번호';
COMMENT ON COLUMN MemberInfo.MemberAddress IS '주소 api 사용?
시도, 군구, 컬럼 구분?';
COMMENT ON COLUMN messege.mDate IS '년월일 시분초
';
COMMENT ON COLUMN PMSMember.memRank IS '직급';
COMMENT ON COLUMN Portfolio.MemberNum IS '회원번호 ';
COMMENT ON COLUMN Project.MemberNum IS '회원번호';
COMMENT ON COLUMN Project.PTitle IS '프로젝트 명';
COMMENT ON COLUMN Project.PPay IS '계약금';
COMMENT ON COLUMN Project.PDate IS '작업 예상 기간
';
COMMENT ON COLUMN Project.PUploadDate IS '공고 기간 업로드';
COMMENT ON COLUMN Project.PType IS '프로젝트 타입
ex)공공기관, 개인등';
COMMENT ON COLUMN Project.GetPartNum IS '구하는 파트';
COMMENT ON COLUMN Project.GetPerMember IS '구하는 인원';
COMMENT ON COLUMN Project.PDesc IS '설명';
COMMENT ON COLUMN Project.PStayArea IS 'PStayOrNot ==1이면
상주지역';
COMMENT ON COLUMN QnANIssue.MemId IS '쿼리문으로 가져오기
';
COMMENT ON COLUMN SkillType.MainSkill IS '메인 스킬타입 정의';
COMMENT ON COLUMN SkillType.SubSkill IS '세부 스킬 정의';
COMMENT ON COLUMN SkillType.SkillDesc IS '기술 설명';
COMMENT ON COLUMN WorkList.wlgrant IS '미승인 : 0
승인 : 1';



