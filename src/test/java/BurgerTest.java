import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @InjectMocks
    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient filling;
    @Mock
    private Ingredient sauce;
    @Spy
    private ArrayList<Ingredient> ingredients;

    @Before
    public void createIngredientsList(){
        Mockito.when(filling.getPrice()).thenReturn(40.00f);
        Mockito.when(filling.getType()).thenReturn(SAUCE);
        Mockito.when(filling.getName()).thenReturn("Сладкий чили");

        Mockito.when(sauce.getPrice()).thenReturn(400.00f);
        Mockito.when(sauce.getType()).thenReturn(FILLING);
        Mockito.when(sauce.getName()).thenReturn("Рваная свинина");

        ingredients.add(filling);
        ingredients.add(sauce);
    }

    @Test
    public void getPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(20.00f);

        float expectedValue = 480.00f;

        float actualValue = burger.getPrice();

        Assert.assertEquals(actualValue,expectedValue, 0);
    }

    @Test
    public void setBunsTest() {
        bun = new Bun("Пшеничная", 20.00f);

        burger.setBuns(bun);

        float expectedValueBunPrice = 20.00f;
        float actualValueBunPrice = bun.getPrice();

        String expectedValueBunName = "Пшеничная";
        String actualValueBunName = bun.getName();

        Assert.assertEquals(actualValueBunPrice,expectedValueBunPrice, 0);
        Assert.assertEquals(actualValueBunName,expectedValueBunName);
    }

    @Test
    public void addIngredientTest() {

        int initialSizeOfIngridients = ingredients.size();

        burger.addIngredient(filling);

        int actualValue = ingredients.size();

        int expectedValue = initialSizeOfIngridients + 1;

        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void removeIngredientTest() {

        int initialSizeOfIngridients = ingredients.size();

        burger.removeIngredient(0);

        int actualValue = ingredients.size();
        int expectedValue = initialSizeOfIngridients - 1;

        Assert.assertEquals(actualValue,expectedValue);
    }

    @Test
    public void moveIngredientTest() {

        Ingredient ingredient1Old = ingredients.get(0);
        Ingredient ingredient2Old = ingredients.get(1);
        burger.moveIngredient(0, 1);

        Ingredient ingredient1New = ingredients.get(0);
        Ingredient ingredient2New = ingredients.get(1);

        Assert.assertEquals(ingredient2New, ingredient1Old);
        Assert.assertEquals(ingredient1New, ingredient2Old);
    }

    @Test
    public void getReceiptTest() {

        Mockito.when(bun.getName()).thenReturn("Пшеничная");
        Mockito.when(bun.getPrice()).thenReturn(20.00f);

        System.out.println(burger.getReceipt());
        Mockito.verify(bun, Mockito.times(2)).getName();

    }


}
