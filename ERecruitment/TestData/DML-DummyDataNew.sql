-- Note PASSWORDS ARE ALL 11111111 ( 8 1's)

delete from ER_WORK_HISTORY;
delete from ER_EDUCATION;
delete from ER_APPLICANT_PROFILE;
delete from er_role;

delete from ER_JOB_APPLICATION;
delete from ER_JOBS;

delete from er_users;
commit;


INSERT INTO er_role VALUES(1, 'admin');
INSERT INTO er_role VALUES(2, 'applicant');
INSERT INTO er_role VALUES(3, 'recruiter');
INSERT INTO er_role VALUES(4, 'staff');
INSERT INTO er_role VALUES(5, 'manager');

--  recruiter 1 & Jobs
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '1@1.1', 'Recruiter1', 'Foolast1', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '3');
Insert into TRAINEE1.ER_JOBS (JOB_ID,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'You CAN get a Java job, but most of you will not','Java Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','Java Developper',ER_USERS_SEQ.CURRVAL);

-- Applicants & job applications & profiles
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '3@3.3', 'Foo3', 'Foolast3', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '2');
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_APPLICANT_PROFILE (APPLICANT_ID,ADDRESS,INTERESTS,PRIMARY_PHONE,SECONDARY_PHONE,SKILLS,RESUME_FILE_ID,USER_USER_ID) values (er_applicant_seq.nextval,'100 Bayview Ave','Boys|Girls','416-967-2222','416-967-1111','Java|CSS',null,ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_JOB_APPLICATION (JOB_APPLICATION_ID,SCORE,STATUS,APPLICANT_USER_ID,JOB_JOB_ID) values (ER_JOB_APPLICATION_SEQ.nextval,1,null,ER_USERS_SEQ.CURRVAL,ER_JOB_SEQ.CURRVAL);

-- Applicants & job applications & profiles
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '4@4.4', 'Foo4', 'Foolast4', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '2');
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_APPLICANT_PROFILE (APPLICANT_ID,ADDRESS,INTERESTS,PRIMARY_PHONE,SECONDARY_PHONE,SKILLS,RESUME_FILE_ID,USER_USER_ID) values (er_applicant_seq.nextval,'100 Bayview Ave','Boys|Girls','416-967-2222','416-967-1111','Java|CSS',null,ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_JOB_APPLICATION (JOB_APPLICATION_ID,SCORE,STATUS,APPLICANT_USER_ID,JOB_JOB_ID) values (ER_JOB_APPLICATION_SEQ.nextval,10,null,ER_USERS_SEQ.CURRVAL,ER_JOB_SEQ.CURRVAL);

--recruiter 2 & job
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '2@2.2', 'Recruiter2', 'Foolast2', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '3');
Insert into TRAINEE1.ER_JOBS (JOB_ID,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'App support job for all. Stay late at night, but get the possiblity of overtime, to make 2x as much as Java developers. Hate your life!!!','Unix Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','App Support',ER_USERS_SEQ.CURRVAL);

