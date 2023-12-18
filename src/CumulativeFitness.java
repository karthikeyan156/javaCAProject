package src;

public class CumulativeFitness {

    public double findFitness(double[] arr) {
        double maximum =  arr[0];
        for(int i=0;i<100;i++){
            if(arr[i]>maximum){
                maximum=arr[i];
            }
        }
        return maximum;
       
    }

}
