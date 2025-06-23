// File: Admin.java
package library;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }

    @Override
    public void interact() {
        System.out.println("[Admin] " + name + " bisa menambah dan menghapus buku.");
    }
}
