package com.example.TextAnalyzer.model;

import java.util.HashMap;
import java.util.Map;

public final class MapCyrillicLatin {
    public Map<Character, Character> cyrillicLatinMap;

    public MapCyrillicLatin() {
        cyrillicLatinMap = new HashMap<>();
            cyrillicLatinMap.put('й', 'q');
            cyrillicLatinMap.put('ц', 'w');
            cyrillicLatinMap.put('у', 'e');
            cyrillicLatinMap.put('к', 'r');
            cyrillicLatinMap.put('е', 't');
            cyrillicLatinMap.put('н', 'y');
            cyrillicLatinMap.put('г', 'u');
            cyrillicLatinMap.put('ш', 'i');
            cyrillicLatinMap.put('щ', 'o');
            cyrillicLatinMap.put('з', 'p');
            cyrillicLatinMap.put('ф', 'a');
            cyrillicLatinMap.put('і', 's');
            cyrillicLatinMap.put('в', 'd');
            cyrillicLatinMap.put('а', 'f');
            cyrillicLatinMap.put('п', 'g');
            cyrillicLatinMap.put('р', 'h');
            cyrillicLatinMap.put('о', 'j');
            cyrillicLatinMap.put('л', 'k');
            cyrillicLatinMap.put('д', 'l');
            cyrillicLatinMap.put('я', 'z');
            cyrillicLatinMap.put('ч', 'x');
            cyrillicLatinMap.put('с', 'c');
            cyrillicLatinMap.put('м', 'v');
            cyrillicLatinMap.put('и', 'b');
            cyrillicLatinMap.put('т', 'n');
            cyrillicLatinMap.put('ь', 'm');

            cyrillicLatinMap.put('[', 'х');
            cyrillicLatinMap.put(']', 'ї');
            cyrillicLatinMap.put(';', 'ж');
            cyrillicLatinMap.put('\'', 'є');
            cyrillicLatinMap.put(',', 'б');
            cyrillicLatinMap.put('.', 'ю');
            cyrillicLatinMap.put('/', '.');
            cyrillicLatinMap.put('\\', 'ʼ');
            cyrillicLatinMap.put('"', '"');
    }



}
