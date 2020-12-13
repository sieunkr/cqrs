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

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email, status)
VALUES
  (1, 'eddy', 'kim', '010-1111-1111', 'sieunkr@gmail.com', 'a');

INSERT INTO CUSTOMER (id, first_name, last_name, phone, email, status)
VALUES
  (2, 'jinwoo', NULL, '010-2222-2222', 'jinwoolee2020@gmail.com', 'b');


INSERT INTO RESERVATION (id, room_id, adults, children, check_in_date, check_out_date, customer_id)
VALUES
  (1, 1, 2, 0, '2020-06-17', '2020-06-20', 1);