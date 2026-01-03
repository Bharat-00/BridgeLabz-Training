//Superclass
class Book {
    String title;
    int publicationYear;
    Book(String title,int publicationYear){
        this.title=title;
        this.publicationYear=publicationYear;
    }
}
//Subclass
class Author extends Book {
    String name;
    String bio;
    Author(String title,int publicationYear,String name,String bio){
        super(title,publicationYear);
        this.name=name;
        this.bio=bio;
    }
    //Method to display book and author details
    void displayInfo(){
        System.out.println("BookTitle:"+title);
        System.out.println("PublicationYear:"+publicationYear);
        System.out.println("AuthorName:"+name);
        System.out.println("AuthorBio:"+bio);
    }
}
public class LibraryManagementWithBooksAndAuthors {
    public static void main(String[] args){
        Author author=new Author(
                "JavaBasics",
                2022,
                "JamesGosling",
                "FatherOfJava"
        );
        author.displayInfo();
    }
}
