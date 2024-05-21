

create table owners(
	owner_id UUID DEFAULT uuid_generate_v4() primary key,
	name varchar(100) not null,
	lastname varchar(100) not null,
	position varchar (100) not null ,
	description varchar(500) not null,
	about_me varchar(500) not null,
	photo varchar(200) not null	,	
	created_at TimeStamp not null,
	updated_at TimeStamp,
	status varchar(20) not null
);


create table owner_skill_types(
	skill_type_id UUID DEFAULT uuid_generate_v4() primary key ,
	skiil_type_name varchar(100),
	skill_type_created_at TimeStamp not null,
	skill_type_updated_at TimeStamp,
	skill_type_status varchar(20) not null
	
);

create table owner_skills(
	skill_id UUID DEFAULT uuid_generate_v4() primary key ,
	skill_name varchar(100) not null,
	skill_created_at TimeStamp not null,
	skill_updated_at TimeStamp,
	skill_status varchar(20) not null,
	owner_id UUID references owners(owner_id) ON DELETE cascade,
	skill_type_id UUID references owner_skill_types(skill_type_id) ON DELETE CASCADE
);



create table owner_contacts(
	contact_id UUID DEFAULT uuid_generate_v4() primary key ,
	contact_url varchar(200) not null,
	contact_name varchar(100)not null,
	contact_photo varchar(200) not null ,
	contact_created_at TimeStamp  not null,
	contact_updated_at TimeStamp,
	contact_status varchar(20)  not null,
	owner_id UUID references owners(owner_id) on delete cascade
);

create table owner_experiences(
	experience_id  UUID DEFAULT uuid_generate_v4() primary key ,
	experience_position_name varchar(100) not null ,
	experience_description varchar(1000)  not null,
	experience_initial_date date not null,
	experience_end_date date ,
	experience_created_at TimeStamp  not null,
	experiencet_updated_at TimeStamp,
	experience_status varchar(20)  not null,
	owner_id UUID references owners(owner_id) on delete cascade
);

create table owner_experience_companies(
	experience_company_id UUID DEFAULT uuid_generate_v4() primary key ,
	experience_company_name varchar(100),
	experience_company_url varchar(100),
	experience_company_created_at TimeStamp  not null,
	experiencet_company_updated_at TimeStamp  ,
	experience_company_status varchar(20)  not null,
	experience_id UUID references  owner_experiences(experience_id) on delete cascade
);

create table owner_experience_skills(
	experience_skill_id  UUID DEFAULT uuid_generate_v4() primary key,
	experience_skill_name varchar(100) not null,
	experience_skill_created_at TimeStamp  not null,
	experiencet_skill_updated_at TimeStamp,
	experience_skill_status varchar(20)  not null,
	experience_id UUID references  owner_experiences(experience_id) on delete cascade
);

create table owner_experience_details(
	experience_detail_id UUID DEFAULT uuid_generate_v4() primary key ,
	experience_detail_description varchar(200),
	experience_detail_created_at TimeStamp   not null,
	experiencet_detail_updated_at TimeStamp,
	experience_detail_status varchar(20)  not null,
	experience_id UUID references owner_experiences(experience_id) on delete cascade
);

create table projects(
	project_id UUID DEFAULT uuid_generate_v4() primary key ,
	project_name varchar(100) not null,
	project_description varchar(1000) not null ,
	project_photo varchar(200) not null,
	project_created_at TimeStamp not null,
	project_updated_at TimeStamp,
	project_status varchar(20) not null,
	owner_id UUID references owners(owner_id) on delete cascade
); 

create table project_skills(
	project_skill_id UUID DEFAULT uuid_generate_v4() primary key ,
	project_skill_name varchar(100) not null,
	project_skill_created_at TimeStamp not null,
	project_skill_updated_at TimeStamp,
	project_skill_status varchar(20) not null,
	project_id UUID references projects(project_id) on delete cascade
);

