package sort;

import java.util.Stack;

public class TestDemo {

    //直接插入排序
    public static void InsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if(tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }

    }

    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    //哈希排序
    public static void hashSort(int[] arr,int gap) {
        for (int i = gap; i < arr.length; i++) {
            int tmp = arr[i];
            int j = 0;
            for (j = i - gap; j >= 0; j--) {
                if(tmp < arr[j]){
                    arr[j + gap] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }
    public static void gap(int[] arr) {
        int[] gap = {5,3,1};
        for (int i = 0; i < gap.length; i++) {
            hashSort(arr,gap[i]);
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        sort(arr,0,arr.length - 1);
    }
    public static void sort(int[] arr,int left,int right) {
        if(left < right) {
            int piv = pivot(arr,left,right);
            sort(arr,left,piv - 1);
            sort(arr,piv + 1,right);
        }
    }
    public static int pivot(int[] arr,int left,int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && tmp <= arr[right]) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && tmp > arr[left]) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    //非递归快速排序
    public static void quickSort1(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int left = 0;
        int right = arr.length - 1;
        int piv = pivot(arr,left,right);
        if(piv > left + 1) {
            s.push(left);
            s.push(piv - 1);
        }
        if(piv < right - 1){
            s.push(piv + 1);
            s.push(right);
        }
        while(!s.isEmpty()) {
            right = s.pop();
            left = s.pop();
            piv = pivot(arr,left,right);
            if(piv > left + 1) {
                s.push(left);
                s.push(piv - 1);
            }
            if(piv < right - 1){
                s.push(piv + 1);
                s.push(right);
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        mergeSort1(arr,0,arr.length - 1);
    }
    public static void mergeSort1(int[] arr,int left, int right) {
        if(left >= right) return;
        int mid = (left + right) / 2;
        mergeSort1(arr,left,mid);
        mergeSort1(arr,mid + 1,right);
        merge(arr,left,mid,right);
    }
    public static void merge(int[] arr,int left,int mid,int right) {
        int s1 = left;
        int s2 = mid + 1;
        int[] ret = new int[right - left + 1];
        int k = 0;
        while(s1 <= mid && s2 <=right) {
            if(arr[s1] < arr[s2]) {
                ret[k++] = arr[s1++];
            } else {
                ret[k++] = arr[s2++];
            }
        }
        while(s1 <= mid) {
            ret[k++] = arr[s1++];
        }
        while(s2 <= right) {
            ret[k++] = arr[s2++];
        }
        for (int i = 0; i < ret.length; i++) {
            arr[i + left] = ret[i];
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    //堆排序
    public static void sort(int[] arr) {
        for (int i = (arr.length -1 - 1) / 2; i >= 0 ; i--) {
            adjust(arr,i,arr.length);
        }
    }
    public static void adjust(int[] arr,int p,int len) {
        int c = p * 2 + 1;
        while(c < len) {
            if(c + 1 < len && arr[c] < arr[c + 1]) {
                c++;
            }
            if(arr[c] > arr[p]) {
                int tmp = arr[c];
                arr[c] = arr[p];
                arr[p] = tmp;
                p = c;
                c = p * 2 + 1;
            } else {
                break;
            }
        }
    }
    public static void heapSort(int[] arr) {
        sort(arr);
        int end = arr.length - 1;
        while(end > 0) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            adjust(arr,0,end);
            end--;
        }
    }
    
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,5,23,1,34,6,12,21,65,4,43,61};
//        InsertSort(arr);
//        print(arr);
//        selectSort(arr);
//        print(arr);
//        gap(arr);
//        print(arr);
//        quickSort1(arr);
//        print(arr);
//        mergeSort(arr);
//        print(arr);
//        bubbleSort(arr);
//        print(arr);
        heapSort(arr);
        print(arr);
    }
}
