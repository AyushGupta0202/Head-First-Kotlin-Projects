// Dog class creation. Defining properties of Dog inside the constructor
// Each dog will have a name, weight, and breed.
class Dog(val name : String, weight_param : Int, breed_param : String) {

    // Array of activities that a dog can perform.
    var activities = arrayOf("Walk")

    // The weight is initialised inside the class.
    var weight = weight_param

        // Setter method to set weight of the dog.
    set(value) {
        if (value > 0) field = value
    }

    // Breed of every dog is stored in upper case format.
    var breed = breed_param.toUpperCase()

    // Initializer block, runs when the dog object is initialised and prints the dog's name.
    init {
        print("Dog $name is been created.")
    }

    // Another initializer block that prints the breed.
    init {
        println(" The breed is $breed.")
    }

    // This calculates the weight of the dog in kgs.
    val weightInKgs : Double

    // Getter method for the weightInKgs.
    get() = weight / 2.2

    //Every dog can bark!
    fun bark() {
        println(if (weight < 20) "Yip!" else "Woof!")
    }
}


// The main function.
fun main() {

    // Creating a dog object and passing the values as arguments.
    val myDog = Dog("Fido", 70, "Mixed")

    // Making the dog bark!
    myDog.bark()

    // Setting the dog's wait explicitly. Remember, this calls the setter method of the weight
    // property of the dog.
    myDog.weight = 75

    println("Weight is Kgs is ${myDog.weightInKgs}")

    // Trying to traumatize the dog and code. But can we do it?
    myDog.weight = -2

    println("Weight is ${myDog.weight}")

    // Nice and simple activities of a dog.
    myDog.activities = arrayOf("Walk", "Fetching balls", "Frisbee")

    // Printing every activity of a dog from the activities array from the dog object.
    for (item in myDog.activities) {
        println("My dog enjoys $item")
    }

    // Now, creating an array of dogs.
    val dogs = arrayOf(Dog("Kelpie", 20, "Westie"), Dog("Ripper", 10, "Poodle"))

    dogs[1].bark()

    dogs[1].weight = 15

    println("Weight for ${dogs[1].name} is ${dogs[1].weight}")
}