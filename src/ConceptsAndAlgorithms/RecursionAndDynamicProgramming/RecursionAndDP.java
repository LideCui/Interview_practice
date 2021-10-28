package ConceptsAndAlgorithms.RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

public class RecursionAndDP {
    /**
     * calculate fib by Top-down DP
     */
    public static int fibonacci(int n){
        return fib(n, new int[n+1]);
    }
    private static int fib(int i, int[] memo){
        if( i==0 || i==1 ) return i;
        if(memo[i] == 0) {
            memo[i] = fib(i-1, memo) + fib(i-2, memo);
        }
        return memo[i];
    }

    /**
     * calculate fib by bottom-up DP
     */
    public static int fibonacci_2(int n){
        if (n == 0 ) return 0;
        int a = 0, b = 1;
        for(int i= 2; i < n; i++){
            int c = a + b;
            a = b;
            b = c;
        }
        return a+b;
    }

    /**
     * Triple step: A child is running a staircase with n steps and can jump either 1 step, 2 steps, or 3 steps,
     * implement a method to count how many possible ways the child can run up stairs
     */
    public static int countWays(int n){
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 4;
        for(int i=3; i < n; i++){
            memo[i] = memo[i-1] + memo[i-2] + memo[i-3];
        }
        return memo[n-1];
    }

    /**
     * Imagine a robot sitting on the upper left corner of grid with r rows and c columns. The robot can only move
     * in two directions, right and down, but certain cells are off limits such that the robot can not step on them.
     *
     * Design an algorithm to find a path from the top left to the bottom right.
     *
     * hint. don't use x and y for the 2D array, because x and y in math is reverse in x and y in arrays,
     * use r for row and c for column instead.
     */
    public static ArrayList<Point> getPath(boolean[][] maze){
        if(maze == null || maze.length == 0) return null;

        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        // target grid
        int lastRow = maze.length -1;
        int lastCol = maze[0].length -1;
        if(getPath(maze, lastRow, lastCol, path, cache)){
            return path;
        }
        return null;
    }
    private static boolean getPath(boolean[][] maze, int row, int col,
                                   ArrayList<Point> path, HashMap<Point, Boolean> cache){
        // if out of bound or not available, return
        if (col < 0 || row < 0 || !maze[row][col]){
            return false;
        }
        Point p = new Point(row, col);

        if(cache.containsKey(p)){
            return cache.get(p);
        }

        boolean isAtOrigin = (row==0)&&(col==0);
        boolean isSuccess = false;

        if(isAtOrigin || getPath(maze, row, col-1, path, cache) || getPath(maze, row-1, col, path, cache)){
            path.add(p);
            isSuccess = true;
        }
        cache.put(p, isSuccess);
        return isSuccess;
    }

    /**
     * Magic Index: A magic index in an array A[1..n-1] is defined to be an index such that A[i] = i;
     * Given a sorted array of distinct integers, write a method to find a magic index, if exists, in array[A]
     */
    public static int magicFast(int[] arr){
        return magicFast(arr, 0, arr.length);
    }
    private static int magicFast(int[] arr, int start, int end){
        if(end < start) return -1;

        int mid = (start + end) / 2;
        int midValue = arr[mid];
        if(mid == midValue) return mid;
        // search left
        int leftIndex = Math.min(mid-1, midValue);
        int left = magicFast(arr,start,leftIndex);
        if(left >= 0) return left;
        // search right
        int rightIndex = Math.max(mid+1, midValue);
        int right = magicFast(arr,rightIndex,end);
        return right;
    }

    /**
     * Write a method to return all subsets of a set
     */
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
        ArrayList<ArrayList<Integer>> allSubsets;
        if( set.size() == index){
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        }else{
            allSubsets = getSubsets(set, index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset: allSubsets){
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moresubsets.add(newSubset);
            }
            allSubsets.addAll(moresubsets);
        }
        return allSubsets;
    }

    /**
     * Recursive multiply: write a recursive function to multiply two numbers without using the * operator, you can only
     * use addition, subtraction, and bit shifting
     *
     * this algorithm is O(log s), where s is the smaller number
     */
    public static int minProduct(int a, int b){
        int bigger = a < b? b : a;
        int smaller = a < b? a: b;
        return minProductHelper(smaller, bigger);
    }
    private static int minProductHelper(int smaller, int bigger){
        if (smaller == 0) return 0;
        else if (smaller == 1) return bigger;

        int s = smaller >> 1;
        int halfPod = minProductHelper(s, bigger);

        if(smaller %2 == 0){
            return halfPod + halfPod;
        }else{
            return halfPod + halfPod + bigger;
        }
    }

    /**
     *
     */
}

class Point {
    int x;
    int y;
    public Point(int row, int column){
        this.x = column;
        this.y = row;
    }
}