public class PracticeProgram3 {
    private String name;
    private int age;
    // Parameterized Constructor
    public PracticeProgram3(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Copy Constructor
    // Creates a new object by copying values from an existing object
    public PracticeProgram3(PracticeProgram3 otherPerson) {
        this.name = otherPerson.name;
        this.age = otherPerson.age;
    }
    public void introduce() {
        System.out.println("Hi, I am " + name + " and I am " + age + " years old.");
    }
    // Main method to test the code
    public static void main(String[] args) {
        System.out.println("--- Problem 3: Person Class ---");
        PracticeProgram3 original = new PracticeProgram3("John Wick", 40);
        PracticeProgram3 clone = new PracticeProgram3(original); // Using Copy Constructor
        System.out.print("Original: ");
        original.introduce();
        System.out.print("Clone:    ");
        clone.introduce();
    }
}