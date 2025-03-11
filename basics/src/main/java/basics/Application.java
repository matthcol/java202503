package basics;

// la classe principale : fichier de démarrage
// - nom simple: Application
// - nom complet: basics.Application
public class Application {

    // point d'entrée du programme
    public static void main(String[] args) {
        // Texte en Unicode: https://en.wikipedia.org/wiki/Unicode
        System.out.println("Hello tout le monde");
        System.out.println("On commence l'apprentissage du langage Java:");

        // Texte Multi-line: Java 17 (introduced in Java 15)
        System.out.println("""
                * Lundi: les bases
                * Mardi: les fonctions
                * Mercredi: les objets
                
                Je dis: "Java c'est bien"
                """);
        System.out.println("Je dis: \"Java c'est bien\"");
        System.out.println("Mots en français: été, cœur, L'Haÿ-les-Roses, L'HAŸ-LES-ROSES");
        System.out.println("東京");
        System.out.println("🦜❤️");
    }
}
