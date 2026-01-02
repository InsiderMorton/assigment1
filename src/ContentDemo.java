import java.util.ArrayList;
import java.time.Year;

public class ContentDemo {
    public static void main(String[] args) {
        ArrayList<ContentItem> items = new ArrayList<>();
        int currentYear = Year.now().getValue();

        items.add(new VideoLecture("Java Basics", 2023, 45, "HD"));
        items.add(new VideoLecture("OOP Principles", 2021, 60, "4K"));
        items.add(new PodcastEpisode("Tech News", 2022, 30, "Alex Johnson"));
        items.add(new PodcastEpisode("AI Trends", 2024, 40, "Sarah Chen"));

        System.out.println("=== CONTENT LIBRARY ===\n");

        for (ContentItem item : items) {
            System.out.println(item.toString() + " | License Cost: $" +
                    String.format("%.2f", item.getLicenseCost(currentYear)));

            if (item instanceof Downloadable) {
                Downloadable downloadableItem = (Downloadable) item;
                downloadableItem.download();
                System.out.println("Max downloads per day: " +
                        downloadableItem.getMaxDownloadsPerDay());
            }
            System.out.println("---");
        }

        System.out.println("\n=== ADDITIONAL STATISTICS ===");
        System.out.println("Total items: " + items.size());

        int videoCount = 0;
        int podcastCount = 0;
        double totalCost = 0;

        for (ContentItem item : items) {
            totalCost += item.getLicenseCost(currentYear);
            if (item instanceof VideoLecture) {
                videoCount++;
            } else if (item instanceof PodcastEpisode) {
                podcastCount++;
            }
        }

        System.out.println("Videos: " + videoCount + " | Podcasts: " + podcastCount);
        System.out.println("Total license cost: $" + String.format("%.2f", totalCost));
    }
}
