import java.util.ArrayList;
import java.util.List;

// Question 1
public class WordDictionary {

    /*
     Using less-efficient data structures here... as HashMap is not permitted.
     I'm assuming "Hashset" or "LinkedHashMap" are also not permitted,
     though they would be more efficient compared to Array/LinkedList.
     */
    List<String> words = new ArrayList<>(); // we will always add in lowercase
    List<String> defs = new ArrayList<>();

    // NOTE: LinkedList could be used instead of Arraylist for slightly faster InsertWord performance
    public WordDictionary(){
        words = new ArrayList<>();
        defs = new ArrayList<>();
    }

    // Inserts the word and corresponding definition into the dictionary, if the word already exists, it
    // will override the word and definition
    public void insertWord(String word, String definition) {
        int index = words.indexOf(word.toLowerCase());
        if(index != -1 ){
            defs.add(index, definition);
            return;
        }

        // word does not exist in dictionary, just append
        words.add(word.toLowerCase());
        defs.add(definition);
    }

    // Returns the definition for the word
    public String findDefinition(String word) {
        // check to make sure word exists
        int pos = words.indexOf(word.toLowerCase());
        if (pos != -1)
            return defs.get(words.indexOf(word.toLowerCase()));
        else return "Error: word does not exist";
    }

    public List<String> partialSearch(String partialWord) {
        List<String> result = new ArrayList<>();
        // Returns the definitions for the words that are matched partially
        for(int i = 0; i < words.size(); i++){
            if (words.get(i).contains(partialWord)){
                result.add(defs.get(i));
            }
        }
        return result;
    }

    // Removes the word with definition from the dictionary
    public void remove(String word) {
        // check to make sure word exists
        int pos = words.indexOf(word.toLowerCase());
        if(pos != -1){
            words.remove(pos);
            defs.remove(pos);
        }
    }

    // Testing the method (informally)
    public static void main(String[] args) {
        WordDictionary wd = new WordDictionary();

        wd.insertWord("Table", "four legs");
        wd.insertWord("Chair", "something to sit on");
        wd.insertWord("Car", "driving vehicle");
        wd.insertWord("Flying car", "car that flies");
        wd.insertWord("Shoe", "wear them everyday");

        System.out.println(wd.findDefinition("SHOE"));

        wd.remove("Car");
        System.out.println(wd.findDefinition("car"));   // should return error string

        System.out.println(wd.partialSearch("a"));
    }

}