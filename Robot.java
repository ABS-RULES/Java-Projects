class Robot
{
    String name;
    String color;
    int weight;

    Robot(String n, String c, int w)
    {
        this.name = n;
        this.color = c;
        this.weight = w;
    }

    void introduceself()
    {
        System.out.println("My name is "+this.name);
    }

    public static void main(String[] args) 
    {
        Robot r1 = new Robot("Tom", "Red", 30);
        Robot r2 = new Robot("Jerry", "Blue", 40);

        r1.introduceself();
        r2.introduceself();
    }
}
