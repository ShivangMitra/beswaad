package com.mongodb.quickstart;

import java.util.Scanner;

public class Beswaad {
    public static void main(String []args)throws Exception{

        Scanner sc = new Scanner(System.in);

        System.out.println("\n" +
                " /$$$$$$$                                                              /$$\n" +
                "| $$__  $$                                                            | $$\n" +
                "| $$  \\ $$  /$$$$$$   /$$$$$$$ /$$  /$$  /$$  /$$$$$$   /$$$$$$   /$$$$$$$\n" +
                "| $$$$$$$  /$$__  $$ /$$_____/| $$ | $$ | $$ |____  $$ |____  $$ /$$__  $$\n" +
                "| $$__  $$| $$$$$$$$|  $$$$$$ | $$ | $$ | $$  /$$$$$$$  /$$$$$$$| $$  | $$\n" +
                "| $$  \\ $$| $$_____/ \\____  $$| $$ | $$ | $$ /$$__  $$ /$$__  $$| $$  | $$\n" +
                "| $$$$$$$/|  $$$$$$$ /$$$$$$$/|  $$$$$/$$$$/|  $$$$$$$|  $$$$$$$|  $$$$$$$\n" +
                "|_______/  \\_______/|_______/  \\_____/\\___/  \\_______/ \\_______/ \\_______/\n" +
                "                                                                          \n" +
                "                                                                          \n" +
                "                                                                          \n");


        Login userLogin = new Login();
        String username;
        username = userLogin.userLogin();

        if(username.equals("Admin")){
            System.out.println("\n" +
                    " __          __  _                                        _           _       \n" +
                    " \\ \\        / / | |                              /\\      | |         (_)      \n" +
                    "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___     /  \\   __| |_ __ ___  _ _ __  \n" +
                    "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   / /\\ \\ / _` | '_ ` _ \\| | '_ \\ \n" +
                    "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/  / ____ \\ (_| | | | | | | | | | |\n" +
                    "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___| /_/    \\_\\__,_|_| |_| |_|_|_| |_|\n" +
                    "                                                                              \n");

            while (true) {

                char choice;

                System.out.println("Check Revenue   ( 1 )");
                System.out.println("Check Warehouse ( 2 )");
                System.out.println("PROMO Codes     ( 3 )");
                System.out.println("Check Menu      ( 4 )");
                System.out.println("Employee Status ( 5 )");
                System.out.println("Users Signed Up ( 6 )");

                choice = sc.next().charAt(0);

                if(choice == '1'){
                    Read adminRevenue = new Read();
                    adminRevenue.adminRevenue();
                }
                else if(choice == '2'){
                    //Warehouse
                }
                else if(choice == '3'){
                    //PROMO Codes
                }
                else if(choice == '4'){
                    //Menu
                }
                else if(choice == '5'){
                    //Employee
                }
                else if(choice == '6'){
                    //Users
                }
                else {
                    System.out.println("You pressed a wrong key!");
                }
            }
        }
        else{
            System.out.println("\n" +
                    " __          __  _                          \n" +
                    " \\ \\        / / | |                         \n" +
                    "  \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___ \n" +
                    "   \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\\n" +
                    "    \\  /\\  /  __/ | (_| (_) | | | | | |  __/\n" +
                    "     \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|\n" +
                    "                                            \n" +
                    "                                            \n");
        }
    }
}
