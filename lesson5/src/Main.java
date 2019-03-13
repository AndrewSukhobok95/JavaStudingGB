public class Main extends Thread {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException{
        oneStreamArrayProcess();
        System.out.println();
        twoStreamArrayProcess();
    }

    public static void oneStreamArrayProcess() {
        float[] arr = new float[size];
        for(int i=0;i<size;i++){
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        for(int i=0;i<size;i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One stream array processing time: " + (System.currentTimeMillis() - startTime) + " miliseconds");
        System.out.println("The number of element in array is " + arr.length);
        float sum = 0;
        for (float e : arr) sum += e;
        System.out.println("Element's sum is " + sum);
    }

    public static void twoStreamArrayProcess() throws InterruptedException{
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        for(int i=0;i<size;i++){
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        ArrayFill array1Fill = new ArrayFill(a1);
        ArrayFill array2Fill = new ArrayFill(a2);

        Thread thread1 = new Thread(array1Fill);
        thread1.setName("FirstHalf");

        Thread thread2 = new Thread(array2Fill);
        thread2.setName("SecondHalf");

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        a1 = array1Fill.getArrayToFill();
        a2 = array2Fill.getArrayToFill();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        System.out.println("Two stream array processing time: " + (System.currentTimeMillis() - startTime) + " miliseconds");
        System.out.println("The number of element in array is " + arr.length);
        float sum = 0;
        for (float e : arr) sum += e;
        System.out.println("Element's sum is " + sum);
    }

    static class ArrayFill implements Runnable {
        private float[] arrayToFill;

        public ArrayFill(float[] arrayToFill) {
            this.arrayToFill = arrayToFill;
        }

        public float[] getArrayToFill() {
            return this.arrayToFill;
        }

        public void fillArray() {

            int shiftValue;
            int numberForFormulaCalc;
            if (Thread.currentThread().getName().equals("FirstHalf")){
                shiftValue = 0;
            }else if (Thread.currentThread().getName().equals("SecondHalf")){
                shiftValue = h;
            }else{
                shiftValue = 0;
            }

            for(int i=0;i<this.arrayToFill.length;i++){
                numberForFormulaCalc = i + shiftValue;
                this.arrayToFill[i] = (float)(this.arrayToFill[i] * Math.sin(0.2f + numberForFormulaCalc / 5) * Math.cos(0.2f + numberForFormulaCalc / 5) * Math.cos(0.4f + numberForFormulaCalc / 2));
            }
        }

        @Override
        public void run() {
            fillArray();
        }
    }
}
