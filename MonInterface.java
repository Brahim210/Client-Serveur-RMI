import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonInterface extends Remote {
    String traitement(String input) throws RemoteException;
}