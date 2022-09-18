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
//            [temp, Humidity, Wind ]
//      transition
//          left,none,right
//should not add
// e
//  more events/states




enum Transition{
    left,
    none,
    right
}
enum State{
    Clear,
    Cloudy,
    Raining,
    SevereWeather
}

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
        System.out.println(random);
        return Transition.values()[random];
    }
    public void StateChange(Transition transition){
        switch(transition){
            case left:
                if (CurrentState != State.Clear) {
                    //-1
                    CauseEvent(CurrentState,transition);
                    CurrentState = State.values()[CurrentState.ordinal() - 1];
                    display();
                }
                break;
            case none:
                //0 no change display
                System.out.println("no change");
                display();
                break;
            case right:
                if (CurrentState != State.SevereWeather) {
                    //+1
                    CauseEvent(CurrentState, transition);
                    CurrentState = State.values()[CurrentState.ordinal() + 1];
                    display();
                }
                break;
            //+1

        }
    }
    //event logic
    private void CauseEvent(State currentState,Transition transition) {
        switch(currentState){
            case Clear:
                System.out.println("the temperature is Getting Colder");
                break;
            case Cloudy:
                if (transition.ordinal()==0){
                    System.out.println("the temperature is Getting Warmer");
                }else {
                    System.out.println("the Humidity is Increasing");
                }
                break;

            case Raining:
                if (transition.ordinal()==0){
                    System.out.println("the Humidity is Decreasing");
                }else {
                    System.out.println("the Wind is Increasing");
                }
                break;

            case SevereWeather:
                System.out.println("the Wind is Decreasing");
                break;
        }
        events++;
    }
    private void display() {
        System.out.println(CurrentState+"\n");
    }
}



public class Main {
    public static void main(String[] args) {
        Day today = new Day(State.Clear);
        for (int x = today.events;x<5;) {
            System.out.println(x);
            today.StateChange(today.CallTransition());
            x = today.events;
        }


    }
}