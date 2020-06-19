INSERT INTO HOTEL (id, city, name)
VALUES
  (1, 'SEOUL', 'A Hotel'),
  (2, 'INCHON', 'B Hotel');

INSERT INTO ROOM_TYPE (id, name)
VALUES
  (1, 'A'),
  (2, 'S');

INSERT INTO ROOM (id, hotel_id, room_status, room_type_id)
VALUES
  (1, 1, 'ON', 1),
  (2, 1, 'ON', 2);

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email)
VALUES
  (1, 'Eddy', 'Kim', 01011111111, 'sieunkr@gmail.com');


INSERT INTO RESERVATION (id, room_id, adults, children, check_in_date, check_out_date, customer_id)
VALUES
  (1, 1, 2, 0, '2020-06-17', '2020-06-20', 1);