package zlh.test.annotation;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import zlh.test.annotation.FruitColor.Color;

public class Apple {

    @FruitName("Apple Apple")
    private String appleName;

    @FruitColor(fruitColor = Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路89号红富士大厦")
    private String appleProvider;
    @Max(value = 2, message = "不能大于2")
    private int appleSize;

    public Apple(int appleSize, String appleName, String appleColor, String appleProvider) {
        this.setAppleSize(appleSize);
        this.appleName = appleName;
        this.appleColor = appleColor;
        this.appleProvider = appleProvider;
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public void displayName() {
        System.out.println("水果的名字是：苹果");
    }

    public int getAppleSize() {
        return appleSize;
    }

    public void setAppleSize(@Valid int appleSize) {
        this.appleSize = appleSize;
    }
}
