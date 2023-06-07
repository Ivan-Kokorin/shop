INSERT INTO public.product_category (id, title) VALUES(1, 'PC');
INSERT INTO public.product_category (id, title) VALUES(2, 'NoteBook');
INSERT INTO public.product_category (id, title) VALUES(3, 'Monitor');
INSERT INTO public.product_category (id, title) VALUES(4, 'HDD');

INSERT INTO public.additional_property (id, title, id_category) VALUES(1, 'Form-factor', 1);
INSERT INTO public.additional_property (id, title, id_category) VALUES(2, 'Size', 2);
INSERT INTO public.additional_property (id, title, id_category) VALUES(3, 'Display', 3);
INSERT INTO public.additional_property (id, title, id_category) VALUES(4, 'Memory', 4);

INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('PC-12345-QWERTY', 12, 'MSI', 100000, 1);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('PC-777-ABC', 8, 'DNS', 50000, 1);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('Acer-NITRO-5-12321', 22, 'Acer', 99000, 2);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('ASUS-333-1', 18, 'Asus', 120000, 2);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('G-5-111111', 52, 'Samsung', 25000, 3);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('LG-32332-E', 35, 'LG', 23000, 3);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('WD-L-512', 99, 'WD', 5999, 4);
INSERT INTO public.product (number_serial, amount, brand, price, category_id) VALUES('S-1024-111', 17, 'Samsung', 7300, 4);

INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('Desktop', 1, 'PC-12345-QWERTY');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('Monoblock', 1, 'PC-777-ABC');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('17', 2, 'Acer-NITRO-5-12321');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('15', 2, 'ASUS-333-1');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('27', 3, 'G-5-111111');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('32', 3, 'LG-32332-E');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('512 Gb', 4, 'WD-L-512');
INSERT INTO public.property_value (value_prop, id_property, number_serial) VALUES('1 Tb', 4, 'S-1024-111');


