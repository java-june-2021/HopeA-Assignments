import java.util.HashMap;

public class MapHash {
    public static void main(String[] args) {
        HashMap<String, String> songMap = new HashMap<String, String>();
        songMap.put("Yesterday", "Yesterday, all my troubles...");
        songMap.put("Across the Universe", "Words are flowing out...");
        songMap.put("Blackbird", "Blackbird singing in the dead of night...");
        songMap.put("All you need is love", "There's nothing you can do that can't be done");

        String song = songMap.get("Yesterday");
        for(String key : songMap.keySet()) {
            System.out.println("Track: " + key + " Lyric: " + songMap.get(key));

        }
    }
}