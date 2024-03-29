//must have
//  simulation should last for 7 days (
//  Each day should consist of 5 event changes.
//  The list of States is [Clear, Cloudy, Raining, and Severe Weather]
//  The list of Events is [Getting Warmer, Getting Colder, Humidity is Increasing, Wind is Increasing]
//  The starting state is Clear
//  The flow will be Clear <-> Cloudy <-> Raining <-> Severe Weather
//      This flow means that the status can change from clear to cloudy but not directly rain.
//      Another example is if the current state is Raining, it can change to either cloudy or severe weather.
//  The transitions should occur based on a random number or coin flip. This number will be 0, 1, or 2.
//      If 0, then the status should move to the left of the flow.
//      If 1, the status should not change.
//      If 2, the status should move to the right if possible.
//      The number should then cause the appropriate event to switch the Status.
//should have
//  days
//      event
//      state
//like to have
//  enum
//      states
//          [Clear, Cloudy, Raining, and SevereWeather]
//     events
//            [Getting Warmer, Getting Colder, Humidity is Increasing, Wind is Increasing]
//      transition
//          left,none,right
//should not add
// e
//  more events/states

import java.util.Scanner;

import FSMWeatherCycle.Day;
import FSMWeatherCycle.State;

/**
enum State{
    Clear,
    Cloudy,
    Raining,
    SevereWeather
}
 **/

public class unitTwo {
  Scanner input;
     

static void question(){
    System.out.println("enter how many days to simulate_(0 will be defalt 7 days):");
}

    public void go(Scanner input){


        question();
       int days = input.nextInt();

        if (days== 0){
            days =7;
        }

        State next = State.Clear;
        for (int y = 0; y < days; y++){
            Day today = new Day(next);
            System.out.println("Day " + (y+1));
            for (int x = today.events; x < 5; ) {
                //display current state
                today.display();
                //creates an event and displays the state change
                today.StateChange(today.CallTransition());
                x = today.events;
            }
            next=today.CurrentState;
        }
        input.close();
    }
}