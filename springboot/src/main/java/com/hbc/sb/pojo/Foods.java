package com.hbc.sb.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "foods")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodsid")
    int foodsid;

    String foodsname;
    String foodshistory;
    String foodsmake;
    String foodsimg1;
    String foodsimg2;
    String foodsother;
    int foodsgood;
    String foodsftime;
    String foodsltime;
    String foodsjj;
    String foodsall;

    public int getFoodsid() {
        return foodsid;
    }

    public void setFoodsid(int foodsid) {
        this.foodsid = foodsid;
    }

    public String getFoodsname() {
        return foodsname;
    }

    public void setFoodsname(String foodsname) {
        this.foodsname = foodsname;
    }

    public String getFoodshistory() {
        return foodshistory;
    }

    public void setFoodshistory(String foodshistory) {
        this.foodshistory = foodshistory;
    }

    public String getFoodsmake() {
        return foodsmake;
    }

    public void setFoodsmake(String foodsmake) {
        this.foodsmake = foodsmake;
    }

    public String getFoodsimg1() {
        return foodsimg1;
    }

    public void setFoodsimg1(String foodsimg1) {
        this.foodsimg1 = foodsimg1;
    }

    public String getFoodsimg2() {
        return foodsimg2;
    }

    public void setFoodsimg2(String foodsimg2) {
        this.foodsimg2 = foodsimg2;
    }

    public String getFoodsother() {
        return foodsother;
    }

    public void setFoodsother(String foodsother) {
        this.foodsother = foodsother;
    }

    public int getFoodsgood() {
        return foodsgood;
    }

    public void setFoodsgood(int foodsgood) {
        this.foodsgood = foodsgood;
    }

    public String getFoodsftime() {
        return foodsftime;
    }

    public void setFoodsftime(String foodsftime) {
        this.foodsftime = foodsftime;
    }

    public String getFoodsltime() {
        return foodsltime;
    }

    public void setFoodsltime(String foodsltime) {
        this.foodsltime = foodsltime;
    }

    public String getFoodsjj() {
        return foodsjj;
    }

    public void setFoodsjj(String foodsjj) {
        this.foodsjj = foodsjj;
    }

    public String getFoodsall() {
        return foodsall;
    }

    public void setFoodsall(String foodsall) {
        this.foodsall = foodsall;
    }
}
