package com.example.foodapp.f_data;
import com.example.foodapp.R;

import java.util.ArrayList;

public class f_data {
    public static ArrayList<ArrayList<String>> food_data = new ArrayList<ArrayList<String>>() {
        {
            add(new ArrayList<>());
            get(0).add("Cheeseburger");
            get(0).add("Beef");
            get(0).add("Lettuce");
            get(0).add("Tomato");
            get(0).add("Cheese");
            get(0).add("Bun");
            get(0).add("Onion");
            add(new ArrayList<>());
            get(1).add("Fries");
            get(1).add("Potatoes");
            get(1).add("Vegetable Oil");
            get(1).add("Salt");
            add(new ArrayList<>());
            get(2).add("Cake");
            get(2).add("Milk");
            get(2).add("Sugar");
            get(2).add("Eggs");
            get(2).add("Flour");
            get(2).add("Vanilla");
            get(2).add("Butter");
            get(2).add("Baking Powder");
            add(new ArrayList<>());
            get(3).add("Pizza");
            get(3).add("Tomato Sauce");
            get(3).add("Cheese");
            get(3).add("Flour");
            get(3).add("Dough");
            get(3).add("Sausage");
            get(3).add("Onion");
            get(3).add("Pepperoni");
            get(3).add("Olive Oil");
            get(3).add("Basil");
            add(new ArrayList<>());
            get(4).add("Fried Rice");
            get(4).add("Carrots");
            get(4).add("Green Peas");
            get(4).add("Vegetable Oil");
            get(4).add("Eggs");
            get(4).add("Soy Sauce");
            get(4).add("White Rice");
            add(new ArrayList<>());
            get(5).add("Pancakes");
            get(5).add("Flour");
            get(5).add("Sugar");
            get(5).add("Baking Powder");
            get(5).add("Salt");
            get(5).add("Milk");
            get(5).add("Butter");
            get(5).add("Eggs");
            get(5).add("Vanilla");
            add(new ArrayList<>());
            get(6).add("Burrito");
            get(6).add("Beef");
            get(6).add("Onion");
            get(6).add("Beans");
            get(6).add("Rice");
            get(6).add("Cheese");
            get(6).add("Green Chili");
            get(6).add("Tortilla");
            add(new ArrayList<>());
            get(7).add("Sushi");
            get(7).add("Rice");
            get(7).add("Vinegar");
            get(7).add("Seaweed");
            get(7).add("Salmon");
            get(7).add("Avocado");
            get(7).add("Soy Sauce");
            get(7).add("Wasabi");
            add(new ArrayList<>());
            get(8).add("Taco");
            get(8).add("Beef");
            get(8).add("Onion");
            get(8).add("Tomato");
            get(8).add("Cheese");
            get(8).add("Salsa");
            get(8).add("Chili Pepper");
            get(8).add("Avocado");
            get(8).add("Tortilla");
            add(new ArrayList<>());
            get(9).add("French Toast");
            get(9).add("Bread");
            get(9).add("Eggs");
            get(9).add("Milk");
            get(9).add("Butter");
            get(9).add("Cinnamon");
            get(9).add("Vanilla");
            get(9).add("Syrup");
            add(new ArrayList<>());
            get(10).add("Pho");
            get(10).add("Beef");
            get(10).add("Bouillon");
            get(10).add("Rice Noodles");
            get(10).add("Chili Pepper");
            get(10).add("Coriander");
            get(10).add("Scallion");
            get(10).add("Onion");
            get(10).add("Ginger");
            add(new ArrayList<>());
            get(11).add("Lasagna");
            get(11).add("Sausage");
            get(11).add("Beef");
            get(11).add("Onion");
            get(11).add("Garlic");
            get(11).add("Tomatoes");
            get(11).add("Tomato Sauce");
            get(11).add("Cheese");
            get(11).add("Lasagna Noodles");
            add(new ArrayList<>());
            get(12).add("Donuts");
            get(12).add("Milk");
            get(12).add("Yeast");
            get(12).add("Sugar");
            get(12).add("Eggs");
            get(12).add("Butter");
            get(12).add("Vanilla");
            get(12).add("Nutmeg");
            get(12).add("Flour");
            get(12).add("Butter");
            add(new ArrayList<>());
            get(13).add("Quesadilla");
            get(13).add("Chicken");
            get(13).add("Cheese");
            get(13).add("Tortilla");
            get(13).add("Salsa");
            get(13).add("Bell Pepper");
            get(13).add("Vegetable Oil");
            get(13).add("Avocado");
            add(new ArrayList<>());
            get(14).add("Fried Chicken");
            get(14).add("Chicken");
            get(14).add("Vegetable Oil");
            get(14).add("Flour");
            get(14).add("Onion");
            get(14).add("Garlic");
            get(14).add("Buttermilk");
            add(new ArrayList<>());
            get(15).add("Chicken Curry");
            get(15).add("Coconut Milk");
            get(15).add("Chili pepper");
            get(15).add("Curry Powder");
            get(15).add("Onion");
            get(15).add("Chicken");
            get(15).add("Garlic");
            get(15).add("Coriander");
            add(new ArrayList<>());
            get(16).add("dummy");
            get(16).add("i");


        }
    };
    public static String[] food_list = {"dummy","Pizza"};
    public static int[] img_list = {R.drawable.bgblue,R.drawable.pizza};
    // Input an arraylist of ingredients, output will be an arraylist of the
    // possible foods made with those ingredients
    public static ArrayList<String> availableFoods(ArrayList<String> ingredients) {
        ArrayList<String> foods = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < food_data.size(); i++) {
            count = 0;
            for (int j = 1; j < food_data.get(i).size(); j++) {
                for (int k = 0; k < ingredients.size(); k++) {
                    if (food_data.get(i).get(j) == ingredients.get(k)) {
                        count++;
                    }
                }
            }

            if (count == ingredients.size()) {
                foods.add(food_data.get(i).get(0));
            }
        }

