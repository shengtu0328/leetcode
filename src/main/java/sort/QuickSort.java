package sort;

/**
 * @author ：rqxiao
 * @description：快速排序
 * @date ：2020/11/2 17:31
 */
public class QuickSort {


    public void sort(int[] array) {


        quickSort(array, 0, array.length - 1);


        return ;
    }


    public void quickSort(int[] array, int i, int j) {

        if (i < j) {
            int index = getIndex(array, i, j);
            quickSort(array, i, index - 1);
            quickSort(array, index + 1, j);
        }

    }


    public int getIndex(int[] array, int i, int j) {

        int start = i;
        int end = j;

        int standard = array[i];
        while (i < j) {
            while (array[j] >= standard && j > i) {
                j--;
            }


            array[i] = array[j];
            array[j] = standard;


//            i = i + 1;


            while (array[i] <= standard && i < j) {
                i++;
            }

            array[j] = array[i];
            array[i] = standard;


//            j = j - 1;
        }

        return i;

    }


    public static void main(String[] args) {
        int[] array =
        {5, 7, 8, 2, 4, 6, 12, 45, 77, 88, 3};

        // 第一轮快排
        // 3,7,8,2,4,6,12,45,77,88,5   右开始
        //                         s
        //                         j
        //   i

        // 3,5,8,2,4,6,12,45,77,88,7   左开始
        //
        //


        // 3,5,8,2,4,6,12,45,77,88,7   右开始
        // 3,4,8,2,5,6,12,45,77,88,7   左开始

        // 3,4,5,2,8,6,12,45,77,88,7   右开始
        // 3,4,2,5,8,6,12,45,77,88,7   左开始


        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
    }


}
