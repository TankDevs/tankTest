package zlh.test.annotation.standard;

public class Fruit {

    public void displayName() {
        System.out.println("水果的名字是：*****");
    }
}

class Orange extends Fruit {
    // @Override
    public void displayName() {
        System.out.println("水果的名字是：桔子");
    }
}

class Apple extends Fruit {
    // @Override
    public void displayname() {
        System.out.println("水果的名字是：苹果");
    }
}