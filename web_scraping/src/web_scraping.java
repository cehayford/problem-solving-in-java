import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Scanner;

public class web_scraping {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = myObj.nextLine();

        try {
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            Elements paragraphs = document.select("p");

            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Title: " + title);
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("Article Content:");
            for (int i = 0; i < paragraphs.size(); i++) {
                System.out.println(paragraphs.get(i).text());
            }
        } catch (IOException e) {
            System.out.println("Invalid URL. Please restart the program and enter a valid URL.");
            e.printStackTrace();
        } finally {
            myObj.close();
        }
    }
}