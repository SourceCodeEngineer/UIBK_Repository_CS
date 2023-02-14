package at.ac.uibk.pm.gXX.zidUsername.s08.e02;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Item> items;

    public Inventory(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    public List<Item> getItems(FoodType foodType, BigDecimal priceUpperBound) {
        List<Item> itemsPerType = new ArrayList<>();
        for (Item item : items) {
            if ((item.getFoodType() == foodType) && (item.getPrice().compareTo(priceUpperBound) < 0)) {
                itemsPerType.add(item);
            }
        }
        return itemsPerType;
    }

    public List<Item> getItems(FoodType foodType) {
        List<Item> itemsPerType = new ArrayList<>();
        for (Item item : items) {
            if (item.getFoodType() == foodType) {
                itemsPerType.add(item);
            }
        }
        return itemsPerType;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(item.getPrice());
        }
        return sum;
    }

    public BigDecimal getTotalPrice(FoodType foodType) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            if (item.getFoodType() == foodType) {
                sum = sum.add(item.getPrice());
            }
        }
        return sum;
    }

    public BigDecimal getAveragePrice(FoodType foodType) {
        BigDecimal sum = BigDecimal.ZERO;
        int amount = 0;
        for (Item item : items) {
            if (item.getFoodType() == foodType) {
                sum = sum.add(item.getPrice());
                amount++;
            }
        }
        return sum.divide(BigDecimal.valueOf(amount), 2, RoundingMode.HALF_EVEN);
    }

    public void sortItemsByPrice() {
        int n = items.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (items.get(j - 1).getPrice().compareTo(items.get(j).getPrice()) > 0) {
                    Item temp = items.get(j);
                    items.set(j, items.get(j - 1));
                    items.set(j - 1, temp);
                }
            }
        }
    }

    public void sortItemsByFoodType() {
        int n = items.size();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (items.get(j - 1).getFoodType().ordinal() > items.get(j).getFoodType().ordinal()) {
                    Item temp = items.get(j);
                    items.set(j, items.get(j - 1));
                    items.set(j - 1, temp);
                }
            }
        }
    }


    @Override
    public String toString() {
        return items.toString();
    }


}
