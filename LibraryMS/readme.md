- ��ҳ��http://localhost:8080/LibraryMS/BookServlet?book=show

- ���ݿ��������
CREATE TABLE writer (
  w_id int(10) NOT NULL PRIMARY KEY  AUTO_INCREMENT,
  w_name varchar(50) NOT NULL
);


CREATE TABLE book(
  b_id int(10) NOT NULL PRIMARY KEY  AUTO_INCREMENT,
  b_name varchar(50) not NULL,
  b_output varchar(50) not null,
  b_price double,
  b_createdate datetime not null,
  b_writer_id int(10),
  CONSTRAINT wb_no FOREIGN KEY (b_writer_id) REFERENCES  writer(w_id)
);

insert into writer values(3,'������'),(2,'����Բ'),(3,'����');

insert into book values(4,'go','���г�����','27.5','2020-01-01 12:00:00',1);
