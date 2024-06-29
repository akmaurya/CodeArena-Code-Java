use mydocument;
show tables;
drop table document, document_informations, person, info, person_documents;

drop table document;
drop table document_informations;
drop table person;
drop table info;
drop table person_documents;
drop table document_type;
drop table person_document;


truncate table document;
truncate table document_type;
truncate table document_informations;
truncate table person;
truncate table info;
truncate table person_document;

select * from person;
select * from document_type;
select * from document;
select * from person_document;
select * from document_informations;
select * from info;
