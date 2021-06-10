public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        String str3 = str1.trim() + str2.trim();
        return str3;
    }
    public Integer getIndexOrNull(String str, char ch) {
        Integer result = str.indexOf(ch);
        if(result < 0) {
            result = null;
        }
        return result;
    }
    public Integer getIndexOrNull(String str, String str2) {
        Integer result = str.indexOf(str2);
        if(result < 0) {
            result = null;
        }
        return result;
    }
    public String concatSubstring(String subStr, int startIndex, int endIndex, String newConcat) {
        subStr = subStr.substring(startIndex, endIndex);
        String concatString = subStr + newConcat;
        return concatString;

    }
}