/*
    Burd Satterfield
    CPSC 1060: Programming Assignment 2
    Lab Section 3
    4/24/23
*/

//lots of code has been incorporated from Lab12

import java.util.*;  

//  SPOILER!!!!!!             if you want to win, enter room B

public class Driver {

    public static void Intro() {        //Introduces the name of the game(Find Bobby), and explains the goal
        System.out.println("Welcome to FindBobby. A game where the only goal is to find Bobby.");
        System.out.println("Bobby has gotten lost in an abandon house, and it is your job to find him.");
        System.out.println("");
    }

    public static void Start() {        //method for the start of the game
        System.out.println("The house you are in is dark.");
        System.out.println("Maybe find something that gives off light.");
        System.out.println("There appears to be a torch on the wall of the foyer. Do you want to take it?");
        System.out.println("");
    }

    public static void enterRoom(String roomIn, AdventureMap map) {             //a method to call in the room you are in with a description of siad room
        Room currentRoom = map.getRoom(roomIn);
        System.out.println(currentRoom.getName() + ": " + currentRoom.getDescription());
        System.out.println("");
        System.out.println("Exits: " + currentRoom.listExits());         
        System.out.println("");
        System.out.println("Please choose an exit");
    }

    public static void main(String[] args) {            //main method
        Scanner scnr = new Scanner(System.in);

        Intro();

        Start();

        BackPack backPack = new BackPack();             //creates object backPack

        String torch = scnr.next();
        scnr.nextLine();
        boolean takeTorch = true;
        while (takeTorch == true) {                      //while loop to grab the torch item, will never be in foyer again
            if (torch.equalsIgnoreCase("yes")) {
                System.out.println("Good choice, now you can see.");
                backPack.addTorch(0, "Torch");
                backPack.printInfo();
                takeTorch = false;
            }
            else if (torch.equalsIgnoreCase("no")){
                System.out.println("You won't be able to see. Are you sure you don't want the torch?");
                torch = scnr.next();
                scnr.nextLine();
            }
            else {
                System.out.println("Please input yes or no.");
                torch = scnr.next();
                scnr.nextLine();
            }     
        }

        boolean playGame = true;
        while (playGame == true) {
            System.out.println("\nWelcome to the abandoned house! Entering the foyer. If you don't find Bobby, you can't leave.\n");
            // Initialize an object for the Adventure Map
            AdventureMap map = new AdventureMap();

            // Make room objects and input the room information into the room objects
            Room roomA = new Room("Room A", "I don't see Bobby in here.");
            // Now that you've made a room object, add everything else into it
            roomA.setExits("Room C");
            map.addRoom(roomA);
            Room roomB = new Room("Room B", "Bobby!");
            // roomD, Room E, foyer
            roomB.setExits("Room D");
            roomB.setExits("Room E");
            roomB.setExits("Foyer");
            map.addRoom(roomB);
            Room roomC = new Room("Room C", "I don't see Bobby in here.");
            roomC.setExits("Foyer");
            roomC.setExits("Room A");
            map.addRoom(roomC);
            Room foyer = new Room("Foyer", "You started here, why would Bobby be here? There is no longer a torch.");
            foyer.setExits("Room C");
            foyer.setExits("Room B");
            foyer.setExits("Room F");
            map.addRoom(foyer);
            Room roomD = new Room("Room D", "I don't see Bobby in here.");
            roomD.setExits("Room B");
            map.addRoom(roomD);
            Room roomE = new Room("Room E", "I don't see Bobby in here.");
            roomE.setExits("Room F");
            roomE.setExits("room B");
            map.addRoom(roomE);
            Room room6 = new Room("Room F", "I don't see Bobby in here.");
            room6.setExits("Foyer");
            room6.setExits("Room E");
            map.addRoom(room6);
            
            String roomIn = "";
            enterRoom("foyer", map);
            // Room room = new Room();

            Room currentRoom = map.getRoom(roomIn);
            // System.out.println(roomIn);
 
            boolean keepGoing2 = true;
            while (keepGoing2 == true) {
                boolean keepGoing = true;
                while (keepGoing == true) {
                    roomIn = scnr.nextLine();
                    currentRoom = map.getRoom(roomIn);
                    
                    if (currentRoom == null) {          //catches invalid text
                        System.out.println("Invalid exit.");
                        System.out.println("Please choose an exit");
                    }
                    if (roomIn.equalsIgnoreCase("Room B")) {            //stops game once you find bobby, kicks out of while loop
                        System.out.println("You found Bobby!");
                        System.out.println("Bobby: Thank you for finding me! Shall we leave? Y or N");
                        keepGoing = false;    
                    }
                    else {                                          //game continues
                        currentRoom = map.getRoom(roomIn);
                        enterRoom(roomIn, map);
                    }
                }

                char yesOrNo = scnr.next().charAt(0);               //ask if you want to leave
                boolean yesNo = false;
                
                while (yesNo == false) {
                    if (yesOrNo == 'y' || yesOrNo == 'Y') {
                        yesNo = true;
                        keepGoing = false;
                        keepGoing2 = false;
                        System.out.println("Bobby: Perfect, let's skedaddle.");
                    }
                    else if (yesOrNo == 'n' || yesOrNo == 'N') {
                        yesNo = true;
                        System.out.println("Bobby: Too bad. I'm ready to go home.");
                        keepGoing = false;
                        keepGoing2 = false;
                    }
                    else {
                        System.out.println("Please enter valid input: Y or N");
                        System.out.println("Bobby: Do you want to leave? Y or N");
                        yesNo = false;
                        yesOrNo = scnr.next().charAt(0);
                    }
                }
            }
            playGame = false;
        }
    }
}
