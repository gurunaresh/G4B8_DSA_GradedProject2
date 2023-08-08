package com.gl.skyscraper;

import java.util.*;

public class Skyscraper {
	public static Stack<Integer> sortDescending(Stack<Integer> inputStack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!inputStack.isEmpty()) {
            int temp = inputStack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() > temp) {
                inputStack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }

        return sortedStack;
    }
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total number of floors in the building: ");
        int N = scanner.nextInt();
        int[] floorSizes = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Enter the floor size given on day " + (i + 1) + ": ");
            floorSizes[i] = scanner.nextInt();
        }
        int max = floorSizes[0];
        for (int i=0; i<N; i++) {
        	if(floorSizes[i]>max) {
        		max = floorSizes[i];
        	}
        }

        
        Stack<Integer> waitingFloors = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (floorSizes[i]!=max) {
            	if (waitingFloors.isEmpty()) {
            		waitingFloors.push(floorSizes[i]);
            	}else if(floorSizes[i]<waitingFloors.peek()) {
            		waitingFloors.push(floorSizes[i]);
            		waitingFloors = sortDescending(waitingFloors);
            	}else {
            		waitingFloors.push(floorSizes[i]);
            		waitingFloors = sortDescending(waitingFloors);
            	}
            	if(i!=N-1) {
            		System.out.println("\nDay: " + (i + 1));
                	System.out.println(" ");
            	}
            	
            }else {
            	waitingFloors.push(floorSizes[i]);
            	waitingFloors = sortDescending(waitingFloors);
            	System.out.println("\nDay: " + (i + 1));

            	while (!waitingFloors.isEmpty()) {
                    System.out.print(waitingFloors.pop() + " ");
                }
            }  
        }
        System.out.println("\nDay: " + N);
        waitingFloors = sortDescending(waitingFloors);
        while (!waitingFloors.isEmpty()) {
            System.out.print(waitingFloors.pop() + " ");
        }
        

        scanner.close();
    }
}

