import java.util.Scanner;

//The code must run (and a screenshot of the running code in the ReadMe file on GitHub)

//If the terminal/console is not in the screenshot, it will not have worked as it will be considered wrong.
//The game should be two players, so no AI (unless you want that blue ribbon)
//There should be a while loop asking players to either continue playing or stop playing after each round (y/n answer)
//Player input can either be a string or integer to select rack/paper/scissors.
//A tally of wins should be kept, and after the player chooses to end the game, the tally should print out for both players.

 //rules
        //paper>rock>scissors
        //2>1>3>2>1
        // #=# tie
        //1 2 false
        //2 3 false
        //3 1 false
        //1 3 true
        //2 1 true
        //3 2 true
        //start
public class unitOne {
    Scanner playerInput = new Scanner(System.in);  // Create a Scanner object

    enum options{
        rock,
        paper,
        scissors
    }

    public void play() {
        start();
        playerInput.close();
       
    }

    public void start(){
        System.out.println("do you want a two player or one player game? (1,2)");
        int player = playerInput.nextInt();
        if(player==1){

            game(true);
        }else if(player==2){
            game(false);
        }else{

        }
    }
    public void game(boolean AI){
       
        boolean Ai;
        String aitrue;
           
            if (AI){
                aitrue = "AI";
            } else{
                aitrue = "playerTwo";
            }
        ai cpu = new ai();
        int playerOneWins = 0;
        int playerTwoWins = 0;
        int tieds =0;
        boolean playing = true;
        System.out.println("Rock, Paper, Scissors");
        while (playing == true) {
            
            System.out.println("1 : rock");
            System.out.println("2 : paper");
            System.out.println("3 : scissors");
            System.out.println("player one enter 1-3:");
            //player 1 goes
            int playerOne = playerInput.nextInt();
            playerInput.nextLine();  // Consume newline left-over
            
            int playerTwo;
            if(AI){
                playerTwo = cpu.choose();

            }else{
                System.out.println("player Two enter 1-3:");
                //player 2 goes
                playerTwo = playerInput.nextInt();
                playerInput.nextLine();  // Consume newline left-over
            }
            //display move

            options playerOneOption = options.values()[playerOne - 1];
            options playerTwoOption = options.values()[playerTwo - 1];

            System.out.println("player one has entered " + playerOneOption);

            if(AI){
                System.out.println("AI has entered " + playerTwoOption);
            }else{
                System.out.println("player Two has entered " + playerTwoOption);
            }
            
            System.out.println();

            //calculate result
            
            int result = checkWinner(playerOneOption,playerTwoOption);
            //display result
            if(result == 1) {
                System.out.println(playerOneOption + " beats " + playerTwoOption + " playerOne wins");
                //add to score
                playerOneWins++;
            } else if(result == 2){
                System.out.println(playerTwoOption + " beats " + playerOneOption +" "+ aitrue+" wins");
                //add to score
                playerTwoWins++;
            } else if(result == 3){
                System.out.println(playerOneOption + " ties with " + playerTwoOption + " players tied");
                //add to score
                tieds++;
            } else {System.out.println("error");}

            //end


            //again y/n
            System.out.println("would you like to play again? (y or n)");
            String answer = playerInput.nextLine();
            if(answer.equals("n")){
            break;
            }
            
        }
        //print display
        System.out.println("Thank out for playing");
        System.out.println("player one has won " + playerOneWins + " times");
        System.out.println( aitrue +" has won " + playerTwoWins + " times");
        System.out.println("players have tied " + tieds + " times");
        
    }

    private int checkWinner(options playerOneOption, options playerTwoOption) {
        int display = 0;
        if (playerOneOption.equals(options.rock)) {
            switch (playerTwoOption) {
                case scissors:
                    return  1;
                case rock:
                    return  3;
                case paper:
                    return  2;
            }
        } else if (playerOneOption.equals(options.paper)) {
            switch (playerTwoOption) {
                case scissors:
                    return   2;
                case rock:
                    return  1;
                case paper:
                   return 3;
            }
        } else if (playerOneOption.equals(options.scissors)) {
            switch (playerTwoOption) {
                case scissors:
                    return  3;
                case rock:
                    return  2;
                case paper:
                    return 1;
            }
        }
        return display;
    }
}