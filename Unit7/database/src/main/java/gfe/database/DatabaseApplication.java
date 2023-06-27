package gfe.database;
import java.util.List;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DatabaseApplication  {

@Autowired private IngredientControler IC;

	public static void main(String[] args) {
		Application.launch(App.class, args);
		
	}
/*
 @Override
    public void run(String... args) throws Exception {
        //creat
		createIngredient();
		//read
		Ingredient bun = IC.findById(2);
		//Read All
		List<Ingredient> IList = findAll();
		//update
		bun.setName("Bun"+ IList.get(IList.size()-1).getId());
		IC.update(bun);
		//delete
		IC.delete(IList.get(IList.size()-1).getId());
    }

   private void createIngredient(){

        Ingredient ingredient = new Ingredient();
        ingredient.setName("bun");
        ingredient.setCount(20);
        ingredient.setValue(5);
		IC.save(ingredient);
    }
	private List<Ingredient> findAll(){
	List<Ingredient> IList = IC.findAll();
	for (Ingredient ingredient : IList) {
		System.out.println(ingredient);
	}
	return IList;
	}*/



}
