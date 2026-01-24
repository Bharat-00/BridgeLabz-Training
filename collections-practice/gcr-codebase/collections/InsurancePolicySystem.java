import java.time.LocalDate;
import java.util.*;
// -------------------- Policy Class --------------------
class InsurancePolicy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;
    public InsurancePolicy(String policyNumber, String policyHolderName,
                           LocalDate expiryDate, String coverageType,
                           double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public String getPolicyHolderName() {
        return policyHolderName;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName +
               " | Expiry: " + expiryDate +
               " | " + coverageType +
               " | ₹" + premiumAmount;
    }
}
// -------------------- Manager Class --------------------
class PolicyManager {
    // 1️⃣ Different Maps
    private Map<String, InsurancePolicy> hashMap = new HashMap<>();
    private Map<String, InsurancePolicy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, InsurancePolicy> treeMap = new TreeMap<>();
    // Add Policy
    public void addPolicy(InsurancePolicy policy) {
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);
        treeMap.put(policy.getExpiryDate(), policy);
    }
    // Retrieve by Policy Number
    public InsurancePolicy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }
    // List Policies Expiring in Next 30 Days
    public List<InsurancePolicy> expiringInNext30Days() {
        List<InsurancePolicy> result = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        for (InsurancePolicy policy : hashMap.values()) {
            if (!policy.getExpiryDate().isBefore(today) &&
                !policy.getExpiryDate().isAfter(limit)) {
                result.add(policy);
            }
        }
        return result;
    }
    // List Policies by Policyholder Name
    public List<InsurancePolicy> getPoliciesByHolder(String name) {
        List<InsurancePolicy> result = new ArrayList<>();
        for (InsurancePolicy policy : hashMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(name)) {
                result.add(policy);
            }
        }
        return result;
    }
    // Remove Expired Policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, InsurancePolicy>> iterator =
                hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            InsurancePolicy policy = iterator.next().getValue();
            if (policy.getExpiryDate().isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(policy.getPolicyNumber());
                treeMap.remove(policy.getExpiryDate());
            }
        }
    }
    // Display All Policies
    public void displayAllPolicies() {
        for (InsurancePolicy policy : linkedHashMap.values()) {
            System.out.println(policy);
        }
    }
}
// -------------------- MAIN CLASS --------------------
public class InsurancePolicySystem {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        // Adding Policies
        manager.addPolicy(new InsurancePolicy(
                "P101", "Alice",
                LocalDate.now().plusDays(10),
                "Health", 5000));
        manager.addPolicy(new InsurancePolicy(
                "P102", "Bob",
                LocalDate.now().plusDays(40),
                "Auto", 3000));
        manager.addPolicy(new InsurancePolicy(
                "P103", "Alice",
                LocalDate.now().minusDays(5),
                "Home", 7000));
        System.out.println("🔹 All Policies:");
        manager.displayAllPolicies();
        System.out.println("\n🔹 Retrieve Policy P101:");
        System.out.println(manager.getPolicyByNumber("P101"));
        System.out.println("\n🔹 Policies Expiring in Next 30 Days:");
        for (InsurancePolicy p : manager.expiringInNext30Days()) {
            System.out.println(p);
        }
        System.out.println("\n🔹 Policies for Alice:");
        for (InsurancePolicy p : manager.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }
        System.out.println("\n🔹 Removing Expired Policies...");
        manager.removeExpiredPolicies();
        System.out.println("\n🔹 Policies After Removal:");
        manager.displayAllPolicies();
    }
}
