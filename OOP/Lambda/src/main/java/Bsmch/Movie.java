package Bsmch;

public class Movie implements Comparable {
  private int id;
  private String name;
  private String genre;
  private float rating;

  public Movie(int id, String name, String genre, float rating) {
    this.updateId(id);
    this.updateName(name);
    this.updateGenre(genre);
    this.updateRating(rating);
  }

  public int id() {
    return this.id;
  }

  private void updateId(int id) {
    this.id = id;
  }

  public String name() {
    return this.name;
  }

  private void updateName(String name) {
    this.name = name;
  }

  public String genre() {
    return this.genre;
  }

  public void updateGenre(String genre) {
    this.genre = genre;
  }

  public float rating() {
    return this.rating;
  }

  public void updateRating(float rating) {
    this.rating = rating;
  }

  @Override
  public String toString() {
    return "Name: "
        + this.name()
        + "\n"
        + "Genre: "
        + this.genre()
        + "\n"
        + "Rating: "
        + this.rating();
  }


  @Override
  public int compareTo(Object o) {
    Movie m = (Movie) o;
    if(this.rating() > m.rating())
      return 1;

    if(this.rating() == m.rating())
      return 0;

    return -1;
  }
}
