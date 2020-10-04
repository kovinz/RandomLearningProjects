package com.elegion.courserafirstcourseprogrammingtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class CharacterCreator extends Observable implements Serializable {

    public enum Specialization {
        WARRIOR, ARCHER, MAGE
    }

    public enum Race {
        HUMAN, ELF, ORC, DWARF
    }

    public enum Attribute {
        STRENGTH, AGILITY, INTELLECT, STAMINA, LUCK
    }

    public enum Perk {
        BERSERK, CALM, LIGHTWEIGHT, HEAVYARMORED, OBSERVANT, MEDITATIONS
    }

    private String mName;
    private Specialization mSpecialization;
    private Race mRace;
    private int mAvailablePoints;

    private Map<String, Integer> mAttributesMap = new HashMap<>();
    private Map<String, Boolean> mPerksMap = new HashMap<>();


    public CharacterCreator() {
        mRace = Race.HUMAN;
        mSpecialization = Specialization.WARRIOR;
        mAvailablePoints = 5;
        mAttributesMap.put(Attribute.STRENGTH.name(), 5);
        mAttributesMap.put(Attribute.AGILITY.name(), 5);
        mAttributesMap.put(Attribute.INTELLECT.name(), 5);
        mAttributesMap.put(Attribute.STAMINA.name(), 5);
        mAttributesMap.put(Attribute.LUCK.name(), 5);
    }


    public String[] getSpecializations() {
        // TODO: 11.12.2017
        /*
         *   этот метод должен возвращать массив строк, созданных на основе enum Specialization
         *   Строки должны начинаться с заглавной буквы, остальные строчные
         * */
        String[] strings = new String[Specialization.values().length];
        for (Specialization specialization : Specialization.values()) {
            String capitalized = specialization.toString().substring(0, 1).toUpperCase() + specialization.toString().substring(1).toLowerCase();
            strings[specialization.ordinal()] = capitalized;
        }
        return strings;

    }

    public void setSpecialization(int position) {
        // TODO: 11.12.2017
        /*
         *  этот метод задает специализацию в переменную mSpecialization
         *  на вход подается число, и из enum Specialization выбирается соответствующий класс
         *  0 - Warrior
         *  1 - Archer
         *  2 - Mage
         *  если введенное число меньше 0, то в mSpecialization записывается самое первое (порядковый номер - 0) значение
         *  если введенное число больше длины enum, то в mSpecialization записывается самое последнее (длина - 1) значение
         *
         * */
        if (position < 0) {
            position = 0;
        } else if (position > Specialization.values().length - 1) {
            position = Specialization.values().length - 1;
        }

        for (Specialization specialization : Specialization.values()) {
            if (specialization.ordinal() == position) {
                mSpecialization = specialization;
                break;
            }
        }
    }

    public String[] getRaces() {
        // TODO: 11.12.2017
        /*
         *   этот метод должен возвращать массив строк, созданных на основе enum Races
         *    Строка должна быть формата - первая буква заглавная, остальные строчные
         *   One, Two, Three
         * */
        String[] strings = new String[Race.values().length];
        for (Race race : Race.values()) {
            String capitalized = race.toString().substring(0, 1).toUpperCase() + race.toString().substring(1).toLowerCase();
            strings[race.ordinal()] = capitalized;
        }
        return strings;
    }

    public void setRace(int position) {
        // TODO: 11.12.2017
        /*
         *  этот метод задает специализацию в переменную mRace
         *  на вход подается число, и из enum Race выбирается соответствующая раса
         *  0 - Human
         *  1 - Elf
         *  2 - Orc
         *  3 - Dwarf
         *  если введенное число меньше 0, то в mRace записывается самое первое (порядковый номер - 0) значение
         *  если введенное число больше длины enum, то в mRace записывается самое последнее (длина - 1) значение
         *
         * */
        if (position < 0) {
            position = 0;
        } else if (position > Race.values().length - 1) {
            position = Race.values().length - 1;
        }

        for (Race race : Race.values()) {
            if (race.ordinal() == position) {
                mRace = race;
                break;
            }
        }
    }

    public String[] getAttributes() {

        // TODO: 11.12.2017
        /*
         *   этот метод должен возвращать массив строк, созданных на основе enum Attribute
         *    Строка должна быть формата - первая буква заглавная, остальные строчные
         *   One, Two, Three
         * */
        String[] strings = new String[Attribute.values().length];
        for (Attribute attribute : Attribute.values()) {
            String capitalized = attribute.toString().substring(0, 1).toUpperCase() + attribute.toString().substring(1).toLowerCase();
            strings[attribute.ordinal()] = capitalized;
        }
        return strings;
    }

    public String[] getPerks() {
        // TODO: 11.12.2017
        /*
         *   этот метод должен возвращать массив строк, созданных на основе enum Perk
         *   Строка должна быть формата - первая буква заглавная, остальные строчные
         *   One, Two, Three
         *
         * */

        String[] strings = new String[Perk.values().length];
        for (Perk perk : Perk.values()) {
            String capitalized = perk.toString().substring(0, 1).toUpperCase() + perk.toString().substring(1).toLowerCase();
            strings[perk.ordinal()] = capitalized;
        }
        return strings;
    }

    public void updateAttributeValue(int position, int updateTo) {
        // TODO: 11.12.2017
        /*
         *  этот метод увеличивает/уменьшает соответствующее значение атрибута
         *  рекомендуется реализовывать его в последнюю очередь
         *
         * 1. на вход подается позиция изменяемого атрибута и на сколько нужно этот атрибут увеличить/уменьшить
         * 2. по позиции атрибута выявляется название атрибута из enum Attribute
         * 3. по названию атрибута получается значение атрибута из mAttributesMap
         * 4. если атрибут собирается увеличиться и у персонажа достаточно очков для увеличения атрибута (mAvailablePoints)
         *    или
         *    если атрибут собирается уменьшиться и уменьшенный атрибут будет больше 0,
         *    то атрибут изменяется, количество доступных очков меняется в противоположную сторону.
         *
         * 5. убедитесь в том, что измененное значение атрибута записано в mAttributesMap
         * 6. убедитесь в том, что измененное значение количества очков записано в mAvailablePoints;
         * 7. после изменения нужно вызвать методы setChanged(); notifyObservers();
         *    для того, чтобы изменения отразились на верстке
         *
         * пример работы алгоритма.
         * на вход подается (0, -1)
         * из значения 0 выясняем, что меняться будет атрибут STRENGTH
         * получаем текущее значение этого атрибута из mAttributesMap
         * допустим, оно равно 3
         * по условию все алгоритма все проходит
         * сила уменьшается до 2, количество доступных очков увеличивается на +1
         *
         * если STRENGTH равно 1, то ничего не происходит,
         * так как мы не можем уменьшить атрибут ниже 1
         *
         * если на вход пришло (0, 1)
         *   если доступных очков больше 0,
         *       то STRENGTH увеличивается на 1, количество доступных очков уменьшается на 1
         *   если количество доступных очков равно 0
         *       то мы не можем увеличить атрибут, ничего не происходит        *
         * */

        if (position < 0) {
            position = 0;
        } else if (position > Attribute.values().length - 1) {
            position = Attribute.values().length - 1;
        }
        Attribute CurrentAttribute = null;
        int CurrentAttributePoint;
        for (Attribute attribute : Attribute.values()) {
            if (attribute.ordinal() == position) {
                CurrentAttribute = attribute;
            }
        }
        CurrentAttributePoint = mAttributesMap.get(CurrentAttribute.toString());
        if (updateTo < 0) {
            for (int i = 0; i > updateTo; i--) {
                if (CurrentAttributePoint > 1) {
                    CurrentAttributePoint--;
                    mAvailablePoints++;
                }
            }
        } else if (updateTo > 0 && mAvailablePoints > 0) {
            for (int i = 0; i < updateTo; i++) {
                if (mAvailablePoints != 0) {
                    CurrentAttributePoint++;
                    mAvailablePoints--;
                }
            }
        }
        mAttributesMap.put(CurrentAttribute.toString(), CurrentAttributePoint);
        setChanged();
        notifyObservers();
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAvailablePoints() {
        return String.valueOf(mAvailablePoints);
    }

    public Map<String, Integer> getAttributesMap() {
        return mAttributesMap;
    }

    public void checkPerk(String text, boolean isChecked) {
        mPerksMap.put(text, isChecked);
    }

    public Character create() {
        Character character = new Character();
        character.setName(mName);
        character.setRace(mRace);
        character.setSpecialization(mSpecialization);
        character.setAttributes(mAttributesMap);
        character.setPerks(mPerksMap);
        character.calculateParameters();
        return character;
    }

    public Specialization getSpecialization() {
        return mSpecialization;
    }

    public Race getRace() {
        return mRace;
    }

    public Map<String, Boolean> getPerksMap() {
        return mPerksMap;
    }

    public void setAvailablePoints(int availablePoints) {
        mAvailablePoints = availablePoints;
    }

    public int getRacePosition() {
        return mRace.ordinal();
    }

    public int getSpecializationPosition() {
        return mSpecialization.ordinal();
    }
}
