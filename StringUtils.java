


public class StringUtils {

	public static String findSortedSequence(String str) {
		 if (str.trim().isEmpty()) {
            return "";
        }

        String[] words = str.split(" ");
        int maxStartIndex = 0;
        int maxLength = 1;
        int currentStartIndex = 0;
        int currentLength = 1;

        for (int i = 1; i < words.length; i++) {
            if (words[i].compareTo(words[i - 1]) >= 0) {
                currentLength++;
            } else {
                if (currentLength >= maxLength) {
                    maxStartIndex = currentStartIndex;
                    maxLength = currentLength;
                }
                currentStartIndex = i;
                currentLength = 1;
            }
        }

        
        if (currentLength >= maxLength) {
            maxStartIndex = currentStartIndex;
            maxLength = currentLength;
        }

        
        StringBuilder result = new StringBuilder();
        for (int i = maxStartIndex; i < maxStartIndex + maxLength; i++) {
            result.append(words[i]);
            if (i < maxStartIndex + maxLength - 1) {
                result.append(" ");
            }
        }
		return result.toString();
	}

	
	public static boolean isEditDistanceOne(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        
        
        if (Math.abs(lengthA - lengthB) > 1) {
            return false;
        }
        int i = 0, j = 0;
        boolean foundDifference = false;

        while (i < lengthA && j < lengthB) {
            if (a.charAt(i) != b.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;

               
                if (lengthA == lengthB) {
                    i++;
                    j++;
                } 
                
                else if (lengthA > lengthB) {
                    i++;
                } 
                
                else {
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }

        if (i < lengthA || j < lengthB) {
            foundDifference = true;
		}
        return foundDifference;
    }
}
