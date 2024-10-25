import java.util.*;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Sort the folder array lexicographically
        Arrays.sort(folder);
        
        // HashMap to keep track of parent folders
        Map<String, Boolean> folderMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        for (String f : folder) {
            // Split folder by "/" to build each potential parent folder path
            String[] parts = f.split("/");
            StringBuilder path = new StringBuilder();
            
            boolean isSubfolder = false;
            for (int i = 1; i < parts.length; i++) {
                path.append("/").append(parts[i]);
                // Check if the current built path exists in the map
                if (folderMap.containsKey(path.toString())) {
                    isSubfolder = true;
                    break;
                }
            }
            
            // If it's not a subfolder, add to result and update the map
            if (!isSubfolder) {
                result.add(f);
                folderMap.put(f, true);
            }
        }
        
        return result;
    }
}
