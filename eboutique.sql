-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --
-- 
-- 		TUTORIEL JAVA VEE
-- 		SCRIPT DE CREATION DES DONNEES EMARKET
-- 
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++ --

-- --------------------------------------------------------
-- Décommenter les lignes suivantes si les tables existent 
-- déjà dans la base (cas où vous voulez repartir d'un 
-- environnement "propre").
-- 
/*
 DROP TABLE product_has_component ;
 DROP TABLE user_has_group ;
 DROP TABLE emarket_user ;
 DROP TABLE product ;
 DROP TABLE component ;
 DROP TABLE groupe ;
 
 DROP TABLE orders ;
 DROP TABLE orders_item ;
 */


-- DROP TABLE shoppingcartitem ;
-- --------------------------------------------------------

--
-- Structure de la table product
--

CREATE TABLE product (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  selling_price DOUBLE DEFAULT 0,
  description VARCHAR(255) DEFAULT 'lorem Ipsum',
  PRIMARY KEY (id)
);

--
-- Contenu de la table product
--

INSERT INTO product (name, selling_price) VALUES
('PC configuration de base', 400),
('PC configuration jeux vidéos', 800),
('MacBook configuration de base', 600),
('MacBook configuration performance', 1000);

-- --------------------------------------------------------

--
-- Structure de la table component
--
CREATE TABLE component (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  supplier VARCHAR(255),
  PRIMARY KEY (id)
);

--
-- Contenu de la table component
--

INSERT INTO component (name, supplier) VALUES
('Carte mère', 'Fournisseur1'),
('Processeur', 'Fournisseur1'),
('RAM', 'Fournisseur1'),
('Disque Dur', 'Fournisseur1');

-- --------------------------------------------------------

--
-- Structure de la table product_has_component
--

CREATE TABLE product_has_component (
  product_id INT NOT NULL ,
  component_id INT NOT NULL ,
  quantity INT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (product_id, component_id) ,
  CONSTRAINT fk_product_id
    FOREIGN KEY (product_id )
    REFERENCES product (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_component_id
    FOREIGN KEY (component_id )
    REFERENCES component (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

--
-- Contenu de la table product_has_component
--

INSERT INTO product_has_component (product_id, component_id, quantity) VALUES
(1, 1, 1),
(1, 2, 1),
(2, 1, 1),
(2, 2, 2),
(2, 3, 2),
(3, 3, 1),
(4, 3, 1),
(4, 4, 2);

-- --------------------------------------------------------

--
-- Structure de la table emarket_user
--

CREATE TABLE emarket_user (
  login VARCHAR(50) NOT NULL ,
  password VARCHAR(50) NOT NULL ,
  lastname VARCHAR(100) NOT NULL ,
  firstname VARCHAR(100) NOT NULL ,
  PRIMARY KEY (login)
);

--
-- Contenu de la table emarket_user
--

INSERT INTO emarket_user (login, password, lastname, firstname) VALUES
('admin', '123', 'Deray', 'Odile'),
('robert', '123', 'Jasques', 'Robert'),
('céline', '123', 'Durand', 'Céline');

-- --------------------------------------------------------

--
-- Structure de la table user_has_group
--

CREATE TABLE user_has_group (
  login VARCHAR(50) NOT NULL ,
  group_id VARCHAR(50) NOT NULL ,
  PRIMARY KEY (login, group_id) ,
  CONSTRAINT fk_login FOREIGN KEY (login )
    REFERENCES emarket_user (login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
--
-- Contenu de la table user_has_group
--

CREATE TABLE groupe (
  groupe_id VARCHAR(255) NOT NULL ,
  PRIMARY KEY (groupe_id)
 );
 
 INSERT INTO groupe (groupe_id) values
 ('Commerciaux'),('Internautes');

INSERT INTO user_has_group (login, group_id) VALUES
('admin', 'Commerciaux'),
('céline', 'Internautes'),
('robert', 'Internautes');

-- --------------------------------------------------------
/*
--
-- Structure de la table shoppingcartitem
--

CREATE TABLE shoppingcartitem (
  id INT NOT NULL AUTO_INCREMENT,
  user_login VARCHAR(50) NOT NULL ,
  product_id INT NOT NULL ,
  quantity INT NOT NULL DEFAULT 1,
  PRIMARY KEY (id) ,
  CONSTRAINT fk_shoppingcart_product_id
    FOREIGN KEY (product_id )
    REFERENCES product (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_shoppingcart_user_login
    FOREIGN KEY (user_login )
    REFERENCES emarket_user (login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

--
-- Contenu de la table shoppingcartitem
--

INSERT INTO shoppingcartitem (user_login, product_id, quantity) VALUES
('robert', 1, 3),
('robert', 4, 1);
*/
-- --------------------------------------------------------

--
-- Table des commandes
--

CREATE TABLE orders (

id INT NOT NULL AUTO_INCREMENT,
user_login VARCHAR(50) NOT NULL ,
prix_tot DOUBLE NOT NULL,
PRIMARY KEY (id) ,
CONSTRAINT fk_orders_emarket_user
    FOREIGN KEY (user_login)
    REFERENCES emarket_user (login)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION 
);

--
-- Détail des commandes
--

CREATE TABLE orders_item (

id INT NOT NULL AUTO_INCREMENT,
id_orders INT NOT NULL ,
id_product INT NOT NULL ,
prix_unit DOUBLE NOT NULL,
quantity INT NOT NULL ,
user_ordering VARCHAR(50) NOT NULL ,
PRIMARY KEY (id) ,
CONSTRAINT fk_orders_id
    FOREIGN KEY (id_orders )
    REFERENCES orders (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT fk_orders_product
    FOREIGN KEY (id_product )
    REFERENCES product (id )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
CONSTRAINT fk_orders_user
    FOREIGN KEY (user_ordering )
    REFERENCES orders (user_login )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION


);
