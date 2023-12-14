CREATE TABLE users (
    PersonID int NOT NULL AUTO_INCREMENT,
    FirstName varchar(255)  NOT NULL,
    LastName varchar(255)  NOT NULL,
    Pesel varchar(255)  NOT NULL UNIQUE
	PRIMARY KEY (PersonID)
);

CREATE TABLE books (
    BookID int NOT NULL AUTO_INCREMENT,
    BookTitle varchar(255)  NOT NULL,
    PRIMARY KEY (BookID)
);

CREATE TABLE rentals (
    UserID int NOT NULL,
    BookID int NOT NULL,
    RentDate Date NOT NULL,
    DayLimit int NOT NULL
);

CREATE TABLE history (
    changeID int NOT NULL AUTO_INCREMENT,
    actionName varchar(255) NOT NULL,
    actionVariables LONGTEXT NOT NULL,
    dateOfChange date NOT NULL,
    PRIMARY KEY(changeID)
);