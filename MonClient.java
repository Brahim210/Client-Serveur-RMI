import java.rmi.*;

public class MonClient {
    public static void main(String args[]) {
        try {
            // Récupération de l'objet distant depuis le serveur de noms RMI
            //"Naming.lookup": Cette méthode est utilisée pour rechercher un objet distant enregistré dans le registre RMI en utilisant son nom.
            //'localhost': indique que le registre RMI est situé sur la même machine que le client.
            //'MonServeur': est le nom de l'objet distant que le client cherche à obtenir.
            MonInterface obj = (MonInterface) Naming.lookup("//localhost/MonServeur");

            // Appel de la méthode distante
            String result = obj.traitement("Hello World");

            // Affichage du résultat
            System.out.println("Résultat : " + result);
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}
