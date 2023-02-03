class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

interface Walkable {
    void walk();
}

interface Swimmable {
    void swim();
}

class Fish extends Animal implements Swimmable {
    public Fish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }
}

class Dog extends Animal implements Walkable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is walking.");
    }
}

class Dolphin extends Animal implements Swimmable, Walkable {
    public Dolphin(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming.");
    }

    @Override
    public void walk() {
        System.out.println(getName() + " is walking.");
    }
}
// In Java, multi-inheritance is achieved through the use of interfaces.
// An interface is similar to a class, but only contains method signatures,
// with no implementation details. A class can implement multiple interfaces,
// thereby inheriting the method signatures and adding the methods to its own
// set of capabilities. In the example above, the Swimmable and Walkable
// interfaces define the swim and walk methods, respectively. The Dolphin class
// implements both of these interfaces, which means that it has both the swim
// and walk methods. It's worth noting that Java does not support multiple
// inheritance of classes, meaning that a class cannot inherit from more than
// one class. However, the use of interfaces allows for a form of multi-inheritance.
// This design decision was made to avoid the complexities and ambiguities that
// can arise with multiple inheritance of classes.
