/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.tel_labs.ex1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class App {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            // reader = new BufferedReader(new FileReader("/home/didula/workspace_dlak/telepathy/example_1/Example1.txt"));
            reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            ArrayList<String> timeSlotsList = new ArrayList<>();

            while (line != null) {
                timeSlotsList.add(line);

                line = reader.readLine();
            }

            Collections.sort(timeSlotsList);

            int maxCount = 1;

            for (int i = 0; i < timeSlotsList.size(); i++) {
                String[] currentTimeSlotSplit = timeSlotsList.get(i).split("-");

                LocalTime startTime = LocalTime.parse(currentTimeSlotSplit[0]);

                int crossedCount = 1;

                for (int j = 0; j < i; j++) {
                    String[] reCalculateSlotsSplit = timeSlotsList.get(j).split("-");
                    LocalTime reEndTime = LocalTime.parse(reCalculateSlotsSplit[1]);

                    int timeCompareValue_end = startTime.compareTo(reEndTime);

                    if (timeCompareValue_end < 0) {
                        ++crossedCount;
                    }
                }

                maxCount = (maxCount < crossedCount) ? crossedCount : maxCount;
            }

            System.out.println("output " + maxCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
