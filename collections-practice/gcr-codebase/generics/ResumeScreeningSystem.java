import java.util.*;
// -------------------- ABSTRACT JOB ROLE --------------------
abstract class JobRole {
    protected String candidateName;
    protected int experience; // years
    public JobRole(String candidateName, int experience) {
        this.candidateName = candidateName;
        this.experience = experience;
    }
    public abstract boolean isEligible();
    public abstract String roleName();
}
// -------------------- CONCRETE JOB ROLES --------------------
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int exp) {
        super(name, exp);
    }
    @Override
    public boolean isEligible() {
        return experience >= 2;
    }
    @Override
    public String roleName() {
        return "Software Engineer";
    }
}
class DataScientist extends JobRole {
    public DataScientist(String name, int exp) {
        super(name, exp);
    }
    @Override
    public boolean isEligible() {
        return experience >= 3;
    }
    @Override
    public String roleName() {
        return "Data Scientist";
    }
}
class ProductManager extends JobRole {
    public ProductManager(String name, int exp) {
        super(name, exp);
    }
    @Override
    public boolean isEligible() {
        return experience >= 5;
    }
    @Override
    public String roleName() {
        return "Product Manager";
    }
}
// -------------------- GENERIC RESUME CLASS --------------------
class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) {
        this.jobRole = jobRole;
    }
    public T getJobRole() {
        return jobRole;
    }
}
// -------------------- SCREENING PIPELINE --------------------
class ResumeScreeningPipeline {
    // Generic Method
    public static <T extends JobRole> void screenResume(Resume<T> resume) {
        T role = resume.getJobRole();
        System.out.println("Candidate: " + role.candidateName);
        System.out.println("Applied Role: " + role.roleName());
        System.out.println("Experience: " + role.experience + " years");
        if (role.isEligible()) {
            System.out.println("Status: ✅ Shortlisted\n");
        } else {
            System.out.println("Status: ❌ Rejected\n");
        }
    }
    // Wildcard Method to handle multiple job roles
    public static void screenAll(List<? extends JobRole> candidates) {
        for (JobRole role : candidates) {
            Resume<JobRole> resume = new Resume<>(role);
            screenResume(resume);
        }
    }
}
// -------------------- MAIN CLASS --------------------
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> applicants = new ArrayList<>();
        applicants.add(new SoftwareEngineer("Aman", 3));
        applicants.add(new DataScientist("Neha", 2));
        applicants.add(new ProductManager("Rahul", 6));
        applicants.add(new SoftwareEngineer("Priya", 1));
        System.out.println("🔍 AI-Driven Resume Screening Results\n");
        ResumeScreeningPipeline.screenAll(applicants);
    }
}
