package efs.task.oop;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Villager kashya = new Villager("Kashya", 30);
        ExtraordinaryVillager akara = new ExtraordinaryVillager("Akara", 40, ExtraordinaryVillager.Skill.SHELTER);
        Villager gheed = new Villager("Gheed", 50);
        ExtraordinaryVillager deckardCain = new ExtraordinaryVillager("Deckard Cain", 85, ExtraordinaryVillager.Skill.IDENTIFY);
        Villager warriv = new Villager("Warriv", 35);
        Villager flawia = new Villager("Flawia", 25);
        kashya.sayHello();
        akara.sayHello();
        gheed.sayHello();
        deckardCain.sayHello();
        warriv.sayHello();
        flawia.sayHello();

        Object objectDeckardCain = deckardCain;
        Object objectAkara = akara;
        //nie mozna wywolac na obiektach metod klasy ExtraOrdinaryVillager.
        List<Villager> villagers = new ArrayList<>();
        villagers.add(akara);
        villagers.add(deckardCain);
        villagers.add(kashya);
        villagers.add(gheed);
        villagers.add(warriv);
        villagers.add(flawia); //dzieki temu bedzie mozna ustalac konkretna osobe i ilosc osob zywych/martwych, aby dojsc do jakiegos wyniku


        Monsters monsters = new Monsters();
        Monster fightingMonster;

        Random rand = new Random();
        while (monsters.getMonstersHealth() > 0 && villagers.size() != 0) {
            System.out.println("Potwory posiadaja jeszcze " + Monsters.getMonstersHealth() + " punkty zycia");

            int fightingVillagerIndex = rand.nextInt(villagers.size()); //aby wybierac kolejnych osadnikow do walki.
            System.out.println("Aktualnie walczacy osadnik to " + villagers.get(fightingVillagerIndex).getName() + " (punkty zycia: " + villagers.get(fightingVillagerIndex).getHealth() + ")\n");

            if(monsters.andariel.getHealth() <= 0){
                fightingMonster = monsters.blacksmith; //wybieranie przeciwnika, tutaj nie mialem pomyslu wiec po prostu jeden po drugim, jak pierwszy umrze to pojdzie drugi do walki.
            }
            else{
                fightingMonster = monsters.andariel;
            }

            //TURA OSADNIKA
            villagers.get(fightingVillagerIndex).attack(fightingMonster); //atakuje osadnik

            if(fightingMonster.getHealth() > 0)
                fightingMonster.attack(villagers.get(fightingVillagerIndex)); //atakuje potwor jesli zyje

            if(villagers.get(fightingVillagerIndex).getHealth() <= 0 ){
                System.out.println("Osadnik " + villagers.get(fightingVillagerIndex).getName() + " umiera\n");
                villagers.remove(villagers.get(fightingVillagerIndex));
            }
        }
        if(monsters.getMonstersHealth() <= 0){
            System.out.println("Obozowisko ocalone!");
        }
        else {
            System.out.println("Obozowisko poleglo...");
        }


        deckardCain = (ExtraordinaryVillager) objectDeckardCain;
        akara = (ExtraordinaryVillager) objectAkara;
        //Sprawdź czy można wywołać metody z klasy ExtraordinaryVillager.
        deckardCain.sayHello();
        akara.sayHello();
    }
}
