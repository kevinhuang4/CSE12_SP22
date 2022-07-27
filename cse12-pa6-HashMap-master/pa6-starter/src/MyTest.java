public class MyTest {
    public static void main(String[] args) {
        // try {
        //     File f = new File("./input.txt");
        //     Scanner sc = new Scanner(f);
        //     while (sc.hasNextLine()) {
        //         String[] data = sc.nextLine().split(", ");
        //         // Add your code here
        //         // System.out.println("Data: ");
        //         // for (String str: data) {
        //         //     System.out.println(str);
        //         // }
        //         // System.out.println("___________");
                
        //     }
        //     sc.close();
        // } catch (FileNotFoundException e) {
        //     System.out.println(e);
        // }
        FileSystem fiSystem = new FileSystem();
        fiSystem.add("mySample.txt", "/home", "02/01/2021");
        fiSystem.add("mySample.txt", "/root", "02/01/2021");
        fiSystem.add("aro.txt", "/home", "02/01/2021");
        fiSystem.add("heyo.txt", "/home", "03/02/2023");
        fiSystem.add("nihao.txt", "/home", "02/01/2021");
        System.out.println(fiSystem.dateMap.get("02/01/2021").size());
        fiSystem.removeByName("mySample.txt");
        System.out.println(fiSystem.dateMap.get("02/01/2021").size());
    }
}
