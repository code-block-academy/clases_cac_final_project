package interfaces;

import enums.Charges;

public interface Admin {
    void bannearUser(int id, Charges problem);
    void permaBan(int id);
    void createUser(String name, String surname, String email, String password);
}
