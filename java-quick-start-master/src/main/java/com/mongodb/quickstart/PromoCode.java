package com.mongodb.quickstart;

import java.util.Scanner;

public class PromoCode {
    public void promoCode(){

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.println("Add a promo code          ( 1 )");
            System.out.println("Delete a promo code       ( 2 )");
            System.out.println("Add special a promo code  ( 3 )");
            System.out.println("View all promo codes      ( 4 )");
            System.out.println("Quit                      ( q )");

            char choice;
            choice = sc.next().charAt(0);

            if(choice == '1'){

            }
            else if(choice == '2'){

            }
            else if(choice == '3'){

            }
            else if(choice == 'q'){
                break;
            }
            else{
                System.out.println("You entered a wrong key!");
            }
        }
    }
}
