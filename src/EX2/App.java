package EX2;

import java.util.*;

public class App {

    public static void main(String[] args) {
        //Creación de una primera lista. Se añaden datos.
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        System.out.println(numList);

        //Creación de una segunda lista
        List<Integer> numListReverse = new ArrayList<>();

        //Creación de una List Iterador con los datos de la primera Lista
        ListIterator numListIt = numList.listIterator(numList.size());

        //Se utiliza el método hasPrevious en la List Iterator para invertir los datos de la primera lista
        //y se añaden los datos invertidos a la segunda lista.
        while (numListIt.hasPrevious()) {
            numListReverse.add((Integer) numListIt.previous());
        }
        System.out.println(numListReverse);


    }

}
