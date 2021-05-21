package com.mongodb.quickstart;

import java.util.*;

public class Login {

    public static void main(String []args){

        Scanner sc = new Scanner(System.in);

        while(true) {

            char signIn;
            System.out.println("Sign In (1) / Sign Up (2)");
            signIn = sc.next().charAt(0);

            if (signIn == '1') {
                String username, password;

                System.out.println("Enter your username: ");
                sc.nextLine();
                username = sc.nextLine();

                System.out.println("Enter your password: ");
                password = sc.nextLine();

                Read readUser = new Read();
                System.out.println("Please Wait . . .");
                if(readUser.readUser(username, password)) {
                    System.out.println("Welcome " + username);
                    break;
                }
            } else if (signIn == '2') {
                String username, password, confPassword;

                System.out.println("Enter your username: ");
                sc.nextLine();
                username = sc.nextLine();

                System.out.println("Enter your password: ");
                password = sc.nextLine();

                System.out.println("Enter confirm password: ");
                confPassword = sc.nextLine();

                if(password.equals(confPassword)){
                    Create userCreate = new Create();
                    userCreate.createUser(username, password);
                    System.out.println("Your account has been created, please proceed to login");
                }
                else {
                    System.out.println("Passwords do not match! (Try again)");
                }
            } else {
                System.out.println("You pressed a wrong key! (Choose from 1 or 2)");
            }
        }
    }
}