create table project_links(
	project_link_id UUID DEFAULT uuid_generate_v4() primary key ,
	project_link_name varchar(100) not null,
	project_link_url varchar(200) not null ,
	project_link_photo varchar(200) not null,
	project_link_created_at TimeStamp not null,
	project_link_updated_at TimeStamp,
	project_link_status varchar(20) not null,
	project_id UUID references projects(project_id)on delete cascade
);

create table owner_educations(
	education_id UUID DEFAULT uuid_generate_v4() primary key ,
	education_university_name varchar(100),
	education_bachelor varchar(100),
	education_initial_date Date,
	education_end_date Date ,
	education_created_at TimeStamp not null,
	education_updated_at TimeStamp,
	education_status varchar(20) not null,
	owner_id UUID references owners(owner_id) on delete cascade


);

create table owner_languages(
	language_id UUID DEFAULT uuid_generate_v4() primary key ,
	language_name varchar(100) not null,
	language_level varchar(100) not null,
	language_degree_link varchar(200),
	language_created_at TimeStamp not null,
	language_education_updated_at TimeStamp,
	language_education_status varchar(20) not null,
	owner_id UUID references owners(owner_id) on delete cascade

);


CREATE EXTENSION IF NOT EXISTS "uuid-ossp";





------------------------------------------------------INSERTS


------------------OWNER
INSERT INTO public.owners
("name", lastname, "position", description, about_me, photo, created_at, updated_at, status)
VALUES( 'Muricio', ' Ramirez', 'Java Developer', 'I am a Java Developer with more than two years of experience in
software development for the financial sector. I adapt very well to
changes and teamwork.', 'I am a Java Developer with more than two years of experience in
software development for the financial sector. I adapt very well to
changes and teamwork.', 'mull', '2024-05-20', null, 'ACTIVE');

SELECT owner_id, "name", lastname, "position", description, about_me, photo, created_at, updated_at, status
FROM public.owners;


INSERT INTO public.owner_skill_types
(skiil_type_name, skill_type_created_at, skill_type_updated_at, skill_type_status)
VALUES( 'Sofware Develoment:', '2024-05-20', null, 'ACTIVE');

INSERT INTO public.owner_skill_types
( skiil_type_name, skill_type_created_at, skill_type_updated_at, skill_type_status)
VALUES( 'Database:', '2024-05-20', null, 'ACTIVE');

INSERT INTO public.owner_skill_types
( skiil_type_name, skill_type_created_at, skill_type_updated_at, skill_type_status)
VALUES( 'Others:', '2024-05-20', null, 'ACTIVE');


SELECT skill_type_id, skiil_type_name, skill_type_created_at, skill_type_updated_at, skill_type_status
FROM public.owner_skill_types;



-----SOFTWARE DEVELOMENT  SKILLS
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Java EE',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', '1e2043c6-ff23-49f3-93c9-58a02fa93e5a');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Hibernate',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', '1e2043c6-ff23-49f3-93c9-58a02fa93e5a');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Spring Boot',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', '1e2043c6-ff23-49f3-93c9-58a02fa93e5a');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Git',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', '1e2043c6-ff23-49f3-93c9-58a02fa93e5a');




