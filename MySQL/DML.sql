SELECT *FROM COURSE;
SELECT *FROM STUDENTUNOFFICIAL;
SELECT *FROM STUDENTOFFICIAL;
SELECT *FROM PROFILE;
SELECT *FROM REGISTER;
SELECT *FROM RESULT;
SELECT *FROM COST;
SELECT *FROM SCHEDULE;
SELECT *FROM CLASS;
SELECT *FROM TEACHER;
SELECT *FROM TIMEKEEPING;

SELECT stoff.IdStudent,pr.Id, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,stunoff.Cost,stunoff.DiscountStatus,
res.StudyMark, res.RewardMark, res.DisciplineMark, res.MoneyPaid, res.NumberOfAbsences, reg.State, reg.TypeOfRegister
FROM STUDENTOFFICIAL stoff
INNER JOIN RESULT res ON stoff.IdStudent=res.IdStudent AND stoff.IdClass=res.IdClass
INNER JOIN PROFILE pr ON stoff.IdProfile=pr.Id
INNER JOIN STUDENTUNOFFICIAL stunoff ON stunoff.Id=stoff.IdStudent
INNER JOIN REGISTER reg ON reg.IdStudent=stoff.IdStudent;



SELECT st.Id, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost, rs.StudyMark, rs.RewardMark, rs.DisciplineMark, rs.MoneyPaid, rs.NumberOfAbsences
FROM STUDENTUNOFFICIAL st
INNER JOIN REGISTER rg ON st.Id= rg.IdStudent
INNER JOIN PROFILE pr ON st.Id= pr.Id
INNER JOIN RESULT rs ON st.Id=rs.IdStudent;


SELECT cl.Id, cl.Name, cl.StudentQuantity, cl.IdTeacher, cl.IdCourse, cl.IdSchedule, sch.DaysOfWeek, sch.StartTime, sch.EndTime FROM CLASS cl
INNER JOIN SCHEDULE sch ON cl.IdSchedule=sch.Id; 


SELECT tc.Id,tc.IdProfile, pr.Name, pr.Gender,  pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber,tc.Workplace, tc.Salary, pr.Email, tk.TeachingHours, tk.RewardLevel, tk.DisciplineLevel  
FROM TEACHER tc
INNER JOIN PROFILE pr ON pr.Id=tc.IdProfile
INNER JOIN TIMEKEEPING tk ON tk.IdTeacher=tc.Id;

SELECT c.Id, c.Name, 
c.ClassQuantity, c.StartDay, c.EndDay, co.Price FROM COURSE c
INNER JOIN COST co ON c.IdCost=co.Id;


INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Vu Thi Bich Thu', '1', '2000-07-12', '0832890865', 'Quang Nam', 'Da Nang', '206360509', 'vuthibichthu@gmail.com', 'Pro01');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Phan Trong Duc', '0', '2000-04-12', '0837790865', 'Phu Yen', 'Da Nang', '306360509', 'phantrongduc@gmail.com', 'Pro02');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Hong', '1', '2004-08-17', '0837790875', 'Quang Binh', 'Da Nang', '706360509', 'nguyenthihong@gmail.com', 'Pro03');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Minh Hieu', '0', '2001-07-18', '0837790565', 'Quang Nam', 'Da Nang', '202360509', 'nguyenminhhieu@gmail.com', 'Pro04');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Tin', '1', '2007-06-22', '0837790225', 'Phu Yen', 'Da Nang', '406360509', 'nguyenthitin@gmail.com', 'Pro05');

INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `Id`) VALUES ('Waitting', 'Maketing', 'Reg01');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `Id`) VALUES ('Registered', 'Internet', 'Reg02');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `Id`) VALUES ('Waitting', 'Maketing', 'Reg03');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `Id`) VALUES ('Cancel', 'Internet', 'Reg04');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `Id`) VALUES ('Registered', 'Direct', 'Reg05');

INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr01', 'Java01', '25', 'TC01', 'K01','19:00:00','22:00:00','MONDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr02', 'Php01', '40','TC02', 'K02','14:00:00','17:00:00','MONDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr03', 'Java03','50', 'TC03', 'K05','19:30:00','22:30:00','MONDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr04', 'Web01', '35','TC04', 'K03','08:00:00','11:00:00','MONDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr05', 'Php02','48', 'TC05','K04','07:30:00','10:30:00','MONDAY');


INSERT INTO `studentmanagement`.`studentunofficial` (`Id`, `DiscountStatus`,`IdProfile`,`Cost`, `IdRegister`,`IdGrade`) VALUES ('ST01', '0', 'Pro01','1000000', 'Reg01','Gr01');
INSERT INTO `studentmanagement`.`studentunofficial` (`Id`, `DiscountStatus`,`IdProfile`,`Cost`, `IdRegister`,`IdGrade`) VALUES ('ST02', '0.25', 'Pro02', '2000000','Reg02','Gr02');
INSERT INTO `studentmanagement`.`studentunofficial` (`Id`, `DiscountStatus`,`IdProfile`,`Cost`, `IdRegister`,`IdGrade`) VALUES ('ST03', '0.5', 'Pro03', '1500000','Reg03','Gr03');
INSERT INTO `studentmanagement`.`studentunofficial` (`Id`, `DiscountStatus`,`IdProfile`,`Cost`, `IdRegister`,`IdGrade`) VALUES ('ST04', '0.75', 'Pro04', '1500000','Reg04','Gr04');
INSERT INTO `studentmanagement`.`studentunofficial` (`Id`, `DiscountStatus`,`IdProfile`,`Cost`, `IdRegister`,`IdGrade`) VALUES ('ST05', '0.25', 'Pro05', '1000000','Reg05','Gr05');






INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('1', 'Class01');
INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('2', 'Class02');
INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('3', 'Class03');
UPDATE `studentmanagement`.`studentofficial` SET `IdClass` = 'Class04' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class02');


INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K01', 'JAVA', '2', '2020-3-25', '2020-9-25', 'C1');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K02', 'PHP', '2', '2020-3-26', '2020-9-26', 'C2');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K03', 'WEB', '1', '2020-3-27', '2020-9-27', 'C3');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K04', 'APP MOBILE', '0', '2020-4-1', '2020-10-1', 'C4');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K05', 'HTML', '0', '2020-4-3', '2020-10-3', 'C5');



INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('1', 'Class01', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('2', 'Class06', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('3', 'Class03', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('4', 'Class04', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('5', 'Class05', '0', '0', '0', '0');


INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV01', 'Phú Yên', '2000000', '5');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV02', 'Da Nang', '1000000', '2');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV03', 'Ho Chi Minh', '3000000', '3');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV04', 'Ha Noi', '5000000', '1');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV05', 'Da Nang', '4500000', '4');


UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '1') and (`IdClass` = 'Class01');
UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class06');
UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '3') and (`IdClass` = 'Class03');
UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '4') and (`IdClass` = 'Class04');
UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '5') and (`IdClass` = 'Class05');


INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`IdTeacher`) VALUES ('20', 'Good', 'No problem','GV01');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`IdTeacher`) VALUES ('12', 'Good', 'No problem','GV02');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`IdTeacher`) VALUES ('12', 'Pretty Good', 'No problem','GV03');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`IdTeacher`) VALUES ('18', 'Very Good', 'No problem','GV04');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`IdTeacher`) VALUES ('10', 'Medium', 'No problem','GV05');

UPDATE `studentmanagement`.`teacher` SET `IdProfile` = 'PT01' WHERE (`Id` = 'GV01');
UPDATE `studentmanagement`.`teacher` SET `IdProfile` = 'PT02' WHERE (`Id` = 'GV02');
UPDATE `studentmanagement`.`teacher` SET `IdProfile` = 'PT03' WHERE (`Id` = 'GV03');
UPDATE `studentmanagement`.`teacher` SET `IdProfile` = 'PT04' WHERE (`Id` = 'GV04');
UPDATE `studentmanagement`.`teacher` SET `IdProfile` = 'PT05' WHERE (`Id` = 'GV05');



