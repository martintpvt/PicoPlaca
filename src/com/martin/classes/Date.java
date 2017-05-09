package com.martin.classes;

import java.time.LocalDate;

/**
 *
 * @author Martin
 */
public class Date {
    private int year;
    private int month;
    private int day;
    private int[] restrictedDigits;

    public int[] getRestrictedDigits() {
        return restrictedDigits;
    }

    public void setRestrictedDigits(int a, int b) {
        this.restrictedDigits = new int[2];
        this.restrictedDigits[0] = a;
        this.restrictedDigits[1] = b;
    }
    
    public boolean insertDate(String date)
    {
        boolean inserted = false;
        boolean valid;
        
        int day;
        int month;
        int year;
        int dayOfWeek;
        
        String[] dateComponents = date.split("/");
        
        if(dateComponents.length == 3)
        {
            try
            {
                day = Integer.parseInt(dateComponents[0]);
                month = Integer.parseInt(dateComponents[1]);
                year = Integer.parseInt(dateComponents[2]);

                valid = this.isValidDate(day, month, year);
                
                if(valid)
                {
                    this.day = day;
                    this.month = month;
                    this.year = year;
                    
                    dayOfWeek = this.getDayOfWeek(day, month, year);
                    
                    switch(dayOfWeek)
                    {
                        case 0: case 1:
                        {
                            this.restrictedDigits = null;
                            break;
                        }
                        case 2:
                        {
                            this.setRestrictedDigits(1, 2);
                            break;
                        }
                        case 3:
                        {
                            this.setRestrictedDigits(3, 4);
                            break;
                        }
                        case 4:
                        {
                            this.setRestrictedDigits(5, 6);
                            break;
                        }
                        case 5:
                        {
                            this.setRestrictedDigits(7, 8);
                            break;
                        }
                        case 6:
                        {
                            this.setRestrictedDigits(9, 0);
                            break;
                        }
                    }
                    
                    inserted = true;
                }
            } catch(Exception ex)
            {
                
            }
        }
        
        return inserted;
    }
    
    static private boolean isValidDate(int day, int month, int year)
    {
        try
        {
            LocalDate date = LocalDate.of(year, month, day);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    
    private static boolean isLeap(int year)
    {
        return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }
    
    private static int getDayOfWeek(int day, int month, int year)
    {
        boolean isLeap = isLeap(year);
        int module = -1;
        int dayOfWeek;
        
        if(isLeap)
        {
            switch(month)
            {
                case 1: case 10:
                {
                    module = 0;
                    break;
                }
                case 2: case 3: case 11:
                {
                    module = 3;
                    break;
                }
                case 4: case 7:
                {
                    module = 6;
                    break;
                }
                case 5:
                {
                    module = 1;
                    break;
                }
                case 6:
                {
                    module = 4;
                    break;
                }
                case 8:
                {
                    module = 2;
                    break;
                }
                case 9: case 12:
                {
                    module = 5;
                    break;
                }
            }
        } else {
            switch(month)
            {
                case 1: case 4: case 7:
                {
                    module = 0;
                    break;
                }
                case 2: case 8:
                {
                    module = 3;
                    break;
                }
                case 3: case 11:
                {
                    module = 4;
                    break;
                }
                case 5:
                {
                    module = 2;
                    break;
                }
                case 6:
                {
                    module = 5;
                    break;
                }
                case 9: case 12:
                {
                    module = 6;
                    break;
                }
                case 10:
                {
                    module = 1;
                    break;
                }
            }
        }
        
        dayOfWeek = ((year - 1) % 7 + ((year - 1) / 4 - 3 * ((year - 1) / 100 + 1) / 4) % 7 + module + day % 7) % 7;
        
        return dayOfWeek;
    }
}
