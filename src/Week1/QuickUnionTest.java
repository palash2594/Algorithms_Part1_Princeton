package Week1;

public class QuickUnionTest {

    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(10);
        System.out.println(qu.connected(0, 4));
        qu.union(0,5);
        qu.union(5,6);
        qu.union(1,6);
        qu.union(1,2);
        qu.union(2,7);
        System.out.println(qu.connected(0,7));
        System.out.println();

        ///// Quick Union Improvements test

        QuickUnionImprovements qui = new QuickUnionImprovements(10);

        System.out.println(qui.connected(0, 4));
        qui.union(0,5);
        qui.union(5,6);
        qui.union(1,6);
        qui.union(1,2);
        qui.union(2,7);
        System.out.println(qui.connected(0,7));
    }

}
