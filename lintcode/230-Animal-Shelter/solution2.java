class Node {
    int time;
    String name;

    Node(String name, int time) {
        this.name = name;
        this.time = time;
    }
    public String getName() {
        return this.name;
    }
    public int getTime() {
        return this.time;
    }
}

public class AnimalShelter {

    private static final int DOG = 1;
    private static final int CAT = 0;

    private int tot;
    private LinkedList<Node> cats, dogs;

    public AnimalShelter() {
        // do initialize if necessary
        tot = 0;
        dogs = new LinkedList<Node>();
        cats = new LinkedList<Node>();
    }

    /**
     * @param name a string
     * @param type an integer, 1 if Animal is dog or 0
     * @return void
     */
    void enqueue(String name, int type) {
        tot += 1;
        if (type == DOG) {
            dogs.add(new Node(name, tot));
        } else {
            cats.add(new Node(name, tot));
        }
    }

    public String dequeueAny() {
        if (cats.isEmpty()) {
            return dequeueDog();
        } else if (dogs.isEmpty()) {
            return dequeueCat();
        } else {
            int dogTime = dogs.getFirst().getTime();
            int catTime = cats.getFirst().getTime();
            if (catTime < dogTime) {
                return dequeueCat();
            } else {
                return dequeueDog();
            }
        }
    }

    public String dequeueDog() {
        String name = dogs.getFirst().getName();
        dogs.removeFirst();
        return name;
    }

    public String dequeueCat() {
        String name = cats.getFirst().getName();
        cats.removeFirst();
        return name;
    }
}