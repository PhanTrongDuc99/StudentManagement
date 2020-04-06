-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema studentmanagement
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `studentmanagement` ;

-- -----------------------------------------------------
-- Schema studentmanagement
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentmanagement` DEFAULT CHARACTER SET utf8 ;
USE `studentmanagement` ;

-- -----------------------------------------------------
-- Table `studentmanagement`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`admin` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`admin` (
  `Id` VARCHAR(20) NOT NULL,
  `Username` TEXT NOT NULL,
  `Password` TEXT NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`course` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`course` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` TEXT NOT NULL,
  `ClassQuantity` INT(11) NOT NULL,
  `StartDay` DATE NOT NULL,
  `EndDay` DATE NOT NULL,
  `Cost` DOUBLE NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`profile` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`profile` (
  `Name` VARCHAR(50) NOT NULL,
  `Gender` TINYINT(1) NOT NULL,
  `DayOfBirth` DATE NOT NULL,
  `PhoneNumber` VARCHAR(20) NOT NULL,
  `Hometown` TEXT NOT NULL,
  `CurrentAddress` TEXT NOT NULL,
  `IdNumber` VARCHAR(20) NOT NULL,
  `Email` VARCHAR(255) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`teacher`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`teacher` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`teacher` (
  `Id` VARCHAR(20) NOT NULL,
  `Workplace` TEXT NOT NULL,
  `Salary` DOUBLE NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_teacher_profile1` (`IdProfile` ASC) VISIBLE,
  CONSTRAINT `fk_teacher_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`grade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`grade` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`grade` (
  `Id` VARCHAR(20) NOT NULL,
  `Name` VARCHAR(50) NOT NULL,
  `StudentQuantity` INT(11) NOT NULL,
  `IdTeacher` VARCHAR(20) NULL DEFAULT NULL,
  `IdCourse` VARCHAR(20) NOT NULL,
  `StartTime` VARCHAR(45) NOT NULL,
  `EndTime` VARCHAR(45) NOT NULL,
  `DaysOfWeek` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_class_course1` (`IdCourse` ASC) VISIBLE,
  INDEX `fk_class_teacher` (`IdTeacher` ASC) VISIBLE,
  CONSTRAINT `fk_class_course1`
    FOREIGN KEY (`IdCourse`)
    REFERENCES `studentmanagement`.`course` (`Id`),
  CONSTRAINT `fk_class_teacher`
    FOREIGN KEY (`IdTeacher`)
    REFERENCES `studentmanagement`.`teacher` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`register`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`register` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`register` (
  `State` VARCHAR(50) NOT NULL,
  `TypeOfRegister` VARCHAR(50) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`result`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`result` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`result` (
  `IdGrade` VARCHAR(20) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  `StudyMark` DOUBLE NOT NULL,
  `RewardMark` DOUBLE NOT NULL,
  `DisciplineMark` DOUBLE NOT NULL,
  `MoneyPaid` DOUBLE NOT NULL,
  `NumberOfAbsences` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`studentofficial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`studentofficial` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`studentofficial` (
  `IdStudent` VARCHAR(20) NOT NULL,
  `IdGrade` VARCHAR(20) NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  `IdResult` VARCHAR(45) NOT NULL,
  `IdRegister` VARCHAR(45) NOT NULL,
  `DiscountStatus` DOUBLE NOT NULL,
  `Cost` DOUBLE NOT NULL,
  PRIMARY KEY (`IdStudent`),
  INDEX `fk_student_profile_idx` (`IdProfile` ASC) VISIBLE,
  INDEX `fk_student_grade_idx` (`IdGrade` ASC) VISIBLE,
  INDEX `fk_student_register_idx1` (`IdRegister` ASC) INVISIBLE,
  INDEX `fk_student_result_idx` (`IdResult` ASC) VISIBLE,
  CONSTRAINT `fk_student_grade`
    FOREIGN KEY (`IdGrade`)
    REFERENCES `studentmanagement`.`grade` (`Id`),
  CONSTRAINT `fk_student_profile`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`),
  CONSTRAINT `fk_student_register1`
    FOREIGN KEY (`IdRegister`)
    REFERENCES `studentmanagement`.`register` (`Id`),
  CONSTRAINT `fk_student_result`
    FOREIGN KEY (`IdResult`)
    REFERENCES `studentmanagement`.`result` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`studentunofficial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`studentunofficial` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`studentunofficial` (
  `Id` VARCHAR(20) NOT NULL,
  `DiscountStatus` TINYINT(1) NOT NULL,
  `IdProfile` VARCHAR(20) NOT NULL,
  `Cost` DOUBLE NOT NULL,
  `IdRegister` VARCHAR(45) NOT NULL,
  `IdCourse` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_student_profile1` (`IdProfile` ASC) VISIBLE,
  INDEX `fk_student_register_idx` (`IdRegister` ASC) VISIBLE,
  INDEX `fk_student_course_idx` (`IdCourse` ASC) VISIBLE,
  CONSTRAINT `fk_student_course`
    FOREIGN KEY (`IdCourse`)
    REFERENCES `studentmanagement`.`course` (`Id`),
  CONSTRAINT `fk_student_profile1`
    FOREIGN KEY (`IdProfile`)
    REFERENCES `studentmanagement`.`profile` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_student_register`
    FOREIGN KEY (`IdRegister`)
    REFERENCES `studentmanagement`.`register` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentmanagement`.`timekeeping`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `studentmanagement`.`timekeeping` ;

CREATE TABLE IF NOT EXISTS `studentmanagement`.`timekeeping` (
  `TeachingHours` DOUBLE NOT NULL,
  `RewardLevel` VARCHAR(20) NOT NULL,
  `DisciplineLevel` VARCHAR(20) NOT NULL,
  `Id` VARCHAR(20) NOT NULL,
  `IdTeacher` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_timekeeping_teacher1_idx` (`IdTeacher` ASC) VISIBLE,
  CONSTRAINT `fk_timekeeping_teacher`
    FOREIGN KEY (`IdTeacher`)
    REFERENCES `studentmanagement`.`teacher` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
