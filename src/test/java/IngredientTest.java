import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private Ingredient ingredient;
    @Before
    public void createIngredient(){
        ingredient = new Ingredient(SAUCE, "Кисло-сладкий", 49.99f);
    }

    @Test
    public void ingredientGetTypeTest() {
        assertEquals(ingredient.getType(), SAUCE);
    }

    @Test
    public void ingredientGetNameTest() {
        assertEquals(ingredient.getName(), "Кисло-сладкий");
    }

    @Test
    public void ingredientGetPriceTest() {
        assertEquals(ingredient.getPrice(), 49.99f, 0);
    }

}
