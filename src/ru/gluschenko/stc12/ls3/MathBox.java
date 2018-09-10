package ru.gluschenko.stc12.ls3;

import java.util.*;

/***
 * Класс для математических операций с коллекциями
 */
@Logged
public class MathBox implements MathActions, PrintActions {
    private ArrayList<Integer> list = new ArrayList<>();

    public MathBox(Integer[] initArray){

        for(Integer element : initArray){
            if(element == null){
                continue;
            }

            if(this.list.contains(element)){
                continue;
            }
            this.list.add(element);
            //this.printList();
        }

        Collections.sort(list);
    }

    public void clearList(){
        this.list.clear();
    }

    public void printList(){
        System.out.println("MathBox list:"+this.list);
    }

    @ClearData
    public Integer summator(){
        Integer result = 0;
        for(Integer e : this.list){
            result += e;
        }
        return result;
    }

    public ArrayList<Double> splitter(Integer divider){
        ArrayList<Double> splittedList = new ArrayList<>();
        if(divider == null || divider == 0) {
            for (Integer e : this.list) {
                splittedList.add(null);
            }
            return splittedList;
        }

        double ddivider = (double) divider;
        for (Integer e : this.list) {
            splittedList.add((double)e/ddivider);
        }
        return splittedList;
    }

    public boolean remove(Integer element){
        if(this.list.contains(element)){
            this.list.remove(element);
            return true;
        }
        return false;
    }

    public String toString() {
        return Arrays.toString(this.list.toArray());
    }

    public final boolean equals(MathBox o) {
        if (o == null)
            return false;

        if (o == this)
            return true;

        return this.toString().equals(o.toString());
    }

    public int hashCode() {
        int hashCode = 1;
        for (Integer e : this.list)
            hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
        return hashCode;
    }

}
