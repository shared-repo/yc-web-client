USE mysql;

SELECT USER, HOST FROM USER;

GRANT ALL PRIVILEGES ON employees.* TO devuserone@localhost;
GRANT ALL PRIVILEGES ON employees.* TO devuserone@"%";
GRANT ALL PRIVILEGES ON madang.* TO devuserone@localhost;
GRANT ALL PRIVILEGES ON madang.* TO devuserone@"%";