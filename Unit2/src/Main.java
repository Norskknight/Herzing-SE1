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


import FSMWeatherCycle.State;



enum Transition{
    left,
    none,
    right
}
/**
enum State{
    Clear,
    Cloudy,
    Raining,
    SevereWeather
}
 **/

//days class
class Day {
    //day
    State CurrentState;
    public int events;
    public Day(State CurrentState) {
        this.CurrentState = CurrentState;
    }
    public Transition CallTransition(){
        // random number 0-2
        int random = (int) Math.floor(Math.random()*3);
        return Transition.values()[random];
    }
    //state change with FSM using enums
    public void StateChange(Transition transition) {
        //CauseEvent(CurrentState,transition);
        switch (transition) {
            case left -> {
                if (CurrentState != State.Clear) {
                    events++;
                }
                CurrentState = CurrentState.previousState();
                display();
            }
            case right -> {
                if (CurrentState != State.SevereWeather) {
                    events++;
                }
                CurrentState = CurrentState.nextState();
                display();
            }
        }
    }
    public void display() {
        System.out.println("State: "+ CurrentState);
    }
}

public class Main {
    public static void main(String[] args) {
State next = State.Clear;
        for (int y = 0; y < 7; y++){
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
    }
}