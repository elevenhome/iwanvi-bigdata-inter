package com.iwanvi.bigdata.inter.common;


import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * @author Zhang Lei
 * @date 2018/5/9
 * desc:
 */
public class CommonUtils {
    //md5加盐值
    public static final String MD5_SALT = "iwanvi";
    //cxb类型
    public static final String CXBTYPE = "cxb";
    //zwsc类型
    public static final String ZWSCTYPE = "zwsc";


    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static Map<String,String> getApp(){
        final Map<String,String> app = new LinkedHashMap<String,String>();
        app.put("'dl'","插件");
        app.put("'cj'","Android");
        app.put("'iOS','ios'","iOS");
        return app;
    }



    /**
     * 通过页码计算分页开始数
     * @param page
     * @param limit
     * @return
     */
    public static Integer getStartPage(Integer page, Integer limit){
        if(page == 1){
            page = 0;
        }else if(page == 0){
            return page;
        }else{
            page = (page - 1) * limit;
        }
        return page;
    }

    /**
     * 用于carbondata的分页的结束条数
     * @param page
     * @param limit
     * @return
     */
    public static Integer getCarBonEndPage(Integer page, Integer limit){
        return page * limit;
    }

    /**
     * 用于carbondata的分页的开始条数
     * @param endPage
     * @param pageSize
     * @return
     */
    public static Integer getCarBonStartPage(Integer endPage, Integer pageSize) {
        return endPage-pageSize+1;
    }



    /**
     * 获得当前日期前一天的日期
     * @return
     */
    public static String getyestDate(){
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        /**
         * 把日期往前减少一天，若想把日期向后推一天则将负数改为正数
         */
        calendar.add(Calendar.DATE,-1);
        date=calendar.getTime();
        String dateString = format.format(date);
        return dateString;
    }


    /**
     * 获取上个月月份
     * @param currentDate 输入指定日起格式格式 "yyyy-MM-dd"
     * @return 返回日志格式 "yyyy-MM"
     */
    public static String getLastMonth(String currentDate) {
        Date date = null;
        try {
            date = format.parse(currentDate + "-" + "01");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        int month = c.get(Calendar.MONTH) + 1;
        String monthStr = "";
        if (month<10){
            monthStr = "0"+month;
        }else {
            monthStr = month+"";
        }
        return c.get(Calendar.YEAR) + "-" + monthStr;

    }




    /**
     * 获得当前日期前一天的日期
     * @return
     */
    public static String getyestDate(int beforeDays){
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        /**
         * 把日期往前减少一天，若想把日期向后推一天则将负数改为正数
         */
        calendar.add(Calendar.DATE,beforeDays);
        date=calendar.getTime();
        return format.format(date);
    }


    /**
     * 获取日期
     * @param specifiedDay 传入日期
     * @param dayNum       需要加减的天数
     * @param type    0为加天数 1为减天数
     * @return
     */
    public static String getDay(String specifiedDay, int dayNum,Integer type) throws  ParseException{
        Calendar c = Calendar.getInstance();
        Date date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        if(null != type){
            day =  type == 0?day + dayNum:day - dayNum;
        }
        c.set(Calendar.DATE, day);
        return format.format(c.getTime());
    }



    /**
     * 北京时间
     */
    public static String getBeiJingTime() throws Exception{
        int newTime = (int) (8 * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

    /**
     * 字符串日期格式的计算时间差
     * @param startDate yyyy-MM-dd HH:mm:ss
     * @param endDate yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String startDate,String endDate) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(sdf.parse(startDate));
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(sdf.parse(endDate));
        long beginTime = beginCalendar.getTime().getTime();
        long endTime = endCalendar.getTime().getTime();
        //先算出两时间的毫秒数之差大于一天的天数
        int betweenDays = (int)((endTime - beginTime) / (1000 * 60 * 60 *24));
        //使endCalendar减去这些天数，将问题转换为两时间的毫秒数之差不足一天的情况
        endCalendar.add(Calendar.DAY_OF_MONTH, -betweenDays);
        //比较两日期的DAY_OF_MONTH是否相等
        if(beginCalendar.get(Calendar.DAY_OF_MONTH)==endCalendar.get(Calendar.DAY_OF_MONTH)){
            //相等说明确实跨天了
            return betweenDays + 1;
        }else{
            //不相等说明确实未跨天
            return betweenDays + 0;
        }
    }


    /**
     * 获取月的第一天
     * @return
     */
    public static String getMonthFirstDay(){

        //获取当前日期
        Calendar   cal_1=Calendar.getInstance();
        //设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.DAY_OF_MONTH,1);
        return format.format(cal_1.getTime());
    }

    /**
     * 获取上一个月的第一天
     * @return
     */
    public static String getLastMonthFirstDay(){
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        return format.format(calendar1.getTime());
    }

    /**
     * 获取上一个月的最后一天
     * @return
     */
    public static String getLastMonthLasttDay(){
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        return format.format(calendar2.getTime());
    }


    /**
     * 格式化日期
     * @param format 格式化格式 例：yyyy-MM-dd
     * @param date 需要格式化日期
     * @return
     */
    public static String FormatDate(String format,String date) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.format(sdf.parse(date));
    }


    /**
     * 获取创新版类型
     * @return
     */
    public static String getCxbType() {
        return CXBTYPE;
    }

    /**
     * 获取中文书城类型
     */
    public static String getZwscType() {
        return ZWSCTYPE;
    }



    public static String[] getBookIds(String bookId){
        String []bookIds = null;
        if (StringUtils.isNotBlank(bookId)){
            bookId =  bookId.replaceAll("，",",");
            bookIds = bookId.split(",");
            if (bookIds.length>=100){
                String []bookIdsNew = new String[100];
                System.arraycopy(bookIds,0,bookIdsNew,0,100);
                bookIds = bookIdsNew;
            }
            for (int i=0;i < bookIds.length;i++){
                bookIds[i] = bookIds[i].trim();
            }
        }
        return bookIds;
    }


    /**
     * 判断是否为数字
     * @param str
     * @return
     */
    public static boolean isNum(String str){

        Pattern pattern = compile("^-?[0-9]+");
        if(pattern.matcher(str).matches()){
            //数字
            return true;
        } else {
            //非数字
            return false;
        }
    }


    public static String secToTime(int time) {
        String timeStr = null;
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (time <= 0) {
            return "00:00:00";
        }else {
            minute = time / 60;
            if (minute < 60) {
                second = time % 60;
                timeStr = "00:"+unitFormat(minute) + ":" + unitFormat(second);
            } else {
                hour = minute / 60;
                if (hour > 99) {
                    return "99:59:59";
                }
                minute = minute % 60;
                second = time - hour * 3600 - minute * 60;
                timeStr = unitFormat(hour) + ":" + unitFormat(minute) + ":" + unitFormat(second);
            }


        }
        return timeStr;
    }

    public static String unitFormat(int i) {
        String retStr = null;
        if (i >= 0 && i < 10) {
            retStr = "0" + Integer.toString(i);
        }else {
            retStr = "" + i;
        }
        return retStr;
    }

}
