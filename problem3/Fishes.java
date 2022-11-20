package problem3;
import java.util.ArrayList;
import java.util.Random;
public class Fishes {
    static ArrayList<String> fish;

    public static void main(String args[]) throws InterruptedException{
        fillFishes();
        System.out.println(fish);
        for(int i=1;i<=5;i++){
            Thread t=new Thread(new Runnable(){

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    meet();
                    
                }

            });
            t.start();
        }

    }

    static void fillFishes(){
        fish=new ArrayList<>();
        for(int i=1;i<20;i++){
            if(i%2==0)
            fish.add("male");
            else
            fish.add("female");
        }
    }

    static synchronized void meet(){
        if(fish.size()<2)
            return;
        Random random=new Random();
        int positionFirst=random.nextInt(fish.size());
        String first=fish.get(positionFirst);
        fish.remove(positionFirst);// we don't select the same fish again

        int positionSecond=random.nextInt(fish.size());
        String second=fish.get(positionSecond);
        fish.remove(positionSecond);

        while(true){
            if(fish.size()<2){
                System.out.println("The program has terminated due to not enough fishes");
                break;
            }
            if(first.equals("male") && second.equals("male")){
                //if both male they kill each other so none would be added back to the arraylist
            }
            else if(first.equals("female") && second.equals("female")){
                //if both female only one is added since one dies
                fish.add("female");
            }
            else if(first.equals("male") && second.equals("female")){
                //since none is dead from original we add them
                fish.add("male");
                fish.add("female");

                //now we add two fishes at random
                fish.add(random.nextInt(2)==0?"male":"female");
                fish.add(random.nextInt(2)==0?"male":"female");
            }
            System.out.println(fish.size());
        }
    }
   
    
}
