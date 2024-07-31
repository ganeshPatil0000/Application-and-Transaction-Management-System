CREATE DATABASE creditcardapprovalsystem;
USE creditcardapprovalsystem;

CREATE TABLE TransactionInfo (
    TransID INT NOT NULL PRIMARY KEY,
    TransAmount DECIMAL(15, 2) NOT NULL,
    Place VARCHAR(100) NOT NULL,
    Date DATETIME DEFAULT CURRENT_TIMESTAMP,
    Time TIME,
    UserID INT,
    FOREIGN KEY (UserID) REFERENCES UserInfo(UserID)
);

CREATE TABLE UserInfo (
    UserID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    UserName VARCHAR(50) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Gender ENUM('Male', 'Female', 'Other') NOT NULL,
    DOB DATE NOT NULL,
    Email VARCHAR(100) NOT NULL,
    PAN_Number VARCHAR(20) NOT NULL,
    City VARCHAR(100) NOT NULL,
    Income DECIMAL(15, 2) NOT NULL,
    State VARCHAR(100) NOT NULL,
    Date DATETIME,
    Time TIME ,
    status varchar(30) default 'pending'
);



CREATE TABLE adminlogin (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

insert into adminlogin
values('admin','tiger');

select * from UserInfo;
