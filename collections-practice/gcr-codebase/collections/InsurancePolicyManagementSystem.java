import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
// -------------------- MODEL CLASS --------------------
class InsurancePolicy implements Comparable<InsurancePolicy> {
    private int policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public InsurancePolicy(int policyNumber, String policyHolderName,
                           LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public int getPolicyNumber() {
        return policyNumber;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public String getCoverageType() {
        return coverageType;
    }
    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InsurancePolicy)) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber == policy.policyNumber;
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public String toString() {
        return String.format(
                "PolicyNo:%d | Holder:%s | Expiry:%s | Coverage:%s | Premium:%.2f",
                policyNumber, policyHolderName, expiryDate, coverageType, premiumAmount
        );
    }
}
// -------------------- MANAGEMENT CLASS --------------------
class PolicyManager {
    private Set<InsurancePolicy> hashSet = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet = new TreeSet<>();
    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    // 1. Display all unique policies
    public void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        hashSet.forEach(System.out::println);
    }
    // 2. Policies expiring within next 30 days
    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        LocalDate today = LocalDate.now();
        for (InsurancePolicy policy : hashSet) {
            long days = ChronoUnit.DAYS.between(today, policy.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(policy);
            }
        }
    }
    // 3. Policies by coverage type
    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage: " + coverageType);
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                System.out.println(policy);
            }
        }
    }
    // 4. Detect duplicate policies
    public void detectDuplicates(List<InsurancePolicy> policies) {
        Set<Integer> seen = new HashSet<>();
        System.out.println("\nDuplicate Policies:");
        for (InsurancePolicy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                System.out.println(policy);
            }
        }
    }
    // 5. Performance comparison
    public void performanceTest() {
        System.out.println("\nPerformance Comparison (nanoseconds)");
        InsurancePolicy testPolicy = new InsurancePolicy(
                999, "Test User", LocalDate.now().plusDays(10), "Health", 5000
        );
        measure("HashSet", hashSet, testPolicy);
        measure("LinkedHashSet", linkedHashSet, testPolicy);
        measure("TreeSet", treeSet, testPolicy);
    }
    private void measure(String name, Set<InsurancePolicy> set, InsurancePolicy policy) {
        long start, end;
        start = System.nanoTime();
        set.add(policy);
        end = System.nanoTime();
        System.out.println(name + " Add: " + (end - start));
        start = System.nanoTime();
        set.contains(policy);
        end = System.nanoTime();
        System.out.println(name + " Search: " + (end - start));
        start = System.nanoTime();
        set.remove(policy);
        end = System.nanoTime();
        System.out.println(name + " Remove: " + (end - start));
    }
}
// -------------------- MAIN CLASS --------------------
public class InsurancePolicyManagementSystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        InsurancePolicy p1 = new InsurancePolicy(101, "Amit",
                LocalDate.now().plusDays(20), "Health", 12000);
        InsurancePolicy p2 = new InsurancePolicy(102, "Neha",
                LocalDate.now().plusDays(60), "Auto", 8000);
        InsurancePolicy p3 = new InsurancePolicy(103, "Ravi",
                LocalDate.now().plusDays(10), "Home", 15000);
        InsurancePolicy p4 = new InsurancePolicy(101, "Duplicate",
                LocalDate.now().plusDays(25), "Health", 12000);
        manager.addPolicy(p1);
        manager.addPolicy(p2);
        manager.addPolicy(p3);
        manager.addPolicy(p4);
        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Health");
        List<InsurancePolicy> list = Arrays.asList(p1, p2, p3, p4);
        manager.detectDuplicates(list);
        manager.performanceTest();
    }
}
