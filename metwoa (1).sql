-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 19 août 2022 à 16:58
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `metwoa`
--

-- --------------------------------------------------------

--
-- Structure de la table `actionnariat`
--

CREATE TABLE `actionnariat` (
  `id_actionnariat` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  `part` double NOT NULL,
  `availableDay` int(11) NOT NULL DEFAULT 30,
  `date` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `actionnariat`
--

INSERT INTO `actionnariat` (`id_actionnariat`, `id_user`, `id_vehicule`, `part`, `availableDay`, `date`) VALUES
(1, 1, 6, 1, 30, '2022-02-09'),
(2, 4, 12, 1, 30, '2022-02-15'),
(3, 4, 13, 2, 30, '2022-02-15'),
(4, 4, 13, 2, 30, '2022-02-15'),
(5, 4, 14, 1, 30, '2022-02-15'),
(6, 4, 14, 1, 30, '2022-02-15');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `id` int(11) NOT NULL,
  `titre` varchar(50) NOT NULL,
  `resume` text NOT NULL,
  `auteur` text NOT NULL,
  `contenu` text NOT NULL,
  `created_at` date NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id`, `titre`, `resume`, `auteur`, `contenu`, `created_at`, `image`) VALUES
(1, 'La Zonda d\'Hamilton', 'Lewis Hamilton revend sa Zonda 7 fois plus chère', 'Challenges', 'Initialement acquise pour la somme de 1,4 millions d\'euros, Lewis Hamilton revend sa Zonda 10 millions d\'euros', '2022-02-02', 'bugattiChiron2016.jpg'),
(2, 'Classe G plus chère d\'occasion', 'Un classe G vaut plus chère d\'occasion que neuf ', 'Steve', '217 000 d\'occasion, c\'est 40000 euros de plus que sa valeur neuve', '2022-02-07', '389514_Lamborghini.jpg'),
(3, 'Bugatti 2024', 'Carnet de commande plein jusqu\'à 2024', 'Capital Luxe', 'Les passionnés de véhicules souhaitant acquérir l\'exception à la française en matière d\'automobile que constitue la Chiron devront; en plus de débourser la coquette somme de 3000 000 d\'euros, s\'inscrire sur une liste d\'attente horizon 2024 afin d\'acquérir ce véhicule d\'exception. ', '2022-02-15', 'BugattiChiron13.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `calendrier`
--

CREATE TABLE `calendrier` (
  `id_rdv` int(11) NOT NULL,
  `date` text NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  `heure` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE `categories` (
  `idCategorie` int(11) NOT NULL,
  `libelle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categories`
--

INSERT INTO `categories` (`idCategorie`, `libelle`) VALUES
(1, 'ALL'),
(2, 'SECONDHAND'),
(3, 'BRANDNEW'),
(4, 'ANCIENNE'),
(5, 'PRE-ORDER'),
(6, 'ONE-OFF');

-- --------------------------------------------------------

--
-- Structure de la table `garage`
--

CREATE TABLE `garage` (
  `id_garage` int(11) NOT NULL,
  `intervention` text NOT NULL,
  `date_entree` text NOT NULL,
  `date_sortie` text NOT NULL,
  `id_sinistre` int(11) NOT NULL,
  `cout` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `garage`
--

INSERT INTO `garage` (`id_garage`, `intervention`, `date_entree`, `date_sortie`, `id_sinistre`, `cout`) VALUES
(1, 'Redressement aile, polissage et peinture', '2022-02-17', '2022-02-26', 4, 2000);

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `id_location` int(11) NOT NULL,
  `depart` varchar(20) DEFAULT NULL,
  `retour` varchar(20) DEFAULT NULL,
  `lieuLivraison` text DEFAULT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_vehicule` int(11) DEFAULT NULL,
  `id_tarif` int(11) DEFAULT NULL,
  `nbreJour` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id_location`, `depart`, `retour`, `lieuLivraison`, `id_user`, `id_vehicule`, `id_tarif`, `nbreJour`) VALUES
(1, '2022-02-10', '2022-02-12', '105 rue de meaux 75019 Paris', 1, 6, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `onglets`
--

CREATE TABLE `onglets` (
  `id_onglet` int(11) NOT NULL,
  `libelle` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `onglets`
--

INSERT INTO `onglets` (`id_onglet`, `libelle`) VALUES
(1, 'HOME'),
(2, 'BUY'),
(3, 'RENT'),
(4, 'SELL'),
(5, 'Articles'),
(6, 'US'),
(9, 'CONTACT');

-- --------------------------------------------------------

--
-- Structure de la table `sinistre`
--

CREATE TABLE `sinistre` (
  `id_sinistre` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `description` text NOT NULL,
  `date` text NOT NULL,
  `id_location` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `sinistre`
--

INSERT INTO `sinistre` (`id_sinistre`, `id_user`, `description`, `date`, `id_location`, `id_vehicule`) VALUES
(4, 1, 'Aile adimée', '2022-02-18', 1, 6);

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

CREATE TABLE `statut` (
  `id_statut` int(11) NOT NULL,
  `titre` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`id_statut`, `titre`) VALUES
(1, 'Administrateur'),
(2, 'Conducteur'),
(3, 'Propriétaire'),
(4, 'Rédacteur'),
(5, 'Chauffeur'),
(6, 'Chauffeur');

-- --------------------------------------------------------

--
-- Structure de la table `tarif`
--

CREATE TABLE `tarif` (
  `id_tarif` int(11) NOT NULL,
  `id_vehicule` int(11) NOT NULL,
  `mbela` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `tarif`
--

INSERT INTO `tarif` (`id_tarif`, `id_vehicule`, `mbela`) VALUES
(1, 6, 1000);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `id_statut` int(11) NOT NULL,
  `email` varchar(20) NOT NULL,
  `age` int(11) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `mdp` text NOT NULL,
  `adresse` varchar(100) NOT NULL,
  `obtentionPermis` varchar(20) NOT NULL,
  `inscription` date NOT NULL DEFAULT current_timestamp(),
  `isVisible` tinyint(1) NOT NULL DEFAULT 1,
  `permis` varchar(20) NOT NULL,
  `image` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `id_statut`, `email`, `age`, `telephone`, `mdp`, `adresse`, `obtentionPermis`, `inscription`, `isVisible`, `permis`, `image`) VALUES
(1, 'KAMSU', 'ijlj', 1, 'jiji@jiji.ji', 29, 'lkjlkj', 'A6xnQhbz4Vx2HuGl4lXwZ5U2I8iziLRFnhP5eNfIRvQ=', 'lk', '0001-02-23', '2022-02-03', 1, 'jbb', ''),
(2, 'dljnn,dL', 'LJLKJ', 2, 'LKJLKJ', 12, '878370708', '8QZtmXfJ1DV/VVJomDJaaOMHxeoizNXT3F2OMww9Xds=', 'KJKJMKJ', '1999-09-12', '2022-02-03', 1, 'OIOIOI', ''),
(3, 'lkjlkjs', 'lkjlksj', 2, 'piupipo', 12, 'OIUIU', 'Bb8TD4Hw0NK8Kv/2/5bJ2Mq471JKejHPBhEw6er1gE8=', 'iulkjlk', '1992-02-19', '2022-02-03', 1, 'lkjlkj', ''),
(4, 'KAMSU', 'Bertrand', 1, 'admin@admin.admin', 30, '0758799635', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=', '105 rue de meaux', '1992-02-12', '2022-02-03', 1, 'AKKR7', '');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `id_vehicule` int(11) NOT NULL,
  `marque` text NOT NULL,
  `modele` text NOT NULL,
  `prix` double NOT NULL,
  `emplacement` text NOT NULL,
  `siege` int(11) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `oneOff` tinyint(1) NOT NULL,
  `color` text NOT NULL,
  `energy` text NOT NULL,
  `miles` int(11) NOT NULL,
  `year` int(11) NOT NULL,
  `mechanic` text NOT NULL,
  `interieur` text NOT NULL,
  `image` text NOT NULL,
  `description` text NOT NULL,
  `isPromo` tinyint(1) NOT NULL DEFAULT 0,
  `image1` text NOT NULL,
  `image2` text NOT NULL,
  `image3` text NOT NULL,
  `approved` tinyint(1) NOT NULL,
  `partDispo` int(11) NOT NULL,
  `forRent` tinyint(1) NOT NULL,
  `availability` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `vehicule`
--

INSERT INTO `vehicule` (`id_vehicule`, `marque`, `modele`, `prix`, `emplacement`, `siege`, `etat`, `oneOff`, `color`, `energy`, `miles`, `year`, `mechanic`, `interieur`, `image`, `description`, `isPromo`, `image1`, `image2`, `image3`, `approved`, `partDispo`, `forRent`, `availability`) VALUES
(6, 'Pagani', 'Zonda', 1200000, 'Paris', 2, 0, 0, 'Vert', 'Essence', 1200, 2019, 'Automatic', 'Cuir', 'paganiZonda.jpg', 'XBEGK3Y', 0, '0', '0', '0', 1, 0, 0, ''),
(7, 'Test', 'Zonda', 1200000, 'Paris', 2, 0, 0, 'Vert', 'Essence', 1200, 2019, 'Automatic', 'Cuir', '389514_Lamborghini.jpg', 'XBEGK3Y', 1, '0', '0', '0', 1, 0, 0, ''),
(8, 'Pagani', 'Zonda', 1200000, 'Paris', 2, 0, 0, 'Vert', 'Essence', 1200, 2019, 'Automatic', 'Cuir', 'paganiZonda.jpg', 'XBEGK3Y', 0, '0', '0', '0', 1, 0, 0, ''),
(9, 'Pagani', 'Zonda', 1200000, 'Paris', 2, 0, 0, 'Vert', 'Essence', 1200, 2019, 'Automatic', 'Cuir', 'paganiZonda.jpg', 'XBEGK3Y', 1, '0', '0', '0', 1, 0, 0, ''),
(10, 'Bugatti', 'Chiron', 3000000, 'Londres', 4, 0, 0, 'Gris', 'Gasoil', 0, 2022, 'Automatic', 'Cuir ', '389514_Lamborghini.jpg', 'Bugatti Chiron en précommande', 1, '0', '0', '0', 1, 0, 0, ''),
(11, 'Pagani', 'Zonda', 12000000, 'Londres', 2, 0, 0, 'Rouge', 'Diesel', 1009, 2017, 'Automatic', 'Cuir', 'paganiZonda.jpg', 'GHEYYDIKZ', 0, '0', '0', '0', 1, 0, 0, ''),
(12, 'Shelby', 'Cobra 427', 166000, 'Bretten, Allemagne', 2, 0, 0, 'Bleue', 'Gasoil', 40000, 1966, 'Manuel', 'Cuir', 'shelby.jpg', 'AD-75-DE', 0, 'shelby1.jpg', 'shelby2.jpg', 'shelby3.jpg', 1, 10, 1, ''),
(13, 'Bugatti', 'Chiron', 3790000, 'Rotterdam, Pays Bas', 2, 0, 0, 'Noir Carbon', 'Essence', 80, 2022, 'Automatic', 'Cuir', 'BugattiChiron11.jpg', 'BK-678-YU', 0, 'BugattiChiron12.jpg', 'BugattiChiron13.jpg', 'BugattiChiron14.jpg', 1, 9, 0, ''),
(14, 'Mercedes', 'G 63 AMG Long BRABUS 700', 149900, 'Allemagne', 4, 0, 0, 'Noir', 'Diesel', 51900, 2015, 'Automatic', 'Cuir', 'classeG1.jpg', 'BI-UYA-95', 0, 'classeG2.jpg', 'classeG3.jpg', 'classeG4.jpg', 1, 7, 0, '12-02-2022');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `actionnariat`
--
ALTER TABLE `actionnariat`
  ADD PRIMARY KEY (`id_actionnariat`),
  ADD KEY `fk_id_user` (`id_user`),
  ADD KEY `fk_id_vehicule` (`id_vehicule`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `calendrier`
--
ALTER TABLE `calendrier`
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`idCategorie`);

--
-- Index pour la table `garage`
--
ALTER TABLE `garage`
  ADD PRIMARY KEY (`id_garage`),
  ADD KEY `fk_id_sinistre` (`id_sinistre`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id_location`),
  ADD KEY `id_tarif` (`id_tarif`),
  ADD KEY `id_vehicule` (`id_vehicule`),
  ADD KEY `id_user` (`id_user`);

