package EX1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class App {

    public static void main(String[] args) {
//////////   Variables
        ArrayList<Month> monthList = new ArrayList<>();

//////////   LLamada a las funciones
        addMonthToMonthList(monthList);
        printForEach(monthList);
        addAgostToList(monthList);
        printIterator(monthList);
        convertArrayListToHashSet(monthList);
    }

    ////////// Funciones
    private static void convertArrayListToHashSet(ArrayList<Month> monthList) {
        Set<Month> monthListHash = new HashSet<>();
        for (Month month : monthList) {
            if (!monthListHash.add(month)) {
                System.out.println("Mes repetido");
            }
        }
        System.out.println("No hay meses duplicados");
    }

    private static void printIterator(ArrayList<Month> monthList) {
        Iterator<Month> it = monthList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }

    private static void printForEach(ArrayList<Month> monthList) {
        for (Month month : monthList) {
            System.out.println(month.getName());
        }
        System.out.println();
    }

    private static ArrayList<Month> addMonthToMonthList(ArrayList<Month> monthList) {

        Month month0 = new Month("Enero");
        Month month1 = new Month("Febrero");
        Month month2 = new Month("Marzo");
        Month month3 = new Month("Abril");
        Month month4 = new Month("Mayo");
        Month month5 = new Month("Junio");
        Month month6 = new Month("Julio");
        Month month8 = new Month("Septiembre");
        Month month9 = new Month("Octubre");
        Month month10 = new Month("Noviembre");
        Month month11 = new Month("Diciembre");

        monthList.add(month0);
        monthList.add(month1);
        monthList.add(month2);
        monthList.add(month3);
        monthList.add(month4);
        monthList.add(month5);
        monthList.add(month6);
        monthList.add(month8);
        monthList.add(month9);
        monthList.add(month10);
        monthList.add(month11);

        return monthList;
    }

    private static ArrayList<Month> addAgostToList(ArrayList<Month> monthList) {
        Month month7 = new Month("Agosto");
        monthList.add(7, month7);
        return monthList;
    }

    public static class Month {

        private String name;

        public Month(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}

