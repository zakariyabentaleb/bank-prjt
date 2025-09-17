public class Main {
    //int x = 5;
    public static int carre( int i){
        int j = i*i ;
        return j ;
    }
    public static int carreplusUn( int c ){
        c= c+1;
        return c;
    }
    public static void main(String[] args) {
        // Main myObj = new Main();
        //System.out.println(myObj.x);
        System.out.println("double : " + carre(5));
        System.out.println("Carré + 1 : " + carreplusUn(carre(5)));
    }
}