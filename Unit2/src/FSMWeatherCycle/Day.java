package FSMWeatherCycle;
//days class
public class Day {
    enum Transition{
        left,
        none,
        right
    }
    //day
    public State CurrentState;
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
            default -> CurrentState = State.Clear;
        }
    }
    public void display() {
        System.out.println("State: "+ CurrentState);
    }
}