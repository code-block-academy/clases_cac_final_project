insert into usuarios (name, surname, email, password, rol)
values("marco", "avila", "marco6267@hotmail.com", "1234","admin");

insert into usuarios (name, surname, email, password)
values("name1", "surname1", "user1@hotmail.com", "1234"), ("name2", "surname2", "user2@hotmail.com", "1234"), ("name3", "surname3", "user3@hotmail.com", "1234");

insert into usuarios (name, surname, email, password)
values ("name4", "surname4", "user4@hotmail.com", "1234"), ("name5", "surname5", "user5@hotmail.com", "1234"), ("name6", "surname6", "user6@hotmail.com", "1234");

insert into productos (name, price)
values ("generic RAM ddr4 8gb 3000Mhz", 3200), ("generic CPU 3.7GHz", 7600), ("generic GPU 2gb GDDR5", 3200), ("generic motherboard", 6500), 
("generic HDD 1TB", 4200), ("generic SSD 120GB", 2290), ("generic mouse", 500), ("generic keyboard", 1400), ("generic box", 3500), 
("generic source", 1200), ("generic monitor", 1500);

insert into comentarios(comment, quality, id_usuario, id_producto)
values
("que buen producto, lo recomiendo", 4.7, 
(select id_usuario from usuarios where id_usuario=2), 
(select id_producto from productos where id_producto=9));

insert into comentarios(comment, quality, id_usuario, id_producto)
values
("que buen producto, lo recomiendo", 4.7, 
4, 
5);

select * from usuarios;
select * from comentarios;
select * from productos;

select * from comentarios where id_producto = 9;

select * from usuarios where id_usuario = 2;
select * from productos where id_producto = 5;

select * from usuarios where email = "user1@hotmail.com" and password = "1234";


SELECT 
    *
FROM
    comentarios 
        natural JOIN
    usuarios
WHERE
    id_producto = 5;

SELECT * FROM comentarios as c inner join usuarios as u on u.id_usuario = c.id_usuario ;

SELECT 
    id_usuario, comment, c.quality
FROM
    productos as p
        INNER JOIN
    comentarios as c ON c.id_producto = p.id_producto
WHERE
    p.id_producto = 13;
    
select * from productos join comentarios;

SELECT 
   *
FROM
    productos AS p
        right JOIN
    comentarios AS c ON c.id_producto = p.id_producto
    where p.id_producto is not null;