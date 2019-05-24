-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 24 mai 2019 à 06:41
-- Version du serveur :  5.7.24-log
-- Version de PHP :  7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `jpublankproject`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `HelloworldByCode`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `HelloworldByCode` (IN `p_code` VARCHAR(2))  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM jpublankproject.helloworld where `code`=p_code$$

DROP PROCEDURE IF EXISTS `helloworldById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `helloworldById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM helloworld WHERE id = p_id$$

DROP PROCEDURE IF EXISTS `mapById`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mapById` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM maps WHERE id = p_id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE IF NOT EXISTS `helloworld` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(2) NOT NULL,
  `message` varchar(1500) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `helloworld`
--

INSERT INTO `helloworld` (`id`, `code`, `message`) VALUES
(1, 'GB', 'Hello world'),
(2, 'FR', 'Bonjour le monde'),
(3, 'DE', 'Hallo Welt'),
(4, 'ID', 'Salamat pagi dunia'),
(5, 'M1', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwpnngsgggsnnsgggggggggigsnsngggggggngggggsgggdgngwwggggsngggggnggssngnggiggsgggnssgggnggsgngggggsggwwssnggggsggnsgggggngsgiggsgnggnsggngggggsgggngngswwgggggngggsgggnsggggggiggsgggsggggnnsgggdgnnngsggwwgggsssgggssggnggsgsggiggggnssggggngggsnsggnggggnwwiiiiiiiiiiigggggggggsggngdggggssgggngggggsgggnsgwwdddggsggggiggssgngggggsggggsgngggngggsgggggngsgswwdggggggnggisggggnggsggsgggnggggnssgggggnggsgggggwwggsnggggnsigggsggggggngggsgggnsgggggnsggggggnnggwwgggggngggniggngggssggngggsssggggggngggggsgggggsgwwsssngggsggggggggngggsggggnggggssnnnggsggggnssgngwwgsssggngdggnnggsgggngggsgnnngsgssssgngggsgnnggggwwsnnsggggnnnnngggdsggggggggggsgsssgsggggnggnnngsgwwsgggggggnngggggsggggnngggnggggggggggggggssggdgggwwsngsnnnnnggggggssggngnsssssgggggsnnnssggggnnddggwwnngggnggsiiiiiiiiiiiiiiiiiiiiiiiiiiiiggggsnggggnwwssgggngggigssggggdnnnnggggggsgggggnnnnnngggggsgswwgsggggsggigggggngggggngsggnnngngggggngsggggggsgswwssggnggggigggggenngggngssgggnggggssggggsgnngggggwwggggggssgisssgggggnggggsssngggsggggsnngggsssngggwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww');

-- --------------------------------------------------------

--
-- Structure de la table `maps`
--

DROP TABLE IF EXISTS `maps`;
CREATE TABLE IF NOT EXISTS `maps` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `maps`
--

INSERT INTO `maps` (`id`, `level`) VALUES
(1, 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\r\nwpnngsgggsnnsgggggggggigsnsngggggggngggggsgggdgngw\r\nwggggsngggggnggssngnggiggsgggnssgggnggsgngggggsggw\r\nwssnggggsggnsgggggngsgiggsgnggnsggngggggsgggngngsw\r\nwgggggngggsgggnsggggggiggsgggsggggnnsgggdgnnngsggw\r\nwgggsssgggssggnggsgsggiggggnssggggngggsnsggnggggnw\r\nwiiiiiiiiiiigggggggggsggngdggggssgggngggggsgggnsgw\r\nwdddggsggggiggssgngggggsggggsgngggngggsgggggngsgsw\r\nwdggggggnggisggggnggsggsgggnggggnssgggggnggsgggggw\r\nwggsnggggnsigggsggggggngggsgggnsgggggnsggggggnnggw\r\nwgggggngggniggngggssggngggsssggggggngggggsgggggsgw\r\nwsssngggsggggggggngggsggggnggggssnnnggsggggnssgngw\r\nwgsssggngdggnnggsgggngggsgnnngsgssssgngggsgnnggggw\r\nwsnnsggggnnnnngggdsggggggggggsgsssgsggggnggnnngsgw\r\nwsgggggggnngggggsggggnngggnggggggggggggggssggdgggw\r\nwsngsnnnnnggggggssggngnsssssgggggsnnnssggggnnddggw\r\nwnngggnggsiiiiiiiiiiiiiiiiiiiiiiiiiiiiggggsnggggnw\r\nwssgggngggigssggggdnnnnggggggsgggggnnnnnngggggsgsw\r\nwgsggggsggigggggngggggngsggnnngngggggngsggggggsgsw\r\nwssggnggggigggggenngggngssgggnggggssggggsgnngggggw\r\nwggggggssgisssgggggnggggsssngggsggggsnngggsssngggw\r\nwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww'),
(2, 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\r\nwpgggsiggsssggndngggsgggggiddgggnnggssnggsssggngsw\r\nwgggssidggggsgnggssgngssngidgggggngssgggnggdgggggw\r\nwnnngginnnnnggggsggggnnggsiiiiiinnnggggsggiiiiiiiw\r\nwggnggidgggggssgggssnnggsgissgngngggssgssggnssgnnw\r\nwggnggiiiiiiiigssgggssgggnisgggsggggggnggnndgggggw\r\nwggnnngissgngnngggsssggnggiggsgggnngngggggsssssssw\r\nwggggnnigggnggggiiiiiiiiiiiiiiiiiiiisgggnnggggssgw\r\nwgggggninnggggssnngsssdggggssnggnngggngggnngssggnw\r\nwgggggnnnggngggsggggsggggnnssnngnnngggssggnngssggw\r\nwgggggnigggnsgssgnsssnggngggggggnsgssssgggnnggnnnw\r\nwiiiignigggngggsnsgiggnggsggnnngggngsggdngngggsggw\r\nwgggisnignnsnngggsgisggnsggggggssgggngnggggssggnnw\r\nwgssisnissgnsgggddgisgggngggssgsgngndggsgsgggnggnw\r\nwsgnigdisgggnssggggisggggndggngssngngggngggsggnggw\r\nwiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiissggnnngsgiiiw\r\nwnnnnggnggggggnggggssgnnnnggsgggsgggggnnggggsggggw\r\nwnssgggnsgignnsnnggsggsggggngggngggnngggssgngsggsw\r\nweggsgssggigngggsgggnggggnnnniiiiiiiinnngngssgnnnw\r\nwsgsggngssignnsggdsggggggnsgsidggnggggnggsgggngssw\r\nwssggngsgnigngggsgggsgsnnnggsidsssgggssgssgsggnggw\r\nwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww'),
(3, 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww\r\nwggggggggiiiiiisgssggggsggggigsggsssgsggdsggggsggw\r\nwpggssgsgiggsggggssggsggggsgigsggggssgsggggsggssgw\r\nwggggsssgiggggssggggsgggsgsgigggsggggsgggsgggdgggw\r\nwggsgggggigssggggssgggsgggggigggsgssgggsgggsgggggw\r\nwgsgsggggsggggsgggggsggsgssgggsggggggsgggsgssggggw\r\nwggggdgggggssggggsgggsgsggggsgggsssgggggsgggggsgsw\r\nwiiiiiiiiiiiiiiiisggggggsgssgggssgggsggsssgggggssw\r\nwddgggggssisggggggggsgsgggsggggggsggggsgsgggsgsssw\r\nwgggssggggiggssgsssggsgsggsggggsggggsgsgsggsgggggw\r\nwiiiiiiiggisggggggggsgggssggsgsggdgsgggsgggssggssw\r\nwggssgggggggsgsssgsssggggggssgggssgggsssgggggssssw\r\nwssggggssgggggsgggggsggsggggsssgggggsggggssiiiiiiw\r\nwgggggggggsgsssggssdgggsgggsgggssgsgggssgsgigssggw\r\nwsssggssgggggggsgggggsggggsggsgggdggsgggsggigggggw\r\nwgggsssiiiiiiiiiiiiiiiissgggggggsgggggsggggiggsssw\r\nwgggggggggddiggsgsgggsggggsssgsggggssgggsggigsgggw\r\nwssggggggsggigsssssgggggsgggggggssggggsggggigggggw\r\nwiiiiiiiggggggggggsgggsdgggsgsgigggsssggssggsssggw\r\nwsgggsgiiiiigggggsgggsggggggsggiggsggggsgggggggggw\r\nwgsggggeggdggggggsgsgggsgsssgggiiiiiigggssgggggsgw\r\nwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
