
//  2. Написать метод, который преобразует массив в ArrayList;

import java.util.ArrayList;

class Dim<T> {
    public T[] dim;

    public Dim(T[] dim) {
        this.dim = dim.clone();
    }
    public ArrayList<T> dim_toArray(T[] dim){
       ArrayList<T> array_list=new ArrayList<>();
        for (T el:dim){
            array_list.add(el);
        }
       return array_list;
    }
}

public class lesson1_2 {

    private static void print_dim(ArrayList dim){
        System.out.println(dim instanceof ArrayList);
        for (Object el:dim) {
            System.out.println(el);
        }
    }

    public static void main(String[] args) {
        Dim<String> dim_ex=new Dim<>(new String[]{"a","b","c","d"});
        ArrayList arrayList=dim_ex.dim_toArray(dim_ex.dim);
        print_dim(arrayList);
    }
}
