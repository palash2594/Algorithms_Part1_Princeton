package Week1;

public class QuickFindTest {

    public static void main(String[] args) {
        QuickFindUF qu = new QuickFindUF(10);
        System.out.println(qu.connected(0, 4));
        qu.union(0,5);
        qu.union(5,6);
        qu.union(1,6);
        qu.union(1,2);
        qu.union(2,7);
        System.out.println(qu.connected(0,7));
    }
}
