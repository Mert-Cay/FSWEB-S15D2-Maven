package org.example.entity;

import java.util.*;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String t) {
        if (t == null) {
            return Collections.emptySet();
        }

        switch (t.toLowerCase()) {
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                List<Set<Task>> allList = new ArrayList<>();
                allList.add(this.annsTasks);
                allList.add(this.bobsTasks);
                allList.add(this.carolsTasks);
                if (this.unassignedTasks != null) {
                    allList.add(this.unassignedTasks);
                }
                return getUnion(this.annsTasks, this.bobsTasks, this.carolsTasks, this.unassignedTasks);
            default:
                return Collections.emptySet();
        }
    }




    @SafeVarargs
    public final Set<Task> getUnion(Set<Task>... sets) {
        Set<Task> totalTasks = new LinkedHashSet<>();
        if (sets != null) {
            for (Set<Task> set : sets) {
                if (set != null) {
                    totalTasks.addAll(set);
                }
            }
        }
        return totalTasks;
    }

    public Set<Task> getDifferences(Set<Task> set1 , Set<Task> set2){
        set1.removeAll(set2);
        return set1;
    }

    public Set<Task> getIntersection(Set<Task> set1 , Set<Task> set2){
        set1.retainAll(set2);
        return set1;
    }

}