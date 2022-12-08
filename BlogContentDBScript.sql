DROP DATABASE IF EXISTS blogContentDBScript;
CREATE DATABASE blogContentDBScript;

USE blogContentDBScript;

-- Account table
CREATE TABLE Account (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    password VARCHAR(100) NOT NULL,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(50)
);

-- Authority table
CREATE TABLE Authority (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    authorityName VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50)
);


-- Article
CREATE TABLE Article (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    articleCreated DATETIME NOT NULL DEFAULT NOW(),
    articleExpired DATETIME,
    articleUpdated DATETIME,
    approved Boolean default false
);

-- Article Body table 
CREATE TABLE ArticleBody (
	Id INT PRIMARY KEY,
    body MEDIUMTEXT,
    FOREIGN KEY (Id)
		REFERENCES Article(Id) ON DELETE CASCADE
);

-- Hashtag
CREATE TABLE Hashtag (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(50) NOT NULL
);

-- Account and Authority connection table
CREATE TABLE AccountAuthority (
Id INT,
    AuthorityName INT,
    PRIMARY KEY  (Id, AuthorityName)
    
);


-- Article and Hashtag connection table
CREATE TABLE ArticleHashtag(
	ArticleId int,
    HashtagId int,
    PRIMARY KEY  (ArticleId, HashtagId),
    FOREIGN KEY (ArticleId)
		REFERENCES Article(Id) ON DELETE CASCADE,
	FOREIGN KEY (HashtagId)
		REFERENCES Hashtag(Id) ON DELETE CASCADE
);

-- Static Page table
CREATE TABLE StaticPage(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255),
    content LONGTEXT
);


    
INSERT INTO Account(Id, password, firstName, lastName, email) 
VALUES 
	("1","password","user_first","user_last", "user.user@domain.com"),
    ("2","password","admin_first","admin_last","admin.admin@domain.com"),
    ("3","password","Maryia","Malakhava", "malakhava@yahoo.com"),
    ("4","password","Everlyn","Leon", "everlyn.loza.leon@gmail.com"),
    ("5","password","Neyssa","Cadet", "neyssacadet2304@gmail.com"),
    ("6","password","Claude","Seide", "seidemarcelle@gmail.com");     
    

    

INSERT INTO Hashtag(NAME) 
VALUES 
	("#Love"),
    ("#Travel"),
    ("#Food");
    
    
    

INSERT INTO StaticPage(Title, Content) 
VALUES 
	("Disclaimer","<p>These are my personal thoughts, beliefs, and perspectives of the world. This is not representative of any
                        employers, planning committees, clients, or any other associations tied with me and my name. Every person has 
                        an opinion on something, and these are mine. We may end up having to agree to disagree, and I can guarantee you that
                        not everyone will feel the way that I do.

                        I may post happy things or sad things, run-of-the-mill things or controversial things. Whatever I post is most
                        likely posted straight out of my mind, as I write stream of conscious style.

                        If you have any questions for me personally, please feel free to email me at my first name at this domain.
                        
                        - Sarah 'sadukie' Dutkiewicz</p>");

