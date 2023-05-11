import java.util.ArrayList;
import java.util.List;

/*
 * Link to problem:
 * https://leetcode.com/problems/the-skyline-problem/
 */

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        //list of output points
        List<List<Integer>> outputList = new ArrayList<List<Integer>>();  

        //denotes current tallest building at location x
        int currentTallest = 0;  
        //denotes the previous tallest building at location x-1
        int previousTallest = 0;

        //tracks which buildings exist at location x
        ArrayList<Integer> buildingsActive = new ArrayList<Integer>();  

        
        //Tracks the last building on the x axis
        int lastBuilding = 0; 

        //Finds the x location of the end of the furthest right building.
        for(int i = 0; i < buildings.length; i++){
            if(lastBuilding < buildings[i][1]){
                lastBuilding = buildings[i][1];
            }
        }

        //iterates through entire x axis
        for(int x = 0; x <= lastBuilding; x++){  


            buildingsActive.clear();

            //updates the buildingsActive list according to x
            for(int b = 0; b < buildings.length; b++){
                if(buildings[b][0] <= x && buildings[b][1] > x){
                    buildingsActive.add(b);
                }
            }

            currentTallest = 0;
        
            //iterates through Active Buildings
            for(int b = 0; b < buildingsActive.size(); b++){

                //finds the tallest building in the active building list
                if(buildings[buildingsActive.get(b)][2] > currentTallest){
                    currentTallest = buildings[buildingsActive.get(b)][2];
                }

                

            }

            if(currentTallest != previousTallest){
                //adds the new point to the output list
                List<Integer> newPoint = new ArrayList<Integer>();
                newPoint.add(x);
                newPoint.add(currentTallest);
                outputList.add(newPoint);

                //updates the previousTallest
                previousTallest = currentTallest;
            }

        }

        return outputList;
    }

    public static void main(String[] args) {
        
        int[][] testBuildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};

        Solution testSolution = new Solution();

        System.out.println(testSolution.getSkyline(testBuildings));
    }
}