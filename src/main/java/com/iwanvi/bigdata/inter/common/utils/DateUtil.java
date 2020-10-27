package com.iwanvi.bigdata.inter.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    public static final String Y4MDHMS = "yyyy-MM-dd HH:mm:ss";
    public static final String Y4MD = "yyyy-MM-dd";
    private static final int DAY_TIME = 86400000; //一天的时间毫秒数

    public static Date parseAgetoBirthday(int age) {
        Calendar cpcalendar = new GregorianCalendar();
        cpcalendar.setTime(new Date());
        int year = cpcalendar.get(Calendar.YEAR) - age;
        cpcalendar.set(Calendar.YEAR, year);
        cpcalendar.set(Calendar.MONTH, 0);
        cpcalendar.set(Calendar.DAY_OF_MONTH, 1);
        return cpcalendar.getTime();
    }

    public static int parseBirthdaytoAge(Date birthday) {
        Calendar nowDate = new GregorianCalendar();
        nowDate.setTime(new Date());
        Calendar birthdayDate = new GregorianCalendar();
        birthdayDate.setTime(birthday);
        return nowDate.get(Calendar.YEAR) - birthdayDate.get(Calendar.YEAR);
    }

    public static Date monthOper(Date date, int month) {
        Calendar cpcalendar = new GregorianCalendar();
        cpcalendar.setTime(date);
        cpcalendar.set(Calendar.MONTH, cpcalendar.get(Calendar.MONTH) + month);
        return cpcalendar.getTime();
    }

    public static Date dateParse(String dateStr, SimpleDateFormat sdFormat) {
        try {
            return sdFormat.parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    public static Date dateParse(String dateStr, String format) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    public static Date dateParseYMD(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.parse(dateStr);
        } catch (Exception e) {
        }
        return null;
    }

    public static String dateFormat(Date date, SimpleDateFormat sdFormat) {

        try {
            if (null != date) {
                return sdFormat.format(date);
            }
        } catch (Exception e) {
        }
        return "";
    }

    public static String dateFormat(Date date, String format) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    public static String dateFormatYMD(Date date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            return formatter.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    public static String dateFormatYM(Date date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            return formatter.format(date);
        } catch (Exception e) {
        }
        return "";
    }

    public static Date getDayStartDate() {
        try {
            Calendar currentDate = new GregorianCalendar();
            currentDate.set(Calendar.HOUR_OF_DAY, 0);
            currentDate.set(Calendar.MINUTE, 0);
            currentDate.set(Calendar.SECOND, 0);

            return currentDate.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static Date addDay(Date date, int day) {
        try {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(date);
            calendar.add(calendar.DATE, day);

            return calendar.getTime();
        } catch (Exception e) {
            return date;
        }
    }

    /**
     * 获取当前到次日凌晨的剩余时间（单位：秒）
     *
     * @return
     */
    public static int getTodayLastSeconds() {
        Calendar curDate = Calendar.getInstance();
        Calendar tommorowDate = new GregorianCalendar(curDate.get(Calendar.YEAR),
                curDate.get(Calendar.MONTH), curDate.get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tommorowDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }

    public static int getYear(Date date) {
        Calendar cpcalendar = new GregorianCalendar();
        return cpcalendar.get(Calendar.YEAR);
    }

    /**
     * 计算目标时间与当前时间日期差
     *
     * @return
     */
    public static int getdaysBetween(String pDate, SimpleDateFormat sdFormat) {
        Date date = DateUtil.dateParse(pDate, sdFormat);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long pTime = cal.getTimeInMillis();
        cal.setTime(new Date());
        long now = cal.getTimeInMillis();
        if (pTime < now) {
            return 0;
        } else {
            long between_days = (pTime - now) / (1000 * 3600 * 24);
            return Integer.parseInt(String.valueOf(between_days)) + 1;
        }
    }

    /**
     * 计算两个时间差
     *
     * @param sdate
     * @param edate
     * @return
     */
    public static int getDates(String sdate, String edate) {
        int days = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(sdf.parse(sdate));
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(sdf.parse(edate));
            long l = cal2.getTimeInMillis() - cal1.getTimeInMillis();
//            days = new Long(l / (1000 * 60 * 60 * 24)).intValue();
            days = (int) (l / DAY_TIME);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /**
     * 获得该月第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return cal.getTime();
    }

    /**
     * 获得该月的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        //设置时间
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        return getFirstDayOfMonth(year, month);
    }


    /**
     * 获得该月最后一天
     */
    public static Date getLastDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return cal.getTime();
    }


    /**
     * 获得该月最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        //设置时间
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        return getLastDayOfMonth(year, month);
    }

    /**
     * 判断选择的日期是否是本周
     *
     * @param time
     */
    public static boolean isThisWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        if (paramWeek == currentWeek) {
            return true;
        }
        return false;
    }


    // 获得本周一0点时间
    public static Date getTimesWeekmorning(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    // 获得本周日24点时间
    public static Date getTimesWeeknight(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekmorning(date));
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }

    //获取当天的开始时间
    public static Date getNowBegTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    //获取当天的结束时间
    public static Date getNowEndTime() {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static void main(String[] args) {
//		Date begDate = getNowBegTime();
//		Date endDate = getNowEndTime();
//		System.out.println(DateUtil.dateFormat(begDate, DateUtil.sFullFormat));
//		System.out.println(DateUtil.dateFormat(endDate, DateUtil.sFullFormat));

        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
    }
}
