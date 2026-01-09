public class SocialMediaSystem {
    static class UserNode {
        int id;
        String name;
        UserNode next;
        UserNode(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    private UserNode head;
    public void addUser(int id, String name) {
        UserNode user = new UserNode(id, name);
        user.next = head;
        head = user;
    }
    public void displayUsers() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.id + " - " + temp.name);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        SocialMediaSystem system = new SocialMediaSystem();
        system.addUser(1, "Rahul");
        system.addUser(2, "Amit");
        system.displayUsers();
    }
}
