package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() = orders.map{ it.products }.flatMap{ it.toList() }.toSet()

val Shop.allOrderedProducts: Set<Product> get() = customers.map{ it.orderedProducts }.flatMap{ it.toList() }.toSet()