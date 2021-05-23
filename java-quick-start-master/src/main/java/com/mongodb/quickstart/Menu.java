package com.mongodb.quickstart;

import org.json.simple.JSONObject;

import java.util.Scanner;

public class Menu {
    public void menu(){
        Scanner sc = new Scanner(System.in);

        Read adminMenu = new Read();
        adminMenu.adminMenu();

        while(true){
            System.out.println("Add a new item to the menu    ( 1 )");
            System.out.println("Update an item in the menu    ( 2 )");
            System.out.println("Remove an item from the menu  ( 3 )");
            System.out.println("Display the menu again        ( 4 )");
            System.out.println("Quit                          ( q )");

            char choice;
            choice = sc.next().charAt(0);

            if(choice == '1'){
                String name, region, type;
                int price, selectionNum;
                JSONObject ingredients = new JSONObject();

                System.out.println("Enter the name of the Item:");
                sc.nextLine();
                name = sc.nextLine();
                System.out.println("Enter the origin region of the Item:");
                region = sc.next();
                System.out.println("Enter the type of Item:");
                type = sc.next();
                System.out.println("Enter the price of the Item:");
                price = sc.nextInt();
                System.out.println("Enter the selection number of the Item:");
                selectionNum = sc.nextInt();
                System.out.println("Enter the ingredients required for the Item:");
                while(true){
                    System.out.println("Add ingredient ( 1 )");
                    System.out.println("Quit           ( q )");

                    char ingChoice;
                    ingChoice = sc.next().charAt(0);
                    if(ingChoice == '1'){
                        String ing;
                        int val;
                        System.out.println("Enter name of ingredient");
                        sc.nextLine();
                        ing = sc.nextLine();
                        System.out.println("Enter the amount of it needed to create the Item");
                        val = sc.nextInt();
                        ingredients.put(ing, val);
                    }
                    else if(ingChoice == 'q'){
                        break;
                    }
                    else{
                        System.out.println("You pressed a wrong key!");
                    }
                }

                System.out.println("Please wait . . .");

                Create addItemToMenu = new Create();
                addItemToMenu.addItemToMenu(name, true, true, region, type, price, selectionNum, ingredients);
            }
            else if(choice == '2'){
                String name;
                System.out.println("Enter the name of the item you want to update:");
                sc.nextLine();
                name = sc.nextLine();

                Update updateItem = new Update();
                updateItem.updateItem(name);
            }
            else if(choice == '3'){

                String itemName;
                System.out.println("Enter the name of the Item:");
                sc.nextLine();
                itemName = sc.nextLine();

                Delete deleteItem = new Delete();
                deleteItem.deleteItem(itemName);
            }
            else if(choice == '4'){
                adminMenu.adminMenu();
            }
            else if(choice == 'q'){
                break;
            }
            else{
                System.out.println("You pressed a wrong key!\n( Choose with 1 or 2 )");
            }
        }
    }
}
