# Create MySQL Image for Caffe-management-system
FROM mysql

ENV MYSQL_ROOT_PASSWORD password

ADD sql/create.sql /docker-entrypoint-initdb.d
ADD sql/insert.sql /docker-entrypoint-initdb.d
ADD sql/update.sql /docker-entrypoint-initdb.d

EXPOSE 3306
