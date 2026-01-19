public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        // StringBuffer performance test
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append("hello");
        }
        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;
        // StringBuilder performance test
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append("hello");
        }
        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;
        // Print comparison
        System.out.println("Time taken by StringBuffer: " + bufferTime + " ns");
        System.out.println("Time taken by StringBuilder: " + builderTime + " ns");
    }
}
