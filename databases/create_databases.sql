drop database if exists example_development;
drop database if exists example_test;
drop user initialdev;

create user initialdev with password 'initialdev';
create database example_development;
create database example_test;

grant all privileges on database example_development to initialdev;
grant all privileges on database example_test to initialdev;

\c example_development
grant create on schema public to initialdev;

\c example_test
grant create on schema public to initialdev;
