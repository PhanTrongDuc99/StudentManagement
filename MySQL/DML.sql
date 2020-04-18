

             -- SQL FOR COURSE --


SELECT st.Id, st.IdCourse, pr.Name, pr.Gender, pr.DayOfBirth, pr.PhoneNumber, pr.Hometown, pr.CurrentAddress, pr.IdNumber, pr.Email,rg.State, rg.TypeOfRegister,st.DiscountStatus, st.Cost
FROM STUDENTUNOFFICIAL st
INNER JOIN REGISTER rg ON st.IdRegister = rg.Id
INNER JOIN PROFILE pr ON st.IdProfile= pr.Id;

INSERT INTO ADMIN(`Id`,`Username`,`Password`) VALUES('1','User01',MD5('123456'));
INSERT INTO ADMIN(`Id`,`Username`,`Password`) VALUES('2','User02',MD5('654321'));
INSERT INTO ADMIN(`Id`,`Username`,`Password`) VALUES('4','User04',MD5('122333'));




INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `Cost`) VALUES ('K01', 'JAVA', '3', '2020-3-25', '2020-9-25', '5000000');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `Cost`) VALUES ('K02', 'PHP', '4', '2020-3-26', '2020-9-26', '6000000');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `Cost`) VALUES ('K03', 'WEB', '3', '2020-3-27', '2020-9-27', '4500000');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `Cost`) VALUES ('K04', 'APP MOBILE', '2', '2020-4-1', '2020-10-1', '8000000');
INSERT INTO `studentmanagement`.`course` (`Id`, `Name`, `ClassQuantity`, `StartDay`, `EndDay`, `Cost`) VALUES ('K05', 'HTML', '3', '2020-4-3', '2020-10-3', '6500000');


-- INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Vu Thi Bich Thu', '1', '2000-07-12', '0832890865', 'Quang Nam', 'Da Nang', '206360509', 'vuthibichthu@gmail.com', 'ProS1');
-- INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Phan Trong Duc', '0', '2000-04-12', '0837790865', 'Phu Yen', 'Da Nang', '306360509', 'phantrongduc@gmail.com', 'ProS2');
-- INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Hong', '1', '2004-08-17', '0837790875', 'Quang Binh', 'Da Nang', '706360509', 'nguyenthihong@gmail.com', 'ProS3');
-- INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Minh Hieu', '0', '2001-07-18', '0837790565', 'Quang Nam', 'Da Nang', '202360509', 'nguyenminhhieu@gmail.com', 'ProS4');
-- INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Thi Tin', '1', '2007-06-22', '0837790225', 'Phu Yen', 'Da Nang', '406360509', 'nguyenthitin@gmail.com', 'ProS5');

INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Nguyen Anh Hung', '0', '1987-09-24', '0397645362', 'Phu Yen', 'Da Nang', '404361609', 'nguyenanhhung@gmail.com', 'ProG1');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Tran Viet Hai', '0', '1993-03-21', '0987645372', 'Hai Duong', 'Da Nang', '408361709', 'haitran@gmail.com', 'ProG2');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Ton Nu Huyen Trang', '1', '1998-11-12', '0367762563', 'Nam Dinh', 'Da Nang', '206361809', 'huyentrang@gmail.com', 'ProG3');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Phan Ngoc Quyen', '0', '1995-12-02', '0123876832', 'Hue', 'Da Nang', '476361959', 'phanquyen@gmail.com', 'ProG4');
INSERT INTO `studentmanagement`.`profile` (`Name`, `Gender`, `DayOfBirth`, `PhoneNumber`, `Hometown`, `CurrentAddress`, `IdNumber`, `Email`, `Id`) VALUES ('Pham Minh Tuan', '0', '1989-10-16', '0904987212', 'Hai Phong', 'Da Nang', '409362009', 'phamtuan@gmail.com', 'ProG5');

INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV01', 'Phú Yên', '20000000', 'ProG1');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV02', 'Da Nang', '10000000', 'ProG2');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV03', 'Ho Chi Minh', '30000000', 'ProG3');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV04', 'Ha Noi', '15000000', 'ProG4');
INSERT INTO `studentmanagement`.`teacher` (`Id`, `Workplace`, `Salary`, `IdProfile`) VALUES ('GV05', 'Da Nang', '45000000', 'ProG5');

INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`Id`,`IdTeacher`) VALUES ('0', 'Good', 'No problem','TK01','GV01');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`Id`,`IdTeacher`) VALUES ('0', 'Good', 'No problem','TK02','GV02');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`Id`,`IdTeacher`) VALUES ('0', 'Pretty Good', 'No problem','TK03','GV03');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`Id`,`IdTeacher`) VALUES ('0', 'Very Good', 'No problem','TK04','GV04');
INSERT INTO `studentmanagement`.`timekeeping` (`TeachingHours`, `RewardLevel`, `DisciplineLevel`,`Id`,`IdTeacher`) VALUES ('0', 'Medium', 'No problem','TK05','GV05');



INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr01', 'JAVA01', '5', 'GV01', 'K01','19:00:00','22:00:00','MONDAY,TUESDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr02', 'JAVA02', '5', 'GV01', 'K01','9:00:00','12:00:00','SUNDAY,TUESDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr03', 'JAVA03', '5', 'GV01', 'K01','15:00:00','18:00:00','MONDAY,WEDNESDAY');

INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr04', 'PHP01', '4','GV02', 'K02','14:00:00','17:00:00','MONDAY,SUNDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr05', 'PHP02', '5', 'GV02', 'K02','19:00:00','22:00:00','FRIDAY,TUESDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr06', 'PHP03', '5', 'GV02', 'K02','19:00:00','22:00:00','MONDAY,SATURDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr07', 'PHP04', '5', 'GV02', 'K02','19:00:00','22:00:00','MONDAY,THURSDAY');

INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr08', 'HTML01','5', 'GV03', 'K05','19:30:00','22:30:00','FRIDAY,SUNDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr09', 'HTML02', '5', 'GV03', 'K05','08:00:00','11:00:00','MONDAY,TUESDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`, `IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr10', 'HTML03', '5', 'GV03', 'K05','20:00:00','23:00:00','MONDAY,TUESDAY');

INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr11', 'WEB01', '5','GV04', 'K03','08:00:00','11:00:00','MONDAY,FRIDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr12', 'WEB02', '4','GV04', 'K03','13:00:00','16:00:00','TUESDAY,FRIDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr13', 'WEB03', '5','GV04', 'K03','08:00:00','11:00:00','TUESDAY,THURSDAY');


INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr14', 'APP MOBILE01','4', 'GV05','K04','08:30:00','11:30:00','WEDNESDAY,SATURDAY');
INSERT INTO `studentmanagement`.`grade` (`Id`, `Name`, `StudentQuantity`,`IdTeacher`, `IdCourse`,`StartTime`,`EndTime`,`DaysOfWeek`) VALUES ('Gr15', 'APP MOBILE02','4', 'GV05','K04','07:30:00','10:30:00','MONDAY,SATURDAY');


-- StudentOfficial khi nao update ben java se update vao DB sau nen khong can insert truoc
-- Result khi nao update student roi update cho no luon khong can insert truoc

-- INSERT INTO `studentmanagement`.`result` (`IdStudent`, `IdClass`, `StudyMark`, `RewardMark`, `DisciplineMark`, `MoneyPaid`, `NumberOfAbsences`) VALUES ('1', 'Class01', '0', '0', '0', '0');

