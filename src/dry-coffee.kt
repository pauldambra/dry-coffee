
enum class Temperature {
    WARM, COLD
}

interface Ingredient {
    fun canBeAddedTo(drink: Drink) = true
}

data class Sugar(val spoons: Int) : Ingredient
data class Milk(val glugs: Int, val temperature: Temperature = Temperature.COLD) : Ingredient

data class ChocolateSprinkles(val pinches: Int) : Ingredient {
    override fun canBeAddedTo(drink: Drink) = drink is Coffee
}

data class HazelnutSyrup(val shots: Int) : Ingredient {
    override fun canBeAddedTo(drink: Drink) = drink is Coffee
}

data class Lemon(val squeezes: Int) : Ingredient {
    override fun canBeAddedTo(drink: Drink) = drink is Tea
}

abstract class Drink {
    class IsNotFitForConsumptionWithThisIngredient(ingredient: Ingredient, drink: Drink) : Throwable("It is not OK to put $ingredient in ${drink.javaClass.simpleName}")

    private val ingredients: MutableList<Ingredient> = mutableListOf()

    fun withIngredient(ingredient: Ingredient): Drink {
        if (!ingredient.canBeAddedTo(this)) {
            throw Drink.IsNotFitForConsumptionWithThisIngredient(ingredient, this)
        }

        ingredients.add(ingredient)
        return this
    }

    override fun toString()
      = "pour a ${this.javaClass.simpleName}(${ingredients.joinToString(",")})"
}

class Coffee : Drink()

class Tea : Drink()

fun main(args: Array<String>) {
    val whiteCoffeeNoSugar = Coffee().withIngredient(Milk(1))
    println(whiteCoffeeNoSugar)

    val sugaryCoffee = Coffee().withIngredient(Sugar(3))
    println(sugaryCoffee)

    val warmerCoffee = Coffee().withIngredient(Milk(2, Temperature.WARM)).withIngredient(Sugar(3))
    println(warmerCoffee)

    val mocha = Coffee()
      .withIngredient(Milk(2, Temperature.WARM))
      .withIngredient(Sugar(2))
      .withIngredient(ChocolateSprinkles(4))
    println(mocha)

    val theFancyCoffee = Coffee()
      .withIngredient(Milk(2, Temperature.WARM))
      .withIngredient(Sugar(2))
      .withIngredient(ChocolateSprinkles(4))
      .withIngredient(HazelnutSyrup(2))

    println(theFancyCoffee)

    val buildersTea = Tea().withIngredient(Milk(1)).withIngredient(Sugar(3))
    println(buildersTea)

    val lemonTea = Tea().withIngredient(Lemon(1))
    println(lemonTea)

    try {
        Tea().withIngredient(ChocolateSprinkles(2))
    } catch (e: Drink.IsNotFitForConsumptionWithThisIngredient) {
        println("excellently did not allow chocolate in tea: $e")
    }
}