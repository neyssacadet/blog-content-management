DROP DATABASE IF EXISTS blogContentDBScriptTest;
CREATE DATABASE blogContentDBScriptTest;

USE blogContentDBScript;

CREATE TABLE Role (
    roleID INT PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(30) NOT NULL
);

CREATE TABLE User (
    	userID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    isEnabled BIT NOT NULL DEFAULT 0,
    email VARCHAR(50),
    createdOn DATETIME NOT NULL DEFAULT NOW()
);

CREATE TABLE Article (
    	articleID INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    author VARCHAR(255) NOT NULL,
    createdOn DATETIME NOT NULL DEFAULT NOW(),
    postOn DATETIME NOT NULL,
    expireOn DATETIME NOT NULL
);

CREATE TABLE Tag (
	tagID INT PRIMARY KEY AUTO_INCREMENT,
    tagName VARCHAR(150) NOT NULL UNIQUE,
    createdBy VARCHAR(255) NOT NULL,
    addedOn VARCHAR(50) NOT NULL
);

CREATE TABLE Comments (
	commentsID INT PRIMARY KEY AUTO_INCREMENT,
    text TEXT NOT NULL,
    user VARCHAR(255) NOT NULL,
    userEmail VARCHAR(255) NOT NULL,
    addedOn VARCHAR(50) NOT NULL,
    articleID INT NOT NULL,
    	FOREIGN KEY (articleID) 
    	REFERENCES Article(articleID)
);

CREATE TABLE ArticleTag (
  	articleID INT NOT NULL,
  tagID INT NOT NULL,
  PRIMARY KEY (articleID, tagID),
  CONSTRAINT PK_ArticleTag
    FOREIGN KEY (articleID)
    REFERENCES Article(articleID),
    FOREIGN KEY (tagID)
    REFERENCES Tag(tagID)
);

CREATE TABLE UserRole (
    roleID INT NOT NULL,
    userID INT NOT NULL,
    PRIMARY KEY (roleID, userID),
    CONSTRAINT fk_UserRole
    	FOREIGN KEY (roleID)
        REFERENCES Role(roleID),
    	FOREIGN KEY (userID)
        REFERENCES User(userID)
);

CREATE TABLE ArticleComments (
  	articleID INT NOT NULL,
  commentsID INT NOT NULL,
  PRIMARY KEY (articleID, commentsID),
  CONSTRAINT PK_ArticleComments
    FOREIGN KEY (articleID)
    REFERENCES Article(articleID),
    FOREIGN KEY (commentsID)
    REFERENCES Comments(commentsID)
);
