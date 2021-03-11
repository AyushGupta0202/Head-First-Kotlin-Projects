data class Recipe(var name: String)

fun main() {
    var mShoppingList = mutableListOf("Tea", "Eggs", "Milk")
    println("mShoppingList original = ${mShoppingList}")
    val extraShoppingList = listOf("Cookies", "Sugar", "Eggs")
    mShoppingList.addAll(extraShoppingList)
    println("mShoppingList items added : = ${mShoppingList}")
    if (mShoppingList.contains("Tea")) {
        mShoppingList.set(mShoppingList.indexOf("Tea"), "Coffee")
    }
    mShoppingList.sort()
    println("mShoppingList sorted = $mShoppingList")
    mShoppingList.reverse()
    println("mShoppingList reversed = ${mShoppingList}")

    val mShoppingSet = mShoppingList.toMutableSet()
    println("mShoppingSet = ${mShoppingSet}")
    val moreShopping = setOf("Chives", "Spinach", "Milk")
    mShoppingSet.addAll(moreShopping)
    println("mShoppingSet items added : = ${mShoppingSet}")
    mShoppingList = mShoppingSet.toMutableList()
    println("mShoppingList new version = ${mShoppingList}")

    val mRecipeMap = mutableMapOf(
        "Recipe1" to Recipe("Chicken Soup"),
        "Recipe2" to Recipe("Quinoa Salad"),
        "Recipe3" to Recipe("Thai Curry")
    )
    println("mRecipeMap = ${mRecipeMap}")
    val recipeToAdd = mapOf(
        "Recipe4" to Recipe("Jambalaya"),
        "Recipe5" to Recipe("Sausage Rolls")
    )
    mRecipeMap.putAll(recipeToAdd)
    println("mRecipeMap updated = ${mRecipeMap}")
    if (mRecipeMap.containsKey("Recipe1")) {
        println("Recipe1 = ${mRecipeMap.getValue("Recipe1")}")
    }
    println(mRecipeMap.values)
}
