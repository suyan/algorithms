public class AnimalShelter {

    class Animal {
        String name;
        int type;
        Animal(String name, int type) {
            this.name = name;
            this.type = type;
        }
    }

    Queue<Animal> queue;

    public AnimalShelter() {
        queue = new LinkedList<Animal>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        queue.add(new Animal(name, type));
    }

    public String dequeueAny() {
        Animal animal = queue.remove();
        return animal.name;
    }

    public String dequeueDog() {
        
    }

    public String dequeueCat() {
        // Write your code here
    }
}
