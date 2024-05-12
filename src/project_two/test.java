package project_two;


public class test {
    public static void main(String[] args) {
        int year = 2024;
        int month = 3;
        int day = 19;

        int dayOfWeek = calculateDayOfWeek(year, month, day);
//        System.out.println("dayOfWeek = " + dayOfWeek);

        System.out.println(year + "-" + month + "-" + day + "是" + getDayOfWeekName(dayOfWeek));
    }

    /**
     * Zeller's Congruence 算法
     * @param year      年份
     * @param mo     月份
     * @param day       日
     * @return          与星期对应的数
     */
    public static int calculateDayOfWeek(int year, int mo, int day) {
        if (mo < 3) {
            mo += 12;
            year--;
        }

        int k = year % 100;
        int j = year / 100;

        int dayOfWeek = (day + ((13 * (mo + 1)) / 5) + k + (k / 4) + (j / 4) - 2 * j) % 7;

        if (dayOfWeek < 0) {
            dayOfWeek += 7;
        }

        return dayOfWeek;
    }

    public static String getDayOfWeekName(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0: return "星期六";
            case 1: return "周日";
            case 2: return "星期一";
            case 3: return "星期二";
            case 4: return "星期三";
            case 5: return "星期四";
            case 6: return "星期五";
            default: return "无效日";
        }
    }
}
