open class Drink(val name: String, val milk: Int = 0, val sugar: Int = 0, val warmMilk: Int = 0, chocolateSprinkles: Int = 0) {

    val chocolateSprinkles: Int

    fun pour(): Drink = this

    override fun toString() = "Drink(" +
      "name='$name', " +
      "milk=$milk, " +
      "sugar=$sugar, " +
      "warmMilk=$warmMilk, " +
      "chocolateSprinkles=$chocolateSprinkles)"

    init {
        if (this.name == "Coffee") {
            this.chocolateSprinkles = chocolateSprinkles
        } else {
            this.chocolateSprinkles = 0
        }
    }
}

fun main(args: Array<String>) {
    val whiteCoffeeNoSugar = Drink(name = "Coffee", milk = 1, sugar = 0).pour()
    println("poured $whiteCoffeeNoSugar")

    val buildersTea = Drink(name = "Tea", milk = 1, sugar = 3).pour()
    println("poured $buildersTea")

    val warmerCoffee = Drink(name = "Warm coffee", sugar = 2, warmMilk = 2).pour()
    println("poured $warmerCoffee")

    val mocha = Drink(name = "Mocha", sugar = 2, warmMilk = 2, chocolateSprinkles = 3).pour()
    println("poured $mocha")

    val teaWithNoChocolateSprinkles = Drink(name = "Tea", chocolateSprinkles = 10)
    println("poured $teaWithNoChocolateSprinkles")
}