SELECT *FROM COURSE;
SELECT *FROM STUDENT;
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
FROM STUDENT st
INNER JOIN REGISTER rg ON st.Id= rg.IdStudent
INNER JOIN PROFILE pr ON st.Id= pr.Id
INNER JOIN RESULT rs ON st.Id=rs.IdStudent;

SELECT GRADE.Id, GRADE.Name, GRADE.StudentQuantity, TEACHER.IdTeacher, SCHEDULE.DaysOfWeek, SCHEDULE.StartTime, SCHEDULE.EndTime;

SELECT cl.Id, cl.Name, cl.StudentQuantity, cl.IdTeacher, cl.IdCourse, cl.IdSchedule, sch.DaysOfWeek, sch.StartTime, sch.EndTime FROM CLASS cl
INNER JOIN SCHEDULE sch ON cl.IdSchedule=sch.Id; 


SELECT tc.Id,tc.IdProfile, pr.Name, pr.Gender,  pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber,tc.Workplace, tc.Salary, pr.Email, tk.TeachingHours, tk.RewardLevel, tk.DisciplineLevel  
FROM TEACHER tc
INNER JOIN PROFILE pr ON pr.Id=tc.IdProfile
INNER JOIN TIMEKEEPING tk ON tk.IdTeacher=tc.Id;

SELECT c.Id, c.Name, 
c.ClassQuantity, c.StartDay, c.EndDay, co.Price FROM COURSE c
INNER JOIN COST co ON c.IdCost=co.Id;

INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('1', 'Class01');
INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('2', 'Class02');
INSERT INTO `studentmanagement`.`studentofficial` (`IdStudent`, `IdClass`) VALUES ('3', 'Class03');
UPDATE `studentmanagement`.`studentofficial` SET `IdClass` = 'Class04' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class02');


INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `IdTeacher`) VALUES ('0', '0', '0', 'GV01');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `IdTeacher`) VALUES ('0', '0', '0', 'GV02');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `IdTeacher`) VALUES ('0', '0', '0', 'GV03');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `IdTeacher`) VALUES ('0', '0', '0', 'GV04');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`, `IdTeacher`) VALUES ('0', '0', '0', 'GV05');

INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K01', 'JAVA', '2', '2020-3-25', '2020-9-25', 'C1');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K02', 'PHP', '2', '2020-3-26', '2020-9-26', 'C2');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K03', 'WEB', '1', '2020-3-27', '2020-9-27', 'C3');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K04', 'APP MOBILE', '0', '2020-4-1', '2020-10-1', 'C4');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `IdCost`) VALUES ('K05', 'HTML', '0', '2020-4-3', '2020-10-3', 'C5');

INSERT INTO `studentmanagement`.`class` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdSchedule`, `IdCourse`) VALUES ('Class01', 'Java01', '15', 'GV01', '12', 'K01');
INSERT INTO `studentmanagement`.`class` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdSchedule`, `IdCourse`) VALUES ('Class06', 'Php01', '10','GV02', '14', 'K02');
INSERT INTO `studentmanagement`.`class` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdSchedule`, `IdCourse`) VALUES ('Class03', 'Java03','20', 'GV03', '10', 'K05');
INSERT INTO `studentmanagement`.`class` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdSchedule`, `IdCourse`) VALUES ('Class04', 'Web01', '25','GV04', '11', 'K03');
INSERT INTO `studentmanagement`.`class` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdSchedule`, `IdCourse`) VALUES ('Class05', 'Php02','18', 'GV05', '13', 'K04');

INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('1', 'Class01', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('2', 'Class02', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('3', 'Class03', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('4', 'Class04', '0', '0', '0', '0');
INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`) VALUES ('5', 'Class05', '0', '0', '0', '0');

INSERT INTO `studentmanagement`.`cost` (`Id`, `Name`, `Price`) VALUES ('C1', 'M1', '100');
INSERT INTO `studentmanagement`.`cost` (`Id`, `Name`, `Price`) VALUES ('C2', 'M2', '0');
INSERT INTO `studentmanagement`.`cost` (`Id`, `Name`, `Price`) VALUES ('C3', 'M3', '200');
INSERT INTO `studentmanagement`.`cost` (`Id`, `Name`, `Price`) VALUES ('C4', 'M4', '100');
INSERT INTO `studentmanagement`.`cost` (`Id`, `Name`, `Price`) VALUES ('C5', 'M5', '0');

INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV01', 'Phú Yên', '2000000', '5');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV02', 'Da Nang', '1000000', '2');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV03', 'Ho Chi Minh', '3000000', '3');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV04', 'Ha Noi', '5000000', '1');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV05', 'Da Nang', '4500000', '4');


INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Vu Thi Bich Thu', '2', '2000-07-12', '0832890865', 'Quang Nam', 'Da Nang', '206360509', 'vuthibichthu@gmail.com', '1');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Phan Trong Duc', '0', '2000-04-12', '0837790865', 'Phu Yen', 'Da Nang', '306360509', 'phantrongduc@gmail.com', '2');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Hong', '1', '2004-08-17', '0837790875', 'Quang Binh', 'Da Nang', '706360509', 'nguyenthihong@gmail.com', '3');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Minh Hieu', '0', '2001-07-18', '0837790565', 'Quang Nam', 'Da Nang', '202360509', 'nguyenminhhieu@gmail.com', '4');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Tin', '1', '2007-06-22', '0837790225', 'Phu Yen', 'Da Nang', '406360509', 'nguyenthitin@gmail.com', '5');


INSERT INTO `studentmanagement`.`student` (`Id`, `DiscountStatus`, `IdProfile`, `Cost`) VALUES ('1', '0', '2', '0');
INSERT INTO `studentmanagement`.`student` (`Id`, `DiscountStatus`, `IdProfile`, `Cost`) VALUES ('2', '0.5', '3', '0');
INSERT INTO `studentmanagement`.`student` (`Id`, `DiscountStatus`, `IdProfile`, `Cost`) VALUES ('3', '0.25', '4', '0');
INSERT INTO `studentmanagement`.`student` (`Id`, `DiscountStatus`, `IdProfile`, `Cost`) VALUES ('4', '0', '5', '0');
INSERT INTO `studentmanagement`.`student` (`Id`, `DiscountStatus`, `IdProfile`, `Cost`) VALUES ('5', '0.5', '1', '0');


INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `IdStudent`) VALUES ('Waitting', 'Maketing', '1');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `IdStudent`) VALUES ('Registered', 'Internet', '2');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `IdStudent`) VALUES ('Waitting', 'Maketing', '4');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `IdStudent`) VALUES ('Cancel', 'Internet', '3');
INSERT INTO `studentmanagement`.`register` (`State`, `TypeOfRegister`, `IdStudent`) VALUES ('Registered', 'Direct', '5');


INSERT INTO `studentmanagement`.`schedule` (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`) VALUES ('10', '1', '19:00:00', '22:00:00');
INSERT INTO `studentmanagement`.`schedule` (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`) VALUES ('11', '3', '15:30:00', '18:30:00');
INSERT INTO `studentmanagement`.`schedule` (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`) VALUES ('12', '5', '08:00:00', '11:00:00');
INSERT INTO `studentmanagement`.`schedule` (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`) VALUES ('13', '7', '19:00:00', '22:00:00');
INSERT INTO `studentmanagement`.`schedule` (`Id`, `DaysOfWeek`, `StartTime`, `EndTime`) VALUES ('14', '4', '20:00:00', '23:00:00');

UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '1') and (`IdClass` = 'Class01');
UPDATE `studentmanagement`.`result` SET `NumberOfAbsences` = '0' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class02');
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

INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Minh', '0', '1980-08-12', '0987565243', 'Quang Nam', 'Da Nang', '221201212', 'nguyenthiminh@gmail.com', 'PT01');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Phan Nhat Yen', '1', '1995-01-12', '0389221234', 'Binh Dinh', 'Da Nang', '209101234', 'nhatyen@gmail.com', 'PT02');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Le Van Hai', '1', '1993-12-09', '0331239823', 'Hai Phong', 'Da Nang', '221209823', 'lehai@gmail.com', 'PT03');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Tran Nam', '0', '1991-05-25', '0391238732', 'Hai Duong', 'Da Nang', '209812123', 'nguyennam@gmail.com', 'PT04');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Pham Nhu Ngan', '1', '1992-02-08', '0987152673', 'Phu Yen', 'Da Nang', '320122398', 'nhungan@gmail.com', 'PT05');

UPDATE `studentmanagement`.`result` SET `StudyMark` = '8', `RewardMark` = '8', `MoneyPaid` = '1000000', `NumberOfAbsences` = '1' WHERE (`IdStudent` = '1') and (`IdClass` = 'Class01');
UPDATE `studentmanagement`.`result` SET `StudyMark` = '9', `RewardMark` = '7', `MoneyPaid` = '2000000' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class04');
UPDATE `studentmanagement`.`result` SET `StudyMark` = '8', `RewardMark` = '9', `MoneyPaid` = '1500000', `NumberOfAbsences` = '2' WHERE (`IdStudent` = '3') and (`IdClass` = 'Class03');


DELETE FROM `studentmanagement`.`result` WHERE (`IdStudent` = '5') and (`IdClass` = 'Class05');
DELETE FROM `studentmanagement`.`result` WHERE (`IdStudent` = '4') and (`IdClass` = 'Class04');
UPDATE `studentmanagement`.`result` SET `IdClass` = 'Class04' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class06');

UPDATE `studentmanagement`.`studentofficial` SET `IdProfile` = '1' WHERE (`IdStudent` = '1') and (`IdClass` = 'Class01');
UPDATE `studentmanagement`.`studentofficial` SET `IdProfile` = '2' WHERE (`IdStudent` = '2') and (`IdClass` = 'Class04');
UPDATE `studentmanagement`.`studentofficial` SET `IdProfile` = '3' WHERE (`IdStudent` = '3') and (`IdClass` = 'Class03');

UPDATE `studentmanagement`.`register` SET `State` = 'Registered' WHERE (`IdStudent` = '1');
UPDATE `studentmanagement`.`register` SET `State` = 'Registered' WHERE (`IdStudent` = '2');
UPDATE `studentmanagement`.`register` SET `State` = 'Registered' WHERE (`IdStudent` = '3');
UPDATE `studentmanagement`.`register` SET `State` = 'Cancel' WHERE (`IdStudent` = '4');
UPDATE `studentmanagement`.`register` SET `State` = 'Waitting' WHERE (`IdStudent` = '5');



