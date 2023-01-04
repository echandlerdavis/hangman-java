import java.util.Scanner;


public class Hangman {
    static Scanner scan = new Scanner(System.in);

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

   
    public static void main(String[] args) {

        
        System.out.println("Let's play hangman! Press any key to continue");
        scan.nextLine(); 
        int misses = 0;
        String word = getRandomWord();
        char[] wordArray = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            wordArray[i] = word.charAt(i);
        }
        char[] board = new char[word.length()];
        for(int i = 0; i < word.length(); i++){
            board[i] = '_';
        }

        char[] guesses = new char[6];


        // while(misses < 6){
            printGallows(misses, board);
            char guess = askUser();
            char num = 0;

            for(int i = 0; i < wordArray.length; i++){
                if(guess == wordArray[i]){
                    board[i] = guess;
                    num++;
                }
                
            }
            if(num == 0){
                misses++;
                guesses[misses - 1] = guess;
            }
            
            printGallows(misses, board);
        // }


        // Make a function that prints the board (based off of tic tac toe); - basically done
            // if misses are a certain number, prints different board. - need to figure out the while loop in this situation
        // Make a function to ask user, and compares the character to the characters in the string
        // Adds misses if incorrect, and updates board, fills in spaces if correct and displays board
        // If they get the word, they win
        // If the gallows gets to the end, they lose. 

        

        if(misses == 6){
            printGallows(misses, board);
            System.out.println("Sorry, you lose.");
        }


        scan.close();
        




    };
    /**
     * Function name - getRandomWord
     * @return word (String)
     * 
     * Inside the function: 
     *      1. 
     */

    public static String getRandomWord(){
        // get a random number and choose from the list based on that number. 
        int randomNumber = (int)(Math.random() * words.length);

        String word = words[randomNumber]; 

        return word;
    }

    public static void printGallows(int misses, char[] board){
        System.out.println(gallows[misses]);
        for(int i = 0; i < board.length; i++){
            System.out.print(board[i] + " ");
        }
    }

    public static char askUser(){
       System.out.print("\nGuess a single character: ");

        char guess = scan.next().charAt(0);
        return guess;

    }

}





