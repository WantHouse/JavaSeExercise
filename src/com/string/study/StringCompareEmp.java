package com.string.study;

/**
 * 通过字符串函数 compareTo (string) ，
 * compareToIgnoreCase(String) 及
 * compareTo(object string)
 * 来比较两个字符串，并返回字符串中第一个字母ASCII的差值。
 */
public class StringCompareEmp {
    public static void main(String[] args) {
        String str = "dddd好 World";
        String anotherString = "hello world";
        Object objStr = str;
        System.out.println( str.compareTo(anotherString));
        System.out.println( str.compareToIgnoreCase(anotherString) );  //忽略大小写
        System.out.println( str.compareTo(objStr.toString()));
        System.out.println();
        System.out.println(MyComparTo(str,anotherString,true));

    }

    /**
     * 比较两个字符串的大小
     * @param original 输入源字符串
     * @param present  输入目标字符串
     * @param flag  是否忽略大小写
     * @return 若两字符串相等返回0，若为正值则original大于present 反正为负值
     * 若长度不同则返回长度的差值，若长度相等则返回字符串中第一个不相同的字符的Unicode值之差
     */
    public static int MyComparTo(String original,String present,Boolean flag){
       int len1 = original.length();
       int len2 = present.length();

       if (len1==len2){
           if(flag){
               char[] org = original.toCharArray();
               char[] pre = present.toCharArray();
               for(int i=0;i<len1;i++){
                   if(Character.isUpperCase(org[i])){
                       org[i] = Character.toLowerCase(org[i]);
                   }
                   if(Character.isLowerCase(org[i])){
                       org[i] = Character.toUpperCase(org[i]);
                   }

                   if(Character.isUpperCase(pre[i])){
                       pre[i] = Character.toLowerCase(pre[i]);
                   }
                   if(Character.isLowerCase(pre[i])){
                       pre[i] = Character.toUpperCase(pre[i]);
                   }

                   if (org[i]!=pre[i]){
                       return org[i]-pre[i];
                   }
               }
           } else {
               char[] org = original.toCharArray();
               char[] pre = present.toCharArray();
               for (int i = 0; i < len1; i++) {
                   if (org[i]!=pre[i]){
                       return org[i]-pre[i];
                   }
               }

           }
       }
       return (len1>len2)?len1-len2:len2-len1;
    }

}
