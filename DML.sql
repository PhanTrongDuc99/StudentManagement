SELECT *FROM STUDENT;
SELECT *FROM REGISTER;
SELECT *FROM PROFILE;
SELECT *FROM STUDENT 
INNER JOIN REGISTER ON STUDENT.Id= REGISTER.IdStudent
INNER JOIN PROFILE ON STUDENT.Id= PROFILE.Id;

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
