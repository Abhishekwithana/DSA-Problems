/**
 * VideoStoreLaucher
 */

import java.io.IOException;
import java.rmi.StubNotFoundException;
import java.util.*;

public class VideoStoreLaucher {

    public static void main(String[] args) {
        VideoStore vs = new VideoStore();
        int ch, uCh , aCh;
        String title , choice;

        do {
            System.out.println("-------------------MENU-------------");
            System.out.println("1. Login as User");
            System.out.println("2. Login as Admin");
            System.out.println("Enter your choice");
            Scanner sc = new Scanner(System.in);

            ch = sc.nextInt();


            do{
                clearScreen();
                switch(ch) {

                    case 1:
                        System.out.println("1. List Inventory");
                        System.out.println("2. Rent Video");
                        System.out.println("3. Enter the rating of Video");
                        System.out.println("4. Return Video");

                        uCh = sc.nextInt();

                        if(uCh == 1) {

                            vs.listInventory();

                        }else if(uCh == 2) {

                            vs.listInventory();
                            System.out.print("Enter the Video Title : ");
                            title = sc.nextLine();

                            vs.checkOut(title);

                        }else if(uCh == 3) {
                            vs.listInventory();
                            System.out.print("Enter the title of video : ");
                            sc.nextLine();
                            title = sc.nextLine();
                            System.out.print("Enter your rating : ");
                            String rate = sc.nextLine();

                            vs.receiveRating(title, rate);

                        }
                        else if(uCh == 4) {
                            System.out.print("Enter the title : ");
                            title = sc.nextLine();

                            vs.returnVideo(title);

                        }else {

                            System.out.println("No such Option is avaiable");

                        }
                        break;

                    case 2:
                        System.out.println("1. List Inventory");
                        System.out.println("2. Add Video");
                        aCh = sc.nextInt();

                        if(aCh == 1) {
                            vs.listInventory();
                        }

                        if(aCh == 2) {
                            System.out.println("Enter the Title of Video");
                            sc.nextLine();
                            title = sc.nextLine();
                            vs.addVideo(title);
                        }
                        break;

                        default :
                            System.out.println("Sorry Wrong Choice");
                }

                System.out.println("Do you want to repeat Yes/No?");
                choice = sc.nextLine();
                sc.nextLine();
            }while(choice.equalsIgnoreCase("yes"));

            System.out.println("Want to Return to the main menu Yes/No ? ");
            choice = sc.nextLine();
                sc.nextLine();
        }while(choice.equalsIgnoreCase("yes"));
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            // Handle exceptions
            ((Throwable) ex).printStackTrace();
        }
    }

}

class VideoStore {
    List<String> list = new ArrayList<>();
    List<Boolean> checkList = new ArrayList<>();
    List<String> ratingList = new ArrayList<>();

    public void addVideo(String title) {
        this.list.add(title);
        this.checkList.add(true);
        this.ratingList.add("0.0");
    }

    public void listInventory() {
        System.out.println();
        if(list.size() == 0) {
            System.out.println("---Empty---");
            return;
        }
        for(int i = 0; i < this.list.size(); i++) {
            System.out.println("Title : " + list.get(i));
            System.out.println("Rating : " + ratingList.get(i));
            System.out.println("Checked? : " + (checkList.get(i) ? "YES" : "NO"));
            System.out.println();
        }
    }

    public void checkOut(String title) {

        if(list.size() == 0) {
            System.out.println("Nothing to CheckOut");
            return;
        }
        System.out.println();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(title)) {
                checkList.set(i, false);
                break;
            }
        }
        System.out.println("Checkout Successfull for video -> " + title);
    }

    public void receiveRating(String title, String rating) {

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(title)) {
                ratingList.set(i, rating);
                break;
            }
        }
    }

    public void returnVideo(String title) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).equals(title)) {
                checkList.set(i, true);
                break;
            }
        }
    }

}