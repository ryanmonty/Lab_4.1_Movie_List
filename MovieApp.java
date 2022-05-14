import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MovieApp {
	
	static Scanner scnr = new Scanner(System.in);
	private static ArrayList<Movie> movieList = new ArrayList<>();

	public static void main(String[] args) {
		
		String carryOn = "y";
		
		populateMovieList();
		movieList.sort(Comparator.comparing(Movie :: getTitle));
		
		System.out.println("Welcome to the Movie List Application!");
		System.out.println("There are 100 movies in this list");
		
		System.out.println("What category are you interested in?");
		String input = scnr.next();
		
		do {
		System.out.println("Here's a list of movies matching that category:");
		
		for(Movie movie : movieList) {
			if(movie.getCategory().equalsIgnoreCase(input)) {
				
				System.out.println(movie.getTitle());
			}
		}
			System.out.println();
			System.out.println("Would you like to continue? (y/n)");
			
			carryOn = scnr.next();
		
		} while (carryOn.equalsIgnoreCase("y"));
		System.out.println("Goodbye!");
				
		
	}
		
	
	private static void populateMovieList() {
		for (int i = 1; i <= 100; i++) {
			movieList.add(MoviesIO.getMovie(i));
		}
	}

}
