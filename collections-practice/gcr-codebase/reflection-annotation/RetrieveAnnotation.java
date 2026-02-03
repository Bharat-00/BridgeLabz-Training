import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}
@Author(name = "Author Name")
class Book {}
public class RetrieveAnnotation {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;
        if (cls.isAnnotationPresent(Author.class)) {
            Author author = cls.getAnnotation(Author.class);
            System.out.println("Author Name: " + author.name());
        }
    }
}
