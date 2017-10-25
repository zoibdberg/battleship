/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

import java.util.*;
import java.lang.*;

/**
 *
 * @author artem
 */
public class Test1 {

    public static int X = 0;
    public static int Y = 0;
    public static int value1 = 20;
    public static int value2 = 20;

    public static void ZeroingOut(char[][] fild_1, char[][] fild_2) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                fild_1[i][j] = ' ';
                fild_2[i][j] = ' ';
            }
        }
    }

    public static void OutputFild_1(char[][] fild_1) {

        System.out.println("****You fild****\n");

        System.out.println("   0123456789   ");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                System.out.print(fild_1[i][j]);
            }
            System.out.println("| " + i);
        }
        System.out.println("   0123456789   ");
    }

    public static void OutputFild_2(char[][] fild_2) {

        System.out.println("**** Welcom to Battle Ships game ****\n\n");

        System.out.println("   0123456789   ");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                System.out.print(fild_2[i][j]);
            }
            System.out.println("| " + i);
        }
        System.out.println("   0123456789   ");
    }

    public static void EnterCoordinate(String type) {
        System.out.println("Введите каординаты " + type);
        Scanner input = new Scanner(System.in);
        System.out.print("Y = ");
        X = input.nextInt();
        System.out.print("X = ");
        Y = input.nextInt();
    }

    public static void DeployPlayerShips(char[][] fild_1) {
        if (X <= 10 && Y <= 10 && X >= 0 
                && X >= 0 && fild_1[X][Y] != 'X' 
                && fild_1[X][Y] != '@') {
            fild_1[X][Y] = 'X';
        } else {
            System.out.println("Error, enter x < 11, y < 11");

        }

    }

    public static boolean BooleanRand() {
        return new Random().nextBoolean();
    }

    public static boolean Chek(int size, int x, int y, char[][] fild, boolean a) {

        if (a == true) {
            for (int i = x; i < x + size; i++) {
                if (fild[i][y] == 'X') {
                    return false;
                }
            }
            if (a == false) {
                for (int i = y; i < y + size; i++) {
                    if (fild[x][i] == 'X') {
                        return false;
                    }
                }
            }
        }
        return true;

    }

    public static void Ship(int size, char[][] fild_2) {
        
        Random rand = new Random();

        int x;
        int y;

        boolean a = BooleanRand();

        if (a == true) {
            x = rand.nextInt(5);
            y = rand.nextInt(9);

            while (Chek(size, x, y, fild_2, a) != true) {
                x = rand.nextInt(5);
                y = rand.nextInt(9);
            }

            for (int i = x; i < x + size; i++) {
                fild_2[i][y] = 'X';
            }
        }

        if (a == false) {
            x = rand.nextInt(9);
            y = rand.nextInt(5);

            while (Chek(size, x, y, fild_2, a) != true) {
                x = rand.nextInt(9);
                y = rand.nextInt(5);
            }
            for (int i = y; i < y + size; i++) {
                fild_2[x][i] = 'X';
            }
        }
    }
    
    public static boolean Win(){
        if (value1 >= 0 && value2 >= 0) return false;
        else return true;
    }
    
    public static void PlayerAttack(char [][] fild){
    EnterCoordinate("атакуемых позиций");
    if (fild[X][Y] == 'X') {
        fild[X][Y] = '*';
        value1--;
    }
    else if (fild[X][Y] == ' ') {
        fild[X][Y] = '@';
    }else{
        fild[X][Y] = '$';
    }
}

    public static void ComputerAttack(char[][] fild){
        Random rand = new Random();
        X = rand.nextInt(9);
        Y = rand.nextInt(9);
        
        if(fild[X][Y] == 'X'){
           fild[X][Y] = '*';
           value2--;
        }
        else if (fild[X][Y] == ' '){
            fild[X][Y] = '@';
        }else{
            fild[X][Y] = 'S';
        }
    }
    public static void main(String[] args) {
        char[][] fild_1 = new char[10][10];
        char[][] fild_2 = new char[10][10];

        ZeroingOut(fild_1, fild_2);

        //ComputerShipsDeploy(fild_2);
        Ship(4, fild_2);
        Ship(3, fild_2);
        Ship(3, fild_2);
        Ship(2, fild_2);
        Ship(2, fild_2);
        Ship(2, fild_2);
        Ship(1, fild_2);
        Ship(1, fild_2);
        Ship(1, fild_2);
        Ship(1, fild_2);
//Удалить, это чит
        OutputFild_2(fild_2);

        for (int i = 0; i < 20; i++) {
            OutputFild_1(fild_1);
            EnterCoordinate("корабля");
            DeployPlayerShips(fild_1);
        }
        
        while(Win() != true){
            OutputFild_2(fild_2);
            PlayerAttack(fild_2);
            if (value2 <= 0){
                System.out.println("Computer win!");
                       System.exit(0);
            }
            ComputerAttack(fild_1);
            if (value1 <= 1){
                System.out.println("\n\n****You win!****");
                       System.exit(0);
            }
        }
        
    }

}

/************************************************************
 * 1.Возможность расставлять корабли где хочешь.
 * 2.Отсутсвие возможности стереть корабли.
 * 3.
 * 4.
 ************************************************************/