DROP DATABASE IF EXISTS blogContentTestDBScript;
CREATE DATABASE blogContentTestDBScript;

USE blogContentTestDBScript;

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
	authorityName INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50),
    username VARCHAR(50) NOT NULL,
    password VARCHAR(100) NOT NULL
);


-- Article
CREATE TABLE Article (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    author VARCHAR(255) NOT NULL,
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

INSERT INTO Article(title, content, author, articleExpired, articleCreated, articleUpdated, approved)  
VALUES 
	("title 1","content 1","user1","2022-12-02","2022-12-01", null, true),
    ("title 2","content 2","user2",null,"2022-12-02","2022-12-03",true),
    ("title 3","content 3","user3",null,"2022-12-03",null, false),
    ("title 4","content 4","user4",null,"2022-12-04",null, true),
    ("title 5","content 5","user5",null,"2022-12-05",null, false);
    
INSERT INTO Account(Id, password, firstName, lastName, email) 
VALUES 
	("1","password","user_first","user_last", "user.user@domain.com"),
    ("2","password","admin_first","user_last","admin.admin@domain.com"),
    ("3","password","user_","user_last", "user.user@dom,ain.com"),
    ("4","password","user_first","user_last", "user.user@domain.com"),
    ("5","password","user_first","user_last", "user.user@domain.com");    
    
INSERT INTO ArticleBody(Id, body) 
VALUES 
	(1,"<p>test content 1</p>"),
    (2,"<p>test content 2</p>"),
    (3,"<p>test content 3</p>"),
    (4,"<p>test content 4</p>"),
    (5,"<p><Strong>test content 5</Strong></p>");
    

INSERT INTO Hashtag(NAME) 
VALUES 
	("#Love"),
    ("#Travel"),
    ("#Food");
    
    
    
INSERT INTO ArticleHashtag(ArticleId, HashtagId) 
VALUES 
	(1,1),
    (1,2),
    (1,3),
    (2,1),
    (3,2),
    (3,3),
    (4,2),
    (5,3),
    (5,2);
    
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
