int i = 0;
        while(i < arr.length){
            if(arr[i] != i + 1){
                int correct = arr[i] - 1;
                if(arr[i] != arr[correct]){
                    swap(arr, i, correct);
                }else{
                    return arr[i];
                }
            }else{
                i++;
            }
        }

        // now search for the duplicate

        return -1;