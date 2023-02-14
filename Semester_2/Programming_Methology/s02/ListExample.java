package at.ac.uibk.pm.gXX.zidUsername.s02.e02;


import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {

        // declares an ArrayList variable named list that is able to reference an Array that stores String objects
        // (In the declaration "String" can be replaced with any other reference type)
        ArrayList<String> list;

        // Instantiates a new ArrayList that stores String objects as defined in line 10
        list = new ArrayList<>();
        // The following line would not work because the declaration of list in line 10 states that the ArrayList stores
        // String objects not Float objects. Feel free to try it out by uncommenting the following line
        // list = new ArrayList<Float>();

        list.add("Hello"); // add the String "Hello" to the list
        list.add("World"); // add the String "World" to the list
        list.add("!"); // add the String "!" to the list

        // you can use a for each loop to iterate over all elements in an ArrayList
        for (String element : list) {
            System.out.println(element);
        }

        // list.size() yields the number of elements in the list
        System.out.println("size = " + list.size());

        System.out.println(list);

        String world = list.get(1); // an ArrayList starts at index 0 just like Arrays
        System.out.println(world);

        list.remove(world); // list items can be removed by reference
        System.out.println(list);

        list.remove(1); // or by index
        System.out.println(list);

    }
}
