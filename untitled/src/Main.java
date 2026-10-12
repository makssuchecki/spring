public class Main {
    public static void main(String[] args){
        Author adas = new Author("Adam Mickiewicz", "a.mickiewicz@gmail.com", Author.Gender.MALE);
        Book book = new Book("Pan Tadeusz", 49.00, adas, 5);
        System.out.println(adas);
        System.out.println(book);
    }
}
