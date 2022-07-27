class Coord {
    public int row, col;
    public Coord(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Car {
    public String color;
    public Coord location;
    public Car(String color, Coord location) {
        this.color = color;
        this.location = location;
    }
}

// public class Q1 {
//     public void g(Car c1, Car c2) {
//         c2 = c1;
//         c2.color = "blue";
//     }
//     public String question() {
//         Car redCar = new Car("red", new Coord(5, 6));
//         Car greenCar = new Car("green", new Coord(7, 8));
//         this.g(greenCar, redCar);
//         return redCar.color + ", " + greenCar.color;
//     }
//     public static void main(String[] args) {
//         System.out.println(new Q1().question());
//     }
// }

// public class Q2 {
//     public void f(Coord c) {
//         Car car = new Car("blue", c);
//         car.location.row = 10;
//         car.location.col = 9;
//     }
//     public int question() {
//         Coord unit = new Coord(1, 1);
//         Car blackCar = new Car("black", unit);
//         this.f(unit);
//         return blackCar.location.row;
//     }
//     public static void main(String[] args) {
//         System.out.println(new Q2().question());
//     }
// }

class O {
    int x = 10;
    int y = 11;
    int z = 12;
    public O(int x, int y, int thisZ) {
        x = x;
        this.y = y;
        z = thisZ;
    }
}

// public class Q {
//     public static void main(String[] args) {
//         O o1 = new O(5, 6, 7);
//         System.out.println(o1.x + " " + o1.y + " " + o1.z);
//     }
// }

class Item {
    String name;
    int price;
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public boolean equals(Object other) {
        if (!(other instanceof Item)) { return false; }
        Item i = (Item) other;
        return this.name.equals(i.name) && this.price == i.price;
    }
}

public class QQ {
    public static void main(String[] args) {
        Item item1 = new Item("Umbrella", 12);
        Item item2 = new Item("Chair", 30);
        Item item3 = new Item("Umbrella", 12);
        System.out.println(item1 == item2);
        System.out.println(item1.equals(item2));
        System.out.println(item1 == item3);
        System.out.println(item1.equals(item3));
        System.out.println(item2 == item3);
        System.out.println(item2.equals(item3));
    }
}