


open class Drink(val name: String, val milk: Int, val sugar: Int) {
    fun pour(): Drink = this
    override fun toString(): String {
        return "$name(milk=$milk, sugar=$sugar)"
    }
}

class Coffee(milk: Int, sugar: Int) : Drink("Coffee", milk, sugar)

class Tea(milk: Int, sugar: Int) : Drink("Tea", milk, sugar)

fun main(args: Array<String>) {
    val whiteCoffeeNoSugar = Coffee(1, 0).pour()
    val buildersTea = Tea(1,3).pour()
    println("poured $whiteCoffeeNoSugar")
    println("poured $buildersTea")
}