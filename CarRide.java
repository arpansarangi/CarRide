package com.mycompany.arabella;
import java.util.*; 
public class NewClass{
    public static void main(String[] args)
    {
        //INITIALIZE ALL OF THE DRIVER OBJECTS HERE
        Map<Integer, Character> alpha = new HashMap<Integer, Character>();//Assigns the value 1 to 'a', 2 to 'b' and so on...
        Map<String, Integer> myMap = new HashMap<String, Integer>();//Assigns the value 1 to "aa", 2 to "ab' and so on...
        int [][]dp = new int[39][39];
        floydWarshall(alpha,myMap,dp);
        //dp[i][j] now holds the shortest path between vertice i and j.
    }
    static void floydWarshall(Map<Integer, Character> alpha, Map<String, Integer> myMap, int[][] dp)
    {
        //To map alphabets to integers {a,1},{b,2}....
        int k = 1;
        for(char x = 'a'; x <= 'z'; x++)
            alpha.put(k++,x);
        //To give all of the Strings a certain value
        k = 1;
        for(int i = 1; i <= 2; i++)
        {
            for(int j = 0; j < 26; j++)
            {
                //assign values to the strings {aa,1},{ab,2}...
                char[] ch = {alpha.get(i),alpha.get(j+1)};
                String s = new String(ch);
                myMap.put(s,k++);
            }
        }
        for(int i = 1; i <= 38; i++)
        {
            for(int j = 1; j <= 38; j++)
            {
                if(i == j)
                    dp[i][j] = 0;
                else
                    dp[i][j] = 200000000;//2e9 corresponds to infinity
            }
        }
        //Let's give the values of every adjacent vertice as input
        dp[myMap.get("aa")][myMap.get("ab")] =  242;
        dp[myMap.get("aa")][myMap.get("aq")] =  308;
        dp[myMap.get("aa")][myMap.get("ao")] =  525;
        dp[myMap.get("ab")][myMap.get("ac")] =  93;
        dp[myMap.get("ab")][myMap.get("ar")] =  75;
        dp[myMap.get("ab")][myMap.get("aa")] =  242;
        dp[myMap.get("ac")][myMap.get("as")] =  75;
        dp[myMap.get("ac")][myMap.get("ad")] =  101;
        dp[myMap.get("ac")][myMap.get("ad")] =  609;
        dp[myMap.get("ad")][myMap.get("ac")] =  101;
        dp[myMap.get("ad")][myMap.get("ae")] =  103;
        dp[myMap.get("ad")][myMap.get("bh")] =  60;
        dp[myMap.get("ae")][myMap.get("af")] =  100;
        dp[myMap.get("ae")][myMap.get("bi")] =  90;
        dp[myMap.get("ae")][myMap.get("ad")] =  103;
        dp[myMap.get("af")][myMap.get("ag")] =  84;
        dp[myMap.get("af")][myMap.get("bj")] =  83;
        dp[myMap.get("af")][myMap.get("ae")] =  100;
        dp[myMap.get("ag")][myMap.get("ah")] =  609;
        dp[myMap.get("ag")][myMap.get("af")] =  84;
        dp[myMap.get("ah")][myMap.get("ag")] =  609;
        dp[myMap.get("ah")][myMap.get("bj")] =  73;
        dp[myMap.get("ah")][myMap.get("ai")] =  128;
        dp[myMap.get("ai")][myMap.get("aj")] =  30;
        dp[myMap.get("ai")][myMap.get("bd")] =  89;
        dp[myMap.get("ai")][myMap.get("ah")] =  128;
        dp[myMap.get("aj")][myMap.get("ai")] =  30;
        dp[myMap.get("aj")][myMap.get("ak")] =  74;
        dp[myMap.get("aj")][myMap.get("bc")] =  50;
        dp[myMap.get("ak")][myMap.get("al")] =  354;
        dp[myMap.get("ak")][myMap.get("aj")] =  74;
        dp[myMap.get("ak")][myMap.get("bb")] =  92;
        dp[myMap.get("al")][myMap.get("ak")] =  354;
        dp[myMap.get("al")][myMap.get("am")] =  130;
        dp[myMap.get("al")][myMap.get("ba")] =  127;
        dp[myMap.get("am")][myMap.get("al")] =  130;
        dp[myMap.get("am")][myMap.get("an")] =  84;
        dp[myMap.get("am")][myMap.get("ba")] =  122;
        dp[myMap.get("an")][myMap.get("am")] =  84;
        dp[myMap.get("an")][myMap.get("ao")] =  249;
        dp[myMap.get("an")][myMap.get("az")] =  152;
        dp[myMap.get("ao")][myMap.get("an")] =  249;
        dp[myMap.get("ao")][myMap.get("ap")] =  188;
        dp[myMap.get("ao")][myMap.get("aa")] =  525;
        dp[myMap.get("ap")][myMap.get("ao")] =  188;
        dp[myMap.get("ap")][myMap.get("av")] =  11;
        dp[myMap.get("ap")][myMap.get("aq")] =  94;
        dp[myMap.get("aq")][myMap.get("aa")] =  308;
        dp[myMap.get("aq")][myMap.get("at")] =  89;
        dp[myMap.get("aq")][myMap.get("ar")] =  70;
        dp[myMap.get("aq")][myMap.get("ap")] =  94;
        dp[myMap.get("ar")][myMap.get("aq")] =  70;
        dp[myMap.get("ar")][myMap.get("as")] =  89;
        dp[myMap.get("ar")][myMap.get("ab")] =  75;
        dp[myMap.get("as")][myMap.get("ar")] =  89;
        dp[myMap.get("as")][myMap.get("at")] =  70;
        dp[myMap.get("as")][myMap.get("ac")] =  75;
        dp[myMap.get("as")][myMap.get("bh")] =  87;
        dp[myMap.get("at")][myMap.get("as")] =  70;
        dp[myMap.get("at")][myMap.get("aq")] =  89;
        dp[myMap.get("at")][myMap.get("au")] =  74;
        dp[myMap.get("at")][myMap.get("bg")] =  86;
        dp[myMap.get("au")][myMap.get("at")] =  74;
        dp[myMap.get("au")][myMap.get("av")] =  78;
        dp[myMap.get("au")][myMap.get("ax")] =  66;
        dp[myMap.get("au")][myMap.get("bf")] =  88;
        dp[myMap.get("av")][myMap.get("au")] =  78;
        dp[myMap.get("av")][myMap.get("aw")] =  81;
        dp[myMap.get("av")][myMap.get("ap")] =  11;
        dp[myMap.get("aw")][myMap.get("av")] =  81;
        dp[myMap.get("aw")][myMap.get("ax")] =  79;
        dp[myMap.get("aw")][myMap.get("ay")] =  123;
        dp[myMap.get("ax")][myMap.get("aw")] =  79;
        dp[myMap.get("ax")][myMap.get("ay")] =  65;
        dp[myMap.get("ax")][myMap.get("au")] =  66;
        dp[myMap.get("ax")][myMap.get("be")] =  91;
        dp[myMap.get("ay")][myMap.get("aw")] =  123;
        dp[myMap.get("ay")][myMap.get("ax")] =  65;
        dp[myMap.get("ay")][myMap.get("az")] =  63;
        dp[myMap.get("ay")][myMap.get("bd")] =  107;
        dp[myMap.get("az")][myMap.get("ay")] =  63;
        dp[myMap.get("az")][myMap.get("bc")] =  75;
        dp[myMap.get("az")][myMap.get("an")] =  151;
        dp[myMap.get("ba")][myMap.get("al")] =  127;
        dp[myMap.get("ba")][myMap.get("bb")] =  66;
        dp[myMap.get("ba")][myMap.get("am")] =  122;
        dp[myMap.get("bb")][myMap.get("ba")] =  66;
        dp[myMap.get("bb")][myMap.get("bc")] =  51;
        dp[myMap.get("bb")][myMap.get("ak")] =  92;
        dp[myMap.get("bc")][myMap.get("aj")] =  50;
        dp[myMap.get("bc")][myMap.get("bb")] =  51;
        dp[myMap.get("bc")][myMap.get("az")] =  75;
        dp[myMap.get("bd")][myMap.get("ai")] =  89;
        dp[myMap.get("bd")][myMap.get("bj")] =  116;
        dp[myMap.get("bd")][myMap.get("be")] =  56;
        dp[myMap.get("bd")][myMap.get("ay")] =  107;
        dp[myMap.get("be")][myMap.get("bd")] =  56;
        dp[myMap.get("be")][myMap.get("bf")] =  48;
        dp[myMap.get("be")][myMap.get("ax")] =  91;
        dp[myMap.get("bf")][myMap.get("be")] =  48;
        dp[myMap.get("bf")][myMap.get("bg")] =  46;
        dp[myMap.get("bf")][myMap.get("au")] =  88;
        dp[myMap.get("bg")][myMap.get("bf")] =  46;
        dp[myMap.get("bg")][myMap.get("bh")] =  67;
        dp[myMap.get("bg")][myMap.get("bi")] =  77;
        dp[myMap.get("bg")][myMap.get("at")] =  86;
        dp[myMap.get("bh")][myMap.get("bg")] =  67;
        dp[myMap.get("bh")][myMap.get("ad")] =  60;
        dp[myMap.get("bh")][myMap.get("as")] =  87;
        dp[myMap.get("bi")][myMap.get("bg")] =  77;
        dp[myMap.get("bi")][myMap.get("bj")] =  69;
        dp[myMap.get("bi")][myMap.get("ae")] =  90;
        dp[myMap.get("bj")][myMap.get("ah")] =  73;
        dp[myMap.get("bj")][myMap.get("af")] =  83;
        dp[myMap.get("bj")][myMap.get("bi")] =  69;
        dp[myMap.get("bj")][myMap.get("bd")] =  116;
        
        for(int s = 1; s <= 38; s++)
        {
            for(int i = 1; i <= 38; i++)
            {
                for(int j = 1; j <= 38; j++)
                {
                    dp[i][j] = Math.min(dp[i][j],dp[i][s]+dp[s][j]); 
                }
            }
        }
        //dp[i][j] now has the shortest distance between vertice i and j
    }
}
