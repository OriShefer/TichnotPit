package Bsmch;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainClass {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<Movie>();
        Scanner io = new Scanner(System.in);

        // Add movies info
        movies.add(new Movie(1, "Matrix", "Sci-Fi", (float)8.7));
        movies.add(new Movie(2, "Pirates Of The Caribbean", "Fantasy", (float)8.1));
        movies.add(new Movie(3, "Titanic", "Drama", (float)7.7));
        movies.add(new Movie(4, "Inception", "Sci-Fi", (float)8.8));
        movies.add(new Movie(5, "Ted", "Comedy", (float)7.0));

       movies.forEach(movie -> System.out.println(movie));

        System.out.println("------------------------------");
        System.out.println("Enter genre:");
        String genre = io.nextLine();
        movies.stream().filter(movie -> movie.genre().equals(genre)).forEach(movie -> System.out.println(movie));
        System.out.println("------------------------------");
        movies.stream().sorted((m1,m2) -> Float.compare(m1.rating(),m2.rating())).forEach(System.out::println);
        movies.stream().sorted().forEach(System.out::println);
        System.out.println("------------------------------");

        System.out.println(movies.stream().mapToDouble(movie -> movie.rating()).max().getAsDouble());
    }

    private static int roundFloat(float numberToRound) {
        int rounded;

        if ((numberToRound > 0) && (numberToRound < 1)) {
            rounded = 1;
        } else if ((numberToRound > -1) && (numberToRound < 0)) {
            rounded = -1;
        } else {
            rounded = Math.round(numberToRound);
        }

        return (rounded);
    }
}