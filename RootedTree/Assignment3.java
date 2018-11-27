/*
Tuyen Pham
TUID 915591991
Assignment 3 - CIS2168 - Section 08
This assignment is implementing methods for a RootedTree class.
 */
package assignment3;
import java.io.IOException;

public class Assignment3 {
    
    public static void main(String[] args) throws IOException {

        // Get Current Directory
        String currentDirectory = System.getProperty("user.dir") + "/";
        System.out.println("Current Directory: " + currentDirectory);

        // Problem 1 (10 pts): Programmatically create your own RootedTree object
        // consisting of at least five nodes.  Then, use the save method to save
        // the tree to a text file named "mytree.txt" within currentDirectory.
        TreeNode<String> root = new TreeNode<String>("Colors");
        TreeNode<String> red = new TreeNode<String>("Red");
        TreeNode<String> white = new TreeNode<String>("White");
        TreeNode<String> blue = new TreeNode<String>("Blue");
        TreeNode<String> green = new TreeNode<String>("Green");

        root.addChild(red);
        root.addChild(white);
        root.addChild(blue);
        root.addChild(green);
        green.addChild(new TreeNode<String>("lime"));
        RootedTree tree = new RootedTree(root);
        tree.save(currentDirectory + "mytree.txt");


        // Loading animal classification data from file "animal_classification_tree.txt".
        RootedTree animalClassificationTree = new RootedTree();
        animalClassificationTree.load(currentDirectory + "animal_classification_tree.txt");

        // Sanity Check for Problem 2: This is a simple sanity check to
        // help you test and debug your problem 2 solution.
        System.out.print("Sanity Check A passed = ");
        System.out.println(animalClassificationTree.getLeafNodes().toString().equals("[Arachnida, Insecta, Malacostraca, Aves, Chondrichthyes, Osteichthyes, Artiodactyla, Carnivora, Cetacea, Chiroptera, Hyracoidea, Insectivora, Lagomorpha, Perissodactyla, Primates, Proboscidea, Rodentia, Sirenia, Xenarthra, Testudines, Squamata, Crocodilia]"));

        // Sanity Checks for Problem 3: These are simple sanity checks to
        // help you test and debug your problem 3 solution.
        System.out.print("Sanity Check B passed = ");
        System.out.println(animalClassificationTree.getAncestry("Animalia").toString().equals("[Animalia]"));

        System.out.print("Sanity Check C passed = ");
        System.out.println(animalClassificationTree.getAncestry("asdfghjkl").toString().equals("[]"));

        System.out.print("Sanity Check D passed = ");
        System.out.println(animalClassificationTree.getAncestry("Reptilia").toString().equals("[Reptilia, Chordata, Animalia]"));

        System.out.print("Sanity Check E passed = ");
        System.out.println(animalClassificationTree.getAncestry("Cetacea").toString().equals("[Cetacea, Mammalia, Chordata, Animalia]"));

        System.out.print("Sanity Check F passed = ");
        System.out.println(animalClassificationTree.getAncestry("Crocodilia").toString().equals("[Crocodilia, Reptilia, Chordata, Animalia]"));

        System.out.print("Sanity Check G passed = ");
        System.out.println(animalClassificationTree.getAncestry("Arachnida").toString().equals("[Arachnida, Arthropoda, Animalia]"));
}

}