-- Applicants & job applications & profiles
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '5@5.5', 'Foo5', 'Foolast5', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '2');
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_APPLICANT_PROFILE (APPLICANT_ID,ADDRESS,INTERESTS,PRIMARY_PHONE,SECONDARY_PHONE,SKILLS,RESUME_FILE_ID,USER_USER_ID) values (er_applicant_seq.nextval,'100 Bayview Ave','Boys|Girls','416-967-2222','416-967-1111','Java|CSS',null,ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_JOB_APPLICATION (JOB_APPLICATION_ID,SCORE,STATUS,APPLICANT_USER_ID,JOB_JOB_ID) values (ER_JOB_APPLICATION_SEQ.nextval,12,null,ER_USERS_SEQ.CURRVAL,ER_JOB_SEQ.CURRVAL);

/* IGNORE THIS STUFF BELOW
INSERT INTO er_role VALUES(1, 'admin');
INSERT INTO er_role VALUES(2, 'applicant');
INSERT INTO er_role VALUES(3, 'recruiter');
INSERT INTO er_role VALUES(4, 'staff');
INSERT INTO er_role VALUES(5, 'manager');

--  recruiter
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '1@1.1', 'Foo1', 'Foolast1', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '3');
Insert into TRAINEE1.ER_JOBS (ER_JOB_SEQ.NEXTVAL,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'You CAN get a Java job, but most of you will get shitty jobs so don''t hold your hopes too high. Just owe us 30,00k and stay with us for 2 years.','Java Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','Java Developper',ER_USERS_SEQ.CURRVAL);



INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '2@2.2', 'Foo2', 'Foolast2', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '3');
Insert into TRAINEE1.ER_JOBS (ER_JOB_SEQ.NEXTVAL,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'App support job for all. Stay late at night, but get the possiblity of overtime, to make 2x as much as Java developers. Hate your life!!!','Unix Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','App Support',ER_USERS_SEQ.CURRVAL);

-- Applicants
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '3@3.3', 'Foo3', 'Foolast3', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '2');
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);

INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, '4@4.4', 'Foo4', 'Foolast4', '$2a$10$h64bTLJ5nU1Z/q0vPRoz2.pW7VXR76ZlkFFMA2pHSvBQKj5gIFuLe', '2');
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),ER_USERS_SEQ.CURRVAL);



Insert into TRAINEE1.ER_JOBS (ER_JOB_SEQ.NEXTVAL,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'You CAN get a Java job, but most of you will get shitty jobs so don''t hold your hopes too high. Just owe us 30,00k and stay with us for 2 years.','Java Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','Java Developper',2);


Insert into TRAINEE1.ER_JOBS (ER_JOB_SEQ.NEXTVAL,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'You CAN get a Java job, but most of you will get shitty jobs so don''t hold your hopes too high. Just owe us 30,00k and stay with us for 2 years.','Java Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','Java Developper',2);


INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'a@fdmgroup.com', 'A', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '2');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'b@fdmgroup.com', 'B', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '2');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'c@fdmgroup.com', 'C', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '2');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'd@fdmgroup.com', 'D', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '3');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'e@fdmgroup.com', 'E', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '3');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'f@fdmgroup.com', 'F', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '3');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'g@fdmgroup.com', 'G', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '4');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'h@fdmgroup.com', 'H', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '4');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'i@fdmgroup.com', 'I', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '4');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'j@fdmgroup.com', 'J', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '5');
INSERT INTO er_users VALUES(ER_USERS_SEQ.NEXTVAL, 1, 0, 'k@fdmgroup.com', 'K', 'Foolast', '$2a$08$6.PDIazvktIwhKUBWH4ftux0/rnCxJPtcCl2dKGuRiFmuPXyhDhzW', '1');

REM INSERTING into TRAINEE1.ER_USERS
SET DEFINE OFF;
Insert into TRAINEE1.ER_USERS (USER_ID,ACTIVE,BLOCKED,EMAIL,FIRST_NAME,LAST_NAME,PW,ROLE_ROLE_ID) values (ER_USERS_SEQ.nextval,1,0,'a@a.a','Saba','Sanatgar','$2a$10$b5lXo41uH17Rhr/c5IgRXeFYy5RnSYY3ky4XeIw4dO5CvwLWlOPK2',0);
Insert into TRAINEE1.ER_USERS (USER_ID,ACTIVE,BLOCKED,EMAIL,FIRST_NAME,LAST_NAME,PW,ROLE_ROLE_ID) values (ER_USERS_SEQ.nextval,1,0,'s@s.s','Sara','Law','$2a$10$/fc6nUEm422tXiT5JMtT5.q3JKxgW2Sx2Kpn0i1dRVwKnfrmNphaW',1);
REM INSERTING into TRAINEE1.ER_WORK_HISTORY
SET DEFINE OFF;
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Tested fart flamability to ensure that the maximum danger exposure is limited when farts are done within an underwear','Hanes',to_date('11-JUN-16','DD-MON-RR'),to_date('08-JUN-16','DD-MON-RR'),'Fart Tester',1);
Insert into TRAINEE1.ER_WORK_HISTORY (WORK_HISTORY_ID,DESCRIPTION,EMPLOYER,END_DATE,START_DATE,TITLE,APPLICANTPROFILE_APPLICANT_ID) values (er_work_history_seq.nextval,'Transfered files around the bank beceause no one else wanted to. Serisouly, why did I ever take this job, I wish I could go back in time and stand my ground. ','RBC Capital Markets',to_date('03-JUN-16','DD-MON-RR'),to_date('05-JUN-15','DD-MON-RR'),'File Transfer-er',1);
REM INSERTING into TRAINEE1.ER_USERS_ER_INTERVIEWS
SET DEFINE OFF;
REM INSERTING into TRAINEE1.ER_JOBS
SET DEFINE OFF;
Insert into TRAINEE1.ER_JOBS (JOB_ID,DEADLINE_DATE,DESCRIPTION,KEYWORDS,NUM_OF_POSITIONS,START_DATE,STATUS,TITLE,JOBPOSTER_USER_ID) values (er_job_seq.nextval,to_date('07-JUN-16','DD-MON-RR'),'You CAN get a Java job, but most of you will get shitty jobs so don''t hold your hopes too high. Just owe us 30,00k and stay with us for 2 years.','Java Css',3,to_date('09-JUN-16','DD-MON-RR'),'ACTIVE','Java Developper',2);
REM INSERTING into TRAINEE1.ER_EDUCATION
SET DEFINE OFF;
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BSC',to_date('07-JUN-16','DD-MON-RR'),'Ryerson','Computers',to_date('10-JUN-15','DD-MON-RR'),1);
Insert into TRAINEE1.ER_EDUCATION (EDUCATION_ID,DEGREE,END_DATE,INSTITUTION,PROGRAM,START_DATE,APPLICANTPROFILE_APPLICANT_ID) values (er_education_seq.nextval,'BA',to_date('07-JUN-16','DD-MON-RR'),'Western','Poli Sci',to_date('10-JUN-15','DD-MON-RR'),1);
REM INSERTING into TRAINEE1.ER_JOB_APPLICATION
SET DEFINE OFF;
Insert into TRAINEE1.ER_JOB_APPLICATION (JOB_APPLICATION_ID,SCORE,STATUS,APPLICANT_USER_ID,JOB_JOB_ID) values (er_job_application_seq.nextval,1,null,1,1);
REM INSERTING into TRAINEE1.ER_INVITATIONS
SET DEFINE OFF;
REM INSERTING into TRAINEE1.ER_APPLICANT_PROFILE
SET DEFINE OFF;
Insert into TRAINEE1.ER_APPLICANT_PROFILE (APPLICANT_ID,ADDRESS,INTERESTS,PRIMARY_PHONE,SECONDARY_PHONE,SKILLS,RESUME_FILE_ID,USER_USER_ID) values (er_applicant_profile_seq.nextval,'123 Bay street','Boys|Girls','647-219-4882','444-222-2122','Manhandling|Touching|crying',1,1);
Insert into TRAINEE1.ER_APPLICANT_PROFILE (APPLICANT_ID,ADDRESS,INTERESTS,PRIMARY_PHONE,SECONDARY_PHONE,SKILLS,RESUME_FILE_ID,USER_USER_ID) values (er_applicant_profile_seq.nextval,null,null,null,null,null,null,2);
*/