import java.util.Scanner;

public class PierreFeuilleCiseaux {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int choixJoueur, choixOrdinateur, scoreJoueur = 0, scoreOrdinateur = 0, points = 0;
        boolean rejouer = true;
        String[] coups = {"Pierre", "Feuille", "Ciseaux", "Puits"};
        
        System.out.println("Bienvenue dans le jeu Pierre-Feuille-Ciseaux !");
        
        while (rejouer) {
            System.out.print("Choisissez le nombre de points pour gagner la partie (3, 5 ou 10) : ");
            points = scanner.nextInt();
            
            while (scoreJoueur < points && scoreOrdinateur < points) {
                
                System.out.print("\nChoisissez votre coup (1 pour Pierre, 2 pour Feuille, 3 pour Ciseaux, 4 pour Puits) : ");
                choixJoueur = scanner.nextInt();
                
                choixOrdinateur = (int) (Math.random() * 4) + 1;
                
                System.out.println("\nVous avez choisi " + coups[choixJoueur-1] + " et l'ordinateur a choisi " + coups[choixOrdinateur-1]);
                
                if (choixJoueur == choixOrdinateur) {
                    System.out.println("Egalité !");
                } else if ((choixJoueur == 1 && choixOrdinateur == 3) || (choixJoueur == 2 && choixOrdinateur == 1) || 
                        (choixJoueur == 3 && choixOrdinateur == 2) || (choixJoueur == 4 && (choixOrdinateur == 1 || choixOrdinateur == 3))) {
                    System.out.println("Vous avez gagné cette manche !");
                    scoreJoueur++;
                } else {
                    System.out.println("L'ordinateur a gagné cette manche !");
                    scoreOrdinateur++;
                }
                
                System.out.println("Score : Joueur " + scoreJoueur + " - " + scoreOrdinateur + " Ordinateur\n");
                
            }
            
            System.out.println("La partie est terminée !");
            if (scoreJoueur > scoreOrdinateur) {
                System.out.println("Vous avez gagné la partie !");
            } else {
                System.out.println("L'ordinateur a gagné la partie !");
            }
            
            System.out.print("Voulez-vous rejouer ? (Oui ou Non) : ");
            scanner.nextLine();
            String reponse = scanner.nextLine();
            
            if (!reponse.equalsIgnoreCase("Oui")) {
                rejouer = false;
            }
            scoreJoueur = 0;
            scoreOrdinateur = 0;
            
        }
        
        scanner.close();
        
    }

}