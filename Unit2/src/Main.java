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
//          [Clear, Cloudy, Raining, and Severe Weather]
//      events
//            [Getting Warmer, Getting Colder, Humidity is Increasing, Wind is Increasing]
//      transition
//          left,none,right

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}