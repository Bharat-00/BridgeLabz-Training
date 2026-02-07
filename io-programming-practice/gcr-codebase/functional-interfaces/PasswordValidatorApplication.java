public class PasswordValidatorApplication {
    public static void main(String[] args) {
        String password = "Secure@123";
        // Validates password using static interface method
        boolean isStrong = SecurityUtils.isStrongPassword(password);
        System.out.println("Password strong: " + isStrong);
    }
}
// Utility interface for security-related checks
interface SecurityUtils {
    // Checks password strength based on basic rules
    static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowerCase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialChar = password.chars().anyMatch(ch -> !Character.isLetterOrDigit(ch));
        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }
}
