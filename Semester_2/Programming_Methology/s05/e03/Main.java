package at.ac.uibk.pm.gXX.zidUsername.s05.e03;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /**
         * The data was generated by a random selection from lists and a match with real
         * persons is purely coincidental.
         */
        String[] csv = {
                "Li Kim,Kranewitterstraße 4;6020;Innsbruck;Austria,09.12.1997,passe-temps:aNT-KEepINg",
                "Nour Vargas,Serlesweg 2;6020;Innsbruck;Austria,22.01.1995,aficiones:SURvIVAlISm;kung Fu;ROBOt cOmbat",
                "Aleksandr Houssein,Seilergasse 6;6020;Innsbruck;Austria,08.04.1999,aficiones:GYmNASTIcs",
                "Jelena Pierre,Josef-Wilberger-Straße 1;6020;Innsbruck;Austria,20.11.1996,passe-temps:rEsEaRch;BUSinESS",
                "Monika Madrid,Lehmweg 3;6020;Innsbruck;Austria,05.01.1993,passe-temps:pRoVErBs;mAgiC;fOsSICkIng",
                "Fatouma Khan,Lutterottistraße 7;6020;Innsbruck;Austria,28.12.1995,passe-temps:meTALwoRKING;reCoRd CoLlecting",
                "Mohamed Rodriguez,Cranachstraße 6;6020;Innsbruck;Austria,03.06.1993,aficiones:MaCrAmE",
                "Md Memmedov,Prinz-Eugen Brücke 10;6020;Innsbruck;Austria,04.07.1991,aficiones:KNoWleDge/wOrd gameS;ENTertaInInG",
                "Dimitris Martin,Gsturnsteig 10;6020;Innsbruck;Austria,21.02.1990,passe-temps:elEctRONIc GAMes;vintAge cArs;HorsEShoeS",
                "Mpho Rusu,Heiligwasserwiese 1;6020;Innsbruck;Austria,02.08.1990,aficiones:CLimbinG;wEIghT trAINInG",
        };

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < csv.length; i++) {
            String csv_row = csv[i];

            /**
             * add code here to split the data of each row, such that you can create
             * instances of type Person
             * 
             * store the individual instances in the list named persons
             */

        }

        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
            System.out.println("***********************************************************");
        }

    }
}