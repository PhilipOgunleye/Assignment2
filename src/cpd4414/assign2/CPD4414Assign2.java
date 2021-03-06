/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cpd4414.assign2;

import java.util.Calendar;
import java.util.Date;
import java.util.Queue;

/**
 *
 * @author philip ogunleye 
 */
public class CPD4414Assign2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Calendar cald= Calendar.getInstance();
        System.out.println("Current time is : " + cald.getTime());
        
        Date dte= new Date();
        cald.setTime(dte);
        
        System.out.println("The set Time: " + cald.getTime());
        }
    public Date nextRequestedOrder(Order orders){
        if(orders.getTimeReceived()!=null){
            return null;
        }
        return orders.getTimeReceived();
    }
    
    public void processOrder(Order o)
    {
        if(o.getTimeReceived() != null)
        {
            o.setTimeReceived(new Date());
        }
        else
        {
            throw new IllegalStateException("ERROR: Time Recieved cannot be null when processing!");
        }
    }
       
        
    }
    

