import javax.swing.*;
// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);


class Dim_ex<T>{
public T[] dim;
public Dim_ex(T[] dim){
    this.dim=dim.clone();
    }
public T[] replase_element(int index_1,int index_2){
   T el1=dim[index_1];
   T el2=dim[index_2];
   dim[index_2]=el1;
   dim[index_1]=el2;
   return dim;
}
public T[] replase_element(T el_1,T el_2){
  int index_1=-1;
  int index_2=-1;
    for (int dx=0;dx<dim.length;dx++){
        if (dim[dx].equals(el_1)){
          index_1=dx;
        }
        else if (dim[dx].equals(el_2)){
            index_2=dx;
        }
    }
    if(index_1!=-1&&index_2!=-1){
        dim[index_2]=el_1;
        dim[index_1]=el_2;
    }
        return dim;
  }
}

public class Lesson1_1 {

private static void print_dim(Object [] dim){
    for (Object el:dim) {
        System.out.println(el);
    }
}
public static void main(String[] args) {
    Dim_ex<String> dim_ex=new Dim_ex<>(new String[]{"a","b","c","d"});
    System.out.println("Исходный массив");
    print_dim(dim_ex.dim);

    System.out.println("Результирующий массив перестановка по индексу");
    dim_ex.replase_element(2,0);
    print_dim(dim_ex.dim);

    System.out.println("Результирующий массив перестановка по элементу");
    dim_ex.replase_element("d","a");
    print_dim(dim_ex.dim);

  }


}

