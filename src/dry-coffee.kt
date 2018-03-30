abstract class Drink(
  val name: Type,
  val milk: Int = 0,
  val sugar: Int = 0,
  val warmMilk: Int = 0,
  val chocolateSprinkles: Int = 0) {

    enum class Type {
        TEA, COFFEE
    }

    fun pour(): Drink = this

    override fun toString() = "$name(" +
      "milk=$milk, " +
      "sugar=$sugar, " +
      "warmMilk=$warmMilk, " +
      "chocolateSprinkles=$chocolateSprinkles)"
}

class Coffee(milk: Int = 0, sugar: Int = 0, warmMilk: Int = 0, chocolateSprinkles: Int = 0) : Drink(Type.COFFEE, milk, sugar, warmMilk, chocolateSprinkles)

class Tea(milk: Int = 0, sugar: Int = 0, warmMilk: Int = 0) : Drink(Type.TEA, milk, sugar, warmMilk, 0)

fun main(args: Array<String>) {
    val whiteCoffeeNoSugar = Coffee(milk = 1, sugar = 0).pour()
    println("poured $whiteCoffeeNoSugar")

    val buildersTea = Tea(milk = 1, sugar = 3).pour()
    println("poured $buildersTea")

    val warmerCoffee = Coffee(sugar = 2, warmMilk = 2).pour()
    println("poured $warmerCoffee")

    val mocha = Coffee(sugar = 2, warmMilk = 2, chocolateSprinkles = 3).pour()
    println("poured $mocha")

    val teaWithNoChocolateSprinkles = Tea().pour()
    println("poured $teaWithNoChocolateSprinkles")
}