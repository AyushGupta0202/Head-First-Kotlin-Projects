abstract class Pet(var name: String)

class Dog(name: String) : Pet(name)
class Cat(name: String) : Pet(name)
class Fish(name: String) : Pet(name)

class Vet<T: Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}

class Contest<T: Pet>(var vet: Vet<in T>) {
    private val scores: MutableMap<T, Int> = mutableMapOf()

    fun addScore(t: T, score: Int = 0) {
        if (score >= 0)
        scores.put(t, score)
    }

    fun getWinners(): MutableSet<T> {
        val winners : MutableSet<T> = mutableSetOf()
        val highScore = scores.values.maxOrNull()

        for ((t, score) in scores) {
            if (score == highScore) winners.add(t)
        }
        return winners
    }
}

interface Retailer<out T> {
    fun sell() : T
}

class CatRetailer : Retailer<Cat> {
    override fun sell(): Cat {
        println("Sell Cat")
        return Cat("")
    }

}
class FishRetailer : Retailer<Fish> {
    override fun sell(): Fish {
        println("Sell Fish")
        return Fish("")
    }

}
class DogRetailer : Retailer<Dog> {
    override fun sell(): Dog {
        println("Sell Dog")
        return Dog("")
    }

}

fun main() {
    val catFuzz = Cat("Fuzz Lightyear")
    val catKatsu = Cat("Katsu")
    val fishFinny = Fish("Finny McGraw")

    val catVet = Vet<Cat>()
    val fishVet = Vet<Fish>()
    val petVet = Vet<Pet>()

    catVet.treat(catFuzz)
    petVet.treat(catKatsu)
    petVet.treat(fishFinny)

    val catContest = Contest(catVet)
    catContest.addScore(catFuzz, 50)
    catContest.addScore(catKatsu, 45)
    val topCat = catContest.getWinners().first()
    println("topCat = ${topCat.name}")

    val petContest = Contest(petVet)
    petContest.addScore(catFuzz, 50)
    petContest.addScore(fishFinny, 56)
    val topPet = petContest.getWinners().first()
    println("topPet = ${topPet.name}")

    val catRetailer : Retailer<Cat> = CatRetailer()
    val dogRetailer : Retailer<Dog> = DogRetailer()
    val petRetailer : Retailer<Pet> = CatRetailer()

    petRetailer.sell()


}