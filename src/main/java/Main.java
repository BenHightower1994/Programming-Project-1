
import java.util.Scanner;

/*
Benjamin Hightower
PP1 Code
COSC 2336
*/

public class Main 
{  
    static String playerLoc = null;
    //Node class
    static class NodeTemp
    {
        String data;
        NodeTemp next, child;
        //Node constructor
        public NodeTemp(String data)
        {
            this.data = data;
            next = child = null;
        }
    }
    
    //If node stores data, creates new sibling node and stores data
    static public NodeTemp addSibling(NodeTemp node, String data)
    {
        if(node == null)
            return null;
        while(node.next != null)
            node = node.next;
        return(node.next = new NodeTemp(data));
    }
    
    //If node stores data, creates new child node and stores data
    static public NodeTemp addChild(NodeTemp node, String data)
    {
        if(node == null)
            return null;
        
        if(node.child != null)
            return(addSibling(node.child,data));
        else
            return(node.child = new NodeTemp(data));
    }
    
    //Preorder traversal of tree
        //Reads parent, moves to children, if no children moves to sibling
    static public void traverseTree(NodeTemp root)
    {
        if(root == null)
            return;
        while(root != null)
        {
            if(root.data.equals(playerLoc))
            {
              if(root.child != null)
                    traverseTree(root.child);
              root = root.next;  
            }
            else
            {
            System.out.println(root.data);
            if(root.child != null)
                    traverseTree(root.child);
            root = root.next;
            }
        }
    }
    
    // Method for player to traverse map
    static public void movePlayer(NodeTemp root)
    {
        System.out.println("You can travel to ");
        traverseTree(root);
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter a location to travel to >> ");
        switch(input.nextInt())
        {
            case 1:
            playerLoc = "1. Central Pyramid";
            System.out.println("");
            pyramid();
            break;
            case 2:
            playerLoc = "2. Northern Monument";
            System.out.println("");
            System.out.println("You are standing at the Northern Monument");
            monument1();
            break;
            case 3:
            playerLoc = "3. Western Monument";
            System.out.println("");
            System.out.println("You are standing at the Western Monument");
            monument2();
            break;
            case 4:
            playerLoc = "4. Eastern Monument";
            System.out.println("");
            System.out.println("You are standing at the Eastern Monument");
            monument3();
            break;
            default:
            System.out.println("Invalid entry.");
            System.out.println("");
            movePlayer(root);
            break;
        }
    }
        
        //Creating Map Tree
    static NodeTemp mapRoot = new NodeTemp("1. Central Pyramid");
    static NodeTemp m1 = addChild(mapRoot, "2. Northern Monument");
    static NodeTemp m2 = addChild(mapRoot, "3. Western Monument");
    static NodeTemp m3 = addChild(mapRoot, "4. Eastern Monument");
        
    
    static Scanner input = new Scanner(System.in);
    static boolean[] mon1Puzzle = new boolean[]{false,false,false,true};
    static boolean[] mon2Puzzle = new boolean[]{true,false,false};
    static boolean[] mon3Puzzle = new boolean[]{false,true,false};
    static boolean[] pryPuzzle = new boolean[]{false,true,false};
    static boolean[] pryCheck = new boolean[]{false,false,false};
    static boolean[] playerAnswers = new boolean[3];
    
    public static void monument1()
    {
        if(pryCheck[0] == true)
        {
            System.out.println("A light points towards the central pyramid.");
            movePlayer(mapRoot);
        }
        else
        {
        System.out.println("In front of you stands a black monument reaching towards the sky.");
        System.out.println("On the face of the monument you see four objects embedded in tiles:");
        System.out.println("1. A dog"+'\n'+"2. A cat"+'\n'+"3. a fox"+'\n'+"4. a leaf");
        System.out.print("Choose a tile that does not belong>>");
        playerAnswers[0] = (mon1Puzzle[input.nextInt() - 1]);
        System.out.println("");
        if(playerAnswers[0] == false)
        {
            System.out.println("You are not worthy of the Pyramid." + '\n' + "Game Over.");
            System.exit(0);
        }
        pryCheck[0] = playerAnswers[0];
        System.out.println("A beam of light shoots from the top of the monument towards the pryamid.");
        System.out.println("Its side facing you begins to glow a deep crimson color.");
        movePlayer(mapRoot);
        }
    }
    
