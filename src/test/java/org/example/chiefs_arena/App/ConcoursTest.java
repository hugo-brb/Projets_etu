package org.example.chiefs_arena.App;
import org.example.chiefs_arena.exception.ChampNonSaisie;
import org.example.chiefs_arena.exception.ConcoursDateInvalide;
import org.example.chiefs_arena.exception.ConcoursDejaExistant;
import org.example.chiefs_arena.exception.DescriptionTropLongue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcoursTest {
    private Concours concours;
    private Concours concours2;
    @BeforeEach
    void setUp() throws ConcoursDejaExistant, DescriptionTropLongue, ConcoursDateInvalide{
        concours = new Concours();
        concours.setNom("CookTempest");
        concours.setDescription("Evénement culinaire sur la cuisine française");
        concours.setDateDebut(new Date(2024 - 1900, Calendar.AUGUST, 8, 14, 0, 0));
        concours.setDateFin(new Date(2024 - 1900, Calendar.AUGUST, 8, 18, 0, 0));
        concours.setLieu(new Lieu("Castilla", 70));

        concours2 = new Concours();
        concours2.setNom("CookContest");
        concours2.setLieu(new Lieu("Menlack", 110));
    }
    @Test
    void setNom() {
        assertEquals("CookTempest", concours.getNom());
        assertEquals("CookContest", concours2.getNom());
    }
    @Test
    void setDescription() {
        assertEquals("Evénement culinaire sur la cuisine française", concours.getDescription());
        assertThrows(DescriptionTropLongue.class, () -> {
            concours2.setDescription("Chaque année, la petite ville pittoresque de Saint-Amour, nichée au cœur des vignobles et des vergers, s'anime pour célébrer la Fête de la Gastronomie Gourmande. Cet événement culinaire tant attendu attire des milliers de visiteurs venus de toute la région et d'ailleurs, avides de découvrir les délices gastronomiques que la ville a à offrir. La place centrale, habituellement tranquille, se transforme en un marché coloré et animé où des stands regorgent de produits locaux et artisanaux. Les visiteurs peuvent déambuler parmi les étals, goûter des fromages affinés, des charcuteries fines, des pâtisseries alléchantes, et bien sûr, les célèbres vins de la région. Les producteurs locaux sont présents pour partager leur passion et leur savoir-faire, expliquant avec enthousiasme les processus de fabrication de leurs produits. Le point culminant de l'événement est sans doute le concours de cuisine, où des chefs renommés ainsi que des amateurs talentueux s'affrontent pour créer des plats innovants en utilisant des ingrédients locaux. Les participants disposent de deux heures pour préparer un repas complet, et leurs créations sont ensuite jugées par un panel d'experts culinaires. Les spectateurs peuvent suivre l'évolution des plats en direct grâce à des écrans géants installés autour de la place. La tension est palpable, et les applaudissements fusent lorsque les chefs présentent leurs œuvres d'art gastronomiques. Parallèlement au concours, des ateliers culinaires sont organisés tout au long de la journée. Les enfants peuvent apprendre à confectionner des biscuits et des cupcakes, tandis que les adultes s'initient à la préparation de plats sophistiqués comme le foie gras poêlé ou les macarons. Des démonstrations de cuisine en direct offrent également aux visiteurs la chance de voir des chefs étoilés en action, partageant leurs astuces et techniques. La Fête de la Gastronomie Gourmande ne serait pas complète sans ses dîners de gala. Chaque soir, des restaurants partenaires proposent des menus dégustation spécialement conçus pour l'occasion. Ces repas raffinés mettent en avant les produits du terroir et les talents des chefs locaux. Les convives, attablés sous des tentes élégamment décorées, savourent des plats exquis tout en écoutant de la musique live jouée par des groupes locaux. Pour les amateurs de vins, des visites guidées des vignobles environnants sont organisées. Les participants peuvent se promener parmi les vignes, apprendre les secrets de la viticulture et déguster les meilleurs crus de la région. Ces excursions offrent une expérience immersive et éducative, permettant aux visiteurs de mieux comprendre le lien étroit entre la terre et la table.L'événement s'achève en apothéose avec un grand feu d'artifice qui illumine le ciel de Saint-Amour, symbolisant la fin de cette célébration gourmande et festive. La Fête de la Gastronomie Gourmande est bien plus qu'un simple événement culinaire ; c'est une véritable ode à la richesse et à la diversité de la culture gastronomique française. Elle laisse à chacun des souvenirs impérissables et une envie irrésistible de revenir l'année suivante pour encore plus de découvertes et de plaisirs gustatifs.");
        });
    }

    @Test
    void setDateDebut() throws ConcoursDateInvalide {
        // Date future (2024-08-08 14:00:00)
        Date futureDate = new Date(2024 - 1900, Calendar.AUGUST, 8, 14, 0, 0);
        concours.setDateDebut(futureDate);
        assertEquals(futureDate, concours.getDateDebut());

        // Date passée (2021-08-08 14:00:00)
        Date pastDate = new Date(2021 - 1900, Calendar.AUGUST, 8, 14, 0, 0);
        assertThrows(ConcoursDateInvalide.class, () -> {
            concours2.setDateDebut(pastDate);
        });
    }

    @Test
    void setDateFin() {
        /*Le concours commence le 8 août 2024 à 14h et se termine à 18h*/
        Date afterContestBegun = new Date(2024 - 1900, Calendar.AUGUST, 8, 18, 0 , 0);
        assertEquals(afterContestBegun,concours.getDateFin());

        Date beforeContestBegun = new Date(2024 - 1900, Calendar.AUGUST, 8, 12, 0, 0);
        assertThrows(ConcoursDateInvalide.class, () -> {
            concours.setDateFin(beforeContestBegun);
        });
    }

    @Test
    void setLieu() {
        assertEquals("Castilla", concours.getLieu().getNom());
        assertEquals(70, concours.getLieu().getCapacite());
        assertEquals("Menlack", concours2.getLieu().getNom());
        assertEquals(110, concours2.getLieu().getCapacite());
    }

    @Test
    void ajouterCategorie() {
        Categorie categorie = new Categorie("Age", List.of("Junior", "Senior"));
        concours.ajouterCategorie(categorie);
        assertTrue(concours.getCategories().contains(categorie));
    }

    @Test
    void ajouterPartenaire() {
        Partenaire partenaire = new Partenaire("1", "Sponsor", 1000, "Aucune");
        concours.ajouterPartenaire(partenaire);
        assertTrue(concours.getPartenaires().contains(partenaire));
    }

    @Test
    void ajouterPersonne() {
        Personne personne = new Personne(1, "Durand", "John", 25, "Participant");
        concours.ajouterPersonne(personne);
        assertTrue(concours.getPersonnes().contains(personne));
    }

    @Test
    void isChampManquant() throws ConcoursDejaExistant {
        assertFalse(concours.isChampManquant());
        assertTrue(concours2.isChampManquant());
        concours.setNom(null);
        assertTrue(concours.isChampManquant());
    }

    @Test
    public void testEvenementDejaExistant() throws ConcoursDejaExistant {
        concours.setNom("Hackathon");

        Exception exception = assertThrows(ConcoursDejaExistant.class, () -> {
            concours2.setNom("Hackathon");
        });

        assertEquals("Le nom de l'événement est déjà utilisé.", exception.getMessage());
    }
    @Test
    public void testChampsObligatoiresNonSaisis() throws ConcoursDejaExistant {
        concours.setNom(null);

        Exception exception = assertThrows(ChampNonSaisie.class, () -> {
            concours.checkChampsSaisie();
        });

        assertEquals("Un champ obligatoire n'a pas été saisi.", exception.getMessage());
    }

}