--
-- Index pour la table `onglets`
--
ALTER TABLE `onglets`
  ADD PRIMARY KEY (`id_onglet`);

--
-- Index pour la table `sinistre`
--
ALTER TABLE `sinistre`
  ADD PRIMARY KEY (`id_sinistre`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `fk_id_location` (`id_location`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id_statut`);

--
-- Index pour la table `tarif`
--
ALTER TABLE `tarif`
  ADD PRIMARY KEY (`id_tarif`),
  ADD KEY `id_vehicule` (`id_vehicule`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `fk_id_statut` (`id_statut`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`id_vehicule`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `actionnariat`
--
ALTER TABLE `actionnariat`
  MODIFY `id_actionnariat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `calendrier`
--
ALTER TABLE `calendrier`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
  MODIFY `idCategorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `garage`
--
ALTER TABLE `garage`
  MODIFY `id_garage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `id_location` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `onglets`
--
ALTER TABLE `onglets`
  MODIFY `id_onglet` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `sinistre`
--
ALTER TABLE `sinistre`
  MODIFY `id_sinistre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `id_statut` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `tarif`
--
ALTER TABLE `tarif`
  MODIFY `id_tarif` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `vehicule`
--
ALTER TABLE `vehicule`
  MODIFY `id_vehicule` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `actionnariat`
--
ALTER TABLE `actionnariat`
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `fk_id_vehicule` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`);

--
-- Contraintes pour la table `calendrier`
--
ALTER TABLE `calendrier`
  ADD CONSTRAINT `calendrier_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `calendrier_ibfk_2` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`);

--
-- Contraintes pour la table `garage`
--
ALTER TABLE `garage`
  ADD CONSTRAINT `fk_id_sinistre` FOREIGN KEY (`id_sinistre`) REFERENCES `sinistre` (`id_sinistre`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `location_ibfk_1` FOREIGN KEY (`id_tarif`) REFERENCES `tarif` (`id_tarif`),
  ADD CONSTRAINT `location_ibfk_2` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`),
  ADD CONSTRAINT `location_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `sinistre`
--
ALTER TABLE `sinistre`
  ADD CONSTRAINT `fk_id_location` FOREIGN KEY (`id_location`) REFERENCES `location` (`id_location`),
  ADD CONSTRAINT `sinistre_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `sinistre_ibfk_3` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`);

--
-- Contraintes pour la table `tarif`
--
ALTER TABLE `tarif`
  ADD CONSTRAINT `tarif_ibfk_1` FOREIGN KEY (`id_vehicule`) REFERENCES `vehicule` (`id_vehicule`);

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_id_statut` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id_statut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
