DROP DATABASE IF EXISTS blogContentDBScript;
CREATE DATABASE blogContentDBScript;

USE blogContentDBScript;

-- Account table
CREATE TABLE Account (
	Id INT, 
    password VARCHAR(100),
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    email VARCHAR(50) NOT NULL PRIMARY KEY,
    enabled boolean not null default true
);

-- Authority table
CREATE TABLE Authority (
	Id INT,
    authorityName VARCHAR(100),
    email VARCHAR(50),
    password VARCHAR(100),
    constraint fk_authority_account foreign key(email) references account(email)
);

create unique index ix_auth_email on authority (email,authorityName);

/*-- Authority table
CREATE TABLE Authority (
	Id INT,
    authorityName VARCHAR(100),
    email VARCHAR(50),
    password VARCHAR(50) not null,
    constraint fk_authority_account foreign key (email) references account(email)
);

create unique index ix_auth_email on authority(email,authorityName);

INSERT INTO Account (email, password, enabled)
VALUES
('user.user.@domain.com', 'password', true),
('admin.admin.@domain.com', 'password', true);

INSERT INTO Authority (email, authorityName)
VALUES
('user.user.@domain.com', 'ROLE_USER'),
('admin.admin.@domain.com', 'ROLE_USER'),
('admin.admin.@domain.com', 'ROLE_ADMIN');*/

-- Article
CREATE TABLE Article (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    content VARBINARY(8000) NOT NULL,
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

INSERT INTO Article(title, content, articleExpired, articleCreated, articleUpdated, approved)  
VALUES 
	("title 1","content 1","2022-12-02","2022-12-01", null, true),
    ("title 2","content 2",null,"2022-12-02","2022-12-03",true),
    ("title 3","content 3",null,"2022-12-03",null, false),
    ("title 4","content 4",null,"2022-12-04",null, true),
    ("title 5","content 5",null,"2022-12-05",null, false),
    ("title 6","content 6",null,"2022-12-06",null, false);   

    
INSERT INTO Account(Id, password, firstName, lastName, email) 
VALUES 
	("1","password","user_first","user_last", "user.user@yahoo.com"),
    ("2","password","admin_first","admin_last","admin.admin@yahoo.com"),
    ("3","password","Maryia","Malakhava", "malakhava@yahoo.com"),
    ("4","password","Everlyn","Leon", "everlyn.loza.leon@gmail.com"),
    ("5","password","Neyssa","Cadet", "neyssacadet2304@gmail.com"),
    ("6","password","Claude","Seide", "seidemarcelle@gmail.com");     

/*INSERT INTO ArticleBody(Id, body) 
VALUES 
	(1,"<p>test content 1</p>"),
    (2,"<p>test content 2</p>"),
    (3,"<p>test content 3</p>"),
    (4,"<p>test content 4</p>"),
    (5,"<p>test content 4</p>"),
    (6,"<p><Strong>test content 5</Strong></p>");

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
    (5,2),
    (6,1),
    (6,2);
 */

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

-- seed the database with 2 users
INSERT INTO Account (Id, email, password, enabled) VALUES 
('1','user.user@domain.com', 'password', true),
('2','admin.admin@domain.com', 'password', true);

-- create the authorities
INSERT INTO authority (Id, email, authorityName) VALUES 
('1','user.user@domain.com', 'ROLE_USER'),
('2','admin.admin@domain.com', 'ROLE_USER'),
('3', 'admin.admin@domain.com', 'ROLE_ADMIN');