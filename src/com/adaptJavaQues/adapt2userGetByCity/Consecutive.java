package com.adaptJavaQues.adapt2userGetByCity;

import java.util.HashSet;
import java.util.Set;

public class Consecutive {

    public static void main(String[] args) {
        String str = "whereabouts";
        char [] charArr = str.toCharArray();
        for (int i=0 ; i<charArr.length ; i++) {
            if (charArr[i] == 'a' || charArr[i] == 'e' || charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
                charArr[i] = 'V';
            } else {
                charArr[i] = 'C';
            }
        }

        for (char ch: charArr) {
            System.out.print(ch);
        }
        System.out.println();
        char C ='C';
        char V = 'V';

        char [] charArrClone = charArr.clone();
        // CCVCVVCVVCC
        // CCVCVVCVVCC

        // || charArr[i+1] != 'C'    || charArr[i] != 'V'
        for (int i=0; i<charArr.length ;i++) {


            if (i == 0) {
                if(charArr[i] == 'C' || charArr[i] == 'V') {
                     System.out.print(charArr[i]);
                }
            }


            else if (charArr[i] == 'C') {
                 if (  charArr[i-1] == 'C' || charArr[i+1] == 'C') {
                     System.out.print("");
                 } else
                     System.out.print('C');
            }


            else if (charArr[i] == 'V') {
                if (charArr[i-1] == 'V' || charArr[i+1] == 'V') {
                    System.out.print("");
                } else
                    System.out.print('V');

            } else if (i == charArr.length-1) {
                    if(charArr[i] == 'C') {
                        if (  charArr[i-1] == 'C') {
                            System.out.print("");
                        } else
                            System.out.print('C');
                    } else if (charArr[i] == 'V') {
                        if (  charArr[i-1] == 'V') {
                            System.out.print("");
                        } else
                            System.out.print('V');
                    }
                } else
                    System.out.print('V');
            }
        }


    }



