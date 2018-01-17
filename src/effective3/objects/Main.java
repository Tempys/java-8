package effective3.objects;

import effective3.objects.NutritionFacts.Builder;

import java.util.EnumSet;

public class Main {

  //  EnumSet<String> a = EnumSet.of("a","b")

    public static void main(String[] args) {

        NutritionFacts facts = new NutritionFacts.Builder(240, 8).build();
        System.out.println(facts.getCalories());

    }
}
