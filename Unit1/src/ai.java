import java.util.Random;

public class ai {
    
    public enum State {
        rock{
            @Override
            public State previousState() {
                return this;
            }
            @Override
            public State nextState() {
                return paper;
            }
        },
        paper{ 
            @Override
            public State previousState() {
                return this;
            }
            @Override
            public State nextState() {
                return paper;
            }},
        scissors{
            @Override
            public State previousState() {
                return this;
            }
            @Override
            public State nextState() {
                return paper;
            }
        };
        public abstract State nextState();
        public abstract State previousState();
    }

public int choose(){
Random ran = new Random();
int choice = ran.nextInt(3) + 1;
//State value = State.values()[choice];

return choice;
}
}
