import java.util.*;

public class Statistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the values: ");
        ArrayList<Integer> data = new ArrayList<>();
        while (sc.hasNextInt())
            data.add(sc.nextInt());
        System.out.println("Mean = " + mean(data));
        System.out.println("Median = " + median(data));
        System.out.println("Mode = " + mode(data));
    }

    public static float mean(ArrayList<Integer> data) {
        float s = 0;
        for (Integer datum : data)
            s += datum;
        return s / data.size();
    }

    public static float median(ArrayList<Integer> data) {
        Collections.sort(data);
        if (data.size() % 2 == 1)
            return data.get((data.size() + 1) / 2 - 1); // median = (n+1)/2
        else
            return (data.get(data.size() / 2 - 1) + data.get(data.size() / 2)) / 2; // median = (n/2 + (n/2 + 1))/2
    }

    public static int mode(ArrayList<Integer> data) {
        HashMap<Integer, Integer> data_freq = new HashMap<>();
        int k = 1;
        for (int i = 0; i < data.size(); i++) {
            data_freq.put(data.get(i), k);

            for (int j = i + 1; j < data.size(); j++) {
                if (data.get(i).equals(data.get(j))) {
                    k++;
                    data_freq.put(data.get(i), k);
                    data.remove(j);
                }
            }
            k = 1;
        }
        Collection getFreq = data_freq.values();
        Iterator i = getFreq.iterator();
        int max = (int) i.next();
        while (i.hasNext()) {
            if((int)i.next()>max)
                max = (int)i.next();
        }
        for(Map.Entry<Integer,Integer> entry : data_freq.entrySet()) {
            if(entry.getValue()==max)
                return entry.getKey();
        }
        return 0;
    }
}
