package FSMWeatherCycle;

    public enum State {

       Clear {
           @Override
           public State previousState() {
               return this;
           }
           @Override
           public State nextState() {
               System.out.println("The temperature is Getting Colder");
               return Cloudy;
           }
       },
       Cloudy {
           @Override
           public State previousState() {
               System.out.println("The temperature is Getting Warmer");
               return Clear;
           }

           @Override
           public State nextState() {
               System.out.println("The Humidity is Increasing");
               return Raining;
           }
       },
           Raining{
               @Override
               public State previousState() {
                   System.out.println("The Humidity is Decreasing");
                   return Cloudy;
               }

               @Override
               public State nextState() {
                   System.out.println("The Wind is Increasing");
                   return SevereWeather;
               }
           },
           SevereWeather{
               @Override
               public State previousState(){
                   System.out.println("The Wind is Decreasing");
                   return Raining;
               }
               @Override
               public State nextState() {
                   return this;
               }
       };

       public abstract State nextState();
        public abstract State previousState();
    }