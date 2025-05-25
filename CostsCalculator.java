package Sprint;

import java.util.ArrayList;

public class CostsCalculator {

    private String name;
    private Double amount;
    private String category;

    public CostsCalculator(String name, Double amount, String category){
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String toString(){
        return category + " " + name  + " " + amount + " руб.";
    }

    public String getName(){
        return this.name;
    }

    public Double getAmount(){
        return this.amount;
    }

    public String getCategory(){
        return this.category;
    }
}