    public static void monument2()
    {
        if(pryCheck[1] == true)
        {
            System.out.println("A light points towards the central pyramid.");
            movePlayer(mapRoot);
        }
        else
        {
        System.out.println("In front of you stands a black monument reaching towards the sky.");
        System.out.println("On the face of the monument you see circles of bright red and blue as well as three colors embedded in tiles:");
        System.out.println("1. Purple"+'\n'+"2. Green"+'\n'+"3. Orange");
        System.out.print("Choose a tile>>");
        playerAnswers[1] = (mon2Puzzle[input.nextInt() - 1]);
        System.out.println("");
        if(playerAnswers[1] == false)
        {
            System.out.println("You are not worthy of the Pyramid." + '\n' + "Game Over.");
            System.exit(0);
        }
        pryCheck[1] = playerAnswers[1];
        System.out.println("A beam of light shoots from the top of the monument towards the pryamid.");
        System.out.println("Its side facing you begins to glow a deep crimson color.");
        movePlayer(mapRoot);
        }
    }
    
    public static void monument3()
    {
        if(pryCheck[2] == true)
        {
            System.out.println("A light points towards the central pyramid.");
            movePlayer(mapRoot);
        }
        else
        {
        System.out.println("In front of you stands a black monument reaching towards the sky.");
        System.out.println("On the face of the monument you see a picture of scissors as well as three objects embedded in tiles:");
        System.out.println("1. A piece of paper"+'\n'+"2. A rock"+'\n'+"3. A pair of scissors");
        System.out.print("Choose a tile>>");
        playerAnswers[2] = (mon3Puzzle[input.nextInt() - 1]);
        System.out.println("");
        if(playerAnswers[2] == false)
        {
            System.out.println("You are not worthy of the Pyramid." + '\n' + "Game Over.");
            System.exit(0);
        }
        pryCheck[2] = playerAnswers[2];
        System.out.println("A beam of light shoots from the top of the monument towards the pryamid.");
        System.out.println("Its side facing you begins to glow a deep crimson color.");
        movePlayer(mapRoot);
        }
    }
    
    public static void pyramid()
    {
        System.out.println("You stand at the base of a great pyramid.");
        if(pryCheck[0] && pryCheck[1] && pryCheck[2])
        {
            System.out.println("Each face grows a dark shade of crimson.");
            System.out.println("As you approach the entrance, fires shoot out from the outer monuments.");
            System.out.println("The fire races towards you rapidly. If you do not put it out soon you will be swallowed by flames.");
            System.out.println("You see three tiles on the wall:");
            System.out.println("1. A brown rock"+'\n'+"2. A blue wave"+'\n'+"3. A crimson fire");
            System.out.print("Choose a tile>>");
            boolean finalPuzzle = pryPuzzle[input.nextInt()-1];
            System.out.println("");
            if (finalPuzzle)
                {
                    System.out.println("The fires vanish and the pyramid turns a deep purple.");
                    System.out.println("You have solved the Crimson Pyramid.");
                    System.exit(0);
                }
            else
            {
                System.out.println("You press the tile but it is no use. You are engulfed in flames.");
                System.out.println("The Crimson Pyramid has claimed another.");
                System.exit(0);
            }
        }
        else
        {
            if(pryCheck[0])
                System.out.println("The northern face of the pyramid glows crimson.");
            if(pryCheck[1])
                System.out.println("The western face of the pyramid glows crimson.");
            if(pryCheck[2])
                System.out.println("The eastern face of the pyramid glows crimson.");
            movePlayer(mapRoot);
        }
    }
    
    public static void main(String[] args)
    {
        movePlayer(mapRoot);
    }
}
