import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// Question 3
public class CodeRefactor {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Feed Child With Ice Cream, Salad or Milk To See Child's Face Reaction : ");
        String food = reader.readLine();
//        if (food.equalsIgnoreCase("Ice Cream")) {
//            System.out.println("Happy" + " " + "Face");
//        } else if (food.equalsIgnoreCase("Salad")) {
//            System.out.println("Angry" + " " + "Face");
//        } else if (food.equalsIgnoreCase("Milk")) {
//            System.out.println("Normal" + " " + "Face");
//        } else {
//            System.out.println("Error" + " " + "Face");
//        }

        // The 3 alternative ways are extracted into below helper methods
//        System.out.println("Output with Alternative1: " + Alternative1(food));
//        System.out.println("Output with Alternative2: " + Alternative2(food));
        System.out.println("Output with Alternative3: " + Alternative3(food));
    }

    // 1: Using Switch statement - basic & straight-forward
    public static String Alternative1(String food){
        String faceReaction;
        switch (food) {
            case "ice cream":
                faceReaction = "Happy Face";
                break;
            case "salad":
                faceReaction = "Angry Face";
                break;
            case "milk":
                faceReaction = "Normal Face";
                break;
            default:
                faceReaction = "Error Face";
        }

        return faceReaction;
    }

    // 2: Using HashMap - we can store each food as key and their corresponding reaction as value
    // in a map for easy retrieval
    // Hashset, or other data structures may also be used here
    public static String Alternative2(String food){
        HashMap<String, String> reactions = new HashMap<>();
        reactions.put("milk", "Normal Face");
        reactions.put("salad", "Angry Face");
        reactions.put("ice cream", "Happy Face");

        String faceReaction = reactions.getOrDefault(food.toLowerCase(), "Error Face");
        return faceReaction;
    }

    // 2: Using Enum: we can have food values (and their reaction values) in enum format,
    // using strings & helper methods like ValueOf() (enum declared in the end)
    public static String Alternative3(String food){
        food = food.replace(' ', '_').toUpperCase(); // for recognizign ice cream
        FoodReaction fr;
        try{
            fr = FoodReaction.valueOf(food);
        } catch (Exception e){ // means baby was fed nothing, so assign error face
            fr = FoodReaction.OTHER;
        }
        return fr.getReaction();
    }

    enum FoodReaction {
        ICE_CREAM("Happy Face"),
        SALAD("Angry Face"),
        MILK("Normal Face"),
        OTHER("Error Face");

        private final String reaction;
        FoodReaction(String reaction) {
            this.reaction = reaction;
        }
        public String getReaction(){
            return reaction;
        }
    }
}