        return foods;
    }

    // input is an arraylist of ingredients, output is an arraylist of foods that
    // contains one of those ingredients
    public static ArrayList<String> containsIngredient(ArrayList<String> ingredients) {
        ArrayList<String> foods = new ArrayList<>();
        boolean done = false;
        for (int i = 0; i < food_data.size(); i++) {
            done = false;
            for (int j = 1; j < food_data.get(i).size(); j++) {
                for (int k = 0; k < ingredients.size(); k++) {
                    if (food_data.get(i).get(j) == ingredients.get(k)) {
                        foods.add(food_data.get(i).get(0));
                        done = true;
                    }
                }
                if (done) {
                    break;
                }
            }
        }

        return foods;
    }

    // input is a list of ingredients, output is a list of foods that can be made
    // with those ingredients (list contains all of the required ingredients)
    public static ArrayList<String> canMakeFood(ArrayList<String> ingredients) {
        ArrayList<String> foods = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < food_data.size(); i++) {
            count = 0;
            for (int j = 1; j < food_data.get(i).size(); j++) {
                for (int k = 0; k < ingredients.size(); k++) {
                    if (food_data.get(i).get(j).equals(ingredients.get(k))) {
                        count++;
                    }
                }
            }

            if (count == food_data.get(i).size() - 1) {
                foods.add(food_data.get(i).get(0));
            }
        }

        return foods;
    }

    // input a food, output an arraylist of its ingredients. Will return empty
    // arrayList if food not in database
    public static ArrayList<String> listIngredients(String food) {
        ArrayList<String> ings = new ArrayList<>();
        for (int i = 0; i < food_data.size(); i++) {
            if (food == food_data.get(i).get(0)) {
                for (int j = 1; j < food_data.get(i).size(); j++) {
                    ings.add(food_data.get(i).get(j));
                }
            }
        }
        return ings;
    }
    public static int[] getImages(String[] Foods){
        int[] images = new int[Foods.length];
        for (int i =0 ; i <Foods.length;i++){
            for (int j =0; j < food_list.length; j++){
                if(Foods[i].equals(food_list[j])){
                    images[i]=img_list[j];
                }
            }
        }
        return images;
    }


}
