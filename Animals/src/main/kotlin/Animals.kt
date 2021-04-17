interface Roamable {
    fun roam()
}

//Creating Animal Superclass
//Using open keyword so that other classes can inherit behaviour from it.
abstract class Animal : Roamable {
    abstract val food : String
    abstract val habitat : String
    abstract val image : String
    var hunger = 10

    abstract fun makeNoise()

    abstract fun eat()

    fun sleep() {
        println("The animal is sleeping")
    }

    override fun roam() {
        println("The animal is roaming")
    }
}

//Hippo class extending from the animal class. (Hippo IS A Animal)
class Hippo : Animal() {
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun eat() {
        println("The hippo is eating $food")
    }

    override fun makeNoise() {
        println("Grunt! Grunt!")

    }

}

//Canine class extending from the animal class. (Canine IS A Animal)
abstract class Canine : Animal() {
    override fun roam() {
        println("The canine is roaming")
    }
}

//Wolf class extending from the canine class. (Wolf IS A Canine) also (Wolf IS A Animal)
class Wolf : Canine() {
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun eat() {
        println("The wolf is eating $food")
    }

    override fun makeNoise() {
        println("Hoooooowl!")
    }
}

class Vehicle : Roamable {
    override fun roam() {
        println("The vehicle is roaming")
    }

}

//Vet class to show polymorphism.
class Vet {
    fun giveShot(animal : Animal) {
        //code to do something medical.
        animal.makeNoise()
    }
}

//Driver code.
fun main() {
    val animals = arrayOf(Hippo(), Wolf())

    for (item in animals) {
        item.roam()
        item.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()
    vet.giveShot(wolf)
    vet.giveShot(hippo)

    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())

    for (item in roamables) {
        item.roam()
        println("item.hashCode() = ${item.hashCode()}")
        println("item = $item")
        if(item is Animal) {
            item.eat()
        }
    }

}

