package JavaPractise;
//larhest elements of array

public class Practise2 {
    public static void main(String[] args) {
        int arr[]={34,4,5,2,3,67};
        int largest=0;
        largest=arr[0];
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>largest)
                largest=arr[i];
        }
        System.out.println(largest);
    }
}
