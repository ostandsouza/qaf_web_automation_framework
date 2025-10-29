package com.common.component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class InspectionItemSequencing {

    private static final List<String> ASSET_PRIORITY_ORDER_VMC = List.of(
            "Tail Pulley", "Belt", "Other Pulleys", "Belt Alignment", "Idlers", "Drive Pulley"
    );

    private static final List<String> ASSET_PRIORITY_ORDER_DEFAULT = List.of(
            "Conveyor Belt", "Cleaning Equipment", "Rollers/Idlers", "Pulley", "Chutes/Load Area", "Roller Frames", "Tracking Frames", "Counterweight", "Drive Motor", "Conveyor Structure", "Other"
    );

    private static final List<String> ASSET_PRIORITY_ORDER_TC = List.of(
            "Tail", "Center", "Head", "Belt"
    );

    private static final Comparator<Item> comparator1 = Comparator
            .comparing(Item::conveyorName)
            .thenComparing(Item::condition)
            .thenComparing(item -> ASSET_PRIORITY_ORDER_DEFAULT.indexOf(item.asset()));

    private static final Comparator<Item> comparator2 = Comparator
            .comparing(Item::conveyorName)
            .thenComparing(item -> ASSET_PRIORITY_ORDER_VMC.indexOf(item.asset()));

    private static final Comparator<Item> comparator3 = Comparator
            .comparing(Item::conveyorName)
            .thenComparing(item -> ASSET_PRIORITY_ORDER_TC.indexOf(item.asset()));

    private static PriorityQueue<Item> priorityQueue = new PriorityQueue<>(comparator1);


    public void clearItems(){
        priorityQueue.clear();
    }

    public void addItem(String conveyorName, String asset, String condition, boolean isCompleted){
        priorityQueue.add(new Item(conveyorName, asset, assignFlag(condition), condition.equalsIgnoreCase("good") || isCompleted));
    }

    public void addItems(List<Item> item){
        priorityQueue.addAll(item);
    }

    public Condition assignFlag(String flag){
        if(flag.equalsIgnoreCase("critical"))
            return Condition.Critical;
        else if(flag.equalsIgnoreCase("poor"))
            return Condition.Poor;
        else if(flag.equalsIgnoreCase("fault"))
            return Condition.Fault;
        else
            return Condition.Good;
    }

    public void updateItem(String conveyorName, String asset, String newCondition, Boolean newStatus) {
        List<Item> tempList = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            Item item = priorityQueue.poll();
            if (item.conveyorName().equals(conveyorName) && item.asset().equals(asset)) {
                Condition updatedCondition = (newCondition != null) ? assignFlag(newCondition) : item.condition();
                boolean updatedStatus = (newStatus != null) ? newStatus : item.isCompleted();
                tempList.add(new Item(conveyorName, asset, updatedCondition, updatedCondition == Condition.Good || updatedStatus));
            } else {
                tempList.add(item);
            }
        }
        System.out.println(tempList);
        // Reinsert updated items back into the priority queue
        priorityQueue.addAll(tempList);
        System.out.println(priorityQueue);
    }


    public void deleteItem(String conveyorName, String asset) {
        List<Item> tempList = new ArrayList<>();

        // Remove all items and keep only the ones that don't match the given parameters
        while (!priorityQueue.isEmpty()) {
            Item item = priorityQueue.poll();
            if (!(item.conveyorName().equals(conveyorName) && item.asset().equals(asset))) {
                tempList.add(item); // Keep all items except the one to be deleted
            }
        }

        // Reinsert the remaining items back into the priority queue
        priorityQueue.addAll(tempList);
    }

    public List<Item> getSortedItems() {
        List<Item> sortedItems = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            sortedItems.add(priorityQueue.poll());
        }
        priorityQueue.addAll(sortedItems);
//        return sortedItems.stream().distinct().toList();
        return sortedItems.stream().distinct().collect(Collectors.toList());
    }

    public List<Item> getNotCompletedItems() {
        return priorityQueue.stream()
                .filter(item -> !item.isCompleted()) // Filter items where isCompleted is false
                .collect(Collectors.toList());
    }

    public void switchComparator(InspectionType type) {
        List<Item> tempList = new ArrayList<>(priorityQueue);

        switch (type) {
            case VMC:
                priorityQueue = new PriorityQueue<>(comparator2);
                break;
            case TC:
                priorityQueue = new PriorityQueue<>(comparator3);
                break;
            case DEFAULT:
            default:
                priorityQueue = new PriorityQueue<>(comparator1);
                break;
        }

        priorityQueue.addAll(tempList);
    }

}
