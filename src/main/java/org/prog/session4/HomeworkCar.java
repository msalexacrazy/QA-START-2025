package org.prog.session1;

import org.w3c.dom.css.CSSStyleRule;

//TODO: HW4: add String model and make equals & hashCode work by model and color
public class HomeworkCar {

    public String color;
    public String model;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HomeworkCar) {
            HomeworkCar car = (HomeworkCar) obj;
            return this.color.equals(car.color)&&this.model.equals(car.model);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.color.hashCode() + this.model.hashCode();
    }

}