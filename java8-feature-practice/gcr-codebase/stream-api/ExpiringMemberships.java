import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
class Member {
    String name;
    LocalDate expiryDate;
    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getName() { return name; }
}
public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("Aman", LocalDate.now().plusDays(10)),
                new Member("Rahul", LocalDate.now().plusDays(40)),
                new Member("Sneha", LocalDate.now().plusDays(25))
        );
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        members.stream()
                .filter(m -> !m.getExpiryDate().isBefore(today) &&
                             !m.getExpiryDate().isAfter(next30Days))
                .forEach(m -> System.out.println(m.getName() + " expires on " + m.getExpiryDate()));
    }
}