-----------------DATABASE SKILLS
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('MYSQL',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', 'ddfb1180-023d-43de-a9f3-e941d30b038a');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Postgresql',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', 'ddfb1180-023d-43de-a9f3-e941d30b038a');




-----------------------OTHER SKILLS
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Team work',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', 'a38054d1-c8c6-4307-9a45-91b204853fec');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Adaptation to change',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', 'a38054d1-c8c6-4307-9a45-91b204853fec');
INSERT INTO public.owner_skills
(skill_name,skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id)
VALUES('Empathy',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31', 'a38054d1-c8c6-4307-9a45-91b204853fec');

SELECT skill_id, skill_name, skill_created_at, skill_updated_at, skill_status, owner_id, skill_type_id
FROM public.owner_skills;





INSERT INTO public.owner_languages
(language_name, language_level, language_degree_link, language_created_at, language_education_updated_at, language_education_status, owner_id)
VALUES( 'English', 'A2', null, '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');


SELECT language_id, language_name, language_level, language_degree_link, language_created_at, language_education_updated_at, language_education_status, owner_id
FROM public.owner_languages;




INSERT INTO public.owner_educations
( education_university_name, education_bachelor, education_initial_date, education_end_date, education_created_at, education_updated_at, education_status, owner_id)
VALUES('Universidad Politécnica de Sinaloa(UPSIN)', 'Computer Engineering', '2015-01-01', '2018-08-01', '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');


SELECT education_id, education_university_name, education_bachelor, education_initial_date, education_end_date, education_created_at, education_updated_at, education_status, owner_id
FROM public.owner_educations;




INSERT INTO public.owner_contacts
( contact_url, contact_name, contact_photo, contact_created_at, contact_updated_at, contact_status, owner_id)
VALUES( 'http://www.linkedin.com/in/mauricio-ramirez-develop', 'Linkedin', 'null', '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');

INSERT INTO public.owner_contacts
( contact_url, contact_name, contact_photo, contact_created_at, contact_updated_at, contact_status, owner_id)
VALUES( 'https://github.com/thestifler', 'Gihub', 'null', '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');

INSERT INTO public.owner_contacts
( contact_url, contact_name, contact_photo, contact_created_at, contact_updated_at, contact_status, owner_id)
VALUES( '6691381479', 'Telefono', 'null', '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');

INSERT INTO public.owner_contacts
( contact_url, contact_name, contact_photo, contact_created_at, contact_updated_at, contact_status, owner_id)
VALUES( 'mauricio.develop@gmail.com', 'Email', 'null', '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');




SELECT contact_id, contact_url, contact_name, contact_photo, contact_created_at, contact_updated_at, contact_status, owner_id
FROM public.owner_contacts;


-----------------------------OWNER PROJECTS


INSERT INTO public.projects
( project_name, project_description, project_photo, project_created_at, project_updated_at, project_status, owner_id)
VALUES( 'Personal portfolio', 'my personal portfolio', 'null',  '2024-05-20', null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');


SELECT project_id, project_name, project_description, project_photo, project_created_at, project_updated_at, project_status, owner_id
FROM public.projects;



INSERT INTO public.project_skills
( project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id)
VALUES( 'Java',  '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');

INSERT INTO public.project_skills
( project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id)
VALUES( 'Spring Boot',  '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');

INSERT INTO public.project_skills
( project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id)
VALUES( 'Hibernate',  '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');

INSERT INTO public.project_skills
( project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id)
VALUES( 'Postgresql',  '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');

INSERT INTO public.project_skills
( project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id)
VALUES( 'Docker',  '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');


SELECT project_skill_id, project_skill_name, project_skill_created_at, project_skill_updated_at, project_skill_status, project_id
FROM public.project_skills;


INSERT INTO public.project_links
( project_link_name, project_link_url, project_link_photo, project_link_created_at, project_link_updated_at, project_link_status, project_id)
VALUES( 'Portfolio', 'null', 'mull', '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');


INSERT INTO public.project_links
( project_link_name, project_link_url, project_link_photo, project_link_created_at, project_link_updated_at, project_link_status, project_id)
VALUES( 'Github', 'https://github.com/thestifler/portfolio', 'mull', '2024-05-20', null, 'ACTIVE', '0494a486-e8d1-4b6a-b526-6adb860bcfb8');



SELECT project_link_id, project_link_name, project_link_url, project_link_photo, project_link_created_at, project_link_updated_at, project_link_status, project_id
FROM public.project_links;

--------------------EXPERIENCES
INSERT INTO public.owner_experiences
(experience_position_name, experience_description, experience_initial_date, experience_end_date, experience_created_at, experiencet_updated_at, experience_status, owner_id)
VALUES( 'Java developer', 'Java developer in Stefanini', '2022-02-01', '2022-11-01', '2024-05-20',null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');

INSERT INTO public.owner_experiences
(experience_position_name, experience_description, experience_initial_date, experience_end_date, experience_created_at, experiencet_updated_at, experience_status, owner_id)
VALUES( 'Java developer', 'Java developer in Solemti', '2021-08-01', '2021-12-01', '2024-05-20',null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');

INSERT INTO public.owner_experiences
(experience_position_name, experience_description, experience_initial_date, experience_end_date, experience_created_at, experiencet_updated_at, experience_status, owner_id)
VALUES( 'Programmer Analyst', 'Java developer in Banregio', '2019-01-01', '2021-05-01', '2024-05-20',null, 'ACTIVE', 'cfd2b4ea-0747-49e1-970f-bf6d08dc8e31');


SELECT experience_id, experience_position_name, experience_description, experience_initial_date, experience_end_date, experience_created_at, experiencet_updated_at, experience_status, owner_id
FROM public.owner_experiences;




INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Java', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');

INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Api Rest', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');


INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Git', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');



INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Java', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');

INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Api Rest', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');


INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Git', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');





INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Java', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');

INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Api Rest', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');


INSERT INTO public.owner_experience_skills
( experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id)
VALUES( 'Git', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');


SELECT experience_skill_id, experience_skill_name, experience_skill_created_at, experiencet_skill_updated_at, experience_skill_status, experience_id
FROM public.owner_experience_skills;



--------STEFANINI
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Create and Optimize RESTful Services with java 8', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Version management with Git.', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Use of SCRUM Methodology for software development', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Analysis and Troubleshooting in Production.', '2024-05-20',null, 'ACTIVE', '3f151984-b368-412e-8c24-e99f39bdbfed');



-----------SOLEMTI
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Create and Optimize RESTful Services with java 8 and 11.', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Migrating Java Web Services to Spring.', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Using Hibernate for Data Persistence.', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Version Management with Git (Github and Gitlab).', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Use of SCRUM Methodology for software development.', '2024-05-20',null, 'ACTIVE', 'b90e9130-eee2-41c1-85cc-98c28d48b1ef');


-------------------------BANREGIO
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Software Development in Java EE Java 8 (EJB).', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Requirement Analysis.', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Use of Hibernate for Data Persistence.', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Process Management in ASE SQL Database (store procedure, tables, querys).', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Version Management with Git (Bitbucket).', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');
INSERT INTO public.owner_experience_details
( experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id)
VALUES( 'Use of SCRUM Methodology for software development.', '2024-05-20',null, 'ACTIVE', 'e358f0ce-9184-4c53-8d19-3ceed258cd8f');


SELECT experience_detail_id, experience_detail_description, experience_detail_created_at, experiencet_detail_updated_at, experience_detail_status, experience_id
FROM public.owner_experience_details;



INSERT INTO public.owner_experience_companies
(experience_company_name, experience_company_url, experience_company_created_at, experiencet_company_updated_at, experience_company_status, experience_id)
VALUES( 'Stefanini LATAM', 'https://stefanini.com/es','2024-05-20',null, 'ACTIVE','e358f0ce-9184-4c53-8d19-3ceed258cd8f');

INSERT INTO public.owner_experience_companies
(experience_company_name, experience_company_url, experience_company_created_at, experiencet_company_updated_at, experience_company_status, experience_id)
VALUES( 'Solemti', 'https://www.solemtipyme.com/','2024-05-20',null, 'ACTIVE','e358f0ce-9184-4c53-8d19-3ceed258cd8f');


INSERT INTO public.owner_experience_companies
(experience_company_name, experience_company_url, experience_company_created_at, experiencet_company_updated_at, experience_company_status, experience_id)
VALUES( 'Banregio', 'https://www.banregio.com/','2024-05-20',null, 'ACTIVE','e358f0ce-9184-4c53-8d19-3ceed258cd8f');



SELECT experience_company_id, experience_company_name, experience_company_url, experience_company_created_at, experiencet_company_updated_at, experience_company_status, experience_id
FROM public.owner_experience_companies;












