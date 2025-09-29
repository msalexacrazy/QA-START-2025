/*TODO: перевірити чи мейл my.home.mail@gmail.com підпадає під правила:
  1. - закінчується на gmail.com
  2. - не містить більше одного символу @
  * - замінити всі крапки на _ окрім останньої
*/

public class Homework {
    public static void main(String[] args) {
        String homeworkVariable = "my.home.mail@gmail.com";
        //перше завдання
        System.out.println("1." + homeworkVariable.endsWith("@gmail.com")); //true

        //друге завдання варіант 1
        int count = 0;

        for (int i = 0; i < homeworkVariable.toCharArray().length; i++) {
            if (homeworkVariable.charAt(i) == '@'){
                count++;
            }
        }

        System.out.println("2a. Total count @ is: " + count);

        //друге завдання варіант 2
        int a = homeworkVariable.indexOf("@");
        int b = homeworkVariable.lastIndexOf("@");

        if (a == b) {
            System.out.println("2b. Total count @ is: 1");
        }

        //третє завдання
        String dotReplacement = homeworkVariable.substring(0, homeworkVariable.lastIndexOf(".")).replace(".","_") + homeworkVariable.substring(homeworkVariable.lastIndexOf(".", homeworkVariable.charAt(homeworkVariable.length() - 1)));
        System.out.println(dotReplacement);

    }
}
