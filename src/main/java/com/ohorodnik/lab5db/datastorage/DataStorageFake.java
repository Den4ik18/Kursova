package com.ohorodnik.lab5db.datastorage;

import com.ohorodnik.lab5db.model.Building;
import com.ohorodnik.lab5db.model.ClassBuilding;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class DataStorageFake {
    public List<Building> buildingList = new ArrayList<>(
            Arrays.asList(
                    /*new Building(1, 3, 4, 40, 10, "двохмісні", "вул.Гагаріна, 62"),
                    new Building(2, 4, 4, 40, 10, "трохмісні", "вул.Дубінська, 10"),
                    new Building(3, 2, 5, 50, 10, "одномісні", "вул.Садова, 127"),
                    new Building(4, 5, 3, 33, 11, "двохмісні", "вул.Грушевського, 10"),
                    new Building(5, 3, 2, 50, 25, "одномісні", "вул.Дачна, 15"),

                    new Building(6, 3, 4, 40, 10, "одномісні", "вул.Ентузіастів, 4"),
                    new Building(7, 4, 3, 30, 10, "двохмісні", "вул.Гайдара, 1А"),
                    new Building(8, 5, 5, 55, 11, "двохмісні", "вул.Сонячна, 21"),
                    new Building(9, 3, 3, 60, 20, "трохмісні", "вул.Перемоги, 9"),
                    new Building(10, 2, 2, 80, 40, "одномісні", "вул.Зради, 10"),

                    new Building(11, 3, 2, 50, 25, "трохмісні", "вул.Леоніда Кучми, 94"),
                    new Building(12, 4, 3, 40, 15, "одномісні", "вул.Кохання, 69"),
                    new Building(13, 5, 2, 50, 25, "трохмісні", "вул.Бульварська, 4"),
                    new Building(14, 2, 4, 32, 8, "двомісні", "вул.Проспектна, 22"),
                    new Building(15, 3, 4, 80, 20, "одномісні", "вул.Рівненська, 32")*/
                    new Building(3,4,32,8,"двохмісні","Руданська, 10")
            )
    );

    public List<Building> getBuildingList() {
        return buildingList;
    }

    /*public List<ClassBuilding> classList = new ArrayList<>(
            Arrays.asList(
                    new ClassBuilding(1, 3, buildingList.get(0)),
                    new ClassBuilding(2, 4, buildingList.get(1)),
                    new ClassBuilding(3, 2, buildingList.get(2)),
                    new ClassBuilding(4, 5, buildingList.get(3)),
                    new ClassBuilding(5, 3, buildingList.get(4)),

                    new ClassBuilding(6, 4, buildingList.get(6)),
                    new ClassBuilding(7, 3, buildingList.get(7)),
                    new ClassBuilding(8, 2, buildingList.get(8)),
                    new ClassBuilding(9, 5, buildingList.get(9)),
                    new ClassBuilding(10, 3, buildingList.get(10))
            )
    );

    public List<ClassBuilding> getClassList() {
        return classList;
    }*/
}
