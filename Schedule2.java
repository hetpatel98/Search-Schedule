//Program By: Het Patel (c)
//UW ID: 20673563
//Date: June 5th 2017

package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule2 {
    public static void main(String args[]) throws IOException {

        BufferedReader fileIn = null;
        String inputLine = null;
        List<Date> myStartDates = new ArrayList<Date>();
        List<Date> myEndDates = new ArrayList<Date>();

        //read csv file and store start times in myStartDates and end times in myEndDates
        try {
            fileIn = new BufferedReader(new FileReader("/Users/hetpatel/Documents/calender.csv"));
            while ((inputLine = fileIn.readLine()) != null) {

                int charIndexHead, charIndexTail;
                charIndexHead = inputLine.indexOf(" ");
                charIndexTail = inputLine.indexOf("-", charIndexHead);
                int year = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail)) - 1900;
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf("-", charIndexHead + 1);
                int month = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail)) - 1;
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(" ", charIndexHead + 1);
                int day = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(":", charIndexHead + 1);
                int hour = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(":", charIndexHead + 1);
                int min = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(",", charIndexHead + 1);
                int sec = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));


                charIndexHead = inputLine.indexOf(" ", charIndexTail);
                charIndexTail = inputLine.indexOf("-", charIndexHead + 1);
                int yearEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail)) - 1900;
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf("-", charIndexHead + 1);
                int monthEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail)) - 1;
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(" ", charIndexHead + 1);
                int dayEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(":", charIndexHead + 1);
                int hourEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.indexOf(":", charIndexHead + 1);
                int minEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));
                charIndexHead = charIndexTail;
                charIndexTail = inputLine.length();
                int secEnd = Integer.parseInt(inputLine.substring(charIndexHead + 1, charIndexTail));

                myStartDates.add(new Date(year, month, day, hour, min, sec));
                myEndDates.add(new Date(yearEnd, monthEnd, dayEnd, hourEnd, minEnd, secEnd));

            }


            //Algorithm to sort events based on their start time from earliest start time to latest start times
            int numOfEntries = myStartDates.size();
            Date temp;
            Date temp2;
            for (int j = 0; j < numOfEntries; j++) {
                for (int i = 1; i <= numOfEntries - 1; i++) {
                    if (myStartDates.get(i).before(myStartDates.get(i - 1))) {
                        temp = myStartDates.get(i - 1);
                        temp2 = myEndDates.get(i - 1);
                        myStartDates.set(i - 1, myStartDates.get(i));
                        myEndDates.set(i - 1, myEndDates.get(i));
                        myStartDates.set(i, temp);
                        myEndDates.set(i, temp2);
                    }
                }
            }

            //Create a start and end ArrayList for each day of the week since the day the program is run
            Date currentSystemTime = new Date();
            List<Date> myStartDatesDay0 = new ArrayList<Date>();
            List<Date> myEndDatesDay0 = new ArrayList<Date>();
            List<Date> myStartDatesDay1 = new ArrayList<Date>();
            List<Date> myEndDatesDay1 = new ArrayList<Date>();
            List<Date> myStartDatesDay2 = new ArrayList<Date>();
            List<Date> myEndDatesDay2 = new ArrayList<Date>();
            List<Date> myStartDatesDay3 = new ArrayList<Date>();
            List<Date> myEndDatesDay3 = new ArrayList<Date>();
            List<Date> myStartDatesDay4 = new ArrayList<Date>();
            List<Date> myEndDatesDay4 = new ArrayList<Date>();
            List<Date> myStartDatesDay5 = new ArrayList<Date>();
            List<Date> myEndDatesDay5 = new ArrayList<Date>();
            List<Date> myStartDatesDay6 = new ArrayList<Date>();
            List<Date> myEndDatesDay6 = new ArrayList<Date>();

            //Store the start times and end times into their respective day arrays
            //These sub arrays are spun off from the master mystartDates and myEndDates array
            for (int k=0; k<7; k++) {
                for (int w = 0; w < myStartDates.size(); w++) {
                    if (myStartDates.get(w).getDate() == currentSystemTime.getDate()+k)
                        if (myStartDates.get(w).getMonth() == currentSystemTime.getMonth()){
                            if (myStartDates.get(w).getYear() == currentSystemTime.getYear()){

                                switch(k){
                                    case 0:
                                        myStartDatesDay0.add(myStartDates.get(w));
                                        myEndDatesDay0.add(myEndDates.get(w));
                                        break;
                                    case 1:
                                        myStartDatesDay1.add(myStartDates.get(w));
                                        myEndDatesDay1.add(myEndDates.get(w));
                                        break;
                                    case 2:
                                        myStartDatesDay2.add(myStartDates.get(w));
                                        myEndDatesDay2.add(myEndDates.get(w));
                                        break;
                                    case 3:
                                        myStartDatesDay3.add(myStartDates.get(w));
                                        myEndDatesDay3.add(myEndDates.get(w));
                                        break;
                                    case 4:
                                        myStartDatesDay4.add(myStartDates.get(w));
                                        myEndDatesDay4.add(myEndDates.get(w));
                                        break;
                                    case 5:
                                        myStartDatesDay5.add(myStartDates.get(w));
                                        myEndDatesDay5.add(myEndDates.get(w));
                                        break;
                                    case 6:
                                        myStartDatesDay6.add(myStartDates.get(w));
                                        myEndDatesDay6.add(myEndDates.get(w));
                                        break;

                                }

                            }
                        }
                }
            }

            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay0.isEmpty()){LargestTimeSlotInDay(myStartDatesDay0, myEndDatesDay0);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay1.isEmpty()){LargestTimeSlotInDay(myStartDatesDay1, myEndDatesDay1);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+1);
                end.setDate(date+1);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay2.isEmpty()){LargestTimeSlotInDay(myStartDatesDay2, myEndDatesDay2);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+2);
                end.setDate(date+2);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay3.isEmpty()){LargestTimeSlotInDay(myStartDatesDay3, myEndDatesDay3);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+3);
                end.setDate(date+3);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            if (!myStartDatesDay4.isEmpty()){LargestTimeSlotInDay(myStartDatesDay4, myEndDatesDay4);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+4);
                end.setDate(date+4);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay5.isEmpty()){LargestTimeSlotInDay(myStartDatesDay5, myEndDatesDay5);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+5);
                end.setDate(date+5);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }
            //Check for the largest available time slot on each day if there are events on that day
            if (!myStartDatesDay6.isEmpty()){LargestTimeSlotInDay(myStartDatesDay6, myEndDatesDay6);}
            else{//no events full day is available
                Date start = (Date) currentSystemTime.clone();
                Date end = (Date) currentSystemTime.clone();
                int date = start.getDate();
                start.setDate(date+6);
                end.setDate(date+6);
                start.setHours(8);
                start.setMinutes(0);
                start.setSeconds(0);
                end.setHours(22);
                end.setMinutes(0);
                end.setSeconds(0);
                System.out.println(start +" to "+end);
            }

        }catch (IOException e) {
            System.out.printf("File Read Error: %s", e.toString());
        } finally {
            if (fileIn != null) {
                fileIn.close();
            }
        }
    }

    /***
     Method: LargestTimeSlotInDay
     Method Description: This method will take two ArrayList's one for start times and the other for end times and return the largest
     available free time slot between 8am and 10pm. The Algorithm checkAvailableStartTime is called. It takes the first end time of the day and then checks for all
     start times that are before that end time. Then it checks for the end time of that start times and if the end times are before
     the first End time of the day then that slot is the start time of the free slot. If not then it jumps to the end time of the event
     that runs past the previous chosen end time, and repeats the whole process again until it finds the largest free slot
     Parameter: List<Dates> startTimes: and array list of all the start times for meetings that day
     List<Dates> endTimes: and array list of all the end times for meetings that day
     ***/
    static public void LargestTimeSlotInDay(List<Date> startTimes, List<Date>endTimes){
        Date BeforeThisTimeSlot = (Date) endTimes.get(0).clone();
        Date MinTime = (Date) BeforeThisTimeSlot.clone();
        MinTime.setHours(8);
        MinTime.setMinutes(0);
        MinTime.setSeconds(0);
        Date MaxTime = (Date) BeforeThisTimeSlot.clone();
        MaxTime.setHours(22);
        MaxTime.setMinutes(0);
        MaxTime.setSeconds(0);
        for (int t=0; t<startTimes.size(); t++){
            if((startTimes.get(t).after(MinTime) || startTimes.get(t).equals(MinTime) ) && (startTimes.get(t).before(MaxTime) || startTimes.get(t).equals(MaxTime))){
                BeforeThisTimeSlot = (Date) endTimes.get(t).clone();
                break;
            }
        }
        FreeSlotInfo biggestSlot = new FreeSlotInfo();
        boolean firstTime = true;
        boolean inLoopAtleastOnce = false;

        for (int s=0; s<endTimes.size(); s++){
            if((endTimes.get(s).after(MaxTime)||endTimes.get(s).equals(MaxTime))){
                if((startTimes.get(s).before(MinTime)) || (startTimes.get(s).equals(MinTime))){

                    DateFormat outputFormatter = new SimpleDateFormat("EEE, MMM d, yyyy");
                    String output = outputFormatter.format(startTimes.get(s));
                    System.out.println("NO AVAILABLE TIME SLOTS FOR " +output);
                    return;
                }
                else{
                    MaxTime = (Date) startTimes.get(s).clone();
                }
            }
        }

        while(BeforeThisTimeSlot.before(MaxTime)) {
            inLoopAtleastOnce = true;
            Date myStartSlotTime = CheckForAvailableStartTime(startTimes, endTimes, BeforeThisTimeSlot);
            Date myEndSlotTime = (Date) MaxTime.clone();
            int p=0;
            for (p = 0; p < startTimes.size(); p++) {
                if (startTimes.get(p).after(myEndSlotTime)) {
                    break;
                } else if (startTimes.get(p).after(myStartSlotTime)) {
                    myEndSlotTime = (Date) startTimes.get(p).clone();
                    break;
                }
            }
            BeforeThisTimeSlot = (Date) MaxTime.clone();
            if(!myEndSlotTime.equals(MaxTime)) {
                BeforeThisTimeSlot = (Date) endTimes.get(p).clone();
            }
            long currentSlotLength = myEndSlotTime.getTime() - myStartSlotTime.getTime();
            if (firstTime) {
                biggestSlot.setDuration(currentSlotLength);
                biggestSlot.setStartTime(myStartSlotTime);
                biggestSlot.setEndTime(myEndSlotTime);
                firstTime = false;
            }
            else{
                if (currentSlotLength > biggestSlot.getDuration()){
                    biggestSlot.setDuration(currentSlotLength);
                    biggestSlot.setEndTime(myEndSlotTime);
                    biggestSlot.setStartTime(myStartSlotTime);
                }
            }

        }
        if (inLoopAtleastOnce == false){
            System.out.println("NO FREE SLOT FOUND FOR" + "");
        }
        else {
            System.out.println(biggestSlot.getStartTime() + " to " + biggestSlot.getEndTime());
        }
    }

    /***
     Method: CheckForAvailableStartTime
     Method Description: This method will take two ArrayList's one for start times and the other for end times and return an available
     flee slot start time
     Parameter: List<Dates> startTimes: and array list of all the start times for meetings that day
     List<Dates> endTimes: and array list of all the end times for meetings that day
     List<Dates> BeforeThisTime: a max time.
     ***/
    static public Date CheckForAvailableStartTime(List<Date> startTimes, List<Date> endTimes, Date BeforeThisTime){
        int i = 0;
        Date checkStartDate = (Date) startTimes.get(i).clone();
        while (checkStartDate.before(BeforeThisTime)) {

            if (endTimes.get(i).before(BeforeThisTime) || endTimes.get(i).equals(BeforeThisTime)) {
                if (i==startTimes.size()-1){
                    break;
                }
                checkStartDate = (Date) startTimes.get(++i).clone();
            } else {
                BeforeThisTime = (Date) endTimes.get(i).clone();
                i = 0;
                checkStartDate = (Date) startTimes.get(i).clone();
            }
        }
        return BeforeThisTime;
    }

    /* This class will represent a free slot found*/
    static public class FreeSlotInfo{

        private long duration;
        private Date startTime;
        private Date endTime;

        //each free slot will have a start time, end time and duration
        public FreeSlotInfo(){
            this.duration = 0;
            this.startTime = new Date();
            this.endTime = new Date();
        }

        //Store the info of a slot
        public FreeSlotInfo(long currentSlotLength, Date myStartSlotTime, Date myEndSlotTime) {
            this.duration = currentSlotLength;
            this.startTime = myStartSlotTime;
            this.endTime = myEndSlotTime;
        }

        public long getDuration(){ return this.duration; }
        public Date getStartTime(){ return this.startTime; }
        public Date getEndTime(){ return this.endTime; }

        public void setDuration(long duration){ this.duration = duration; }
        public void setStartTime(Date startTime){ this.startTime = startTime; }
        public void setEndTime(Date endTime){ this.endTime = endTime; }
    }
}
