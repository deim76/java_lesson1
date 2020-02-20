/* 3. Большая задача:
        a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false
         в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
        соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/

import javax.swing.*;
import java.util.ArrayList;

class Fruit{
    public float weight;

    public float getWeight() {
        return weight;
    }
}
class Apple extends Fruit{
 public Apple(){
     this.weight=1.0f;
  }
}

class Orange extends  Fruit{
    public Orange(){
        this.weight=1.5f;
   }
}
class Box<T extends Fruit>{
    private ArrayList<T> list_fruit;

    public Box(){
      this.list_fruit=new ArrayList<>();
    }

    public void add_fruit(T fruit){
        list_fruit.add(fruit);
    }

    public float getWeight(){
        float el_weight=0f;
        if(list_fruit.size()>0){
            el_weight=((T) list_fruit.get(0)).getWeight();
        }
        return el_weight*list_fruit.size();
    }

    public int getCount(){
       return list_fruit.size();
    }

    public String get_type(){
        String type_element="Empty";
        if (list_fruit.size()>0){
           if (list_fruit.get(0) instanceof Apple){
               type_element="Apple";

           }
           else {type_element="Orange";}

        }
        return type_element;
    }

    public boolean compare(Box box){

        return getWeight()==box.getWeight();
    }

    public void empty_box(Box box){
        list_fruit= (ArrayList<T>) box.list_fruit.clone();
        box.list_fruit.clear();

    }
}


public class lesson1_3 {
    public static void main(String[] args) {
      // инициализация Apple
       Apple apple=new Apple();
       Orange orange=new Orange();
       Box<Apple> box=new Box();
        // добавление Apple
       box.add_fruit(apple);
       box.add_fruit(apple);
       //box.add_fruit(orange); //проверка добавления в apple orange
       box.add_fruit(apple);

       System.out.println(box.get_type()+" Количество "+box.getCount()+" : "+
                           "вес "+box.getWeight());
        // инициализация Orange
        Box<Orange> box1=new Box();
        // добавление Orange
        box1.add_fruit(orange);
        box1.add_fruit(orange);
        System.out.println(box1.get_type()+" Количество "+box1.getCount()+" : "+
                           "вес "+box1.getWeight());

        //сравнение
        System.out.println("Коробки равны : " +box.compare(box1));

        // пересыпание
        Box new_box=new Box();
        new_box.empty_box(box);
        System.out.println("box : " +box.getCount() +
                " new_box "+ new_box.getCount());

    }
}
