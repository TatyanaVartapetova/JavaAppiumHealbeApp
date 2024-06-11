package lib.dictionary;

import java.util.HashMap;

public class Ru {
    public static void main(String[] args) {

        HashMap<String, String> ruDictionary = new HashMap<>();
        ruDictionary.put("onb_1_title", "Настройтесь на своё тело");
        ruDictionary.put("onb_1_desc", "Улучшайте питание и весь образ жизни, опираясь на точные данные");
        ruDictionary.put("onb_1_bttn", "НАЧАТЬ");
        ruDictionary.put("onb_2_title", "Найдите идеальный баланс");
        ruDictionary.put("onb_2_desc", "Обретите полное понимание того, как привычки влияют на вас");
        ruDictionary.put("onb_2_bttn", "ВПЕРЁД!");


        ruDictionary.entrySet();

    }


}



//        switch (Locale){
//            case "Ru" :
//                Ru.entrySet();
//                break;
//            case "En" :
//                System.out.println("english");
//                break;
//        }



