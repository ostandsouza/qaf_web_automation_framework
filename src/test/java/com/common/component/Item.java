package com.common.component;

//public record Item(String conveyorName, String asset, Condition condition, boolean isCompleted) {}

import java.util.Objects;

public class Item {
    private final String conveyorName;
    private final String asset;
    private final Condition condition;
    private final boolean isCompleted;

    // Constructor
    public Item(String conveyorName, String asset, Condition condition, boolean isCompleted) {
        this.conveyorName = conveyorName;
        this.asset = asset;
        this.condition = condition;
        this.isCompleted = isCompleted;
    }

    // Getters
    public String conveyorName() {
        return conveyorName;
    }

    public String asset() {
        return asset;
    }

    public Condition condition() {
        return condition;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // equals() and hashCode() for proper comparison in collections
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return isCompleted == item.isCompleted &&
                Objects.equals(conveyorName, item.conveyorName) &&
                Objects.equals(asset, item.asset) &&
                condition == item.condition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(conveyorName, asset, condition, isCompleted);
    }

    // toString() for better debugging
    @Override
    public String toString() {
        return "Item{" +
                "conveyorName='" + conveyorName + '\'' +
                ", asset='" + asset + '\'' +
                ", condition=" + condition +
                ", isCompleted=" + isCompleted +
                '}';
    }
}