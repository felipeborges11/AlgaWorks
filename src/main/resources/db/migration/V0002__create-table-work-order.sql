CREATE TABLE work_order(
id bigint not null auto_increment,
client_id bigint not null,
description text not null,
price decimal(10,2) not null,
status varchar(20) not null,
open_date datetime not null,
finalization_date datetime,

primary key(id)
);

alter table work_order add constraint fk_work_order_client
foreign key (client_id) references client(id)