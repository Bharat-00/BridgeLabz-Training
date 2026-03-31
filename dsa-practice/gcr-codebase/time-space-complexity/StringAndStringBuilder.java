public class StringAndStringBuilder {
    // Using String (O(N^2))
    public static long usingString(int operations) {
        long start = System.nanoTime();
        String str = "";
        for (int i = 0; i < operations; i++) {
            str = str + "hello";
        }
        long end = System.nanoTime();
        return end - start;
    }
    // Using StringBuilder (O(N))
    public static long usingStringBuilder(int operations) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < operations; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }
    // Using StringBuffer (O(N))
    public static long usingStringBuffer(int operations) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < operations; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {
        int operations = 1_000_000;
        long stringTime = usingString(operations);
        long builderTime = usingStringBuilder(operations);
        long bufferTime = usingStringBuffer(operations);
        System.out.println("String Concatenation Performance");
        System.out.println("Operations Count : " + operations);
        System.out.println("String Time        : " + stringTime + " ns");
        System.out.println("StringBuilder Time : " + builderTime + " ns");
        System.out.println("StringBuffer Time  : " + bufferTime + " ns");
    }
}
