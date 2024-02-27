import java.rmi.*;
import java.rmi.server.*;

//* "MonServeur": 
    //est une classe qui implémente l'interface "MonInterface" et étend la classe "UnicastRemoteObject"
//* "UnicastRemoteObject":
    // Fournit des fonctionnalités de base pour la communication d'objets distants via RMI.
    //En étendant cette classe, "MonServeur" devient un objet distant pouvant être invoqué à distance via RMI.

public class MonServeur extends UnicastRemoteObject implements MonInterface {

    public MonServeur() throws RemoteException {
        super();
    }

    public String traitement(String input) throws RemoteException {
        // Implémentation du traitement souhaité
        return "Traitement effectué avec succès : " + input.toUpperCase();
    }

    public static void main(String args[]) {
        try {
            // Création du serveur de nom RMI sur le port 1099 (par défaut) de la machine locale.
            //Ce registre est utilisé pour lier les noms d'objets distants avec leurs références sur le réseau.
            java.rmi.registry.Registry registry = java.rmi.registry.LocateRegistry.createRegistry(1099);

            // Création d'une instance du serveur
            MonServeur obj = new MonServeur();

            // Liaison de l'objet distant dans le registre RMI à l'aide de la méthode "rebind".
            registry.rebind("MonServeur", obj);

            System.out.println("Serveur prêt");
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}