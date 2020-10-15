
insert into series
(ID, SERIES_NAME, SERIES_LINK_MORE_INFO)
values
(0, 'Samsung Galaxy S series', 'https://en.wikipedia.org/wiki/Samsung_Galaxy_S_series');

insert into series
(ID, SERIES_NAME, SERIES_LINK_MORE_INFO)
values
(1, 'Apple Iphone series', 'https://en.wikipedia.org/wiki/List_of_iOS_devices');

insert into brand
(ID, BRAND_NAME, BRAND_LINK_MORE_INFO)
values
(0, 'Samsung', 'https://www.samsung.com/be/');

insert into brand
(ID, BRAND_NAME, BRAND_LINK_MORE_INFO)
values
(1, 'Apple', 'https://www.apple.com/benl/');

ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 0 minvalue 0;
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Samsung Galaxy S10e', 500, 0, 0);
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Samsung Galaxy S10', 700, 0, 0);
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Samsung Galaxy S10+', 800, 0, 0);
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Apple Iphone XR', 700, 1, 1);
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Apple Iphone X', 900, 1, 1);
insert into phone
(ID, NAME, PRIJS, BRAND_ID, SERIES_ID) values
(nextval('HIBERNATE_SEQUENCE'), 'Apple Iphone XS', 1000, 1, 1);


