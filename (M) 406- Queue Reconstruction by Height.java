public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> keysInMap = new ArrayList<>();    // for iteration the map
        int leng = people.length;
        
        // Create the hashmap sorted by the # of people who are standing infront of him
        for(int i = 0; i < leng; i++) {
          if(!map.containsKey(people[i][1])) {
            keysInMap.add(people[i][1]);
            List<Integer> list = new ArrayList<>();
            list.add(people[i][0]);
            map.put(people[i][1], list);
          } else {
            map.get(people[i][1]).add(people[i][0]);    // !!!!PAY ATTENTION TO THIS LINE. It's not: map.put(peoplep[i][1], map.get(people[i][1]).add(people[i][0]));
          }
        }
        
        // Neccessary to sort the arry for KeysInMap.
        Collections.sort(keysInMap);
        
        // Not neccessary to sort the arry in the map
        // for(int i = 0; i < keysInMap.size(); i++) {
        //   Collections.sort(map.get(keysInMap.get(i)));
        // }
        
        int[][] ans = new int[leng][1]; // initialize the ans with the element array of size 1, so that we can distinguish the initial element.
        
        /*
            algo:
            1. Insert the people by the order of HashMap.
            2. Scan from the beginning of the ans array. If the people is taller than him, decrease the quota(# of people who are taller or equal to him in front of him); Do nothing otherwise.
            3. If the quota becomes minus, insert the people into the ans array at that index.
        */
        int viewedMapSize = 0;
        while(viewedMapSize < keysInMap.size()) {
          int key = keysInMap.get(viewedMapSize);
          List<Integer> temp = map.get(key);
          
          for(int i = 0; i < temp.size(); i++) {
            int[] element = new int[2];
            element[0] = temp.get(i);
            element[1] = key;
            
            int quota = key;
            int insertIndex = 0;
            while(insertIndex < ans.length) {
              if(ans[insertIndex].length <= 1 || insertIndex == (ans.length - 1)) {
                arrInsert(ans, insertIndex, element);
                break;
              }
              
              if(ans[insertIndex][0] >= element[0]) {
                quota--;
                if(quota < 0) {
                  arrInsert(ans, insertIndex, element);
                  break;
                }
              }
              insertIndex++;
            }
          }
          viewedMapSize++;
        }
        return ans;
    }
    
    private int[][] arrInsert(int[][] arr, int index, int[] value) {
      int leng = arr.length;
      if(index >= leng) {
        System.out.print("Cannot insert the value into the array.");
        return arr;
      } else {
        for(int i = leng - 1; i > index; i--) {
          arr[i] = arr[i - 1];
        }
        arr[index] = value;
      }
      return arr;
    }
}
