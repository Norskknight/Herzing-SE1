package gfe.database;

import java.util.List;

import org.springframework.stereotype.Repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;


@Repository
public class IngredientControler {
    
    @PersistenceContext private EntityManager entityManager;
    //create
    @Transactional
    public void save(Ingredient ingredient) {
        entityManager.persist(ingredient);
    }

    //readByID
    public Ingredient findById(int id) {
    return entityManager.find(Ingredient.class, id);
    }

    //readAll
    public List<Ingredient> findAll() {
        String jpql = "SELECT c FROM Ingredient c";
        TypedQuery<Ingredient> query = entityManager.createQuery(jpql, Ingredient.class);
         
        return query.getResultList();
    }

    //update
    @Transactional
    public Ingredient update(Ingredient ingredient) {
        return entityManager.merge(ingredient);
    }

    //Delete 
    @Transactional
    public void delete(Integer ingredientId) {
    Ingredient ingredient = entityManager.find(Ingredient.class, ingredientId);    
    entityManager.remove(ingredient);
}


}
