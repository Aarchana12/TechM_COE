abstract class Animal {
    abstract void makeSound();
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog is barking");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
