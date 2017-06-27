USE perfumeDb;
INSERT INTO brands
VALUES (NULL, "Chanel"), (NULL, "Sergio Lutens"), (NULL, "Tom Ford"), (NULL, "Dior"), (NULL, "Givenchy");
INSERT INTO perfumes
VALUES (NULL, "#5", 1), (NULL, "Diamond Blond", 2), (NULL, "Tom Ford for Men", 3), (NULL, "J'adore", 4),
  (NULL, "Le Secret", 5), (NULL, "Le petit robe noir", 4), (NULL, "Leather", 3);
INSERT INTO offers
VALUES (NULL, 10, 50, 1), (NULL, 13, 30, 2), (NULL, 20, 50, 3), (NULL, 11, 70, 4), (NULL, 10, 55, 5), (NULL, 8, 70, 6),
  (NULL, 7, 20, 5), (NULL, 18, 50, 5);


-- Insert log-in data

INSERT INTO users VALUES (1, 'ana', 'some phone number', 'some e-mail', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);